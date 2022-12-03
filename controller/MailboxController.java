package controller;

import model.Mailbox;
import model.Message;
import model.User;
import view.CreateMessageView;
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
        this.user = user;
    }


    public void showMailbox() {
        mailBox = new Mailbox();
        DefaultTableModel dft = mailBox.receivedMessageDft(user.getUserId());
        MailboxView view = new MailboxView(this);
        view.getTblMessages().setModel(dft);
        view.renderTable();
        navigationController.pushView(view);
    }

    public void deleteMessageAction(Message message) {
        mailBox.removeMessage(message);
        message.deleteMessage();
    }

    public void showMessage(Message message) {
        message.changeMessageToRead();
        ReadMessageView view = new ReadMessageView(this, message);
        navigationController.pushView(view);
        view.getFromText().setText(message.getSenderUserId());
        view.getSubjectText().setText(message.getSubject());
        view.getMessageTextPane().setText(message.getContents());
        view.getJobTextField().setText(String.valueOf(message.getJobId()));
    }

    public void replyMessage(Message message) {
        CreateMessageView createMessageView = new CreateMessageView(this);
        createMessageView.getToText().setText(message.getSenderUserId());
        createMessageView.getToText().setEnabled(false);
        createMessageView.getSubjectText().setText("RE: " + message.getSubject());
        createMessageView.getJobTextField().setText(String.valueOf(message.getJobId()));

        navigationController.pushView(createMessageView);
    }

    public void sendMessage(CreateMessageView view){
        Message newMessage = new Message();
        newMessage.setContents(view.getMessageTextPane().getText());
        newMessage.setJobId(Integer.parseInt(view.getJobTextField().getText()));
        newMessage.setRecipientUserId(view.getToText().getText());
        newMessage.setSenderUserId(user.getUserId());
        newMessage.setSubject(view.getSubjectText().getText());

        newMessage.createMessage();

        this.showMailbox();
    }





}
