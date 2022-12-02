package controller;

import model.*;
import view.EditProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

import javax.swing.*;

public class JobSeekerProfileController {
    private NavigationController navigationController;
    User user;
    JobSeeker jobSeeker;

    EditProfileView editProfileView;

    public JobSeekerProfileController(NavigationController navigationController, User user) throws SQLException {
        this.navigationController = navigationController;
        this.user = user;
        this.jobSeeker = new JobSeeker(JobSeeker.getJobSeeker(user.getUserId()));
    }

    public EditProfileView getEditProfileView() {
        return editProfileView;
    }

    public void setEditProfileView(EditProfileView editProfileView) {
        this.editProfileView = editProfileView;
    }

    public void showEditProfile() throws SQLException {
        this.editProfileView = new EditProfileView(this);
        loadLocations();
        loadSkills();
        editProfileView.populateForUser(user, jobSeeker);
        navigationController.pushView(editProfileView);
    }

    public void updateProfile(String firstName, String lastName, String phoneNumber, String city) throws SQLException {

        user.setFirstName(firstName);
        user.setLastName(lastName);
        jobSeeker.setPhoneNumber(phoneNumber);
        jobSeeker.setLocationId(Location.getLocationByCity(city).getString("locationId"));

        //jobSeeker.setLocationId(Location.getLocationByCity(location).getString("locationId"));
        // TODO: update the db

    }

    public void loadLocations() throws SQLException {
        ResultSet rs = Location.listLocations();
        editProfileView.getAddressComboBox().addItem("");
        while (rs.next())
        {
            editProfileView.getAddressComboBox().addItem(rs.getString("city"));
        }
    }

    public void loadSkills() throws SQLException {
        DefaultListModel dlm = new DefaultListModel();
        ResultSet rs = Keyword.listSkills();
        while (rs.next())
        {
            dlm.addElement(rs.getString("keywordValue"));
        }
        editProfileView.getList1().setModel(dlm);
    }
}
