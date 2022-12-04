package controller;

import model.Job;
import model.JobApplication;
import model.User;

import java.util.ArrayList;

public class ListApplicationsController {
    private NavigationController navigationController;
    private User user;
    private Job job;
    private ArrayList<JobApplication> applicationList;

    public ListApplicationsController(NavigationController controller, User user, Job job){
        this.navigationController = controller;
        this.user = user;
        this.job = job;
        applicationList = new ArrayList<JobApplication>();

    }






}
