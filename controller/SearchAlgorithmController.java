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

    public void performSearch(String searchString) {
        // TODO: actually run the search and collect some results to show

        showResults(searchString);
    }

    public void showResults(String searchString) {
        SearchResultsView searchResultsView = new SearchResultsView(this);
        searchResultsView.getSearchTextField().setText(searchString);
        navigationController.pushView(searchResultsView);
    }
}
