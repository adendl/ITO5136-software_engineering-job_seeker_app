package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobSearchController {

    private JobSearchView boundary;
    private JobDetailsView boundary2;

    public JobSearchController(JobSearchView jobSearchView, JobDetailsView jobDetailsView){
        this.boundary = jobSearchView;
        this.boundary2 = jobDetailsView;

        boundary.addSearchButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get field attributes (these really need to be int)
                boundary.getCbxLocation();
                boundary.getCbxCategory();
                boundary.getTxtSearchBar();
                boundary.getCbxSalary();

                //send to searchActionController

                //bring search results into frame
                //boundary2.setVisible(true);
            }
        });

        boundary.addSearchOnProfileButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get field attributes and send to searchActionController
                //bring search results into frame
                //boundary2.setVisible(true);
            }
        });

    }


}
