package view;

import javax.swing.*;
import controller.ListJobsController;
import controller.SearchAlgorithmController;

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
    private JButton seachForCandidatesButton;

    SearchAlgorithmController searchAlgorithmController;
    ListJobsController listJobsController;

    public JPanel getJobDetailsPanel() {
        return JobDetailsPanel;
    }

    public ReviewJobDetailsView(SearchAlgorithmController controller) {
        this.searchAlgorithmController = controller;
    }

    public ReviewJobDetailsView(ListJobsController controller) {
        this.listJobsController = controller;
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

    public JButton getBtnApplyNow() {
        return btnAdvertise;
    }

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
