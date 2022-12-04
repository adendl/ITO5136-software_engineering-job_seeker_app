package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import controller.ListApplicationsController;

public class AppliedJobView implements UIView {

    private JLabel titleLabel;
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JButton viewResumeButton;
    private JButton viewCoverLetterButton;
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
    private JLabel jobDescriptionLabel;
    private JTextField basket_weaver_2022PdfText;
    private JTextField my_Resume_2022PdfText;
    private JPanel panelMain;
    private JButton sendInvitationBtn;
    private JTextField jobIdText;
    private JLabel jobIdLabel;
    private ListApplicationsController controller;

    public AppliedJobView(ListApplicationsController controller) {
        this.controller = controller;
        sendInvitationBtn.addActionListener(e -> {
           controller.sendInvitation(getEmailText());
        });

    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        //AppliedJobView view = new AppliedJobView(null);
        //ViewHelper.showStandaloneFrame(view);
    }

    public void setTitleLabelTxt(String str){
        titleLabel.setText(str);
    }

    public void setFirstNameText(String firstNameText) {
        this.firstNameText.setText(firstNameText);
    }

    public void setLastNameText(String lastNameText) {
        this.lastNameText.setText(lastNameText);
    }

    public void setEmailText(String emailText) {
        this.emailText.setText(emailText);
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescriptionTextPane.setText(jobDescription);
    }

    public String getEmailText() {
        return emailText.getText();
    }

    public void setCoverLetterText(String coverLetterText) {
        this.basket_weaver_2022PdfText.setText(coverLetterText);
    }

    public void setResumeText(String resumeText) {
        this.my_Resume_2022PdfText.setText(resumeText);
    }

    public String getJobIdText() {
        return jobIdText.getText();
    }

    public void setJobIdText(int jobIdText) {
        this.jobIdText.setText(String.valueOf(jobIdText));
    }

    public void addViewCoverLetterButtonListener(ActionListener viewCoverLetterButtonListener) {
        viewCoverLetterButton.addActionListener(viewCoverLetterButtonListener);
    }
}
