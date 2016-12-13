package com.itis.freelance_marketplace.service;

import com.itis.freelance_marketplace.entity.PortfolioImage;

import java.util.List;

/**
 * Created by alt on 22.11.16.
 */
public interface PortfolioImageService {
    PortfolioImage create(PortfolioImage portfolioImage);

    PortfolioImage delete(long id);

    List<PortfolioImage> findAll();

    PortfolioImage update(PortfolioImage portfolioImage);

    PortfolioImage findById(long id);
}
