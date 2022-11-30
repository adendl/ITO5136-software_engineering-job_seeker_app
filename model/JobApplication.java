package model;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Connection;


public class JobApplication {
    private String applicationId;
    private String applicantId;
    private LocalDate dateApplied;
    private int jobId;
    private int resumeId;
    private int messageId;

    public JobApplication(String applicationId, String applicantId, LocalDate dateApplied, int jobId, int resumeId, int messageId) {
        this.applicationId = applicationId;
        this.applicantId = applicantId;
        this.dateApplied = dateApplied;
        this.jobId = jobId;
        this.resumeId = resumeId;
        this.messageId = messageId;
    }

    public JobApplication()
    {

    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    public ResultSet listJobApplicationsJobSeeker(int applicantId) {
        return DBConnection.queryDatabase("select * from JobApplication where applicantId =" + applicantId);
    }

    public static ResultSet listJobApplicationsRecruiter(int jobId)
    {
        ResultSet rs = DBConnection.queryDatabase("select * from JobApplication where jobId =" + jobId);
        return rs;
    }

    public static ResultSet getJobApplication(int applicationId)
    {
        ResultSet rs = DBConnection.queryDatabase("select * from JobApplication where applicationId =" + applicationId);
        return rs;
    }
    public ResultSet listJobApplications() {
        ResultSet rs = DBConnection.queryDatabase("select * from JobApplication");
        return rs;
    }

    public void updateJobApplication(String applicationId, String fieldName, String value) {
        String sql = "update JobApplication \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere applicationId='" + applicationId + "'";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }

    public void deleteJobApplication(String applicationId) {
        DBConnection.queryDatabase("delete from JobApplication where applicationId='" + applicationId + "'");
    }


    public void createJobApplication() {
        DBConnection conn = DBConnection.get();
        String sql = "INSERT INTO JobApplication (messageId, resumeId, jobId, dateApplied, applicantId, applicationId) VALUES (" +
                messageId + ", " +
                resumeId + ", " +
                jobId + ", " +
                '"' + LocalDate.now() + '"' + ", " +
                applicantId + ", " +
                null + ")";
        System.out.println(sql);
        conn.executeQuery(sql);
        try {
            setApplicationId(conn.getLatestItemId("JobApplication"));
        } catch (Exception e) {
            System.err.println("createJobApplication failed:" + e);
        }
    }
}

