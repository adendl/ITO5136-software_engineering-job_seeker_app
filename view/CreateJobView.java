package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import controller.CreateJobController;
import view.UIView;

public class CreateJobView implements UIView {
    private JPanel panelMain;
    private JTextArea jobDescriptionText;
    private JButton createJobButton;
    private JLabel createJobLabel;
    private JLabel jobTitleLabel;
    private JLabel jobDescriptionLabel;
    private JLabel jobTypeLabel;
    private JLabel locationLabel;
    private JLabel companyLabel;
    private JLabel jobCategoryLabel;
    private JLabel salaryRangeLabel;
    private JTextArea jobTitleText;
    private JTextArea locationText;
    private JTextArea companyText;
    private JTextArea jobTypeText;
    private JTextArea jobCategoryText;
    private JTextArea salaryRangeText;
    private CreateJobController controller;

    public CreateJobView(CreateJobController controller) {
        this.controller = controller;
        createJobButton.addActionListener((e) -> {
            doCreateJob();
        });
    }

    private void doCreateJob() {
        String description = jobDescriptionText.getText();
        String title = jobTitleText.getText();
        String jobType = jobTypeText.getText();
        String company = companyText.getText();
        String salaryRange = salaryRangeText.getText();
        controller.doCreateJob(title, description, jobType, company, salaryRange);
    }
    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public JTextArea getJobDescriptionText() {
        return jobDescriptionText;
    }

    public JTextArea getJobTitleText() {
        return jobTitleText;
    }

    public JTextArea getLocationText() {
        return locationText;
    }

    public JTextArea getCompanyText() {
        return companyText;
    }

    public JTextArea getJobTypeText() {
        return jobTypeText;
    }

    public JTextArea getJobCategoryText() {
        return jobCategoryText;
    }

    public JTextArea getSalaryRangeText() {
        return salaryRangeText;
    }

    public static void main(String[] args) {
        CreateJobView myCreateJobView = new CreateJobView(null);
        ViewHelper.showStandaloneFrame(myCreateJobView);
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
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        jobTitleLabel = new JLabel();
        jobTitleLabel.setText("model.Job Title");
        panelMain.add(jobTitleLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jobDescriptionLabel = new JLabel();
        jobDescriptionLabel.setText("JobDescription");
        panelMain.add(jobDescriptionLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jobDescriptionText = new JTextArea();
        panelMain.add(jobDescriptionText, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 9, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        jobTypeLabel = new JLabel();
        jobTypeLabel.setText("model.Job Type");
        panelMain.add(jobTypeLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jobCategoryLabel = new JLabel();
        jobCategoryLabel.setText("model.Job Category");
        panelMain.add(jobCategoryLabel, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        companyLabel = new JLabel();
        companyLabel.setText("Company");
        panelMain.add(companyLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        locationLabel = new JLabel();
        locationLabel.setText("Location");
        panelMain.add(locationLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createJobButton = new JButton();
        createJobButton.setText("Create model.Job Listing");
        panelMain.add(createJobButton, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        salaryRangeLabel = new JLabel();
        salaryRangeLabel.setText("Salary Range");
        panelMain.add(salaryRangeLabel, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        createJobLabel = new JLabel();
        createJobLabel.setText("Create model.Job Listing");
        panelMain.add(createJobLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jobTitleText = new JTextArea();
        panelMain.add(jobTitleText, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        locationText = new JTextArea();
        panelMain.add(locationText, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        companyText = new JTextArea();
        panelMain.add(companyText, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        jobTypeText = new JTextArea();
        panelMain.add(jobTypeText, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        jobCategoryText = new JTextArea();
        panelMain.add(jobCategoryText, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        salaryRangeText = new JTextArea();
        panelMain.add(salaryRangeText, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
