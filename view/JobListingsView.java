package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeRecruiterController;
import model.Job;
import view.UIView;
import view.ViewHelper;

public class JobListingsView implements UIView {
    private JPanel panelMain;
    private JTable jobListingsTable;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;
    private HomeRecruiterController controller;

    public JobListingsView(HomeRecruiterController controller) {
        this.controller = controller;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setJobListingsTable(JTable jobListingsTable) {
        this.jobListingsTable = jobListingsTable;
    }

    public void addPreviousButtonListener(ActionListener buttonListener) {
        previousButton.addActionListener(buttonListener);
    }

    public void addNextButtonListener(ActionListener buttonListener) {
        nextButton.addActionListener(buttonListener);
    }

    public void addSortByButtonListener(ActionListener buttonListener) {
        sortByButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        JobListingsView view = new JobListingsView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
