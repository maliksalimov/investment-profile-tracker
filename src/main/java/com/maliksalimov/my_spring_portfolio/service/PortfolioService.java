package com.maliksalimov.my_spring_portfolio.service;

import com.maliksalimov.my_spring_portfolio.model.Fund;
import com.maliksalimov.my_spring_portfolio.model.Investment;
import com.maliksalimov.my_spring_portfolio.repository.FundRepository;
import com.maliksalimov.my_spring_portfolio.repository.InvestmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final Double DEFAULT_STARTING_FUND = 10000000.0;
    private final InvestmentRepository investmentRepository;
    private final FundRepository fundRepository;

    public PortfolioService(InvestmentRepository investmentRepository, FundRepository fundRepository) {
        this.investmentRepository = investmentRepository;
        this.fundRepository = fundRepository;
    }

    @PostConstruct
    public void initFund() {
        if (fundRepository.count() == 0) {
            fundRepository.save(new Fund(1L, DEFAULT_STARTING_FUND));
        }
    }

    public void addToFund(Double amount){
        Fund fund = fundRepository.findById(1L).orElseThrow();
        fund.setTotalAmount(fund.getTotalAmount() + amount);
        fundRepository.save(fund);
    }

    public Double getRemainingFund() {
        Fund fund = fundRepository.findById(1L).orElseThrow();
        Double totalInvested = investmentRepository.findAll().stream().
                mapToDouble(Investment::getAmount)
                .sum();

        return fund.getTotalAmount() - totalInvested;
    }

    public java.util.List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public List<Investment> getSortedInvestments(String sortBy) {
        if("AmountAsc".equals(sortBy)) return investmentRepository.findAll(Sort.by("amount").ascending());
        if("AmountDesc".equals(sortBy)) return investmentRepository.findAll(Sort.by("amount").descending());
        if("name".equals(sortBy)) return investmentRepository.findAll(Sort.by("name").ascending());
        return investmentRepository.findAll();
    }

    public void saveInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public void updateInvestment(Long id, String newName) {
        Investment investment = investmentRepository.findById(id).orElseThrow();
        investment.setName(newName);
        investmentRepository.save(investment);
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }

    public Investment getInvestmentById(Long id) {
        return investmentRepository.findById(id).orElseThrow();
    }
}
