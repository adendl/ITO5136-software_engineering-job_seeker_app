package view;

import javax.swing.*;
import java.sql.SQLException;

import controller.ManageUsersController;

public class ManageUsersView implements UIView {
    private JPanel panelMain;
    private JList userList;
    private JTextField manageUsersBox;
    private JButton manageUsersButton;
    private JLabel manageUsersText;
    private ManageUsersController controller;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageUsersView(ManageUsersController manageUsersController) {
        this.controller = manageUsersController;
    }

    public void ManageUsersView(ManageUsersController controller) {
        this.controller = controller;
        manageUsersButton.addActionListener((e) -> {
            try {
                controller.doLockUser(manageUsersBox.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });}

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTextField getManageUsersBox() {
        return manageUsersBox;
    }

    public JList getUserList() {
        return userList;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ManageUsersView m = new ManageUsersView(null);
        ViewHelper.showStandaloneFrame(m);
    }
}
