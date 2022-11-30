package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;


public class CreateMessageView implements UIView {
    private JTextField subjectText;
    private JTextPane invitationMessageTextPane;
    private JButton sendMessageButton;
    private JPanel panelMain;
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
        return panelMain;
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
