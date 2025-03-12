package com.odine.marketplace.service;

import com.odine.marketplace.model.Freelancer;
import com.odine.marketplace.model.Job;
import com.odine.marketplace.repository.FreelancerRepository;
import com.odine.marketplace.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final FreelancerRepository freelancerRepository;

    public JobService(JobRepository jobRepository, FreelancerRepository freelancerRepository) {
        this.jobRepository = jobRepository;
        this.freelancerRepository = freelancerRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public List<Job> getJobsByFreelancer(Long freelancerId) {
        return freelancerRepository.findById(freelancerId)
                .map(jobRepository::findByFreelancer)
                .orElseThrow(() -> new RuntimeException("Freelancer not found"));
    }

    @Transactional
    public Job createJob(Long freelancerId, String description) {
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Freelancer not found"));

        Job job = new Job();
        job.setFreelancer(freelancer);
        job.setDescription(description);

        return jobRepository.save(job);
    }

    @Transactional
    public Job updateJob(Long jobId, String description, Job.JobStatus jobStatus) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (description != null) {
            job.setDescription(description);
        }
        if (jobStatus != null) {
            job.setJobStatus(jobStatus);
        }

        return jobRepository.save(job);
    }
}
