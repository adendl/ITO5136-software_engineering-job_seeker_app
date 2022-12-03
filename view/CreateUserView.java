package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import controller.Validation;
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

    public LoginController getController()
    {
        return controller;
    }

    public boolean validateUser(String email, String password, String passwordConfirm, String firstName, String lastName)
    {
        if (!Validation.isEmail(email)) {
            this.getController().displayErrrorMessage("The email entered is not in the correct format of emailaddress@domain.com", "Invalid Email Address");
            return false;
        }
        if (!Validation.betweenLength(password, 8,255))
        {
            getController().displayErrrorMessage("Passwords need to be between 8-255 characters", "Invalid Password");
            return false;
        }
        if (!password.equals(passwordConfirm)) {
            getController().displayErrrorMessage("Passwords do not match", "Invalid Password");
            return false;
        }
        if (!Validation.betweenLength(firstName, 2,255))
        {
            getController().displayErrrorMessage("Names need to be between 2-255 characters", "Invalid Name");
            return false;
        }
        if (!Validation.betweenLength(lastName, 2,255))
        {
            getController().displayErrrorMessage("Names need to be between 2-255 characters", "Invalid Name");
            return false;
        }
        return true;
    }

    private void createAccount() {
        String email  = emailText.getText();
        String password = String.valueOf(enterPasswordText.getPassword());
        String passwordConfirm = String.valueOf(confirmPasswordText.getPassword());
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        int userType = selectUserTypeComboBox.getSelectedIndex();

        if (this.validateUser(email, password, passwordConfirm, firstName, lastName))
        {
            controller.doCreateAccount(firstName, lastName, email, password, userType);
        }
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
