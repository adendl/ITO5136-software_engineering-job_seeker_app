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
                navigationController.setContentArea(searchResultsView.getPanelMain());
            }
        });
    }


}
