package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Job {

    private int jobId;
    private int categoryId;
    private String company;
    private String description;
    private LocalDate expiryDate;

    private boolean isAdvertised;

    private ArrayList<String> keywords;
    private int locationId;
    private int recruiterId;
    private int salaryMax;
    private int salaryMin;
    private String status;
    private LocalDate dateCreated;
    private String title;


    public Job() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExpiriyDate() {
        return expiryDate;
    }

    public void setExpiriyDate(LocalDateTime expiriyDate) {
        this.expiryDate = expiriyDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public int getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }

    public int getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void createJob()
    {
       DBConnection.queryDatabase(DBConnection.connectDb(), "INSERT INTO Job (" +
                        "keyword, " +
                        "title, " +
                        "dateCreated, " +
                        "status, " +
                        "salaryMin, " +
                        "salaryMax, " +
                        "locationId, " +
                        "recruiterId, " +
                        "expiryDate, " +
                        "description, " +
                        "company, " +
                        "categoryId, " +
                        "jobId" +
               ")" +
                " VALUES (" +
                        keywords + ", " +
                        title + ", " +
                        dateCreated + ", " +
                        status + ", " +
                        salaryMin + ", " +
                        salaryMax + ", " +
                        locationId + ", " +
                        recruiterId + ", " +
                        expiryDate + ", " +
                        description + ", " +
                        company + ", " +
                        categoryId + ", " +
                        jobId + ")"
        );
    }

    public void deleteJob(int jobId)
    {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Job where jobId=" + jobId);
    }

    public void updateJob(int jobId, String fieldName, String value)
    {
        DBConnection.queryDatabase(DBConnection.connectDb(), "update Job \nset " + fieldName + " = " + value "\nwhere jobId=" + jobId);
    }

}