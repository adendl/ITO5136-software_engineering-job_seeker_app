package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.UIView;
import view.ViewHelper;
import controller.LoginController;

public class LoginView implements UIView {
    private JTextField emailText;
    private JButton forgotPasswordButton;
    private JPasswordField passwordText;
    private JButton createNewAccountButton;
    private JButton loginButton;
    private JLabel titleLabel;
    private JLabel sloganLabel;
    private JLabel loginInstructionLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel panelMain;
    private JButton forgotPasswordButton;
    private LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
        loginButton.addActionListener((e) -> {
            // note: getText() is deprecated on JPasswordField, getPassword() replaces it
            String password = String.valueOf(passwordText.getPassword());
            try {
                controller.doLogin(emailText.getText(), password);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        createNewAccountButton.addActionListener((e) -> {
            controller.showCreateAccount();
        });
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public JPasswordField getPasswordText() {
        return passwordText;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        LoginView view = new LoginView(null);
        ViewHelper.showStandaloneFrame((UIView) view);
    }
}
