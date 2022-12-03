package view;

import controller.ListJobsController;
import controller.NavigationController;
import controller.SearchAlgorithmController;

import javax.swing.*;
import java.awt.*;

public class JobDetailsView implements UIView {
    public JPanel JobDetailsPanel;
    private JLabel jobTitle;
    private JLabel lbJobDescription;
    private JTextArea txtDescription;
    private JButton btnApplyNow;
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

    SearchAlgorithmController searchAlgorithmController;
    ListJobsController listJobsController;

    public JPanel getJobDetailsPanel() {
        return JobDetailsPanel;
    }

    public JobDetailsView(SearchAlgorithmController controller) {
        this.searchAlgorithmController = controller;
    }

    public JobDetailsView(ListJobsController controller) {
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
        return btnApplyNow;
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

    public static void main(String[] args) {
        //JobDetailsView myJobDetailsView = new JobDetailsView();
        //ViewHelper.showStandaloneFrame(myJobDetailsView);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JobDetailsPanel = new JPanel();
        JobDetailsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        jobTitle = new JLabel();
        jobTitle.setText("model.Job Title");
        JobDetailsPanel.add(jobTitle, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbJobDescription = new JLabel();
        lbJobDescription.setText("model.Job Description");
        JobDetailsPanel.add(lbJobDescription, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtDescription = new JTextArea();
        JobDetailsPanel.add(txtDescription, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 9, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lbJobType = new JLabel();
        lbJobType.setText("model.Job Type");
        JobDetailsPanel.add(lbJobType, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbJobCategory = new JLabel();
        lbJobCategory.setText("model.Job Category");
        JobDetailsPanel.add(lbJobCategory, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbCompany = new JLabel();
        lbCompany.setText("Company");
        JobDetailsPanel.add(lbCompany, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnApplyNow = new JButton();
        btnApplyNow.setText("Apply Now");
        JobDetailsPanel.add(btnApplyNow, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbLocation = new JLabel();
        lbLocation.setText("Location");
        JobDetailsPanel.add(lbLocation, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbSalaryRange = new JLabel();
        lbSalaryRange.setText("Salary Range");
        JobDetailsPanel.add(lbSalaryRange, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtSalaryRange = new JTextArea();
        JobDetailsPanel.add(txtSalaryRange, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        txtJobCategory = new JTextArea();
        JobDetailsPanel.add(txtJobCategory, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        txtJobType = new JTextArea();
        JobDetailsPanel.add(txtJobType, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        txtCompany = new JTextArea();
        JobDetailsPanel.add(txtCompany, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        txtLocation = new JTextArea();
        JobDetailsPanel.add(txtLocation, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        txtJobTitle = new JTextArea();
        JobDetailsPanel.add(txtJobTitle, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lbJobDetails = new JLabel();
        lbJobDetails.setText("model.Job Details");
        JobDetailsPanel.add(lbJobDetails, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JobDetailsPanel;
    }
}
