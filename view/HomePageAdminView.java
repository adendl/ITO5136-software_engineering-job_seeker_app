package view;

import javax.swing.*;
import java.sql.SQLException;

import controller.HomeAdminController;

public class HomePageAdminView implements UIView {
    private JButton manageUsersButton;
    private JPanel panelMain;
    private JButton manageKeywordsButton;
    private JButton manageSkillsButton;
    private JButton manageLocationsButton;
    private HomeAdminController controller;

    public HomePageAdminView(HomeAdminController controller) {
        this.controller = controller;
        manageUsersButton.addActionListener((e) -> {
            try {
                controller.showManageUsers();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        manageKeywordsButton.addActionListener((e) -> {
            try {
                controller.showManageKeywords();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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
