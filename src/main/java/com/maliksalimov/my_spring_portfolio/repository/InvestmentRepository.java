package com.maliksalimov.my_spring_portfolio.repository;


import com.maliksalimov.my_spring_portfolio.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
