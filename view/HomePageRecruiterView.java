package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;

public class HomePageRecruiterView implements UIView {
    private JButton createNewJobButton;
    private JPanel panelMain;
    private JButton manageListedJobsButton;
    private JButton editCategoriesButton;
    private JButton editProfileButton;

    public HomePageRecruiterView() {
        createNewJobButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "create new job");
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
