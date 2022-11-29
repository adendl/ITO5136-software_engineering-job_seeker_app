package controller;

import view.HomePageAdminView;
import view.ManageCategoriesView;
import view.ManageSkillsView;
import view.ManageUsersView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdminController {
    NavigationController navigationController;
    public HomeAdminController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showHub() {
        HomePageAdminView view = new HomePageAdminView(this);
        navigationController.pushView(view);
    }

    public void showManageCategories() {
        ManageCategoriesController manageCategoriesController = new ManageCategoriesController(navigationController);
        manageCategoriesController.showManageCategories();
    }
    public void showManageLocations() {
        //
    }
    public void showManageSkills() {
        ManageSkillsView manageSkillsView = new ManageSkillsView(this);
        navigationController.pushView(manageSkillsView);
    }
    public void showManageUsers() {
        //
    }
}
