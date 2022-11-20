package controller;

import javax.swing.*;
import java.util.ArrayDeque;

public class NavigationController {
    JPanel contentArea;
    public NavigationController() {
        // todo: create navigation view stack and set up anything that needs
    }

    public void doBack() {
        JOptionPane.showMessageDialog(null, "logout clicked");
    }

    public void doLogout() {
        JOptionPane.showMessageDialog(null, "logout clicked");
    }

    public JPanel getContentArea() {
        return contentArea;
    }

    public void setContentArea(JPanel contentArea) {
        this.contentArea = contentArea;
    }
}
