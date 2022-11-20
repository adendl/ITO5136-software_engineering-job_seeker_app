package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton createNewAccountButton;
    private JButton loginButton;
    private JLabel createNewAccountLabel;
    private JLabel titleLabel;
    private JLabel sloganlabel;
    private JLabel loginInstructionLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    public LoginView() {
        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
