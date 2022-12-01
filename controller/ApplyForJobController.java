package controller;

import model.JobApplication;
import view.AppliedJobView;
import view.JobApplicationView;


public class ApplyForJobController {
    NavigationController navigationController;
    //takes in the jobDetailView, jobApplyView, confirmApplyView .
    public ApplyForJobController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    //resume and cover letter path need to be added
    public void submitApplication(String FirstName, String lastName, String email, String phone){
        JobApplication jobApplication = new JobApplication();
        //create in db.
        //show appliedJobView
        AppliedJobView appliedJobView = new AppliedJobView(this);
        navigationController.pushView(appliedJobView);
    }
}
