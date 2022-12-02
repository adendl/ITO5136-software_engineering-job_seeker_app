package controller;

import view.*;
import model.User;
import model.Recruiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeRecruiterController {
    NavigationController navigationController;
    public HomeRecruiterController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showHub() {
        HomePageRecruiterView view = new HomePageRecruiterView(this);
        navigationController.pushView(view);
    }

    public void showCreateJob() {
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
        JobListingsView jobListingsView = new JobListingsView(this);
        navigationController.pushView(jobListingsView);
    }
}
