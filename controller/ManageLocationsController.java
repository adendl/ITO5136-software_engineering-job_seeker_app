package controller;

import view.ManageLocationsView;

public class ManageLocationsController {
    NavigationController navigationController;

    public ManageLocationsController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showManageLocations(){
        ManageLocationsView manageLocationsView = new ManageLocationsView(this);
        navigationController.pushView(manageLocationsView);
    }

    public void renderLocations(){
        //render all locations into table
    }

    public void doLocationAdd(String name){
        //add to db.
    }

    public void doLocationDelete(String name){
        //find in db and delete.
    }
}
