package controller;

import view.HomePageAdminView;

import java.sql.SQLException;

public class HomeAdminController {
    NavigationController navigationController;
    public HomeAdminController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showHub() {
        HomePageAdminView view = new HomePageAdminView(this);
        navigationController.pushReplacementView(view);
    }

    public void showManageKeywords() throws SQLException {
        ManageKeywordController manageKeywordController = new ManageKeywordController(navigationController);
        manageKeywordController.showManageKeywords();
    }
    public void showManageUsers() throws SQLException {
        ManageUsersController manageUsersController = new ManageUsersController(navigationController);
        manageUsersController.showManageUsers();
    }
}
