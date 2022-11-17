package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadMessageView {
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JPanel mainLabel;
    private JLabel fromLabel;
    private JLabel subjectLabel;
    private JPanel optionsPanel;
    private JButton replyButton;
    private JButton deleteButton;
    private JTextField textField1;

    public ReadMessageView() {
        replyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}