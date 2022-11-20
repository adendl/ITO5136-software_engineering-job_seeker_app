package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.NavigationController;
import view.UIView;
import view.CreateJobView;

public class HomePageRecruiterView implements UIView {
    private JButton createNewJobButton;
    private JPanel panelMain;
    private JButton manageListedJobsButton;
    private JButton editCategoriesButton;
    private JButton editProfileButton;

    // temporary! we'll do this in the controller later
    NavigationController navController;

    public HomePageRecruiterView(NavigationController controller) {
        navController = controller;

        createNewJobButton.addActionListener((ActionEvent e) -> {
            //JOptionPane.showMessageDialog(null, "create new job");
            CreateJobView jobView = new CreateJobView();
            navController.pushView(jobView);
        });

        manageListedJobsButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "manage listed jobs");
        });

        editCategoriesButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "edit categories");
        });

        editProfileButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "edit profile");
        });

    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }
}
