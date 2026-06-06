package com.interntrack.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final List<JobApplication> applications = new ArrayList<>();
    private Long nextId = 4L;

    public JobApplicationService() {
        applications.add(new JobApplication(
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
        ));

        applications.add(new JobApplication(
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
        ));

        applications.add(new JobApplication(
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
        ));
    }

    public List<JobApplication> getAllApplications() {
        return applications;
    }

    private boolean containsIgnoreCase(String value, String searchTerm) {
        return value != null && value.toLowerCase().contains(searchTerm);
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return applications
                .stream()
                .filter(application -> application.getId().equals(id))
                .findFirst();
    }

    public JobApplication createApplication(JobApplication application) {
        application.setId(nextId);
        nextId++;
        applications.add(application);
        return application;
    }

    public Optional<JobApplication> updateApplication(Long id, JobApplication updatedApplication) {
        Optional<JobApplication> existingApplicationOptional = getApplicationById(id);

        if (existingApplicationOptional.isEmpty()) {
            return Optional.empty();
        }

        JobApplication existingApplication = existingApplicationOptional.get();

        existingApplication.setCompanyName(updatedApplication.getCompanyName());
        existingApplication.setRoleTitle(updatedApplication.getRoleTitle());
        existingApplication.setJobType(updatedApplication.getJobType());
        existingApplication.setLocation(updatedApplication.getLocation());
        existingApplication.setWorkMode(updatedApplication.getWorkMode());
        existingApplication.setSalary(updatedApplication.getSalary());
        existingApplication.setJobLink(updatedApplication.getJobLink());
        existingApplication.setStatus(updatedApplication.getStatus());
        existingApplication.setDeadline(updatedApplication.getDeadline());
        existingApplication.setDateApplied(updatedApplication.getDateApplied());
        existingApplication.setNotes(updatedApplication.getNotes());

        return Optional.of(existingApplication);
    }

    public boolean deleteApplication(Long id) {
        return applications.removeIf(application -> application.getId().equals(id));
    }

    public List<JobApplication> filterApplications(
            String searchTerm,
            ApplicationStatus status
    ) {
        String normalisedSearch = searchTerm == null
                ? ""
                : searchTerm.trim().toLowerCase();

        return applications.stream()
                .filter(application
                        -> status == null || application.getStatus() == status
                )
                .filter(application
                        -> normalisedSearch.isBlank()
                || containsIgnoreCase(
                        application.getCompanyName(),
                        normalisedSearch
                )
                || containsIgnoreCase(
                        application.getRoleTitle(),
                        normalisedSearch
                )
                || containsIgnoreCase(
                        application.getLocation(),
                        normalisedSearch
                )
                || containsIgnoreCase(
                        application.getNotes(),
                        normalisedSearch
                )
                )
                .toList();
    }
}
