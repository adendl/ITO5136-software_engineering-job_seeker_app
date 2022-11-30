package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobSearchController {
    public JobSearchController(NavigationController navigationController, SearchJobView searchJobView, JobDetailsView jobDetailsView, SearchResultsView searchResultsView){

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
    }


}
