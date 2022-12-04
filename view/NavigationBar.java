package view;

import controller.NavigationController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NavigationBar {
    private JButton backButton;
    private JButton logoutButton;
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton unreadMessageButton;

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
        unreadMessageButton.setVisible(false);
        unreadMessageButton.addActionListener((e) -> {
            controller.showMailbox();
        });
    }

    public JComponent getUIComponent() {
        return mainPanel;
    }

    public void setBackButtonEnabled(boolean enable) {
        backButton.setEnabled(enable);
    }

    public void setHomeButtonEnabled(boolean enable) {
        homeButton.setEnabled(enable);
    }

    public void setLogoutButtonEnabled(boolean enable) {
        logoutButton.setEnabled(enable);
    }

    // set unread message button text and visibility according to the unread message count
    public void setUnreadMessageCount(int unreadCount) {
        if (unreadCount > 100) {
            unreadMessageButton.setText("99+ unread messages");
        } else {
            unreadMessageButton.setText(unreadCount + " unread messages");
        }

        unreadMessageButton.setVisible(unreadCount > 0);
    }
}
