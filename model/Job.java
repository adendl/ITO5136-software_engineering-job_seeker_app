package model;

import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
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
    private int salaryMax;
    private int salaryMin;
    private String status;
    private LocalDate dateCreated;
    private String title;


    public Job() {
    }

    public Job(String company, String description, LocalDate expiryDate, boolean isAdvertised, ArrayList<Keyword> keyword, int locationId, int recruiterId, int salaryMax, int salaryMin, String status, String title) {
        this.company = company;
        this.description = description;
        this.expiryDate = expiryDate;
        this.isAdvertised = isAdvertised;
        this.keyword = keyword;
        this.locationId = locationId;
        this.recruiterId = recruiterId;
        this.salaryMax = salaryMax;
        this.salaryMin = salaryMin;
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
        this.salaryMax = rs.getInt("salaryMax");
        this.salaryMin = rs.getInt("salaryMin");
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

    public boolean isAdvertised() {
        return isAdvertised;
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

    public static ResultSet listJobsOneStringFilter(String key, String value)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Job where " + key + '=' + '"' + value + '"');
        return rs;
    }

    public static ResultSet listJobsCategoriesFilter(ArrayList<Keyword> keywords)
    {
        String sql = "select * from Job where";
        for (int i = 0; i < keywords.size(); i++) {
            if (i == 0) {
                sql += "(',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            } else {
                sql += " OR (',' + RTRIM(keyword) + ',' ) LIKE '%,' + " + keywords.get(i).getKeywordId() + " + ',%'";
            }
        }
        System.out.println(sql);
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        return rs;
    }

    public static ResultSet listJobsCategoriesOneStringFilter(ArrayList<Keyword> keywords, String key, String value)
    {
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
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        return rs;
    }


    public void createJob()
    {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO Job (keyword, title, dateCreated, status, salaryMin, salaryMax, locationId, recruiterId, expiryDate, description, company, jobId) VALUES (" + '"';
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
               sql += '"' + "," + '"' + title + '"' + ", " +
                '"' +  dateCreated + '"' + ", " +
                '"' +   status + '"' + ", " +
                salaryMin + ", " +
                salaryMax + ", " +
                locationId + ", " +
                recruiterId + ", " +
                '"' +   expiryDate + '"' + ", " +
                '"' +   description + '"' + ", " +
                '"' +  company + '"' + ", " +
                null + ")";
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

    public static void main(String[] args)
    {
        /** ArrayList<Keyword> al1 = new ArrayList<Keyword>();
        Keyword kw1 = new Keyword(1, "category", "Accounting");
        Keyword kw2 = new Keyword(2, "category", "Administration");
        Keyword kw3 = new Keyword(3, "category", "Advertising");
        al1.add(kw1);
        al1.add(kw2);
        al1.add(kw3);
        Job job = new Job("ACME", "A really awesome job that you should apply for.", LocalDate.now(), true, al1, 1, 1, 80000, 100000, null, "Ass Kicker" );
        job.createJob();
        listJobsCategoriesOneStringFilter(al1, "locationId", "3"); **/
    }


}