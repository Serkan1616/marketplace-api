package com.odine.marketplace.controller;

import com.odine.marketplace.model.Job;
import com.odine.marketplace.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/freelancer/{freelancerId}")
    public List<Job> getJobsByFreelancer(@PathVariable Long freelancerId) {
        return jobService.getJobsByFreelancer(freelancerId);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(
            @RequestParam Long freelancerId,
            @RequestParam String description) {
        Job job = jobService.createJob(freelancerId, description);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Long id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Job.JobStatus jobStatus) {
        Job job = jobService.updateJob(id, description, jobStatus);
        return ResponseEntity.ok(job);
    }
}
