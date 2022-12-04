package controller;

import model.Keyword;
import view.*;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeRecruiterController {
    NavigationController navigationController;
    User user;
    public HomeRecruiterController(NavigationController navigationController, User user){
        this.navigationController = navigationController;
        this.user = user;
    }

    public void showHub() {
        HomePageRecruiterView view = new HomePageRecruiterView(this);
        navigationController.getNotificationController().setUser(user);
        navigationController.pushReplacementView(view);
    }

    public void showCreateJob() throws SQLException {
        CreateJobController createJobController = new CreateJobController(navigationController, user);
        createJobController.showCreateJob();
    }

    public void shoeManageKeywords() throws SQLException {
        ManageKeywordController manageKeywordController = new ManageKeywordController(navigationController);
        manageKeywordController.showManageKeywords();
    }

    public void showEditProfile() {
        // TODO: create a view for this and show it here
        RecruiterProfileController controller = new RecruiterProfileController(navigationController);
        controller.showEditRecruiter();
    }

    public void showManageListedJobs(ArrayList<Keyword> keywords) {
        ListJobsController listJobsController = new ListJobsController(this.navigationController, this.user);
        listJobsController.renderListedJobs(keywords);
    }

    public void showMailbox() {
        MailboxController mailboxController = new MailboxController(this.navigationController, this.user);
        mailboxController.showMailbox(false);
    }
}
