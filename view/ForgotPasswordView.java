package view;

import controller.LoginController;
import controller.NavigationController;

import javax.swing.*;

public class ForgotPasswordView implements UIView{
    private JPanel panel1;
    private JButton okButton;
    private JLabel changeLabel;
    private LoginController controller;

    public ForgotPasswordView(LoginController controller, NavigationController navigationController){
        this.controller = controller;
        okButton.addActionListener((e -> {
            navigationController.doBack();
        }));
    }

    @Override
    public JComponent getUIView() {
        return panel1;
    }
}
