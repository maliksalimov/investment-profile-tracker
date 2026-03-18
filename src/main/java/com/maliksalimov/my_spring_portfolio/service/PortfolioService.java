package com.maliksalimov.my_spring_portfolio.service;

import com.maliksalimov.my_spring_portfolio.model.Fund;
import com.maliksalimov.my_spring_portfolio.model.Investment;
import com.maliksalimov.my_spring_portfolio.repository.FundRepository;
import com.maliksalimov.my_spring_portfolio.repository.InvestmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PortfolioService {

    private final Double DEFAULT_STARTING_FUND = 10000000.0;
    private final InvestmentRepository investmentRepository;
    private final FundRepository fundRepository;
    private final NotificationService notificationService;

    public PortfolioService(InvestmentRepository investmentRepository,
                            FundRepository fundRepository,
                            NotificationService notificationService) {
        this.investmentRepository = investmentRepository;
        this.fundRepository = fundRepository;
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void initFund() {
        if (fundRepository.count() == 0) {
            fundRepository.save(new Fund(1L, DEFAULT_STARTING_FUND));
        }
    }

    @Transactional
    @CacheEvict(value = "fund", allEntries = true)
    public void addToFund(Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Fund fund = getFund();
        fund.setTotalAmount(fund.getTotalAmount() + amount);
        fundRepository.save(fund);
    }

    @Cacheable("fund")
    public Fund getFund() {
        return fundRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException("Fund not initialized"));
    }

    public Double getRemainingFund() {
        Fund fund = getFund();
        Double totalInvested = investmentRepository.getTotalInvestedAmount();

        return fund.getTotalAmount() - totalInvested;
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public List<Investment> getSortedInvestments(String sortBy) {
        if("AmountAsc".equals(sortBy)) {
            return investmentRepository.findAll(Sort.by("amount").ascending());
        }
        if("AmountDesc".equals(sortBy)) {
            return investmentRepository.findAll(Sort.by("amount").descending());
        }
        if("name".equals(sortBy)) {
            return investmentRepository.findAll(Sort.by("name").ascending());
        }
        return investmentRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "fund", allEntries = true)
    public void saveInvestment(Investment investment) {
        if (investment.getAmount() == null || investment.getAmount() <= 0) {
            throw new IllegalArgumentException("Investment amount must be positive");
        }

        // Lock the fund to ensure consistent check of remaining funds
        fundRepository.findByIdWithLock(1L)
                .orElseThrow(() -> new IllegalStateException("Fund not initialized"));

        Double remaining = getRemainingFund();
        if (remaining < investment.getAmount()) {
            throw new IllegalStateException(
                    String.format("Insufficient funds! Available: $%.2f, Required: $%.2f",
                            remaining, investment.getAmount())
            );
        }

        investmentRepository.save(investment);

        notificationService.scheduleNotification(investment);
    }

    @Transactional
    @CacheEvict(value = "fund", allEntries = true)
    public void updateInvestment(Long id, String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Investment name cannot be empty");
        }

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Investment not found"));
        investment.setName(newName.trim());
        investmentRepository.save(investment);
    }

    @Transactional
    @CacheEvict(value = "fund", allEntries = true)
    public void deleteInvestment(Long id) {
        if (!investmentRepository.existsById(id)) {
            throw new IllegalStateException("Investment not found");
        }
        investmentRepository.deleteById(id);
    }

    public Investment getInvestmentById(Long id) {
        return investmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Investment not found with id: " + id));
    }
}