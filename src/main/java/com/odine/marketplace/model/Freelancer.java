package com.odine.marketplace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String phone;
    private String city;

    @Enumerated(EnumType.STRING)
    private FreelancerType freelancerType;

    private String portfolioUrl; // Designer'lar için

    @ElementCollection
    private List<String> designTools; // Designer'lar için

    @ElementCollection
    private List<String> softwareLanguages; // Developer'lar için

    @ElementCollection
    private List<String> specialties; // Developer'lar için

    private int evaluationScore;

    // Enum: Freelancer Türü
    public enum FreelancerType {
        SOFTWARE_DEVELOPER, DESIGNER
    }
}
