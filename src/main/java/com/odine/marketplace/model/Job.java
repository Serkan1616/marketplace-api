package com.odine.marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
