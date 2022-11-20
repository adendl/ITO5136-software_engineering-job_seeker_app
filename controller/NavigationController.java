package controller;

import javax.swing.*;
import java.util.ArrayDeque;

import view.UIView;

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

    public void popView() {
        // TODO: pop off navigation stack, update contentArea
    }

    public void pushView(UIView view) {
        // TODO: push onto a navigation stack
        contentArea.removeAll();
        contentArea.add(view.getUIView());
    }
}
