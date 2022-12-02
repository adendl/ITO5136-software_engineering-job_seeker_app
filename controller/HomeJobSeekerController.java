package controller;

import view.*;
import model.JobSeeker;

public class HomeJobSeekerController {
    NavigationController navigationController;

    // TODO: we should probably have a User passed in here as well so we can pass it along as needed
    public HomeJobSeekerController(NavigationController navigationController /*JobSeeker user*/) {
        this.navigationController = navigationController;
        //checkLoginStatus(navigationController, user);
    }

    public void checkLoginStatus(NavigationController controller, JobSeeker user){
        if (user.getStatus() == "out")
        {
            controller.doLogout();
        }
    }

    public void showHub() {
        HomePageJobSeekerView view = new HomePageJobSeekerView(this);
        navigationController.pushView(view);
    }

    public void showJobSearch() {
        JobSearchController jobSearchController = new JobSearchController(navigationController);
        jobSearchController.showSearch();
    }

    public void showJobApplications() {
        ApplicationsView applicationsView = new ApplicationsView(this);
        navigationController.pushView(applicationsView);
    }

    public void showInvitations() {
        // this could probably use MailboxController/View instead?
        InvitationsView invitationsView = new InvitationsView(this);
        navigationController.pushView(invitationsView);
    }

    public void showEditProfile() {
        // TODO: we should have a legit user object already, instead of this placeholder
        // this placeholder user just gives us something to fill the form fields
        JobSeeker user = new JobSeeker();
        user.setFirstName("Test");
        user.setLastName("User");
        //user.setPhoneNumber("123456789");
        //user.setEmail("test@user.org");
        //user.setAddress("somewhere");

        JobSeekerProfileController controller = new JobSeekerProfileController(navigationController, user);
        controller.showEditProfile();
    }
}
