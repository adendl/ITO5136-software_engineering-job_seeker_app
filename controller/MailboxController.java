package controller;

import model.Mailbox;
import model.Message;
import model.User;
import view.MailboxView;
import view.ReadMessageView;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


public class MailboxController {
    NavigationController navigationController;
    private Mailbox mailBox;
    private User user;

    public MailboxController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        mailBox = new Mailbox();
        this.user = user;
    }


    public void showMailbox() {
        try {
            DefaultTableModel dft = mailBox.receivedMessageDft(user.getUserId());
            MailboxView view = new MailboxView(this);
            navigationController.pushView(view);
        }
        catch (SQLException e) {
            System.err.println("Error retrieving messages from DB: " + e);
        }
    }



    public void deleteMessageAction(Message message) {
        mailBox.removeMessage(message);
    }

    public void showMessage(Message message) {
        ReadMessageView view = new ReadMessageView(this);
        navigationController.pushView(view);
        view.getFromText().setText(message.getSenderUserId());
        view.getSubjectText().setText(message.getSubject());
        view.getInvitationMessageTextPane().setText(message.getContents());
    }



}
