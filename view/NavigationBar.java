package view;

import controller.NavigationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBar {
    private JButton backButton;
    private JButton logoutButton;
    private JPanel mainPanel;

    NavigationController controller;

    public NavigationBar(NavigationController controller) {
        this.controller = controller;
        backButton.addActionListener((ActionEvent e) -> {
            controller.doBack();
        });
        logoutButton.addActionListener((ActionEvent e) -> {
            controller.doLogout();
        });
    }

    public JComponent getUIComponent() {
        return mainPanel;
    }
}
