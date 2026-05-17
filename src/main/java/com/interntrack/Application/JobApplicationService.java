package com.interntrack.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    public List<JobApplication> getAllApplications() {
        return List.of(
                new JobApplication(
                        1L,
                        "IBM",
                        "Software Developer Placement",
                        JobType.PLACEMENT_YEAR,
                        "London",
                        WorkMode.HYBRID,
                        24000,
                        "https://example.com/ibm-placement",
                        ApplicationStatus.APPLIED,
                        LocalDate.of(2026, 6, 1),
                        LocalDate.of(2026, 5, 16),
                        "Need to revise Java OOP and SQL."
                ),
                new JobApplication(
                        2L,
                        "Google",
                        "Software Engineering Intern",
                        JobType.INTERNSHIP,
                        "London",
                        WorkMode.ONSITE,
                        null,
                        "https://example.com/google-internship",
                        ApplicationStatus.INTERESTED,
                        LocalDate.of(2026, 6, 15),
                        null,
                        "Check eligibility before applying."
                ),
                new JobApplication(
                        3L,
                        "JP Morgan",
                        "Technology Analyst Intern",
                        JobType.INTERNSHIP,
                        "Bournemouth",
                        WorkMode.HYBRID,
                        null,
                        "https://example.com/jpmorgan-internship",
                        ApplicationStatus.ONLINE_ASSESSMENT,
                        LocalDate.of(2026, 5, 30),
                        LocalDate.of(2026, 5, 12),
                        "Online assessment stage. Practise problem solving."
                )
        );
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return getAllApplications()
                .stream()
                .filter(application -> application.getId().equals(id))
                .findFirst();
    }
}
