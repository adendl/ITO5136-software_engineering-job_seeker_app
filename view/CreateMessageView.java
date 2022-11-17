package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMessageView {
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JButton sendInvitationButton;
    private JPanel titleLabel;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JTextField textField1;

    public CreateMessageView() {
        sendInvitationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
