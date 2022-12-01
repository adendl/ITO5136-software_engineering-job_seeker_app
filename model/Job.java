package model;

import java.sql.Connection;
import java.sql.ResultSet;
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

    public Job(int jobId, int categoryId, String company, String description, LocalDate expiryDate, boolean isAdvertised, ArrayList<String> keywords, int locationId, int recruiterId, int salaryMax, int salaryMin, String status, String title) {
        this.jobId = jobId;
        this.categoryId = categoryId;
        this.company = company;
        this.description = description;
        this.expiryDate = expiryDate;
        this.isAdvertised = isAdvertised;
        this.keywords = keywords;
        this.locationId = locationId;
        this.recruiterId = recruiterId;
        this.salaryMax = salaryMax;
        this.salaryMin = salaryMin;
        this.status = status;
        this.dateCreated = LocalDate.now();
        this.title = title;
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate timeCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static ResultSet getJob(int jobId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Job where jobId=" + jobId);
        return rs;
    }

    public static ResultSet listJobs()
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Job");
        return rs;
    }

    public void createJob()
    {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO Job (keyword, title, dateCreated, status, salaryMin, salaryMax, locationId, recruiterId, expiryDate, description, company, categoryId, jobId) VALUES (" +
               '"' + keywords + '"' + ", " +
                '"' +    title + '"' + ", " +
                '"' +  dateCreated + '"' + ", " +
                '"' +   status + '"' + ", " +
                salaryMin + ", " +
                salaryMax + ", " +
                locationId + ", " +
                recruiterId + ", " +
                '"' +   expiryDate + '"' + ", " +
                '"' +   description + '"' + ", " +
                '"' +  company + '"' + ", " +
                categoryId + ", " +
                jobId + ")";
        System.out.println(sql);
       DBConnection.queryDatabase(conn, sql);
        try {
            setJobId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM Job").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteJob(int jobId)
    {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Job where jobId=" + jobId);
    }

    public void updateJob(int jobId, String fieldName, String value)
    {
        String sql = "update Job \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere jobId=" + jobId;
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }


}