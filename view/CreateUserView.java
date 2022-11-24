package view;

import javax.swing.*;

import view.UIView;
import view.ViewHelper;

public class CreateUserView implements UIView {
    private JPanel mainPanel;
    private JTextField firstNameTextField;
    private JTextField emailTextField;
    private JPasswordField enterPasswordField;
    private JPasswordField confirmPasswordField;
    private JComboBox selectUserTypeComboBox;
    private JButton createAccountButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JTextField lastNameTextField;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel selectUserLabel;

    @Override
    public JComponent getUIView() {
        return mainPanel;
    }

    public static void main(String[] args) {
        CreateUserView view = new CreateUserView();
        ViewHelper.showStandaloneFrame(view);
    }
}
