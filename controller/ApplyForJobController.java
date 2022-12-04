package controller;

import java.io.File;
import java.sql.SQLException;

import model.*;
import view.AppliedJobView;
import view.JobApplicationView;

import static java.lang.Integer.valueOf;


public class ApplyForJobController {
    //TODO: take in a Job and Job seeker in the constructor
    User user;
    Job job;
    NavigationController navigationController;

    JobApplicationView jobApplicationView;
    //takes in the jobDetailView, jobApplyView, confirmApplyView .
    public ApplyForJobController(NavigationController navigationController, User user, Job job){
        this.navigationController = navigationController;
        this.job = job;
        this.user = user;
    }

    public void doStartApplyProcess(Job job) throws SQLException {
         this.jobApplicationView = new JobApplicationView(this);
         loadPage(job, user);
         navigationController.pushView(jobApplicationView);
         System.out.println("dostartapplyprocess" + user.getUserId());

    }

    public void loadPage(Job job, User user) throws SQLException {
        jobApplicationView.getEmailText().setText(user.getUserId());
        jobApplicationView.getFirstNameText().setText(user.getFirstName());
        jobApplicationView.getLastNameText().setText(user.getLastName());
    }

    public String storeCoverLetter(String name, String path){
        CoverLetter coverLetter = new CoverLetter();
        coverLetter.setName(name);
        coverLetter.setPath(path);
        coverLetter.setUserId(valueOf(user.getUserId()));
        //TODO: add to db.
        return String.valueOf(coverLetter.getCoverLetterId());
    }

    public String storeResume(String name, String path){
        Resume resume = new Resume();
        resume.setUserId(valueOf(user.getUserId()));
        resume.setName(name);
        resume.setPath(path);
        //TODO: add to db.
        return String.valueOf(resume.getResumeId());
    }

    //resume and cover letter path need to be added
    public void doJobApply(String FirstName, String lastName, String email, String phone, int resumeId, int coverLetterId){
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicantId(user.getUserId());
        jobApplication.setJobId(job.getJobId());
        jobApplication.setResumeId(resumeId);
        //TODO: create in db.
        //show appliedJobView
        AppliedJobView appliedJobView = new AppliedJobView(this);
        //populate applied job view.
        navigationController.pushView(appliedJobView);
    }
}
