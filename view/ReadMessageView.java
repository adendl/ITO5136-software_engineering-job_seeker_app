package view;

import javax.swing.*;

import controller.MailboxController;
import model.Message;

public class ReadMessageView implements UIView {
    private JTextField subjectText;
    private JTextPane messageTextPane;
    private JPanel mainPanel;
    private JLabel fromLabel;
    private JLabel subjectLabel;
    private JPanel optionsPanel;
    private JButton replyButton;
    private JButton deleteButton;
    private JTextField fromText;
    private JLabel titleLabel;
    private JLabel jobLabel;
    private JTextField jobTextField;
    private MailboxController controller;
    private Message message;

    public ReadMessageView(MailboxController controller, Message message) {
        this.controller = controller;
        this.message = message;
        replyButton.addActionListener((e -> {
            controller.replyMessage(message);

        }));
        deleteButton.addActionListener((e -> {
            controller.deleteMessageAction(message);
            // TODO: this should refresh the existing view rather than pushing a brand new one
            controller.showMailbox(false);
        }));
    }

    public JTextField getSubjectText() {
        return subjectText;
    }

    public JTextPane getMessageTextPane() {
        return messageTextPane;
    }

    public JTextField getFromText() {
        return fromText;
    }

    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public JTextField getJobTextField() {
        return jobTextField;
    }

    public static void main(String[] args) {
       // ReadMessageView view = new ReadMessageView(null);
        //ViewHelper.showStandaloneFrame(view);
    }
}