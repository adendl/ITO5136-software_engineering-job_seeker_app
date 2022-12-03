package controller;

import view.HomePageAdminView;
import view.ManageCategoriesView;
import view.ManageSkillsView;
import view.ManageUsersView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
        ManageLocationsController manageLocationsController = new ManageLocationsController(navigationController);
        manageLocationsController.showManageLocations();
    }
    public void showManageSkills() {
        ManageSkillsController manageSkillsController = new ManageSkillsController(navigationController);
        manageSkillsController.showManageSkills();
    }
    public void showManageUsers() throws SQLException {
        ManageUsersController manageUsersController = new ManageUsersController(navigationController);
        manageUsersController.showManageUsers();
    }
}
