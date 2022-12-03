package controller;

import model.Keyword;
import model.User;
import view.ManageUsersView;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageUsersController {
    NavigationController navigationController;
    ManageUsersView manageUsersView;

    public ManageUsersController(NavigationController navigationController){
        this.navigationController = navigationController;
    }

    public void showManageUsers() throws SQLException {
        this.manageUsersView = new ManageUsersView(this);
        renderUsers();
        navigationController.pushView(manageUsersView);
    }

    public void renderUsers() throws SQLException {
        DefaultListModel dlm = new DefaultListModel();
        ResultSet rs = User.listUsers();
        while (rs.next())
        {
            dlm.addElement(rs.getString("userId"));
        }
        manageUsersView.getUserList().setModel(dlm);
    }

    public void doLockUser(String email) throws SQLException {
        if (User.getUser(email).getString("status").equals("locked"))
        {
            User.updateUser(email, "status", "unlocked");
            JOptionPane.showMessageDialog(null,"The user has been unlcoked", "User unlocked", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            User.updateUser(email, "status", "locked");
            JOptionPane.showMessageDialog(null,"The user has been locked", "User locked", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
