package com.odine.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private Freelancer freelancer;

    private LocalDate createdDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus = JobStatus.IN_PROGRESS;

    @Column(columnDefinition = "TEXT")
    private String description;

    public enum JobStatus {
        IN_PROGRESS, FINISHED
    }

    public Job() {}

    public Long getId() { return id; }
    public Freelancer getFreelancer() { return freelancer; }
    public LocalDate getCreatedDate() { return createdDate; }
    public JobStatus getJobStatus() { return jobStatus; }
    public String getDescription() { return description; }

    public void setFreelancer(Freelancer freelancer) { this.freelancer = freelancer; }
    public void setJobStatus(JobStatus jobStatus) { this.jobStatus = jobStatus; }
    public void setDescription(String description) { this.description = description; }
}
