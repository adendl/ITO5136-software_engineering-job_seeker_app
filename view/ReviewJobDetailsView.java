package view;

import javax.swing.*;
import controller.ListJobsController;

public class ReviewJobDetailsView implements UIView {
    public JPanel JobDetailsPanel;
    private JLabel jobTitle;
    private JLabel lbJobDescription;
    private JTextArea txtDescription;
    private JButton btnAdvertise;
    private JLabel lbJobType;
    private JLabel lbLocation;
    private JLabel lbCompany;
    private JLabel lbJobCategory;
    private JLabel lbSalaryRange;
    private JTextArea txtSalaryRange;
    private JTextArea txtJobCategory;
    private JTextArea txtJobType;
    private JTextArea txtCompany;
    private JTextArea txtLocation;
    private JTextArea txtJobTitle;
    private JLabel lbJobDetails;
    private JButton btnEditJob;
    private JButton btnViewApplications;
    private JButton searchForCandidatesButton;
    private JLabel lblJobId;
    private JTextArea txtJobId;
    ListJobsController listJobsController;

    public ReviewJobDetailsView(ListJobsController controller) {
        this.listJobsController = controller;
        btnAdvertise.addActionListener(e -> {
            controller.setJobToAdvertised(Integer.parseInt(txtJobId.getText()));

        });

        btnEditJob.addActionListener(e -> {
            controller.editJob(Integer.parseInt(getTxtJobId().getText()));
        });

        btnViewApplications.addActionListener(e -> {
            //controller
        });
    }

    public JPanel getJobDetailsPanel() {
        return JobDetailsPanel;
    }

    public JLabel getJobTitle() {
        return jobTitle;
    }

    public JLabel getLbJobDescription() {
        return lbJobDescription;
    }

    public JTextArea getTxtJobDescription() {
        return txtDescription;
    }

    public JTextArea getTxtJobId() { return txtJobId; }

    public JButton getBtnAdvertise() { return btnAdvertise; }

    public JLabel getLbJobType() {
        return lbJobType;
    }

    public JLabel getLbLocation() {
        return lbLocation;
    }

    public JLabel getLbCompany() {
        return lbCompany;
    }

    public JLabel getLbJobCategory() {
        return lbJobCategory;
    }

    public JLabel getLbSalaryRange() {
        return lbSalaryRange;
    }

    public JTextArea getTxtSalaryRange() {
        return txtSalaryRange;
    }

    public JTextArea getTxtJobCategory() {
        return txtJobCategory;
    }

    public JTextArea getTxtJobType() {
        return txtJobType;
    }

    public JTextArea getTxtCompany() {
        return txtCompany;
    }

    public JTextArea getTxtLocation() {
        return txtLocation;
    }

    public JTextArea getTxtJobTitle() {
        return txtJobTitle;
    }

    public JLabel getLbJobDetails() {
        return lbJobDetails;
    }

    @Override
    public JComponent getUIView() {
        return JobDetailsPanel;
    }

}
