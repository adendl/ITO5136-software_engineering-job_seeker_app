package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.HomeRecruiterController;
import model.Keyword;

public class HomePageRecruiterView implements UIView {
    private JButton createNewJobButton;
    private JPanel panelMain;
    private JButton manageListedJobsButton;
    private JButton editProfileButton;
    private JButton viewMailboxButton;
    private HomeRecruiterController controller;

    public HomePageRecruiterView(HomeRecruiterController controller) {
        this.controller = controller;
        createNewJobButton.addActionListener((e) -> {
            try {
                controller.showCreateJob();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        manageListedJobsButton.addActionListener((e) -> {
            controller.showManageListedJobs();
        });
        editProfileButton.addActionListener((e) -> {
            controller.showEditProfile();
        });
        viewMailboxButton.addActionListener((e) -> {
            controller.showMailbox();
        });
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }
    public JPanel getPanelMain() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        HomePageRecruiterView h = new HomePageRecruiterView(null);
        ViewHelper.showStandaloneFrame(h);
    }
}
