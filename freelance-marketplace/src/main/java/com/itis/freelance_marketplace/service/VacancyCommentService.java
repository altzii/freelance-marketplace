package com.itis.freelance_marketplace.service;

import com.itis.freelance_marketplace.entity.VacancyComment;

import java.util.List;

/**
 * Created by alt on 13.12.16.
 */
public interface VacancyCommentService {
    VacancyComment create(VacancyComment vacancyComment);

    VacancyComment delete(long id);

    List<VacancyComment> findAll();

    VacancyComment update(VacancyComment vacancyComment);

    VacancyComment findById(long id);
}
