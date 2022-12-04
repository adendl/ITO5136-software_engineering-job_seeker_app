package controller;

import model.JobApplication;
import model.User;
public class ListAppliedJobsController {
    private NavigationController navigationController;

    User user;

    public ListAppliedJobsController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void renderAppliedJobs(int jobId){
        //ResultSet JobApplication.listJobApplicationsRecruiter(jobId);
    }
}
