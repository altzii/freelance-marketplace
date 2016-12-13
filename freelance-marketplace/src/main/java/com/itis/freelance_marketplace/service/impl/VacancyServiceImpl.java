package com.itis.freelance_marketplace.service.impl;

import com.itis.freelance_marketplace.entity.Vacancy;
import com.itis.freelance_marketplace.repository.VacancyRepository;
import com.itis.freelance_marketplace.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 12.12.16.
 */
@Service
public class VacancyServiceImpl implements VacancyService {
    @Autowired
    VacancyRepository vacancyRepository;

    @Override
    @Transactional
    public Vacancy create(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    @Transactional
    public Vacancy delete(long id) {
        Vacancy vacancy = vacancyRepository.findOne(id);
        vacancyRepository.delete(vacancy);
        return vacancy;
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    @Transactional
    public Vacancy update(Vacancy vacancy) {
        return vacancyRepository.saveAndFlush(vacancy);
    }

    @Override
    public Vacancy findById(long id) {
        return vacancyRepository.findOne(id);
    }
}
