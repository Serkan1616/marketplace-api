package com.odine.marketplace.service;

import com.odine.marketplace.model.Freelancer;
import com.odine.marketplace.repository.FreelancerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerService {

    private final EvaluationService evaluationService;

    private final FreelancerRepository freelancerRepository;

    public FreelancerService(FreelancerRepository freelancerRepository, EvaluationService evaluationService) {
        this.freelancerRepository = freelancerRepository;
        this.evaluationService = evaluationService;
    }


    public List<Freelancer> getAllFreelancers() {
        return freelancerRepository.findAll();
    }

    public Optional<Freelancer> getFreelancerById(Long id) {
        return freelancerRepository.findById(id);
    }

    public List<Freelancer> searchFreelancers(String name, String city, Freelancer.FreelancerType freelancerType) {
        if (name != null) {
            return freelancerRepository.findByNameContainingIgnoreCase(name);
        } else if (city != null) {
            return freelancerRepository.findByCityContainingIgnoreCase(city);
        } else if (freelancerType != null) {
            return freelancerRepository.findByFreelancerType(freelancerType);
        }
        return freelancerRepository.findAll();
    }

    @Transactional
    public Freelancer createFreelancer(Freelancer freelancer) {
        Freelancer savedFreelancer = freelancerRepository.save(freelancer);
        evaluationService.evaluateFreelancer(savedFreelancer).thenAccept(score -> {
            savedFreelancer.setEvaluationScore(score);
            freelancerRepository.save(savedFreelancer);
        });
        return savedFreelancer;
    }
}
