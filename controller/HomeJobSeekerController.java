package controller;

import model.User;
import view.*;
import model.JobSeeker;

import java.sql.SQLException;

public class HomeJobSeekerController {
    NavigationController navigationController;
     User user;

    // TODO: we should probably have a User passed in here as well so we can pass it along as needed
    public HomeJobSeekerController(NavigationController navigationController, User user) {
        this.user = user;
        this.navigationController = navigationController;
    }

    public void showHub() {
        HomePageJobSeekerView view = new HomePageJobSeekerView(this);
        navigationController.pushReplacementView(view);
    }

    public void showJobSearch() throws SQLException {
        JobSearchController jobSearchController = new JobSearchController(navigationController, user);
        jobSearchController.showSearch();
    }

    public void showJobApplications() {
        ApplicationsView applicationsView = new ApplicationsView(this);
        navigationController.pushView(applicationsView);
    }

    public void showMailbox() {
        MailboxController mailboxController = new MailboxController(this.navigationController, this.user);
        mailboxController.showMailbox();
    }

    public void showEditProfile() throws SQLException {
        // TODO: we should have a legit user object already, instead of this placeholder
        // this placeholder user just gives us something to fill the form fields


        JobSeekerProfileController controller = new JobSeekerProfileController(navigationController, user);
        controller.showEditProfile();
    }
}
