package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMessageView {
    private JTextField subjectText;
import view.UIView;
import view.ViewHelper;

public class CreateMessageView implements UIView {
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JButton sendMessageButton;
    private JPanel mainPanel;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JTextField toText;
    private JLabel newInvitationMessageLabel;

    public CreateMessageView() {

    }

    public JTextField getSubjectText() {
        return subjectText;
    }

    public JTextPane getInvitationMessageTextPane() {
        return invitationMessageTextPane;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getToText() {
        return toText;
    }

    public void addSendMessageButtonListener(ActionListener sendMessageButtonListener) {
        sendMessageButton.addActionListener(sendMessageButtonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        CreateMessageView view = new CreateMessageView();
        ViewHelper.showStandaloneFrame(view);
    }
}
