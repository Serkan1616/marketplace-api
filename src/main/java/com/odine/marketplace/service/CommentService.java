package com.odine.marketplace.service;

import com.odine.marketplace.model.Comment;
import com.odine.marketplace.model.Job;
import com.odine.marketplace.repository.CommentRepository;
import com.odine.marketplace.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final JobRepository jobRepository;

    public CommentService(CommentRepository commentRepository, JobRepository jobRepository) {
        this.commentRepository = commentRepository;
        this.jobRepository = jobRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getCommentsByJob(Long jobId) {
        return jobRepository.findById(jobId)
                .map(commentRepository::findByJob)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    @Transactional
    public Comment createComment(Long jobId, String commenterName, String commentText) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Comment comment = new Comment();
        comment.setJob(job);
        comment.setCommenterName(commenterName);
        comment.setCommentText(commentText);

        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(Long commentId, String commentText) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        if (commentText != null) {
            comment.setCommentText(commentText);
        }

        return commentRepository.save(comment);
    }
}
