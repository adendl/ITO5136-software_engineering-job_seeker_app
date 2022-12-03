package controller;

import model.Keyword;
import model.Location;
import view.CreateJobView;
import model.Job;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateJobController {
    NavigationController navigationController;
    CreateJobView createJobView;
    public CreateJobController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showCreateJob() throws SQLException {
        this.createJobView = new CreateJobView(this);
        loadCities();
        loadCategories();
        navigationController.pushView(createJobView);
    }

    public void doCreateJob(String title, String description, String jobType, String company) {
        // TODO: change args to appropriate types and create a job with them
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);
        job.createJob();
    }

    public void loadCategories() throws SQLException {
        ResultSet rs = Keyword.listCategories();
        createJobView.getCategoryComboBox().addItem("");
        while (rs.next())
        {
            createJobView.getCategoryComboBox().addItem(rs.getString("keywordValue"));
        }
    }

    public void loadCities() throws SQLException {
        ResultSet rs = Location.listLocations();
        createJobView.getLocationComboBox().addItem("");
        while (rs.next())
        {
            createJobView.getLocationComboBox().addItem(rs.getString("city"));
        }
    }

}
