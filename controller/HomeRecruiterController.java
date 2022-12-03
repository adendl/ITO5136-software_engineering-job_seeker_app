package controller;

import model.Keyword;
import view.*;
import model.Recruiter;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeRecruiterController {
    NavigationController navigationController;
    Recruiter user;
    public HomeRecruiterController(NavigationController navigationController, Recruiter user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public Recruiter getUser(){
        return user;
    }

    public void showHub() throws SQLException {
        HomePageRecruiterView view = new HomePageRecruiterView(this);
        navigationController.pushView(view);
    }

    public void showCreateJob() throws SQLException {
        CreateJobController createJobController = new CreateJobController(navigationController);
        createJobController.showCreateJob();
    }

    public void showEditCategories() {
        ManageCategoriesController manageCategoriesController = new ManageCategoriesController(navigationController);
        manageCategoriesController.showManageCategories();
    }

    public void showEditProfile() {
        // TODO: create a view for this and show it here
        RecruiterProfileController controller = new RecruiterProfileController(navigationController, user);
        controller.showEditRecruiter();
    }

    public void showManageListedJobs(ArrayList<Keyword> keywords) {
        ListJobsController listJobsController = new ListJobsController(this.navigationController, this.user);
        listJobsController.renderListedJobs(keywords);
    }

    public void showMailbox() {
        MailboxController mailboxController = new MailboxController(this.navigationController, this.user);
        mailboxController.showMailbox();
    }
}
