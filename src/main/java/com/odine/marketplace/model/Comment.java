package com.odine.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private String commenterName;
    private LocalDate createdDate = LocalDate.now();

    @Column(columnDefinition = "TEXT")
    private String commentText;

    public Comment() {}

    public Long getId() { return id; }
    public Job getJob() { return job; }
    public String getCommenterName() { return commenterName; }
    public LocalDate getCreatedDate() { return createdDate; }
    public String getCommentText() { return commentText; }

    public void setJob(Job job) { this.job = job; }
    public void setCommenterName(String commenterName) { this.commenterName = commenterName; }
    public void setCommentText(String commentText) { this.commentText = commentText; }
}
