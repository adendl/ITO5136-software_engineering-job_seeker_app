package controller;

import view.JobListingsView;
import model.User;

public class ListJobsController {
    private NavigationController navigationController;

    User user;

    public ListJobsController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void renderListedJobs(){
        //TODO: render table of listed jobs for the user
    }

}