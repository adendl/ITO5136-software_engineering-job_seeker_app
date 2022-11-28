package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;
import controller.LoginController;

public class CreateUserView implements UIView {
    private JPanel mainPanel;
    private JTextField firstNameText;
    private JTextField emailText;
    private JPasswordField enterPasswordText;
    private JPasswordField confirmPasswordText;
    private JComboBox selectUserTypeComboBox;
    private JButton createAccountButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JTextField lastNameText;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel selectUserLabel;
    private LoginController controller;

    public CreateUserView(LoginController controller) {
        this.controller = controller;
        createAccountButton.addActionListener((e) -> {
            createAccount();
        });
    }
    private void createAccount() {
        String email  = emailText.getText();
        String password = String.valueOf(enterPasswordText.getPassword());
        String passwordConfirm = String.valueOf(confirmPasswordText.getPassword());
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        int userType = selectUserTypeComboBox.getSelectedIndex();

        if (!password.equals(passwordConfirm)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!", "Password mismatch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        controller.doCreateAccount(firstName, lastName, email, password, userType);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getFirstNameText() {
        return firstNameText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public JPasswordField getEnterPasswordText() {
        return enterPasswordText;
    }

    public JPasswordField getConfirmPasswordText() {
        return confirmPasswordText;
    }

    public JComboBox getSelectUserTypeComboBox() {
        return selectUserTypeComboBox;
    }

    public JTextField getLastNameText() {
        return lastNameText;
    }


    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public static void main(String[] args) {
        CreateUserView view = new CreateUserView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
