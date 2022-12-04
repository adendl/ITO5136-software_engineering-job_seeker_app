package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

import controller.CreateJobController;
import controller.Validation;
import model.Keyword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

public class CreateJobView implements UIView {
    private JPanel panelMain;
    private JTextArea jobDescriptionText;
    private JButton createJobButton;
    private JLabel createJobLabel;
    private JLabel jobTitleLabel;
    private JLabel jobDescriptionLabel;
    private JLabel locationLabel;
    private JLabel companyLabel;
    private JLabel jobCategoryLabel;
    private JLabel salaryRangeLabel;
    private JTextArea jobTitleText;
    private JComboBox salaryComboBox;
    private JComboBox categoryComboBox;
    private JComboBox locationComboBox;
    private JTextField companyText;
    private JList skillsList;

    private CreateJobController controller;

    public boolean validateJob(String company, String description, String title, String city, String categories, String salary)
    {
        System.out.println(company);
        System.out.println(description);
        System.out.println(title);
        System.out.println(city);
        if (!Validation.betweenLength(company, 2, 50))
        {
            JOptionPane.showMessageDialog(null, "Please enter valid company name", "Invalid company name", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validation.betweenLength(description, 1, 500))
        {
            JOptionPane.showMessageDialog(null, "Please enter valid description", "Invalid description", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validation.betweenLength(title, 2, 50))
        {
            JOptionPane.showMessageDialog(null, "Please enter valid job title", "Invalid job title", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validation.betweenLength(city, 2, 50))
        {
            JOptionPane.showMessageDialog(null, "Please select a city", "Invalid city", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validation.betweenLength(salary, 2, 50))
        {
            JOptionPane.showMessageDialog(null, "Please select a salary range", "Invalid salary", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validation.betweenLength(categories, 2, 50))
        {
            JOptionPane.showMessageDialog(null, "Please select a category", "Invalid category", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public JList getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(JList skillsList) {
        this.skillsList = skillsList;
    }

    public CreateJobView(CreateJobController controller) {
        this.controller = controller;


    }

    public void setBtnToCreate(){
        createJobButton.addActionListener((e) -> {
            String company = companyText.getText();
            String description = getJobDescriptionText().getText();
            String title = getJobTitleText().getText();
            String city = locationComboBox.getSelectedItem().toString();
            String categories = categoryComboBox.getSelectedItem().toString();
            String salary = salaryComboBox.getSelectedItem().toString();
            java.util.List skillValueList = skillsList.getSelectedValuesList();
            String skillIds = "";
            for (int i = 0; i < skillValueList.size(); i++)
            {
                try {
                    skillIds += (Keyword.getKeywordByValue(skillValueList.get(i).toString()).getString("keywordId") + ",");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (validateJob(company, description, title, city, categories, salary)) {
                System.out.println("PASSED");
                try {
                    controller.doCreateJob(title, description, company, city, categories, salary, skillIds);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else
            {
                System.out.println("Job creation failed");
            }


        });
    }

    public void setBtnToEdit(){
        createJobButton.setText("Edit");
        createJobButton.addActionListener(e -> {
            String company = companyText.getText();
            String description = getJobDescriptionText().getText();
            String title = getJobTitleText().getText();
            String city = locationComboBox.getSelectedItem().toString();
            String categories = categoryComboBox.getSelectedItem().toString();
            String salary = salaryComboBox.getSelectedItem().toString();
            java.util.List skillValueList = skillsList.getSelectedValuesList();
            String skillIds = "";
            for (int i = 0; i < skillValueList.size(); i++)
            {
                try {
                    skillIds += (Keyword.getKeywordByValue(skillValueList.get(i).toString()).getString("keywordId") + ",");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (validateJob(company, description, title, city, categories, salary)) {
                System.out.println("PASSED");
                try {
                    controller.doUpdateJob(title, description, company, city, categories, salary, skillIds);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else
            {
                System.out.println("Job creation failed");
            }
        });
    }

    public JComboBox getSalaryComboBox() {
        return salaryComboBox;
    }

    public JLabel getCreateJobLabel() {
        return createJobLabel;
    }

    public void setSalaryComboBox(JComboBox salaryComboBox) {
        this.salaryComboBox = salaryComboBox;
    }

    public JComboBox getCategoryComboBox() {
        return categoryComboBox;
    }

    public void setCategoryComboBox(JComboBox categoryComboBox) {
        this.categoryComboBox = categoryComboBox;
    }

    public JComboBox getLocationComboBox() {
        return locationComboBox;
    }

    public void setLocationComboBox(JComboBox locationComboBox) {
        this.locationComboBox = locationComboBox;
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

    public JTextField getCompanyText() {
        return companyText;
    }


    public static void main(String[] args) {
        CreateJobView myCreateJobView = new CreateJobView(null);
        ViewHelper.showStandaloneFrame(myCreateJobView);
    }
}
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!