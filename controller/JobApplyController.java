package controller;

import model.JobApplication;
import view.JobApplicationView;
import model.Job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobApplyController {
    //takes in the jobDetailView, jobApplyView, confirmApplyView .
    public JobApplyController(JobApplicationView jobApplicationView){

        jobApplicationView.addSubmitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //also need to get the resume and cover letter.
                String firstName = jobApplicationView.getFirstNameTextField().getText();
                String lastName = jobApplicationView.getLastNameTextField().getText();
                String email = jobApplicationView.getEmailTextField().getText();
                String phoneNumber = jobApplicationView.getPhoneTextField().getText();

                //populate constructor
                JobApplication newJobApplication = new JobApplication();
            }
        });
        jobApplicationView.addBrowseCoverLetterButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //upload cover letter
            }
        });

        jobApplicationView.addBrowseResumeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //upload resume
            }
        });

    }
}
