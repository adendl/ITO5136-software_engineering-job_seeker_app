package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class CreateProfileView {

    private JPanel createUserPanel;
    private JLabel pageTitleText;
    private JTextField firstNameTextField;
    private JPasswordField confirmPasswordField;
    private JComboBox userTypeComboBox;
    private JTextField lastNameTextField;
    private JPasswordField passwordField;
    private JTextField emailTextField;
    private JLabel lastNameLabel;
    private JButton createAccountButton;

    public CreateProfileView() {
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
