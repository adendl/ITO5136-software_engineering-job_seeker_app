package controller;

import model.Administrator;
import model.JobSeeker;
import model.Recruiter;
import view.*;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    public LoginController(NavigationController navigationController , LoginView loginView, CreateUserView createUserView,
                           HomePageAdminView homePageAdminView, HomePageRecruiterView homePageRecruiterView, HomePageJobSeekerView homePageJobSeekerView){

        loginView.addLoginButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                //find out if the email entered matches the db. (findUserIDByEmail method in model) load into user object
                JobSeeker jobSeeker = new JobSeeker();
                //user = loginView.getEmailText().getText();
                //check if the password matches the email. (verifyUser method in model)
                //send to home page depending on the type of user.
                switch(jobSeeker.getUserType()) {
                    case JOBSEEKER:
                        navigationController.pushView(homePageJobSeekerView);
                        break;
                    case RECRUITER:
                        navigationController.pushView(homePageRecruiterView);
                        break;
                    case ADMIN:
                        navigationController.pushView(homePageAdminView);
                        break;
                }
                 */
                navigationController.pushView(homePageAdminView);
            }
        });

        loginView.addCreateNewAccountButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //send to the create user view
                navigationController.pushView(createUserView);
            }
        });

        createUserView.addCreateAccountButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //hold input
                String userEmailInput = createUserView.getEmailText().getText();
                String userPasswordInput = createUserView.getConfirmPasswordText().getText();
                String userFirstNameInput = createUserView.getFirstNameText().getText();
                String userLastNameInput = createUserView.getLastNameText().getText();
                JComboBox userTypeInput = createUserView.getSelectUserTypeComboBox();

                //create object, add to constructor and call method to add to db
                switch (createUserView.getSelectUserTypeComboBox().getSelectedIndex()){
                    //job seeker selection
                    case 1:
                        JobSeeker newJobSeeker = new JobSeeker();
                        //adds to db.
                        //set to logged in and sends to homepage
                        break;
                    //recruiter selection
                    case 2:
                        Recruiter newRecruiter = new Recruiter();
                        //adds to db.
                        //set to logged in and sends to homepage
                        break;
                    //admin selection
                    case 3:
                        Administrator newAdmin = new Administrator();
                        //adds to db.
                        //set to logged in and sends to homepage
                        break;
                }
            }
        });
    }
}
