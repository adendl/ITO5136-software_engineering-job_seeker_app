package view;

import javax.swing.*;
import java.awt.event.ActionListener;

import controller.ApplyForJobController;
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
    private ApplyForJobController controller;

    public AppliedJobView(ApplyForJobController controller) {

    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        AppliedJobView view = new AppliedJobView();
        ViewHelper.showStandaloneFrame(view);
    }

    public void addViewResumeButtonListener(ActionListener viewResumeButtonListener) {
        viewResumeButton.addActionListener(viewResumeButtonListener);
    }

    public void addViewCoverLetterButtonListener(ActionListener viewCoverLetterButtonListener) {
        viewCoverLetterButton.addActionListener(viewCoverLetterButtonListener);
    }
}
