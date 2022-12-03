package controller;

import view.*;
import model.User;
import model.Recruiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class HomeRecruiterController {
    NavigationController navigationController;
    User user;
    public HomeRecruiterController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void showHub() {
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
        RecruiterProfileController controller = new RecruiterProfileController(navigationController);
        controller.showEditRecruiter();
    }

    public void showManageListedJobs() {
        ListJobsController listJobsController = new ListJobsController(this.navigationController, this.user);
        listJobsController.renderListedJobs();
    }

    public void showMailbox() {
        MailboxController mailboxController = new MailboxController(this.navigationController, this.user);
        mailboxController.showMailbox();
    }
}
