package controller;

import view.SearchJobView;
import view.SearchResultsView;

public class SearchAlgorithmController {
    private NavigationController navigationController;
    public SearchAlgorithmController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void backToSearch(String newSearchText) {
        // TODO: return to original search screen with updated search terms text?
        // if we're doing the searching in this controller then it may be easier to just reuse the search parameters and not go back?
        // otherwise we can grab it from the navigation stack (it should always be the previous item) so we don't need to pass
    }

    public void performSearch(/*params go here*/) {
        // TODO: actually run the search and collect some results to show
        showResults(/*results*/);
    }

    public void showResults(/*results*/) {
        SearchResultsView searchResultsView = new SearchResultsView(this);
        navigationController.pushView(searchResultsView);
    }
}
