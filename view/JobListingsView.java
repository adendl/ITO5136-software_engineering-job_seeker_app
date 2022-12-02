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

    public JobListingsView(ListJobsController controller, DefaultTableModel dft) {
        this.controller = controller;

        ActionListener listener = e1 -> {
            int row = jobListingsTable.convertRowIndexToModel(jobListingsTable.getEditingRow());
            int col = jobListingsTable.getColumn("JobObject").getModelIndex();
            controller.showJobDetails((Job)jobListingsTable.getValueAt(row, col));
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

    public static void main(String[] args) {
        JobListingsView view = new JobListingsView(null, null);
        ViewHelper.showStandaloneFrame(view);
    }
}
