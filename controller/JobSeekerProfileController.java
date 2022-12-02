package controller;

import view.EditProfileView;
import model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;

public class JobSeekerProfileController {
    private NavigationController navigationController;
    User user;
    public JobSeekerProfileController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        this.user = user;
    }

    public void showEditProfile() {
        EditProfileView editProfileView = new EditProfileView(this);
        editProfileView.populateForUser(user);
        navigationController.pushView(editProfileView);
    }

    public void updateProfile(String firstName, String lastName, String email, String phoneNumber, String address) {
        //user.setAddress(address);
        //user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        //user.setPhoneNumber(phoneNumber);
        // TODO: update the db
    }
}
