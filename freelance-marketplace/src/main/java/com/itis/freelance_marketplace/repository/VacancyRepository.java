package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 12.12.16.
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAll();
}
