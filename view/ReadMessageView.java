package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadMessageView {
    private JTextField fromTextField;
    private JTextField toTextField;
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JPanel mainLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JLabel invitationMessageLabel;
    private JPanel optionsPanel;
    private JButton replyButton;
    private JButton deleteButton;

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