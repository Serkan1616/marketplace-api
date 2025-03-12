package com.odine.marketplace.controller;

import com.odine.marketplace.model.Freelancer;
import com.odine.marketplace.service.FreelancerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/freelancers")
public class FreelancerController {

    private final FreelancerService freelancerService;

    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping
    public List<Freelancer> getAllFreelancers() {
        return freelancerService.getAllFreelancers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freelancer> getFreelancerById(@PathVariable Long id) {
        Optional<Freelancer> freelancer = freelancerService.getFreelancerById(id);
        return freelancer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Freelancer> searchFreelancers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Freelancer.FreelancerType freelancerType) {
        return freelancerService.searchFreelancers(name, city, freelancerType);
    }

    @PostMapping
    public ResponseEntity<Freelancer> createFreelancer(@Valid @RequestBody Freelancer freelancer) {
        Freelancer savedFreelancer = freelancerService.createFreelancer(freelancer);
        return ResponseEntity.ok(savedFreelancer);
    }
}
