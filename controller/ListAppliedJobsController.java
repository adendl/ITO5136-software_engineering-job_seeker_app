package controller;

import model.User;
public class ListAppliedJobsController {
    private NavigationController navigationController;

    User user;

    public ListAppliedJobsController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void renderAppliedJobs(){
        //TODO: render table of applied jobs for the user
    }
}
