package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class AppliedJobView implements UIView {

    private JLabel titleLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton viewResumeBtn;
    private JButton viewCoverLetterBtn;
    private JLabel firstNameField;
    private JLabel lastNameField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JLabel emailField;
    private JLabel attachResumeLabel;
    private JLabel resumeFileTypeLabel;
    private JLabel attachCoverLetterLabel;
    private JLabel coverLetterFileTypeLabel;
    private JTextPane jobDescriptionTextPane;
    private JLabel jobDescriptionLabel;
    private JTextField basket_weaver_2022PdfTextField;
    private JTextField my_Resume_2022PdfTextField;
    private JPanel panelMain;

    public AppliedJobView() {
        viewResumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        viewCoverLetterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        AppliedJobView view = new AppliedJobView();
        ViewHelper.showStandaloneFrame(view);
    }
}
