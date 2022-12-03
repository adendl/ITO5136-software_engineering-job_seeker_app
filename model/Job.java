package model;

import java.security.Key;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Job {

    private int jobId;
    private String company;
    private String description;
    private LocalDate expiryDate;

    private boolean isAdvertised;

    private ArrayList<Keyword> keyword;
    private int locationId;
    private int recruiterId;
    private String salary;
    private String status;

    public void setAdvertised(boolean advertised) {
        isAdvertised = advertised;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    private LocalDate dateCreated;
    private String title;


    public Job() {
    }

    public Job(String company, String description, LocalDate expiryDate, boolean isAdvertised, ArrayList<Keyword> keyword, int locationId, int recruiterId, String status, String title) {
        this.company = company;
        this.description = description;
        this.expiryDate = expiryDate;
        this.isAdvertised = isAdvertised;
        this.keyword = keyword;
        this.locationId = locationId;
        this.recruiterId = recruiterId;
        this.status = status;
        this.dateCreated = LocalDate.now();
        this.title = title;
    }

    public Job(ResultSet rs) throws SQLException {
        this.jobId = rs.getInt("jobId");
        this.company = rs.getString("company");
        this.description = rs.getString("description");
        this.expiryDate = Date.valueOf(rs.getString("expiryDate")).toLocalDate();
        this.isAdvertised = rs.getBoolean("isAdvertised");
        this.locationId = rs.getInt("locationId");
        this.recruiterId = rs.getInt("recruiterId");
        this.salary = rs.getString("salary");
        this.status = rs.getString("status");
        this.dateCreated = Date.valueOf(rs.getString("dateCreated")).toLocalDate();
        this.title = rs.getString("title");
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

    public ArrayList<Keyword> getKeyword() {
        return keyword;
    }

    public void setKeyword(ArrayList<Keyword> keyword) {
        this.keyword = keyword;
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

    public boolean isAdvertised() {
        return isAdvertised;
    }

    public static ResultSet getJob(int jobId)
    {
        DBConnection db = DBConnection.get();
        return db.executeQuery("select * from Job where jobId=" + jobId);

    }

    public static ResultSet listJobs()
    {
        DBConnection db = DBConnection.get();
        return db.executeQuery("select jobId, dateCreated, title, company, Location.city from Job\nJoin Location on Job.locationId = Location.locationId");

    }



    public static ResultSet listJobsOneStringFilter(String key, String value)
    {
        DBConnection db = DBConnection.get();
        return db.executeQuery("select * from Job where " + key + '=' + '"' + value + '"');
    }

    public static ResultSet listJobsCategoriesFilter(ArrayList<Keyword> keywords)
    {
        DBConnection db = DBConnection.get();
        String sql = "select * from Job where";
        for (int i = 0; i < keywords.size(); i++) {
            if (i == 0) {
                sql += "(',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            } else {
                sql += " OR (',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            }
        }
        System.out.println(sql);
        return db.executeQuery(sql);
    }

    public static ResultSet listJobsCategoriesOneStringFilter(ArrayList<Keyword> keywords, String key, String value)
    {
        DBConnection db = DBConnection.get();
        String sql = "select * from Job where " + key + '=' + '"' + value + '"' + " AND (";
        for (int i = 0; i < keywords.size(); i++) {
            if (i == 0) {
                sql += "(',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            } else {
                sql += " OR (',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            }
        }
        sql += ')';
        System.out.println(sql);
        return db.executeQuery(sql);
    }

    public void createJob() throws SQLException {
        DBConnection db = DBConnection.get();
        String sql = "INSERT INTO Job (keyword, title, dateCreated, status, salary, locationId, recruiterId, expiryDate, description, isAdvertised, company, jobId) VALUES (" + '"';
                if (!keyword.isEmpty())
                {
                    for (int i = 0; i < keyword.size(); i++)
                    {
                        if (i < (keyword.size() - 1))
                        {
                            sql+= (keyword.get(i).getKeywordId() + ",");
                        }
                        else
                        {
                            System.out.println(keyword.get(i).getKeywordId());
                            sql+= (keyword.get(i).getKeywordId());
                            System.out.println(sql);
                        }
                    }
                    System.out.println(sql);
                }
               sql += '"' + "," + '"' + title + '"' + ", " +
                '"' +  LocalDate.now() + '"' + ", " +
                '"' +   status + '"' + ", " +
                '"' +   salary + '"' + ", " +
                locationId + ", " +
                recruiterId + ", " +
                '"' +   LocalDate.now().plusMonths(1) + '"' + ", " +
                '"' +   description + '"' + ", " +
                       "'False'," +
                '"' +  company + '"' + ", " +
                null + ")";
        System.out.println(sql);
        db.executeQuery(sql);

        try {
            setJobId(db.getLatestItemId("Job"));
        } catch (Exception e) {
            System.err.println("createJob failed:" + e);
        }

        if (Keyword.getKeywordByValue(title).getString("keywordId") == null)
        {
            new Keyword("jobTitle", title).createKeyword();
        }
        updateJob(jobId, "keyword", (Job.getJob(jobId).getString("keyword") + Keyword.getKeywordByValue(title).getString("keywordId")));
        System.out.println("job ID = " + jobId);
    }

    public void deleteJob(int jobId)
    {
        DBConnection db = DBConnection.get();
        db.executeQuery("delete from Job where jobId=" + jobId);
    }

    public void updateJob(int jobId, String fieldName, String value)
    {
        DBConnection db = DBConnection.get();
        String sql = "update Job \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere jobId=" + jobId;
        System.out.println(sql);
        db.executeQuery(sql);
    }

    public String getLocationFromDb() throws SQLException {
            ResultSet rs = DBConnection.queryDatabase("select city, state from Location where locationId=" + "\"" +this.locationId +"\"");
            String location = (rs.getString(1) + ", " + rs.getString(2));
            System.out.println(location);
            System.out.println(this.locationId);
            return location;
    }
}