import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobApplicationView {
    private JLabel titleLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton browseResumeBtn;
    private JButton coverLetterBrowseBtn;
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
    private JButton submitBtn;
    private JLabel jobDescriptionLabel;
    private JTextField basket_weaver_2022PdfTextField;
    private JTextField my_Resume_2022PdfTextField;

    public JobApplicationView() {
        browseResumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        coverLetterBrowseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
