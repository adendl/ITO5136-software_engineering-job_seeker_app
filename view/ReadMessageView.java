package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class ReadMessageView implements UIView {
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JPanel mainPanel;
    private JLabel fromLabel;
    private JLabel subjectLabel;
    private JPanel optionsPanel;
    private JButton replyButton;
    private JButton deleteButton;
    private JTextField fromText;
    private JLabel titleLabel;

    public ReadMessageView() {

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

    public void addDeleteButtonListener(ActionListener buttonListener) {
        deleteButton.addActionListener(buttonListener);
    }

    public void addReplyButtonListener(ActionListener buttonListener) {
        replyButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public static void main(String[] args) {
        ReadMessageView view = new ReadMessageView();
        ViewHelper.showStandaloneFrame(view);
    }
}