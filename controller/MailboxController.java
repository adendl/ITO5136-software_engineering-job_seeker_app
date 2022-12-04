package controller;

import model.Job;
import model.Mailbox;
import model.Message;
import model.User;
import view.*;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


public class MailboxController {
    NavigationController navigationController;
    private Mailbox mailBox;
    private User user;
    boolean showingUnreadOnly;

    public MailboxController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        this.user = user;
        showingUnreadOnly = false;
    }


    public void showMailbox(boolean unreadOnly) {
        mailBox = new Mailbox();
        DefaultTableModel dft;
        if (unreadOnly) {
            dft = mailBox.unreadMessageDft(user.getUserId());
        } else {
            dft = mailBox.receivedMessageDft(user.getUserId());
        }

        showingUnreadOnly = unreadOnly;
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

    public void sendMessage(CreateMessageView view) {
        Message newMessage = new Message();
        newMessage.setContents(view.getMessageTextPane().getText());
        newMessage.setJobId(Integer.parseInt(view.getJobTextField().getText()));
        newMessage.setRecipientUserId(view.getToText().getText());
        newMessage.setSenderUserId(user.getUserId());
        newMessage.setSubject(view.getSubjectText().getText());
        confirmSend(newMessage);
    }

       public void confirmSend(Message message){
        ConfirmPage confirmPage = new ConfirmPage(navigationController);
        confirmPage.getYesButton().addActionListener(e -> {
            message.createMessage();
            CompletionPage completionPage = new CompletionPage(navigationController);
            completionPage.getContinueButton().addActionListener(e1 -> {
                this.showMailbox(showingUnreadOnly);
            });
            navigationController.pushView(completionPage);
        });
        confirmPage.getNoButton().addActionListener(e -> {
            navigationController.popView();
        });
        navigationController.pushView(confirmPage);
    }

    public void sendApplyMessage(Job job) {
        CreateMessageView createMessageView = new CreateMessageView(this);
        createMessageView.getToText().setText(String.valueOf(job.getRecruiterId()));
        createMessageView.getToText().setEnabled(false);
        createMessageView.getSubjectText().setText("Application for " + job.getTitle() + " from " + user.getFirstName() + " " + user.getLastName());
        createMessageView.getJobTextField().setText(String.valueOf(job.getJobId()));
        createMessageView.getMessageTextPane().setText("Hello,\n I would like to apply for the role of " + job.getTitle() + ".\nKind Regards,\n" + user.getFirstName() + " " + user.getLastName());

        sendMessage(createMessageView);
    }

    public void sendInvitationMessage(Job job, User applicant) {
        CreateMessageView createMessageView = new CreateMessageView(this);
        createMessageView.getToText().setText(user.getUserId());
        createMessageView.getToText().setEnabled(false);
        createMessageView.getSubjectText().setText("Interview Invitation for " + job.getTitle());
        createMessageView.getJobTextField().setText(String.valueOf(job.getJobId()));
        createMessageView.getMessageTextPane().setText("Hello,\n I would like to Invite you for an interview for the role of " + job.getTitle() + ".\nKind Regards");

        sendMessage(createMessageView);
    }
}
