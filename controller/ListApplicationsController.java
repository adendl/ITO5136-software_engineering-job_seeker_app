package controller;

import model.ApplicationList;
import model.Job;
import model.JobApplication;
import model.User;
import view.ApplicationsView;
import view.AppliedJobView;
import view.JobApplicationView;
import view.JobListingsView;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListApplicationsController {
    private NavigationController navigationController;
    private User user;
    private int jobId;
    private ApplicationList applicationList;

    public ListApplicationsController(NavigationController controller, User user, int jobId){
        this.navigationController = controller;
        this.user = user;
        this.jobId = jobId;
        applicationList = new ApplicationList();
    }

    public void renderListedApplications() {
        DefaultTableModel dft = applicationList.applicationListDft(this.jobId);
        ApplicationsView view = new ApplicationsView(this);
        view.getTable1().setModel(dft);
        view.renderTableForRecruiter();
        navigationController.pushView(view);
    }

    public void viewApplication(JobApplication application) {
        AppliedJobView view = new AppliedJobView(this);
        view.setTitleLabelTxt("Application for " + application.getJobTitleFromDB());
        view.setEmailText(application.getApplicantId());
        view.setFirstNameText(application.getApplicantFirstNameFromDB());
        view.setLastNameText(application.getApplicantLastNameFromDB());
        view.setResumeText(application.getApplicantResumeNameFromDB());
        view.setJobDescription(application.getJobDescriptionFromDB());
        view.setJobIdText(application.getJobId());
        navigationController.pushView(view);
    }

    public void sendInvitation(String applicantID){
        MailboxController mailboxController = new MailboxController(navigationController, user);
        User applicant;
        try {
            applicant = new User(applicantID);
        }
        catch (SQLException e){
            System.err.println("Cannot retrieve Job from Db: " + e);
            applicant = new User();
        }

        Job job;
        try {
            job = new Job(this.jobId);
        }
        catch (SQLException e){
            System.err.println("Cannot retrieve Job from Db: " + e);
            job = new Job();
        }

        mailboxController.sendInvitationMessage(job, applicant);

    }



}
