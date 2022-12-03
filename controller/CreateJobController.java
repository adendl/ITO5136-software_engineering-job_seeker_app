package controller;

import model.Keyword;
import model.Location;
import view.ConfirmPage;
import view.CreateJobView;
import model.Job;
import model.Recruiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class CreateJobController {
    NavigationController navigationController;
    CreateJobView view;
    Job job;

    public CreateJobController(NavigationController navigationController) throws SQLException {
        this.view = new CreateJobView(this);
        this.navigationController = navigationController;
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }

    public void showConfirm(){
        ConfirmPage confirmPage = new ConfirmPage(navigationController, null,this.job);
        navigationController.pushView(confirmPage);
    }

    public void showCreateJob() throws SQLException {
        CreateJobView createJobView = new CreateJobView(this);
        this.view = createJobView;
        navigationController.pushView(createJobView);
        loadLocations(createJobView);
        loadCategories(createJobView);
        loadSalary(createJobView);
    }

    public void doCreateJob(String title, String description, String company,String category, String location, String salaryRange) throws SQLException {
        // TODO: change args to appropriate types and create a job with them
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setCompany(company);
        ArrayList<Keyword> keywords = new ArrayList<Keyword>();
        keywords.add(Keyword.getKeywordObjectByName(category));
        Location locationObj = Location.getLocationObjectByName(location);
        job.setLocationId(locationObj.getLocationId());
        job.setSalary(salaryRange);
        job.setKeyword(keywords);
        job.setStatus("listed");
        job.setDateCreated(LocalDate.now());
        job.setExpiryDate(LocalDate.of(2023,01,18));
        this.job = job;
    }

    public void loadCategories(CreateJobView view) throws SQLException {
        ResultSet rs = Keyword.listCategories();
        view.getCategoryComboBox().addItem("");
        while (rs.next())
        {
            view.getCategoryComboBox().addItem(rs.getString("keywordValue"));
        }
    }

    public void loadLocations(CreateJobView view) throws SQLException {
        ResultSet rs = Location.listLocations();
        view.getLocationComboBox().addItem("");
        while (rs.next()) {
            view.getLocationComboBox().addItem(rs.getString("city"));
        }
    }

    public void loadSalary(CreateJobView view) throws SQLException {
        ResultSet rs = Keyword.listSalary();
        System.out.println("TEST2");
        view.getSalaryComboBox().addItem("");
        while (rs.next())
        {
            System.out.println("TEST" + rs.getString("keywordValue"));
            view.getSalaryComboBox().addItem(rs.getString("keywordValue"));
        }
    }



}
