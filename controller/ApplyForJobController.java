package controller;

import java.io.File;

import model.*;
import view.AppliedJobView;
import view.JobApplicationView;

import static java.lang.Integer.valueOf;


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
    public void doJobApply(String FirstName, String lastName, String email, String phone, String resumeId, String coverLetterId){
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicantId(user.getUserId());
        jobApplication.setJobId(String.valueOf(job.getJobId()));
        jobApplication.setResumeId(resumeId);
        //TODO: create in db.
        //show appliedJobView
        AppliedJobView appliedJobView = new AppliedJobView(this);
        //populate applied job view.
        navigationController.pushView(appliedJobView);
    }
}
