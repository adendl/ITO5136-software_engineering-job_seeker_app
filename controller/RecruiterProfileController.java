package controller;

import model.User;
import model.Recruiter;
import view.EditRecuiterProfileView;
import view.UIView;

public class RecruiterProfileController {
    NavigationController navigationController;
    Recruiter user;
    public RecruiterProfileController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showEditRecruiter(){
        EditRecuiterProfileView editRecuiterProfileView = new EditRecuiterProfileView(this);
        navigationController.pushView(editRecuiterProfileView);
    }

    public void updateProfile(String firstName, String lastName, String email, String phone, String company) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCompany(company);
    }
}
