package controller;

import view.CreateJobView;
import model.Job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateJobController {
    NavigationController navigationController;
    public CreateJobController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showCreateJob() {
        CreateJobView createJobView = new CreateJobView(this);
        navigationController.pushView(createJobView);
    }

    public void doCreateJob(String title, String description, String jobType, String company, String salaryRange) {
        // TODO: change args to appropriate types and create a job with them
        //Job newJob = new Job();
    }
}
