package controller;

import model.User;
import model.Mailbox;
import view.MailboxView;

import javax.swing.table.DefaultTableModel;

public class NotificationController {
    NavigationController navigationController;
    User user;
    Mailbox mailBox;

    public NotificationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    // set user and create a mailbox to keep an eye on their messages
    // then update the unread message count
    public void setUser(User user) {
        this.user = user;
        this.mailBox = new Mailbox();
        // always update after changing user
        update();
    }

    // clear current user and mailbox
    public void clearUser() {
        user = null;
        mailBox = null;
        // also update the controller and nav bar so it hides the button
        navigationController.updateUnreadMessageCount(0);
    }

    // update unread message count and any UI related to it
    public void update() {
        if (user == null) {
            System.out.println("notification: update called with no user set");
            return;
        }

        // get unread message count
        int unread = mailBox.getUnreadMessageCount(user.getUserId());
        // tell the navigation controller (so the navbar view can be updated)
        navigationController.updateUnreadMessageCount(unread);
    }

    // show the mailbox view for our user
    public void showMailbox() {
        if (user == null) {
            System.out.println("notification: showMailbox called with no user set");
            return;
        }

        MailboxController controller = new MailboxController(navigationController, user);
        controller.showMailbox(true);
    }
}
