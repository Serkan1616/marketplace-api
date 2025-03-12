package com.odine.marketplace.repository;

import com.odine.marketplace.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    List<Freelancer> findByNameContainingIgnoreCase(String name);
    List<Freelancer> findByCityContainingIgnoreCase(String city);
    List<Freelancer> findByFreelancerType(Freelancer.FreelancerType freelancerType);
}
