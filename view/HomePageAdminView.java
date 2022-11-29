package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeAdminController;
import view.UIView;
import view.ViewHelper;

public class HomePageAdminView implements UIView {
    private JButton manageUsersButton;
    private JPanel panelMain;
    private JButton manageCategoriesButton;
    private JButton manageSkillsButton;
    private JButton manageLocationsButton;
    private HomeAdminController controller;

    public HomePageAdminView(HomeAdminController controller) {
        this.controller = controller;
        manageUsersButton.addActionListener((e) -> {
            controller.showManageUsers();
        });
        manageCategoriesButton.addActionListener((e) -> {
            controller.showManageCategories();
        });
        manageSkillsButton.addActionListener((e) -> {
            controller.showManageSkills();
        });
        manageLocationsButton.addActionListener((e) -> {
            controller.showManageLocations();
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        HomePageAdminView view = new HomePageAdminView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
