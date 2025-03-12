package com.odine.marketplace.service;

import com.odine.marketplace.model.Freelancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class EvaluationService {

    private static final Logger logger = LoggerFactory.getLogger(EvaluationService.class);

    @Async
    public CompletableFuture<Integer> evaluateFreelancer(Freelancer freelancer) {
        try {
            // Simulated delay
            TimeUnit.SECONDS.sleep(2);
            int score = 1; // Varsayılan skor

            if (freelancer.getFreelancerType() == Freelancer.FreelancerType.DESIGNER) {
                score = Math.min(10, freelancer.getDesignTools().size());
            } else if (freelancer.getFreelancerType() == Freelancer.FreelancerType.SOFTWARE_DEVELOPER) {
                score = Math.min(10, freelancer.getSoftwareLanguages().size() * freelancer.getSpecialties().size());
            }

            logger.info("Freelancer {} evaluated with score {}", freelancer.getName(), score);
            return CompletableFuture.completedFuture(score);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Evaluation interrupted", e);
        }
    }
}
