package controller;

import view.ManageSkillsView;

public class ManageSkillsController {
    NavigationController navigationController;

    public ManageSkillsController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showManageSkills(){
        ManageSkillsView manageSkillsView = new ManageSkillsView(this);
        navigationController.pushView(manageSkillsView);
    }

    public void renderSkills(){
        //TODO
    }
}
