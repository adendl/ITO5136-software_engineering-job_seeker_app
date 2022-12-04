package controller;

import model.ApplicationList;
import model.Job;
import model.JobApplication;
import model.User;
import view.ApplicationsView;
import view.JobListingsView;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ListApplicationsController {
    private NavigationController navigationController;
    private User user;
    private int jobId;
    private ApplicationList applicationList;

    public ListApplicationsController(NavigationController controller, User user, int jobId){
        this.navigationController = controller;
        this.user = user;
        this.jobId = jobId;
        applicationList = new ApplicationList();
    }

    public void renderListedApplications() {
        DefaultTableModel dft = applicationList.applicationListDft(this.jobId);
        ApplicationsView view = new ApplicationsView(this);
        view.getTable1().setModel(dft);
        view.renderTableForRecruiter();
        navigationController.pushView(view);
    }








}
