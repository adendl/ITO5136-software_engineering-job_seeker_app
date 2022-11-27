package controller;

import view.*;
import model.User;
import model.Recruiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeRecruiterController {
    public HomeRecruiterController(NavigationController navigationController, HomePageRecruiterView homePageRecruiterView, CreateJobView createJobView, JobListingsView jobListingsView, MailboxView mailboxView){

        //initialise CreateJobController
        CreateJobController createJobController = new CreateJobController(createJobView);

        //sends to createJobView
        homePageRecruiterView.addCreateNewJobButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(createJobView);
            }
        });

        //sends to recruiterProfileEditView which currently does not exist.
        homePageRecruiterView.addEditProfileButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //navigationController.setContentArea();
            }
        });

        //sends to jobListingsView
        homePageRecruiterView.addManageListedJobsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(jobListingsView);
            }
        });


    }
}
