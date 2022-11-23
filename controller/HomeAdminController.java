package controller;

import view.HomePageAdminView;
import view.ManageCategoriesView;
import view.ManageSkillsView;
import view.ManageUsersView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdminController {
    public HomeAdminController(NavigationController navigationController, HomePageAdminView homePageAdminView, ManageCategoriesView manageCategoriesView,
                                   ManageSkillsView manageSkillsView, ManageUsersView manageUsersView){

        //sends to ManageLocation View (not currently a view).
        homePageAdminView.addManageLocationButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //sends to ManageCategoriesView
        homePageAdminView.addManageCategoriesButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(manageCategoriesView.getPanelMain());
            }
        });

        //sends to ManageSkillsView
        homePageAdminView.addManageSkillsButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(manageSkillsView.getPanelMain());
            }
        });

        //sends to manageUser view
        homePageAdminView.addManageUsersButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigationController.setContentArea(manageSkillsView.getPanelMain());
            }
        });
    }
}
