package controller;

import view.SearchJobView;
import view.SearchResultsView;

public class SearchAlgorithmController {
    public SearchAlgorithmController(NavigationController navigationController, SearchJobView searchJobView, SearchResultsView searchResultsView){
        navigationController.pushView(searchResultsView);
    }
}
