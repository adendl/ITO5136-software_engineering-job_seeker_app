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

    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public static void main(String[] args) {
        ReadMessageView view = new ReadMessageView();
        ViewHelper.showStandaloneFrame(view);
    }
}