package view;

import javax.swing.*;
import java.sql.SQLException;

import controller.HomeJobSeekerController;

public class HomePageJobSeekerView implements UIView {
    private JButton searchJobsButton;
    private JPanel panelMain;
    private JButton viewApplicationsButton;
    private JButton viewMailboxButton;
    private JButton editProfileButton;
    private HomeJobSeekerController controller;

    public HomePageJobSeekerView(HomeJobSeekerController controller) {
        this.controller = controller;

        searchJobsButton.addActionListener((e) -> {
            try {
                controller.showJobSearch();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        viewApplicationsButton.addActionListener((e) -> {
            controller.showJobApplications();
        });
        viewMailboxButton.addActionListener((e) -> {
            controller.showMailbox();
        });
        editProfileButton.addActionListener((e) -> {
            try {
                controller.showEditProfile();
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
        HomePageJobSeekerView view = new HomePageJobSeekerView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
