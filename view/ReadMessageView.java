package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MailboxController;
import model.Message;
import view.UIView;
import view.ViewHelper;

public class ReadMessageView implements UIView {
    private JTextField subjectText;
    private JTextPane invitationMessageTextPane;
    private JPanel mainPanel;
    private JLabel fromLabel;
    private JLabel subjectLabel;
    private JPanel optionsPanel;
    private JButton replyButton;
    private JButton deleteButton;
    private JTextField fromText;
    private JLabel titleLabel;
    private MailboxController controller;
    private Message message;

    public ReadMessageView(MailboxController controller, Message message) {
        this.controller = controller;
        this.message = message;
        replyButton.addActionListener((e -> {

        }));
        deleteButton.addActionListener((e -> {
            controller.deleteMessageAction(message);
            controller.showMailbox();
        }));
    }

    public JTextField getSubjectText() {
        return subjectText;
    }

    public JTextPane getInvitationMessageTextPane() {
        return invitationMessageTextPane;
    }

    public JTextField getFromText() {
        return fromText;
    }

    @Override
    public JComponent getUIView() {
        return mainPanel;
    }



    public static void main(String[] args) {
       // ReadMessageView view = new ReadMessageView(null);
        //ViewHelper.showStandaloneFrame(view);
    }
}