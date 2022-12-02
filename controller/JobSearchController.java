package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobSearchController {
    private NavigationController navigationController;
    public JobSearchController(NavigationController navigationController){
        this.navigationController = navigationController;
        /*
        searchJobView.addSearchJobButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get all field attributes and search term and run through matching algorithm
                SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController, searchJobView, searchResultsView);
            }
        });

        //add event listeners for the search results page
        //we may need a searchResultsController to add the action listeners for the job details, maybe this can be done in the view.
        searchResultsView.addNextButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if there are more results to paginate through
            }
        });

        searchResultsView.addPreviousButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if not on first page
            }
        });

        searchResultsView.addSearchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchResultsView.getSearchTextField().toString();
                //pass search term back to searchJobView
                navigationController.doBack();
            }
        });

         */
    }

    public void doSearch() {
        //get all field attributes and search term and run through matching algorithm
        // TODO: JobSearchView passes in parameters here, we have SearchAlgorithmController do the work, then call showResults
        SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController);
        searchAlgorithmController.performSearch(/*search params go here*/);
    }

    public void doProfileSearch() {
        // TODO: similar to the above, but we're just using the user profile data?
        SearchAlgorithmController searchAlgorithmController = new SearchAlgorithmController(navigationController);
        // not sure if we'd use the same performSearch or if we need something different for profile-based search
        // end result should be the same though, it's only the search inputs that change
        searchAlgorithmController.performSearch(/*search params go here*/);
    }

    public void showSearch() {
        JobSearchView jobSearchView = new JobSearchView(this);
        navigationController.pushView(jobSearchView);
    }
}
