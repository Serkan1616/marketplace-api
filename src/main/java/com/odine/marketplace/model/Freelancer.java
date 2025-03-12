package com.odine.marketplace.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String city;

    @Enumerated(EnumType.STRING)
    private FreelancerType freelancerType;

    private String portfolioUrl;

    @ElementCollection
    private List<String> designTools;

    @ElementCollection
    private List<String> softwareLanguages;

    @ElementCollection
    private List<String> specialties;

    private int evaluationScore;

    public enum FreelancerType {
        DESIGNER, SOFTWARE_DEVELOPER
    }

    public Freelancer() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public FreelancerType getFreelancerType() { return freelancerType; }
    public String getPortfolioUrl() { return portfolioUrl; }
    public List<String> getDesignTools() { return designTools; }
    public List<String> getSoftwareLanguages() { return softwareLanguages; }
    public List<String> getSpecialties() { return specialties; }
    public int getEvaluationScore() { return evaluationScore; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCity(String city) { this.city = city; }
    public void setFreelancerType(FreelancerType freelancerType) { this.freelancerType = freelancerType; }
    public void setPortfolioUrl(String portfolioUrl) { this.portfolioUrl = portfolioUrl; }
    public void setDesignTools(List<String> designTools) { this.designTools = designTools; }
    public void setSoftwareLanguages(List<String> softwareLanguages) { this.softwareLanguages = softwareLanguages; }
    public void setSpecialties(List<String> specialties) { this.specialties = specialties; }
    public void setEvaluationScore(int evaluationScore) { this.evaluationScore = evaluationScore; }
}
