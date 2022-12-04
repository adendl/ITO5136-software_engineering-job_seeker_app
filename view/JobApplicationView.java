package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import controller.ApplyForJobController;
import controller.HomeJobSeekerController;
import controller.NavigationController;
import model.CoverLetter;
import model.Resume;
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
    private int resumeId;
    private int coverLetterId;

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getFirstNameText() {
        return firstNameText;
    }

    public void setFirstNameText(JTextField firstNameText) {
        this.firstNameText = firstNameText;
    }

    public JTextField getLastNameText() {
        return lastNameText;
    }

    public void setLastNameText(JTextField lastNameText) {
        this.lastNameText = lastNameText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public void setEmailText(JTextField emailText) {
        this.emailText = emailText;
    }

    public JTextField getPhoneText() {
        return phoneText;
    }

    public void setPhoneText(JTextField phoneText) {
        this.phoneText = phoneText;
    }

    public JobApplicationView(ApplyForJobController controller) {
        this.controller = controller;
        submitButton.addActionListener((e -> {
            String firstName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String email = emailText.getText();
            controller.doJobApply(firstName, lastName, email, resumeId, coverLetterId);
        }));
        browseResumeButton.addActionListener((e -> {
            //upload resume
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(this.getUIView());
            if(response == JFileChooser.APPROVE_OPTION) {
                File upload = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(upload);
                if(upload != null){
                    File newFile = new File("Files/resume/" + upload.getName());
                    doUpload(upload, newFile);
                    my_Resume_2022PdfText.setText(upload.getName());
                    //create resume object and save in db.
                   //resumeId is dynamically generated this.resumeId = controller.storeResume(newFile.getName(), newFile.getAbsolutePath());
                    System.out.println("Resume uploaded in Files/resume");
                } else {
                    System.out.println("Error file not uploaded");
                }
            }
        }));
        browseCoverLetterButton.addActionListener((e -> {
            //upload cover letter
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(this.getUIView());
            if(response == JFileChooser.APPROVE_OPTION){
                File upload = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(upload);
                if(upload != null){
                    File newFile =new File("Files/coverletter/" + upload.getName());
                    doUpload(upload, newFile);
                    basket_weaver_2022PdfText.setText(upload.getName());
                    //create cover letter object and save in db.
            //cover letterId is uniquely generated        this.coverLetterId = controller.storeCoverLetter(newFile.getName(), newFile.getAbsolutePath());
                    System.out.println("Cover letter uploaded in Files/coverletter");
                } else {
                    System.out.println("Error file not uploaded");
                }
            }
        }));
    }


    public void doJobApply(){
        //todo: check for null resumeId and coverLetterId.
        controller.doJobApply(getFirstName(), getLastName(), getEmail(), resumeId, coverLetterId);
    }

    public void doUpload(File upload, File newFile){
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(upload).getChannel();
            destination = new FileOutputStream(newFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        } catch(Exception error) {
            System.out.println("Error file not uploaded");
        }
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
