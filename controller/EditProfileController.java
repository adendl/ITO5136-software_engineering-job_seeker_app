package controller;

import view.EditProfileView;
import model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfileController {
    public EditProfileController(NavigationController navigationController, EditProfileView editProfileView, User user){
        //prepopulate with current user info
        editProfileView.getEmailText().setText(user.getEmail());
        editProfileView.getAddressText().setText(user.getAddress());
        editProfileView.getPhoneNumberText().setText(user.getPhoneNumber());
        editProfileView.getFirstNameText().setText(user.getFirstName());
        editProfileView.getLastNameText().setText(user.getLastName());

        editProfileView.addSubmitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set to entered values
                //need to add password and skills
                user.setAddress(editProfileView.getAddressText().getText());
                user.setEmail(editProfileView.getEmailText().getText());
                user.setFirstName(editProfileView.getFirstNameText().getText());
                user.setLastName(editProfileView.getLastNameText().getText());
                user.setPhoneNumber(editProfileView.getPhoneNumberText().getText());
                //updated in db
            }
        });

    }
}
