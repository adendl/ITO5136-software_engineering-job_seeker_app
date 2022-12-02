package controller;

import view.JobListingsView;
import model.User;

import java.sql.Connection;

public class ListJobsController {
    private Connection connection;
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
