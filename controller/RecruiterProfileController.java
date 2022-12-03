package controller;

import model.User;
import model.Recruiter;
import view.EditRecuiterProfileView;
import view.UIView;

public class RecruiterProfileController {
    NavigationController navigationController;
    Recruiter user;
    public RecruiterProfileController(NavigationController navigationController, Recruiter user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void showEditRecruiter(){
        EditRecuiterProfileView editRecuiterProfileView = new EditRecuiterProfileView(this, user);
        navigationController.pushView(editRecuiterProfileView);
    }

    public void updateProfile(String firstName, String lastName, String email, String company) {
        user.setFirstName(firstName);
        user.updateRecruiter(email, "firstName", firstName);
        System.out.println(user.getFirstName());
        user.setUserId(email);
        user.updateRecruiter(email, "email", email);
        System.out.println(user.getUserId());
        user.setLastName(lastName);
        user.updateRecruiter(email, "lastName", lastName);
        System.out.println(user.getLastName());
        user.setCompany(company);
        user.updateRecruiter(email, "company", company);
        System.out.println(user.getCompany());
    }
}
