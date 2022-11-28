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
            // TODO: pass in the values rather than having the controller mess with our components
            controller.doCreateAccount(this);
        });
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
