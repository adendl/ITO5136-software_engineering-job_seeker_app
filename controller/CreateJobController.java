package controller;

import model.Keyword;
import model.Location;
import model.User;
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
    User user;

    Job job;
    public CreateJobController(NavigationController navigationController, User user){
        this.user = user;
        this.navigationController = navigationController;
    }

    public void setEditMode(Job job) {
        this.job = job;
        this.createJobView = new CreateJobView(this);
        try{
            loadCities();
            loadCategories();
            loadSalary();
            loadSkills();}
        catch(SQLException e) {
            System.err.println("Unable to load keywords to combo-box: " + e);
        }
        createJobView.getCreateJobLabel().setText("Edit Job Listing");
        createJobView.getJobTitleText().setText(job.getTitle());
        createJobView.getLocationComboBox().setSelectedIndex(job.getLocationId());
        createJobView.getCompanyText().setText(job.getCompany());
        createJobView.getSalaryComboBox().setSelectedItem(job.getSalary());
        createJobView.getJobDescriptionText().setText(job.getDescription());
        createJobView.setBtnToEdit();
        navigationController.pushView(createJobView);
    }


    public void showCreateJob() throws SQLException {
        this.createJobView = new CreateJobView(this);
        this.createJobView.setBtnToCreate();
        loadCities();
        loadCategories();
        loadSalary();
        loadSkills();
        navigationController.pushView(createJobView);
    }

    // create a job with the given parameters then return home
    public void doCreateJob(String title, String description, String company, String city, String category, String salary, String skillIds) throws SQLException {
        this.job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);
        job.setLocationId(Location.getLocationByCity(city).getInt("locationId"));
        job.setSalary(salary);
        job.setKeyword(new ArrayList<Keyword>());
        job.setRecruiterId(user.getUserId());
        job.setSkillIds(skillIds);
        // post it to the db
        job.createJob();
        // return home
        navigationController.popUntilLast();
    }

    // update a job with new parameters
    public void doUpdateJob(String title, String description, String company, String city, String category, String salary, String skillIds) throws SQLException {
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);
        job.setLocationId(Location.getLocationByCity(city).getInt("locationId"));
        job.setSalary(salary);
        job.setKeyword(new ArrayList<Keyword>());
        job.setRecruiterId(user.getUserId());
        job.setSkillIds(skillIds);
        // post it to the db
        job.editJob();
        // return home
        navigationController.popUntilLast();
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

    public void loadSkills() throws SQLException {
        DefaultListModel dlm = new DefaultListModel();
        ResultSet rs = Keyword.listSkills();
        while (rs.next())
        {
            dlm.addElement(rs.getString("keywordValue"));
        }
        createJobView.getSkillsList().setModel(dlm);
    }
}
