package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.HomeRecruiterController;
import controller.ListJobsController;
import model.Job;
import model.JobList;
import model.TableModelCreator;
import view.UIView;
import view.ViewHelper;

public class JobListingsView implements UIView {
    private JPanel panelMain;
    private JTable jobListingsTable;
    private JButton populateTable;
    private JLabel headingText;
    private ListJobsController controller;

    public JobListingsView(ListJobsController controller) {
        this.controller = controller;
    }

    public void renderTable(){
        ActionListener listener = e1 -> {
            int row = jobListingsTable.convertRowIndexToModel(jobListingsTable.getEditingRow());
            int col = (jobListingsTable.getModel().getColumnCount() - 2);
            controller.showJobDetails((Job)jobListingsTable.getModel().getValueAt(row, col));
            System.out.println("Go to Job View");
        };

        TableModelCreator.addActionColumn((DefaultTableModel) jobListingsTable.getModel(), "Job Details", "More Details", listener);

        jobListingsTable.removeColumn(jobListingsTable.getColumn("LocationId"));
        jobListingsTable.removeColumn(jobListingsTable.getColumn("Recruiter"));
        jobListingsTable.removeColumn(jobListingsTable.getColumn("Status"));
        jobListingsTable.removeColumn(jobListingsTable.getColumn("Keywords"));
        jobListingsTable.removeColumn(jobListingsTable.getColumn("IsAdvertised"));
        jobListingsTable.removeColumn(jobListingsTable.getColumn("JobObject"));

        jobListingsTable.setFocusable(true);
        jobListingsTable.setColumnSelectionAllowed(false);
        jobListingsTable.setRowSelectionAllowed(false);

        JTableButtonRenderer renderer = new JTableButtonRenderer();
        jobListingsTable.getColumn("Job Details").setCellRenderer(renderer);
        jobListingsTable.getColumn("Job Details").setCellEditor(renderer);
    }


    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public JTable getJobListingsTable() {
        return jobListingsTable;
    }

    public static void main(String[] args) {
        //JobListingsView view = new JobListingsView(null, null);
       // ViewHelper.showStandaloneFrame(view);
    }
}
