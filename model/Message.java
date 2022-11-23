package model;

import java.time.LocalDate;

public class Message {
    private int messageId;
    private String subject;
    private String contents;
    private LocalDate sendDate;
    private int jobId;
    private String messageType;
    private int senderUserId;
    private int recipientUserId;

    public Message() {
    }

    public Message(int messageId, String subject, String contents, LocalDate sendDate, int jobId, String messageType, int senderUserId, int recipientUserId) {
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

    public int getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }

    public int getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(int recipientUserId) {
        this.recipientUserId = recipientUserId;
    }
