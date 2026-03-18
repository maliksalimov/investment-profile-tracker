package com.maliksalimov.my_spring_portfolio.repository;

import com.maliksalimov.my_spring_portfolio.model.Fund;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FundRepository extends JpaRepository<Fund, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT f FROM Fund f WHERE f.id = :id")
    Optional<Fund> findByIdWithLock(@Param("id") Long id);
}
