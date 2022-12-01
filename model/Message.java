package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Message {
    private int messageId;
    private String subject;
    private String contents;
    private LocalDate sendDate;
    private int jobId;
    private String messageType;
    private String senderUserId;
    private String recipientUserId;

    public Message() {
    }

    public Message(int messageId, String subject, String contents, LocalDate sendDate, int jobId, String messageType, String senderUserId, String recipientUserId) {
        this.messageId = messageId;
        this.subject = subject;
        this.contents = contents;
        this.sendDate = sendDate;
        this.jobId = jobId;
        this.messageType = messageType;
        this.senderUserId = senderUserId;
        this.recipientUserId = recipientUserId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId;
    }

    public String getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(String recipientUserId) {
        this.recipientUserId = recipientUserId;
    }
    public static ResultSet getMessage(int messageId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Message where messageId=" + messageId);
        return rs;
    }

    public static ResultSet listMessages(String recipientUserId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Message where recipientUserId='" + recipientUserId + "'" );
        return rs;
    }

    public void createJob()
    {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO Message (recipientUserId, senderUserId, messageType, jobId, sendDate, contents, subject, messageId) VALUES (" +
                '"' + recipientUserId + '"' + ", " +
                '"' + senderUserId + '"' + ", " +
                '"' +  messageType + '"' + ", " +
                jobId + ", " +
                '"' +   LocalDate.now() + '"' + ", " +
                '"' +   contents + '"' + ", " +
                '"' +  subject + '"' + ", " +
                null + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(conn, sql);
        try {
            setJobId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM Message").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMessage(int messageId)
    {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Message where messageId=" + messageId);
    }



}
