package controller;

import view.JobDetailsView;
import view.JobSearchView;

public class Driver {
    public static void main(String[] args) {
        JobSearchView myJobSearchView = new JobSearchView();
        //myJobSearchView.setVisible(true);
        JobDetailsView myJobDetailsView = new JobDetailsView();
        JobSearchController myJobSearchController = new JobSearchController(myJobSearchView, myJobDetailsView);
    }
}
