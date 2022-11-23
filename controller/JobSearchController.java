package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobSearchController {

    //this needs to take all of the views and models the controller handles and the navigation controller
    public JobSearchController(JobSearchView jobSearchView, JobDetailsView jobDetailsView, NavigationController navigationController){

        jobSearchView.addSearchButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get field attributes (these really need to be int)

                //send to searchActionController

                //pass the job details panel to the navigation controller
                navigationController.setContentArea(jobDetailsView.getJobDetailsPanel());
            }
        });

        jobSearchView.addSearchOnProfileButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get field attributes and send to searchActionController
                //bring search results into frame
                navigationController.setContentArea(jobDetailsView.getJobDetailsPanel());
            }
        });

    }


}
