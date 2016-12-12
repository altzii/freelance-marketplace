package com.itis.freelance_marketplace.service;

import com.itis.freelance_marketplace.entity.Portfolio;

import java.util.List;

/**
 * Created by alt on 20.11.16.
 */
public interface PortfolioService {
    Portfolio create(Portfolio portfolio);

    Portfolio delete(long id);

    List<Portfolio> findAll();

    Portfolio update(Portfolio portfolio);

    Portfolio findById(long id);
}
