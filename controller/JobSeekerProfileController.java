package controller;

import model.*;
import view.EditProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.User;

public class JobSeekerProfileController {
    private NavigationController navigationController;
    User user;
    JobSeeker jobSeeker;
    public JobSeekerProfileController(NavigationController navigationController, User user) throws SQLException {
        this.navigationController = navigationController;
        this.user = user;
        this.jobSeeker = new JobSeeker(JobSeeker.getJobSeeker(user.getUserId()));
    }

    public void showEditProfile() {
        EditProfileView editProfileView = new EditProfileView(this);
        editProfileView.populateForUser(user, jobSeeker);
        navigationController.pushView(editProfileView);
    }

    public void updateProfile(String firstName) throws SQLException {

        user.setFirstName(firstName);
        user.updateUser(user.getUserId(), "firstName", firstName);
        System.out.println("USER UPDATED");

        //jobSeeker.setLocationId(Location.getLocationByCity(location).getString("locationId"));
        // TODO: update the db

    }
}
