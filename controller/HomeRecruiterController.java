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
        // TODO: show something here
    }

    public void showEditProfile() {
        // TODO: create a view for this and show it here
    }

    public void showManageListedJobs() {
        // TODO: show something here
    }
}
