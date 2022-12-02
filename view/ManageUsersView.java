package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeAdminController;
import controller.ManageUsersController;
import view.UIView;
import view.ViewHelper;

public class ManageUsersView implements UIView {
    private JPanel panelMain;
    private JList userList;
    private JTextField manageUsersBox;
    private JButton manageUsersButton;
    private JLabel manageUsersText;
    private ManageUsersController controller;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageUsersView(ManageUsersController controller) {
        this.controller = controller;
        manageUsersButton.addActionListener((e) -> {
            System.out.println(manageUsersBox.getText());
            if (dlm.contains(manageUsersBox.getText()))
            {
                System.out.println("NOT ALLOWED");
            }
            else
            {
                dlm.addElement(manageUsersBox.getText());
                userList.setModel(dlm);
            }
        });
    }

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
