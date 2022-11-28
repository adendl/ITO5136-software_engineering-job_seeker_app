package controller;

import view.*;
import model.JobSeeker;

public class HomeJobSeekerController {
    NavigationController navigationController;

    // TODO: we should probably have a User passed in here as well so we can pass it along as needed
    public HomeJobSeekerController(NavigationController navigationController) {
        this.navigationController = navigationController;
        /*
        //send to mailboxView
        homePageJobSeekerView.addViewInvitationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(mailboxView);
            }
        });

        //send to applicationsView
        homePageJobSeekerView.addViewApplicationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(applicationsView);
            }
        });
        */
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
        //ApplicationsView applicationsView = new ApplicationsView();
    }

    public void showInvitations() {
        // TODO: MailboxView but it's also used by the Recruiter controller which might complicate things
    }

    public void showEditProfile() {
        // TODO: we should have a legit user object already, instead of this placeholder
        // this placeholder user just gives us something to fill the fields
        JobSeeker user = new JobSeeker();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPhoneNumber("123456789");
        user.setEmail("test@user.org");
        user.setAddress("somewhere");

        JobSeekerProfileController controller = new JobSeekerProfileController(navigationController, user);
        controller.showEditProfile();
    }
}
