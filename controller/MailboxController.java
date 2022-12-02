package controller;

import view.MailboxView;
import model.User;

public class MailboxController {
    NavigationController navigationController;
    User user;

    public MailboxController(NavigationController navigationController, User user) {
        this.navigationController = navigationController;
        this.user = user;
    }

    public void showMailbox() {
        MailboxView view = new MailboxView(this);
        navigationController.pushView(view);
    }

    public void renderMessages(){
        //TODO: render the messages for a specfic user ID
    }
}
