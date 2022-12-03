package model;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Mailbox {
    private ArrayList<Message> mailBox;

    public Mailbox() {
        mailBox = new ArrayList<Message>();
    }

    public ArrayList<Message> getMailBox() {
        return mailBox;
    }

    public DefaultTableModel receivedMessageDft(String recipientId) {
     resultSetToMessageList(listReceivedMessages(recipientId));
     return messageListToTableModel();
    }

    public DefaultTableModel sentMessageDft(String senderId) {
        resultSetToMessageList(listReceivedMessages(senderId));
        return messageListToTableModel();
    }

    public DefaultTableModel messageListToTableModel(){
        Vector<String> colHeader = new Vector<String>(List.of("Message ID", "Subject", "Contents", "Date Sent", "Job ID", "Message Type", "Sender", "Recipient", "Message Status", "Message Object" ));
        Vector rows = new Vector();
        for(Message m : mailBox){
            Vector newRow = new Vector();

            newRow.addElement(m.getMessageId());
            newRow.addElement(m.getSubject());
            newRow.addElement(m.getContents());
            newRow.addElement(m.getSendDate());
            newRow.addElement(m.getJobId());
            newRow.addElement(m.getMessageType());
            newRow.addElement(m.getSenderUserId());
            newRow.addElement(m.getRecipientUserId());
            newRow.addElement(m.getMessageStatus());
            newRow.addElement(m);
            rows.addElement(newRow);
        }
        return new DefaultTableModel(rows, colHeader);
    }
    public ResultSet listReceivedMessages(String recipientUserId) {
        DBConnection db = DBConnection.get();
        return db.executeQuery("select * from Message where recipientUserId='" + recipientUserId + "'" );
    }

    public ResultSet listSentMessages(String senderUserId) {
        DBConnection db = DBConnection.get();
        return db.executeQuery("select * from Message where senderUserId='" + senderUserId + "'" );
    }

    public void resultSetToMessageList(ResultSet rs) {
        try{
            while (rs.next()) {
                Message newMessage = new Message(rs);
                mailBox.add(newMessage);
            }
        }
        catch(SQLException e){
            System.err.println("Error accessing message DB: " + e);
        }
    }

    public void removeMessage(Message message) {
        //message.deleteMessage();
        mailBox.remove(message);
    }
}
