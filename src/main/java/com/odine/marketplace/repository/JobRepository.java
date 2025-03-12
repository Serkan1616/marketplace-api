package com.odine.marketplace.repository;

import com.odine.marketplace.model.Job;
import com.odine.marketplace.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByFreelancer(Freelancer freelancer);
}
