package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 20.11.16.
 */
@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAll();
}
