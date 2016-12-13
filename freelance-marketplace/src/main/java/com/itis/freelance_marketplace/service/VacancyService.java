package com.itis.freelance_marketplace.service;


import com.itis.freelance_marketplace.entity.Vacancy;

import java.util.List;

/**
 * Created by alt on 12.12.16.
 */
public interface VacancyService {
    Vacancy create(Vacancy vacancy);

    Vacancy delete(long id);

    List<Vacancy> findAll();

    Vacancy update(Vacancy vacancy);

    Vacancy findById(long id);
}
