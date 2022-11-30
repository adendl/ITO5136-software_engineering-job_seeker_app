package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeJobSeekerController {
    public HomeJobSeekerController(NavigationController navigationController, HomePageJobSeekerView homePageJobSeekerView, SearchJobView searchJobView,
                                   MailboxView mailboxView, EditProfileView editProfileView, ApplicationsView applicationsView){

        //initialise JobSearchController
        JobDetailsView jobDetailsView = new JobDetailsView();
        SearchResultsView searchResultsView = new SearchResultsView();
        JobSearchController jobSearchController = new JobSearchController(navigationController, searchJobView, jobDetailsView, searchResultsView);
        //send to searchJobView
        homePageJobSeekerView.addSearchJobsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(searchJobView);
            }
        });

        //send to mailboxView
        homePageJobSeekerView.addViewInvitationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(mailboxView);
            }
        });

        //send to editProfile
        homePageJobSeekerView.addEditProfileButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(editProfileView);
            }
        });

        //send to applicationsView
        homePageJobSeekerView.addViewApplicationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.pushView(applicationsView);
            }
        });
    }
}
