package controller;

import model.JobSeeker;
import view.*;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    public LoginController(NavigationController navigationController , LoginView loginView, CreateUserView createUserView, User user,
                           HomePageAdminView homePageAdminView, HomePageRecruiterView homePageRecruiterView, HomePageJobSeekerView homePageJobSeekerView){

        loginView.addLoginButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find out if the email entered matches the db. (findUserIDByEmail method in model) load into user object
                loginView.getEmailText().getText();
                //check if the password matches the email. (verifyUser method in model)
                //send to home page depending on the type of user.
                switch(user.getUserType()) {
                    case JOBSEEKER:
                        navigationController.setContentArea(homePageJobSeekerView.getPanelMain());
                        break;
                    case RECRUITER:
                        navigationController.setContentArea(homePageRecruiterView.getPanelMain());
                        break;
                    case ADMIN:
                        navigationController.setContentArea(homePageAdminView.getPanelMain());
                        break;
                }
            }
        });

        loginView.addCreateNewAccountButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send to the create user view
                navigationController.setContentArea(createUserView.getMainPanel());
            }
        });

        createUserView.addCreateAccountButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add user to the db.
                String userEmailInput = createUserView.getEmailText().getText();
                String userPasswordInput = createUserView.getConfirmPasswordText().getText();
                String userFirstNameInput = createUserView.getFirstNameText().getText();
                String userLastNameInput = createUserView.getLastNameText().getText();
                JComboBox userTypeInput = createUserView.getSelectUserTypeComboBox();
                //pass in values
                JobSeeker myNewJobSeekerUser = new JobSeeker();
                //myNewJobSeekerUser.createJobSeeker;
            }
        });
    }
}
