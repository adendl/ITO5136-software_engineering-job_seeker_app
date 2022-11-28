package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeJobSeekerController;
import view.UIView;
import view.ViewHelper;

public class HomePageJobSeekerView implements UIView {
    private JButton searchJobsButton;
    private JPanel panelMain;
    private JButton viewApplicationsButton;
    private JButton viewInvitationsButton;
    private JButton editProfileButton;
    private HomeJobSeekerController controller;

    public HomePageJobSeekerView(HomeJobSeekerController controller) {
        this.controller = controller;

        searchJobsButton.addActionListener((e) -> {
            controller.showJobSearch();
        });
        viewApplicationsButton.addActionListener((e) -> {
            controller.showJobApplications();
        });
        viewInvitationsButton.addActionListener((e) -> {
            controller.showInvitations();
        });
        editProfileButton.addActionListener((e) -> {
            controller.showEditProfile();
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
