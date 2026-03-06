package com.maliksalimov.my_spring_portfolio.service;

import com.maliksalimov.my_spring_portfolio.model.Investment;
import com.maliksalimov.my_spring_portfolio.repository.InvestmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private Double STARTING_FUND = 10000000.0;
    private final InvestmentRepository investmentRepository;

    public PortfolioService(InvestmentRepository investmenRepository) {
        this.investmentRepository = investmenRepository;
    }

    public void addToFund(Double amount){
        this.STARTING_FUND += amount;
    }

    public Double getRemainingFund() {
        Double totalInvested = investmentRepository.findAll().stream().
                mapToDouble(Investment::getAmount)
                .sum();

        return STARTING_FUND - totalInvested;
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
}
