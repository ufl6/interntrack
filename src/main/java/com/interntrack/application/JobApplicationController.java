package com.interntrack.application;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("/api/applications")
    public List<JobApplication> getApplications(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) ApplicationStatus status
    ) {
        return jobApplicationService.filterApplications(search, status);
    }

    @GetMapping("/api/applications/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        return jobApplicationService.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/applications")
    public ResponseEntity<JobApplication> createApplication(@RequestBody JobApplication application) {
        JobApplication createdApplication = jobApplicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }

    @PutMapping("/api/applications/{id}")
    public ResponseEntity<JobApplication> updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication updatedApplication
    ) {
        return jobApplicationService.updateApplication(id, updatedApplication)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/applications/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        boolean deleted = jobApplicationService.deleteApplication(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
