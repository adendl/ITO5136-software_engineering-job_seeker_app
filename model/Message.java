package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.function.DoubleBinaryOperator;

public class Message {
    private int messageId;
    private String subject;
    private String contents;
    private LocalDate sendDate;
    private int jobId;
    private String messageType;
    private String senderUserId;
    private String recipientUserId;
    private String messageStatus;

    public Message() {
    }

    public Message(int messageId, String subject, String contents, LocalDate sendDate, int jobId, String messageType, String senderUserId, String recipientUserId, String messageStatus) {
        this.messageId = messageId;
        this.subject = subject;
        this.contents = contents;
        this.sendDate = sendDate;
        this.jobId = jobId;
        this.messageType = messageType;
        this.senderUserId = senderUserId;
        this.recipientUserId = recipientUserId;
        this.messageStatus = messageStatus;
    }

    public Message(ResultSet rs) throws SQLException {
        this.messageId = rs.getInt("messageId");
        this.subject = rs.getString("subject");
        this.contents = rs.getString("contents");
        this.sendDate = Date.valueOf(rs.getString("sendDate")).toLocalDate();
        this.jobId = rs.getInt("jobId");
        this.messageType = rs.getString("messageType");
        this.senderUserId = rs.getString("senderUserId");
        this.recipientUserId = rs.getString("recipientUserId");
        this.messageStatus = rs.getString("messageStatus");
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

    public String getMessageStatus() { return messageStatus; }

    public void setRecipientUserId(String recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public ResultSet getMessage()
    {
        ResultSet rs = DBConnection.queryDatabase("select * from Message where messageId=" + this.messageId);
        return rs;
    }

    public static ResultSet getMessage(int messageId)
    {
        ResultSet rs = DBConnection.queryDatabase("select * from Message where messageId=" + messageId);
        return rs;
    }

    public void createMessage() {
        DBConnection conn = DBConnection.get();
        String sql = "INSERT INTO Message (recipientUserId, senderUserId, messageType, jobId, sendDate, contents, subject, messageStatus, messageId) VALUES (" +
                '"' + recipientUserId + '"' + ", " +
                '"' + senderUserId + '"' + ", " +
                '"' +  messageType + '"' + ", " +
                jobId + ", " +
                '"' +   LocalDate.now() + '"' + ", " +
                '"' +   contents + '"' + ", " +
                '"' +  subject + '"' + ", " +
                '"' +  messageStatus + '"' + ", " +
                null + ")";
        System.out.println(sql);
        conn.executeQuery(sql);
        try {
            setJobId(conn.getLatestItemId("Message"));
        } catch (Exception e) {
            System.err.println("createMessage failed: " + e);
        }
    }

    public void deleteMessage()
    {
        DBConnection.queryDatabase("delete from Message where messageId=" + this.messageId);
    }

    public void deleteMessage(int messageId)
    {
        DBConnection.queryDatabase("delete from Message where messageId=" + messageId);
    }



}
