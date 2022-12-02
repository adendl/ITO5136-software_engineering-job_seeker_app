package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import controller.ApplyForJobController;
import controller.HomeJobSeekerController;
import controller.NavigationController;
import view.UIView;
import view.ViewHelper;

public class JobApplicationView implements UIView {
    private JLabel titleLabel;
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JButton browseResumeButton;
    private JButton browseCoverLetterButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField emailText;
    private JTextField phoneText;
    private JLabel emailLabel;
    private JLabel attachResumeLabel;
    private JLabel resumeFileTypeLabel;
    private JLabel attachCoverLetterLabel;
    private JLabel coverLetterFileTypeLabel;
    private JTextPane jobDescriptionTextPane;
    private JButton submitButton;
    private JLabel jobDescriptionLabel;
    private JTextField basket_weaver_2022PdfText;
    private JTextField my_Resume_2022PdfText;
    private JPanel panelMain;
    private JLabel phoneLabel;
    private ApplyForJobController controller;

    public JobApplicationView(ApplyForJobController controller) {
        this.controller = controller;
        submitButton.addActionListener((e -> {
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String email = emailText.getText();
            String phone = phoneText.getText();
            controller.doJobApply(firstName, lastName, email, phone);
        }));
        browseResumeButton.addActionListener((e -> {
            //upload resume
            JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showOpenDialog(this.getUIView());

            if (i == JFileChooser.APPROVE_OPTION) {
                //add file to files
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();
            }
        }));
        browseCoverLetterButton.addActionListener((e -> {
            //upload cover letter
            JFileChooser fileChooser = new JFileChooser();
            int i = fileChooser.showOpenDialog(this.getUIView());

            if(i == JFileChooser.APPROVE_OPTION){
                //add file to files
                File file = fileChooser.getSelectedFile();
                String filePath = file.getPath();

            }
        }));
    }

    public void doJobApply(){
        controller.doJobApply(getFirstName(), getLastName(), getEmail(), getPhone());
    }

    public String getFirstName() {
        return firstNameText.getText();
    }

    public String getLastName() {
        return lastNameText.getText();
    }

    public String getEmail() {
        return emailText.getText();
    }

    public String getPhone() {
        return phoneText.getText();
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        JobApplicationView view = new JobApplicationView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
