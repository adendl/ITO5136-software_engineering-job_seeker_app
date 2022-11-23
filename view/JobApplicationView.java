package view;

import javax.swing.*;
import java.awt.event.ActionListener;
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
    private JTextField emailTextLabel;
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

    public JobApplicationView() {
    }

    public JTextField getFirstNameTextField() {
        return firstNameText;
    }

    public JTextField getLastNameTextField() {
        return lastNameText;
    }

    public JTextField getEmailTextField() {
        return emailTextLabel;
    }

    public JTextField getPhoneTextField() {
        return phoneText;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public void setJobDescriptionTextPane(JTextPane jobDescriptionTextPane) {
        this.jobDescriptionTextPane = jobDescriptionTextPane;
    }

    public void addBrowseResumeButtonListener(ActionListener buttonListener) {
        browseResumeButton.addActionListener(buttonListener);
    }
    public void addBrowseCoverLetterButtonListener(ActionListener buttonListener) {
        browseCoverLetterButton.addActionListener(buttonListener);
    }
    public void addSubmitButtonListener(ActionListener buttonListener) {
        submitButton.addActionListener(buttonListener);
    }
    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        JobApplicationView view = new JobApplicationView();
        ViewHelper.showStandaloneFrame(view);
    }
}
