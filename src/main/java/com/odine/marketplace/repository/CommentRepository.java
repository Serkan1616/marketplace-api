package com.odine.marketplace.repository;

import com.odine.marketplace.model.Comment;
import com.odine.marketplace.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByJob(Job job);
}
