package com.itis.freelance_marketplace.service.impl;

import com.itis.freelance_marketplace.entity.VacancyComment;
import com.itis.freelance_marketplace.repository.VacancyCommentRepository;
import com.itis.freelance_marketplace.service.VacancyCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alt on 13.12.16.
 */
@Service
public class VacancyCommentServiceImpl implements VacancyCommentService {
    @Autowired
    VacancyCommentRepository vacancyCommentRepository;

    @Override
    @Transactional
    public VacancyComment create(VacancyComment vacancyComment) {
        return vacancyCommentRepository.save(vacancyComment);
    }

    @Override
    @Transactional
    public VacancyComment delete(long id) {
        VacancyComment vacancyComment = vacancyCommentRepository.findOne(id);
        vacancyCommentRepository.delete(vacancyComment);
        return vacancyComment;
    }

    @Override
    public List<VacancyComment> findAll() {
        return vacancyCommentRepository.findAll();
    }

    @Override
    @Transactional
    public VacancyComment update(VacancyComment vacancyComment) {
        return vacancyCommentRepository.saveAndFlush(vacancyComment);
    }

    @Override
    public VacancyComment findById(long id) {
        return vacancyCommentRepository.findOne(id);
    }
}
