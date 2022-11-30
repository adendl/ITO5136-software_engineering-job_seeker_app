package view;

import controller.NavigationController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NavigationBar {
    private JButton backButton;
    private JButton logoutButton;
    private JPanel mainPanel;
    private JButton homeButton;

    NavigationController controller;

    public NavigationBar(NavigationController controller) {
        this.controller = controller;
        controller.setNavigationBar(this);
        backButton.addActionListener((ActionEvent e) -> {
            controller.doBack();
        });
        homeButton.addActionListener((e) -> {
            controller.doHome();
        });
        logoutButton.addActionListener((ActionEvent e) -> {
            controller.doLogout();
        });
    }

    public JComponent getUIComponent() {
        return mainPanel;
    }

    public void setBackButtonEnabled(boolean enable) {
        backButton.setEnabled(enable);
    }
}
