package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeRecruiterController;
import controller.NavigationController;
import view.UIView;
import view.CreateJobView;

public class HomePageRecruiterView implements UIView {
    private JButton createNewJobButton;
    private JPanel panelMain;
    private JButton manageListedJobsButton;
    private JButton editCategoriesButton;
    private JButton editProfileButton;
    private HomeRecruiterController controller;

    public HomePageRecruiterView(HomeRecruiterController controller) {
        this.controller = controller;
        createNewJobButton.addActionListener((e) -> {
            controller.showCreateJob();
        });
        manageListedJobsButton.addActionListener((e) -> {
            controller.showManageListedJobs();
        });
        editCategoriesButton.addActionListener((e) -> {
            controller.showEditCategories();
        });
        editProfileButton.addActionListener((e) -> {
            controller.showEditProfile();
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
