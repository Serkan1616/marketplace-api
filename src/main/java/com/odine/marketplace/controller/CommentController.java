package com.odine.marketplace.controller;

import com.odine.marketplace.model.Comment;
import com.odine.marketplace.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/job/{jobId}")
    public List<Comment> getCommentsByJob(@PathVariable Long jobId) {
        return commentService.getCommentsByJob(jobId);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestParam Long jobId,
            @RequestParam String commenterName,
            @RequestParam String commentText) {
        Comment comment = commentService.createComment(jobId, commenterName, commentText);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable Long id,
            @RequestParam String commentText) {
        Comment comment = commentService.updateComment(id, commentText);
        return ResponseEntity.ok(comment);
    }
}
