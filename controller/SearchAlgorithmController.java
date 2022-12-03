package controller;

import model.*;
import view.JobDetailsView;
import view.JobListingsView;
import view.SearchJobView;
import view.SearchResultsView;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchAlgorithmController {
    private NavigationController navigationController;
    private SearchResultsView searchResultsView;
    private JobSeeker user;
    private JobList jobList;
    public SearchAlgorithmController(NavigationController navigationController, JobSeeker user) {
        this.navigationController = navigationController;
        this.user = user;
        jobList = new JobList();
    }

    public void backToSearch(String newSearchText) {
        // TODO: return to original search screen with updated search terms text?
        // if we're doing the searching in this controller then it may be easier to just reuse the search parameters and not go back?
        // otherwise we can grab it from the navigation stack (it should always be the previous item) so we don't need to pass
    }

    public void performSearch(String searchString) throws SQLException {
        // TODO: actually run the search and collect some results to show

        showResults(searchString);
    }

    public void showResults(String searchString) {
        this.searchResultsView = new SearchResultsView(this);
        searchResultsView.getSearchTextField().setText(searchString);
        loadTable();
        searchResultsView.renderTable();
        navigationController.pushView(searchResultsView);
    }

    public void loadTable() {
        DefaultTableModel dft = jobList.jobListDft();
        searchResultsView.getTable1().setModel(dft);
    }

    public void showJobDetails(Job newJob){
        JobDetailsView jobDetailsView = new JobDetailsView(this);
        jobDetailsView.getTxtJobTitle().setText(newJob.getTitle());
        jobDetailsView.getTxtCompany().setText(newJob.getCompany());
        System.out.println(newJob.getLocationId());
        try {
            jobDetailsView.getTxtLocation().setText(newJob.getLocationFromDb());
        }
        catch(SQLException e) {
            System.err.println("Unable to retrieve Job Location from DB: " + e);
        }
        navigationController.pushView(jobDetailsView);
    }

}
