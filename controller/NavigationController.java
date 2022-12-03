package controller;

import javax.swing.*;
import java.util.ArrayDeque;

import view.*;

public class NavigationController {
    JPanel contentArea;
    ArrayDeque<UIView> navigationStack;
    NavigationBar navigationBar;
    UIView checkpoint;

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
        if (view == checkpoint) {
            checkpoint = null;
            return;
        }
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
            if (view == checkpoint) {
                checkpoint = null;
            }
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
        checkpoint = null;
        navigationStack.clear();
        navigationStack.push(view);
        updateNavBar();

        contentArea.removeAll();
        contentArea.add(navigationStack.getFirst().getUIView());

        contentArea.revalidate();
        contentArea.repaint();
    }

    // make the current view a 'checkpoint' that we can return to easily
    public void setCheckpoint() {
        this.checkpoint = navigationStack.getFirst();
    }

    public void popUntilCheckpoint() {
        if (checkpoint == null) {
            System.out.println("popUntilCheckpoint: no checkpoint to return to");
            return;
        }

        if (navigationStack.size() == 1) {
            System.out.println("popUntilCheckpoint: can't pop, only one item on stack");
            return;
        }

        UIView view = navigationStack.getFirst();
        if (view == checkpoint) {
            checkpoint = null;
            return;
        }

        while (navigationStack.size() > 1 && view != checkpoint) {
            view = navigationStack.pop();
            System.out.println("popping view " + view.getClass().getCanonicalName());
            if (view == checkpoint) {
                checkpoint = null;
                break;
            }
        }
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
        boolean loggingIn = navigationStack.getLast() instanceof LoginView;
        UIView current = navigationStack.getFirst();
        // is one of the home views showing?
        boolean atHome = current instanceof HomePageAdminView
                || current instanceof HomePageJobSeekerView
                || current instanceof HomePageRecruiterView;

        // enable home button if not logging in or already at the hub screen
        navigationBar.setHomeButtonEnabled(!loggingIn && !atHome);
        // enable logout button if we're not currently logging in
        navigationBar.setLogoutButtonEnabled(!loggingIn);
        // enable back button if there's something to go back to
        navigationBar.setBackButtonEnabled(navigationStack.size() > 1);
    }
}
