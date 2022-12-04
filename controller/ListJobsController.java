package controller;

import model.Job;
import model.JobList;
import model.Keyword;
import view.JobDetailsView;
import view.JobListingsView;
import model.User;
import view.ReviewJobDetailsView;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListJobsController {
    private NavigationController navigationController;
    User user;
    private JobList jobList;

    public ListJobsController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        this.user = user;
        jobList = new JobList();
    }

    public void renderListedJobs(ArrayList<Keyword> keywords) {
        DefaultTableModel dft = jobList.jobListDft(keywords);
        JobListingsView view = new JobListingsView(this);
        view.getJobListingsTable().setModel(dft);
        view.renderTable();
        navigationController.pushView(view);
    }

    public void renderListedJobs() {
        DefaultTableModel dft = jobList.jobListDft(this.user);
        JobListingsView view = new JobListingsView(this);
        view.getJobListingsTable().setModel(dft);
        view.renderTable();
        navigationController.pushView(view);
    }

    public void showJobDetails(Job newJob){
        ReviewJobDetailsView reviewJobDetailsView = new ReviewJobDetailsView(this);
        reviewJobDetailsView.getTxtJobTitle().setText(newJob.getTitle());
        reviewJobDetailsView.getTxtCompany().setText(newJob.getCompany());
        reviewJobDetailsView.getTxtLocation().setText(newJob.getLocationFromDb());
        reviewJobDetailsView.getTxtJobDescription().setText(newJob.getDescription());
        reviewJobDetailsView.getTxtSalaryRange().setText(newJob.getSalary());
        reviewJobDetailsView.getTxtJobCategory().setText(newJob.categoriesToString());


        navigationController.pushView(reviewJobDetailsView);
    }

}
