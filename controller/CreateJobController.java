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
import java.util.ArrayList;

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
        loadSalary();
        navigationController.pushView(createJobView);
    }

    public void doCreateJob(String title, String description, String company, String city, String category, String salary) throws SQLException {
        // TODO: change args to appropriate types and create a job with them
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);
        job.setLocationId(Location.getLocationByCity(city).getInt("locationId"));
        job.setSalary(salary);
        job.setKeyword(new ArrayList<Keyword>());
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

    public void loadSalary() throws SQLException {
        ResultSet rs = Keyword.listSalary();
        System.out.println("TEST2");
        createJobView.getSalaryComboBox().addItem("");
        while (rs.next())
        {
            System.out.println("TEST" + rs.getString("keywordValue"));
            createJobView.getSalaryComboBox().addItem(rs.getString("keywordValue"));
        }
    }



}
