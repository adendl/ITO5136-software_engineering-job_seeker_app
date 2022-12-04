package controller;

import model.*;
import view.JobDetailsView;
import view.SearchResultsView;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void backToSearch() {
        // TODO: return to original search screen with updated search terms text?
        // if we're doing the searching in this controller then it may be easier to just reuse the search parameters and not go back?
        // otherwise we can grab it from the navigation stack (it should always be the previous item) so we don't need to pass
    }

    public void performSearch(ArrayList<Keyword> keywords) throws SQLException {
        // TODO: actually run the search and collect some results to show

        showResults(keywords);
    }

    public void showResults(ArrayList<Keyword> keywords) {
        this.searchResultsView = new SearchResultsView(this);
        loadTable(keywords);
        navigationController.pushView(searchResultsView);
        navigationController.setCheckpoint();
    }

    public void loadTable(ArrayList<Keyword> keywords) {
        DefaultTableModel dft = jobList.jobListDft(keywords);
        searchResultsView.getTable1().setModel(dft);
        searchResultsView.renderTable();
    }

    public void showJobDetails(Job newJob){
        JobDetailsView jobDetailsView = new JobDetailsView(this);
        jobDetailsView.getTxtJobTitle().setText(newJob.getTitle());
        jobDetailsView.getTxtCompany().setText(newJob.getCompany());
        jobDetailsView.getTxtLocation().setText(newJob.getLocationFromDb());
        jobDetailsView.getTxtJobDescription().setText(newJob.getDescription());
        jobDetailsView.getTxtSalaryRange().setText(newJob.getSalary());
        jobDetailsView.getTxtJobCategory().setText(newJob.categoriesToString());


        navigationController.pushView(jobDetailsView);
    }

}
