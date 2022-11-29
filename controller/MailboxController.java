package controller;

import view.MailboxView;

public class MailboxController {
    NavigationController navigationController;

    public MailboxController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void showMailbox() {
        MailboxView view = new MailboxView(this);
        navigationController.pushView(view);
    }
}
