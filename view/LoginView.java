package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class LoginView implements UIView {
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
    private JPanel panelMain;

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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        LoginView view = new LoginView();
        ViewHelper.showStandaloneFrame(view);
    }
}
