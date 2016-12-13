package com.itis.freelance_marketplace.repository;

import com.itis.freelance_marketplace.entity.Message;
import com.itis.freelance_marketplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alt on 14.11.16.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAll();

    @Query("select m from Message m where (m.fromUser = :fromUser and m.toUser = :toUser)" +
            " or (m.fromUser = :toUser and m.toUser = :fromUser) ORDER BY m.date")
    List<Message> findAllMessagesByUsers(@Param("fromUser") User fromUser,  @Param("toUser") User toUser);
}

