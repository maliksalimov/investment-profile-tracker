package com.maliksalimov.my_spring_portfolio.repository;


import com.maliksalimov.my_spring_portfolio.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    @Query("SELECT COALESCE(SUM(i.amount), 0.0) FROM Investment i")
    Double getTotalInvestedAmount();
}
