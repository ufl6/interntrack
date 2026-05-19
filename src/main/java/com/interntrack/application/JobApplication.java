package com.interntrack.application;

import java.time.LocalDate;

public class JobApplication {

    private Long id;
    private String companyName;
    private String roleTitle;
    private JobType jobType;
    private String location;
    private WorkMode workMode;
    private Integer salary;
    private String jobLink;
    private ApplicationStatus status;
    private LocalDate deadline;
    private LocalDate dateApplied;
    private String notes;

    public JobApplication() {
    }

    public JobApplication(
            Long id,
            String companyName,
            String roleTitle,
            JobType jobType,
            String location,
            WorkMode workMode,
            Integer salary,
            String jobLink,
            ApplicationStatus status,
            LocalDate deadline,
            LocalDate dateApplied,
            String notes
    ) {
        this.id = id;
        this.companyName = companyName;
        this.roleTitle = roleTitle;
        this.jobType = jobType;
        this.location = location;
        this.workMode = workMode;
        this.salary = salary;
        this.jobLink = jobLink;
        this.status = status;
        this.deadline = deadline;
        this.dateApplied = dateApplied;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public JobType getJobType() {
        return jobType;
    }

    public String getLocation() {
        return location;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getJobLink() {
        return jobLink;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
