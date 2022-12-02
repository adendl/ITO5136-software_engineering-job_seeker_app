package controller;

import view.ManageUsersView;

public class ManageUsersController {
    NavigationController navigationController;

    public ManageUsersController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showManageUsers(){
        ManageUsersView manageUsersView = new ManageUsersView(this);
        navigationController.pushView(manageUsersView);
    }
}
