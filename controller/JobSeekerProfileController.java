package controller;

import model.*;
import view.EditProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        editProfileView.populateForUser(user, new JobSeeker(JobSeeker.getJobSeeker(user.getUserId())));
        navigationController.pushView(editProfileView);
    }

    public void updateProfile(String firstName, String lastName, String phoneNumber, String city, String keywordIds) throws SQLException {

        user.setFirstName(firstName);
        user.setLastName(lastName);
        jobSeeker.setPhoneNumber(phoneNumber);
        jobSeeker.setLocationId(Location.getLocationByCity(city).getString("locationId"));
        if (!keywordIds.isEmpty())
        {
            jobSeeker.setSkillIds(keywordIds);
            System.out.println("Update profile" + keywordIds);
            loadCurrentSkillList(Keyword.getKeywordListByIds(keywordIds));
        }

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

    public void loadCurrentSkillList(ArrayList<Keyword> keywords)
    {
        DefaultListModel dlm = new DefaultListModel();
        for (int i = 0; i < keywords.size(); i++)
        {
            dlm.addElement(keywords.get(i).getKeywordValue());
        }
        editProfileView.getCurrentSkillsList().setModel(dlm);
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
