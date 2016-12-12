package com.itis.freelance_marketplace.service.impl;

import com.itis.freelance_marketplace.entity.Portfolio;
import com.itis.freelance_marketplace.repository.PortfolioRepository;
import com.itis.freelance_marketplace.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 22.11.16.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    @Override
    @Transactional
    public Portfolio create(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    @Transactional
    public Portfolio delete(long id) {
        Portfolio portfolio = portfolioRepository.findOne(id);
        portfolioRepository.delete(portfolio);
        return portfolio;
    }

    @Override
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    @Override
    @Transactional
    public Portfolio update(Portfolio portfolio) {
        return portfolioRepository.saveAndFlush(portfolio);
    }

    @Override
    public Portfolio findById(long id) {
        return portfolioRepository.findOne(id);
    }
}
