package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeJobSeekerController {
    public HomeJobSeekerController(NavigationController navigationController, HomePageJobSeekerView homePageJobSeekerView, SearchJobView searchJobView,
                                   MailboxView mailboxView, EditProfileView editProfileView, ApplicationsView applicationsView){

        //send to searchJobView
        homePageJobSeekerView.addSearchJobsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(searchJobView.getPanelMain());
            }
        });

        //send to mailboxView
        homePageJobSeekerView.addViewInvitationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(mailboxView.getPanelMain());
            }
        });

        //send to editProfile
        homePageJobSeekerView.addEditProfileButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(editProfileView.getPanelMain());
            }
        });

        //send to applicationsView
        homePageJobSeekerView.addViewApplicationsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(applicationsView.getPanelMain());
            }
        });
    }
}
