package com.itis.freelance_marketplace.service.impl;

import com.itis.freelance_marketplace.entity.PortfolioImage;
import com.itis.freelance_marketplace.repository.PortfolioImageRepository;
import com.itis.freelance_marketplace.service.PortfolioImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 22.11.16.
 */
@Service
public class PortfolioImageServiceImpl implements PortfolioImageService {
    @Autowired
    PortfolioImageRepository portfolioImageRepository;


    @Override
    @Transactional
    public PortfolioImage create(PortfolioImage portfolioImage) {
        return portfolioImageRepository.save(portfolioImage);
    }

    @Override
    @Transactional
    public PortfolioImage delete(long id) {
        PortfolioImage portfolioImage = portfolioImageRepository.findOne(id);
        portfolioImageRepository.delete(portfolioImage);
        return portfolioImage;
    }

    @Override
    public List<PortfolioImage> findAll() {
        return portfolioImageRepository.findAll();
    }

    @Override
    @Transactional
    public PortfolioImage update(PortfolioImage portfolioImage) {
        return portfolioImageRepository.saveAndFlush(portfolioImage);
    }

    @Override
    public PortfolioImage findById(long id) {
        return portfolioImageRepository.findOne(id);
    }
}
