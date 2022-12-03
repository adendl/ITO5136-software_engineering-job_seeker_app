package controller;

import model.Administrator;
import model.JobSeeker;
import model.Recruiter;
import view.*;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
                JobSeeker jobSeekerUser = new JobSeeker(email, firstName, lastName, password, "JOBSEEKER", LocalDate.now(), "Active");
                jobSeekerUser.createUser();
                jobSeekerUser.createJobSeeker();
                showSeekerHub(jobSeekerUser);
                break;
            //recruiter selection
            case 1:
                User recruiterUser = new User(email, firstName, lastName, password, "RECRUITER", LocalDate.now(), "Active");
                recruiterUser.createUser();
                Recruiter newRecruiter = new Recruiter(email);
                //adds to db.
                //set to logged in and sends to homepage
                showRecruiterHub(recruiterUser);
                break;
            //admin selection
            case 2:
                User adminUser = new User(email, firstName, lastName, password, "ADMIN", LocalDate.now(), "Active");
                adminUser.createUser();
                Administrator newAdmin = new Administrator();
                //adds to db.
                //set to logged in and sends to homepage
                showAdminHub(adminUser);
                break;
        }
    }

    public void doLogin(String email, String password) throws SQLException {
        ResultSet result = User.getUser(email);

        if (result.isBeforeFirst()) {
            if (result.getString("password").equals(password)) {
                User user = new User(result);
                switch (user.getUserType()) {
                    case "JOBSEEKER":
                        showSeekerHub(user);
                        break;
                    case "RECRUITER":
                        showRecruiterHub(user);
                        break;
                    case "ADMIN":
                        showAdminHub(user);
                        break;
                }
            }
            else
            {
                displayErrrorMessage(" the entered username/password is not correct", "Invalid Login Details");

            }
        }
        else
        {
            displayErrrorMessage(" the entered username/password is not correct", "Invalid Login Details");
        }
    }

    public void displayErrrorMessage(String message, String title)
    {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);

    }

    public void showAdminHub(User user) {
        HomeAdminController controller = new HomeAdminController(navigationController);
        controller.showHub();
    }

    public void showRecruiterHub(User user) {
        HomeRecruiterController controller = new HomeRecruiterController(navigationController, user);
        controller.showHub();
    }

    public void showSeekerHub(User user) {
        HomeJobSeekerController controller = new HomeJobSeekerController(navigationController, user);
        controller.showHub();
    }
}
