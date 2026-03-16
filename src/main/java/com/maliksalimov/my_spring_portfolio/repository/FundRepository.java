package com.maliksalimov.my_spring_portfolio.repository;

import com.maliksalimov.my_spring_portfolio.model.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Long> {
}
