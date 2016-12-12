package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.VacancyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 13.12.16.
 */
@Repository
public interface VacancyCommentRepository extends JpaRepository<VacancyComment, Long> {
    List<VacancyComment> findAll();
}
