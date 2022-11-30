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
    private JButton populateTable;
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        JobListingsView view = new JobListingsView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
