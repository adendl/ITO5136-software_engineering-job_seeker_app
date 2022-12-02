package controller;

import model.DBConnection;
import model.Job;
import view.SearchJobView;
import view.SearchResultsView;

import java.sql.ResultSet;

public class SearchAlgorithmController {
    private NavigationController navigationController;
    private SearchResultsView searchResultsView;
    public SearchAlgorithmController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void backToSearch(String newSearchText) {
        // TODO: return to original search screen with updated search terms text?
        // if we're doing the searching in this controller then it may be easier to just reuse the search parameters and not go back?
        // otherwise we can grab it from the navigation stack (it should always be the previous item) so we don't need to pass
    }

    public void performSearch(String searchString) {
        // TODO: actually run the search and collect some results to show

        showResults(searchString);
    }

    public void showResults(String searchString) {
        this.searchResultsView = new SearchResultsView(this);
        searchResultsView.getSearchTextField().setText(searchString);
        loadTable();
        navigationController.pushView(searchResultsView);
    }

    public void loadTable()
    {
        ResultSet rs = Job.listJobs();
        searchResultsView.getTable1().setModel(DBConnection.resultSetToTableModel(rs));
    }
}
