package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class LoginView implements UIView {
    private JTextField emailTextField;
    private JPasswordField passwordField;
public class LoginView {
    private JTextField emailText;
    private JPasswordField passwordText;
    private JButton createNewAccountButton;
    private JButton loginButton;
    private JLabel createNewAccountLabel;
    private JLabel titleLabel;
    private JLabel sloganLabel;
    private JLabel loginInstructionLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel panelMain;

    public LoginView() {

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

    public void addLoginButtonListener(ActionListener buttonListener) {
        loginButton.addActionListener(buttonListener);
    }
    public void addCreateNewAccountButtonListener(ActionListener buttonListener) {
        createNewAccountButton.addActionListener(buttonListener);
    }
    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        LoginView view = new LoginView();
        ViewHelper.showStandaloneFrame(view);
    }
}
