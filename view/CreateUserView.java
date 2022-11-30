package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

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

    public CreateUserView(){

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

    public void addCreateAccountButtonListener(ActionListener createAccountButtonListener) {
        createAccountButton.addActionListener(createAccountButtonListener);
    }


    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public static void main(String[] args) {
        CreateUserView view = new CreateUserView();
        ViewHelper.showStandaloneFrame(view);
    }
}
