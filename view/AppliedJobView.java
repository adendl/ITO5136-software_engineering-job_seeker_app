package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

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

    public AppliedJobView() {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameText = firstNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameText = lastNameTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailText = emailTextField;
    }

    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneText = phoneTextField;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        AppliedJobView view = new AppliedJobView();
        ViewHelper.showStandaloneFrame(view);
    }

    public void setJobDescriptionTextPane(JTextPane jobDescriptionTextPane) {
        this.jobDescriptionTextPane = jobDescriptionTextPane;
    }

    public void addViewResumeButtonListener(ActionListener viewResumeButtonListener) {
        viewResumeButton.addActionListener(viewResumeButtonListener);
    }

    public void addViewCoverLetterButtonListener(ActionListener viewCoverLetterButtonListener) {
        viewCoverLetterButton.addActionListener(viewCoverLetterButtonListener);
    }
}
