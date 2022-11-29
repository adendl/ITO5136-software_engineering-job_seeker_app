package controller;

import view.ManageCategoriesView;

public class ManageCategoriesController {
    NavigationController navigationController;

    public ManageCategoriesController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void showManageCategories() {
        ManageCategoriesView manageCategoriesView = new ManageCategoriesView(this);
        navigationController.pushView(manageCategoriesView);
    }
}
