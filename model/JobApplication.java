package model;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Connection;


public class JobApplication {
    private String applicationId;
    private String applicantId;
    private LocalDate dateApplied;
    private String jobId;
    private String resumeId;
    private String messageId;

    public JobApplication(String applicationId, String applicantId, LocalDate dateApplied, String jobId, String resumeId, String messageId) {
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
        String sql = "INSERT INTO JobApplication (messageId, resumeId, jobId, dateApplied, applicantId, applicationId) VALUES (" +
                messageId + ", " +
                resumeId + ", " +
                jobId + ", " +
                '"' + LocalDate.now() + '"' + ", " +
                applicantId + ", " +
                null + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(conn, sql);
        try {
            setApplicationId(String.valueOf(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM JobApplication").getInt("last_insert_rowid()")));
        } catch (Exception e) {

        }
    }


}

