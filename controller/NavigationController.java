package controller;

import javax.swing.*;
import java.util.ArrayDeque;

import view.NavigationBar;
import view.UIView;

public class NavigationController {
    JPanel contentArea;
    ArrayDeque<UIView> navigationStack;
    NavigationBar navigationBar;

    public NavigationController() {
        navigationStack = new ArrayDeque<>();
    }

    public void doBack() {
        popView();
    }

    public void doHome() {
        popUntilLast();
    }

    public void doLogout() {
        boolean confirmLogout =  JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "Confirm logout", JOptionPane.YES_NO_OPTION) == 0;
        if (!confirmLogout) {
            // user selected 'no'
            return;
        }

        LoginController loginController = new LoginController(this);
        loginController.showLogin();
    }

    public JPanel getContentArea() {
        return contentArea;
    }

    public void setContentArea(JPanel contentArea) {
        this.contentArea = contentArea;
    }

    public void popView() {
        if (navigationStack.size() == 1) {
            // can't pop
            System.out.println("can't pop - only one item on stack");
            return;
        }
        UIView view = navigationStack.pop();
        System.out.println("popping view " + view.getClass().getCanonicalName());
        updateNavBar();

        contentArea.removeAll();
        contentArea.add(navigationStack.getFirst().getUIView());

        contentArea.revalidate();
        contentArea.repaint();
    }

    // pop views until only one remains, as a way to return home
    public void popUntilLast() {
        if (navigationStack.size() == 1) {
            // can't pop
            System.out.println("can't pop - only one item on stack");
            return;
        }
        UIView view = navigationStack.pop();
        System.out.println("popping view " + view.getClass().getCanonicalName());
        while (navigationStack.size() > 1) {
            view = navigationStack.pop();
            System.out.println("popping view " + view.getClass().getCanonicalName());
        }
        updateNavBar();

        contentArea.removeAll();
        contentArea.add(navigationStack.getFirst().getUIView());

        contentArea.revalidate();
        contentArea.repaint();
    }

    public void pushView(UIView view) {
        contentArea.removeAll();

        System.out.println("pushing view " + view.getClass().getCanonicalName());
        navigationStack.push(view);
        updateNavBar();
        contentArea.add(view.getUIView());

        contentArea.revalidate();
        contentArea.repaint();
    }

    // blow away the existing navigation stack and push a view to be the new base of the stack
    // this is useful for switching between Login and Home views, for example
    public void pushReplacementView(UIView view) {
        navigationStack.clear();
        navigationStack.push(view);
        updateNavBar();

        contentArea.removeAll();
        contentArea.add(navigationStack.getFirst().getUIView());

        contentArea.revalidate();
        contentArea.repaint();
    }

    public void setNavigationBar(NavigationBar bar) {
        navigationBar = bar;
    }

    void updateNavBar() {
        navigationBar.setBackButtonEnabled(navigationStack.size() > 1);
    }
}
