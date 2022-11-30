package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.HomeRecruiterController;
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
    private HomeRecruiterController controller;

    public JobListingsView(HomeRecruiterController controller) {
        this.controller = controller;

        JobList jobList = new JobList();
        ResultSet rs = jobList.listJobs();
        try {
            jobList.resultSetToJobList(rs);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        DefaultTableModel dft = jobList.jobListToTableModel();
        ActionListener listener = e1 -> {
            int row = jobListingsTable.convertRowIndexToModel(jobListingsTable.getEditingRow());
            int col = jobListingsTable.getColumn("JobObject").getModelIndex();

            JobDetailsView job = new JobDetailsView();
            Job newJob = (Job) jobListingsTable.getModel().getValueAt(row, col);
            job.getTxtCompany().setText(newJob.getCompany());
            job.getTxtJobTitle().setText(newJob.getTitle());
            job.getTxtJobDescription().setText(newJob.getDescription());
            job.getTxtSalaryRange().setText(String.valueOf(newJob.getSalaryMin()));
            job.getTxtSalaryRange().setText(String.valueOf(newJob.getSalaryMax()));
            System.out.println(newJob.getLocationId());
//            try {
//                job.getTxtLocation().setText(newJob.getLocationFromDb(newJob.getLocationId()));
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
        };

        TableModelCreator.addActionColumn(dft, "Job Details", "More Details", listener);
        jobListingsTable.setModel(dft);
        TableColumnModel tcm = jobListingsTable.getColumnModel();

        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("JobObject")));
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Category Id")));
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("IsAdvertised")));
        jobListingsTable.setFocusable(true);
        jobListingsTable.setColumnSelectionAllowed(false);
        jobListingsTable.setRowSelectionAllowed(false);

        JTableButtonRenderer renderer = new JTableButtonRenderer();
        jobListingsTable.getColumn(jobListingsTable.getColumnName(jobListingsTable.getColumnCount() - 1)).setCellRenderer(renderer);
        jobListingsTable.getColumn(jobListingsTable.getColumnName(jobListingsTable.getColumnCount() - 1)).setCellEditor(renderer);
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
