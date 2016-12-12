package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.PortfolioImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 22.11.16.
 */
@Repository
public interface PortfolioImageRepository extends JpaRepository<PortfolioImage, Long> {
    List<PortfolioImage> findAll();
}
