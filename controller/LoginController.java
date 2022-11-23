package controller;

import view.*;
import model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    public LoginController(NavigationController navigationController , LoginView loginView, CreateUserView createUserView,
                           HomePageAdminView homePageAdminView, HomePageRecruiterView homePageRecruiterView, HomePageJobSeekerView homePageJobSeekerView){

        loginView.addLoginButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find out if the email entered matches the db. (findUserIDByEmail method in model)
                //check if the password matches the email. (verifyUser method in model)
                //send to home page depending on the type of user.
                navigationController.setContentArea(homePageJobSeekerView.getPanelMain());
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
            }
        });
    }
}
