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
    NavigationController navigationController;

    public LoginController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    // show the create account view
    public void showCreateAccount() {
        //send to the create user view
        CreateUserView createUserView = new CreateUserView(this);
        navigationController.pushView(createUserView);
    }

    // show the login view
    public void showLogin() {
        LoginView loginView = new LoginView(this);
        navigationController.pushView(loginView);
    }

    public void showForgotPassword(){
        ForgotPasswordView forgotPasswordView = new ForgotPasswordView(this, navigationController);
        navigationController.pushView(forgotPasswordView);
    }

    // create a new account when the view's button is clicked
    public void doCreateAccount(String firstName, String lastName, String email, String password, int userType) {
        //create object, add to constructor and call method to add to db
        switch (userType) {
            //job seeker selection
            case 0:
                JobSeeker newJobSeeker = new JobSeeker();
                //adds to db.
                //call createJobSeeker
                //set to logged in and sends to homepage
                newJobSeeker.setStatus("in");
                showSeekerHub();
                break;
            //recruiter selection
            case 1:
                Recruiter newRecruiter = new Recruiter();
                //adds to db.
                //call createRecruiter
                //set to logged in and sends to homepage
                newRecruiter.setStatus("in");
                showRecruiterHub();
                break;
            //admin selection
            case 2:
                Administrator newAdmin = new Administrator();
                //adds to db.
                //call createAdmin
                //set to logged in and sends to homepage
                newAdmin.setStatus("in");
                showAdminHub();
                break;
        }
    }

    public void doLogin(String email, String password) {
        /*
        // verify user at login verifyLogin(), returns a user and takes and email and password
        User user = verifyLogin(email, password);
        //set to logged in
        user.setStatus("in");

        //send to home page depending on the type of user.
        switch(user.getUserType()) {
            case "JobSeeker":
                showSeekerHub();
                break;
            case "Recruiter":
                showRecruiterHub();
                break;
            case "Administrator":
                showAdminHub();
                break;
        }
        */
        showSeekerHub();
    }
    public void showAdminHub() {
        HomeAdminController controller = new HomeAdminController(navigationController);
        controller.showHub();
    }

    public void showRecruiterHub() {
        HomeRecruiterController controller = new HomeRecruiterController(navigationController);
        controller.showHub();
    }

    public void showSeekerHub() {
        HomeJobSeekerController controller = new HomeJobSeekerController(navigationController);
        controller.showHub();
    }
}
