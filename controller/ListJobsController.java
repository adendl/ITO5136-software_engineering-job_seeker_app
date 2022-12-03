package controller;

import model.Job;
import model.JobList;
import view.JobDetailsView;
import view.JobListingsView;
import model.User;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;

public class ListJobsController {
    private NavigationController navigationController;
    User user;
    private JobList jobList;

    public ListJobsController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        this.user = user;
        jobList = new JobList();
        renderListedJobs();
    }

    public void renderListedJobs() {
        DefaultTableModel dft = jobList.jobListDft();
        JobListingsView view = new JobListingsView(this, dft);
        navigationController.pushView(view);
    }

    public void showJobDetails(Job newJob){
        JobDetailsView job = new JobDetailsView();
        job.getTxtCompany().setText(newJob.getCompany());
        job.getTxtJobTitle().setText(newJob.getTitle());
        job.getTxtJobDescription().setText(newJob.getDescription());
        job.getTxtSalaryRange().setText(newJob.getSalary());
        System.out.println(newJob.getLocationId());
//            try {
//                job.getTxtLocation().setText(newJob.getLocationFromDb(newJob.getLocationId()));
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }

    }




}
