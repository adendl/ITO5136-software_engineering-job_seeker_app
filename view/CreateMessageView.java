package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMessageView {
    private JTextField fromTextField;
    private JTextField toTextField;
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JButton sendInvitationButton;
    private JPanel titleLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JLabel invitationMessageLabel;

    public CreateMessageView() {
        sendInvitationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
