package controller;

import model.Job;
import model.JobApplication;
import model.JobSeeker;
import view.AppliedJobView;
import view.JobApplicationView;


public class ApplyForJobController {
    //TODO: take in a Job and Job seeker in the constructor
    JobSeeker user;
    Job job;
    NavigationController navigationController;
    //takes in the jobDetailView, jobApplyView, confirmApplyView .
    public ApplyForJobController(NavigationController navigationController, JobSeeker user, Job job){
        this.navigationController = navigationController;
        this.job = job;
        this.user = user;
    }

    //resume and cover letter path need to be added
    public void doJobApply(String FirstName, String lastName, String email, String phone){
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicantId(user.getUserId());
        jobApplication.setJobId(String.valueOf(job.getJobId()));
        //create in db.
        //show appliedJobView
        AppliedJobView appliedJobView = new AppliedJobView(this);
        //populate applied job view.
        navigationController.pushView(appliedJobView);
    }
}
