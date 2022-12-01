package model;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Connection;


public class JobApplication {
    private int applicationId;
    private int applicantId;
    private LocalDate dateApplied;
    private int jobId;
    private int resumeId;

    private int messageId;

    public JobApplication(int applicationId, int applicantId, LocalDate dateApplied, int jobId, int resumeId, int messageId) {
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

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }


    public ResultSet listJobApplicationsJobSeeker(int applicantId) {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobApplication where applicantId =" + applicantId);
        return rs;
    }

    public static ResultSet listJobApplicationsRecruiter(int jobId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobApplication where jobId =" + jobId);
        return rs;
    }

    public static ResultSet getJobApplication(int applicationId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobApplication where applicationId =" + applicationId);
        return rs;
    }

    public static ResultSet listJobApplications() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobApplication");
        return rs;
    }

    public void updateJobApplication(String applicationId, String fieldName, String value) {
        String sql = "update JobApplication \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere applicationId='" + applicationId + "'";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }

    public void deleteJobApplication(String applicationId) {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from JobApplication where applicationId='" + applicationId + "'");
    }


    public void createJobApplication() {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO JobApplication (messageId, resumeId, jobId, dateApplied, applicantId, applicationId) VALUES (" + +
                messageId + ", " +
                resumeId + ", " +
                jobId + ", " +
                '"' + LocalDate.now() + '"' + ", " +
                applicantId + ", " +
                null + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(conn, sql);
        try {
            setApplicationId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM JobApplication").getInt("last_insert_rowid()"));
        } catch (Exception e) {

        }
    }


}

