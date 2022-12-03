package view;

import javax.swing.*;

import controller.MailboxController;


public class CreateMessageView implements UIView {
    private JTextField subjectText;
    private JTextPane messageTextPane;
    private JButton sendMessageButton;
    private JPanel panelMain;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JTextField toText;
    private JLabel newMessageLabel;
    private JLabel jobLabel;
    private JTextField jobTextField;
    private MailboxController mailboxController;

    public CreateMessageView(MailboxController mailboxController) {
        this.mailboxController = mailboxController;
        sendMessageButton.addActionListener((e -> {
            mailboxController.sendMessage(this);
        }));
    }

    public JTextField getSubjectText() {
        return subjectText;
    }

    public JTextPane getMessageTextPane() {
        return messageTextPane;
    }

    public JPanel getMainPanel() {
        return panelMain;
    }

    public JTextField getToText() {
        return toText;
    }

    public JTextField getJobTextField() { return jobTextField; }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        //CreateMessageView view = new CreateMessageView();
        //ViewHelper.showStandaloneFrame(view);
    }
}
