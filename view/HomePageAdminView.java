package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class HomePageAdminView implements UIView {
    private JButton manageUsersButton;
    private JPanel panelMain;
    private JButton manageCategoriesButton;
    private JButton manageSkillsButton;
    private JButton manageLocationsButton;

    public HomePageAdminView() {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void addManageUsersButtonListener(ActionListener manageUsersButtonListener) {
        manageUsersButton.addActionListener(manageUsersButtonListener);
    }

    public void addManageCategoriesButtonListener(ActionListener manageCategoriesButtonListener) {
        manageCategoriesButton.addActionListener(manageCategoriesButtonListener);
    }

    public void addManageSkillsButtonListener(ActionListener manageSkillsButtonListener) {
        manageSkillsButton.addActionListener(manageSkillsButtonListener);
    }

    public void addManageLocationButtonListener(ActionListener manageLocationButtonListener) {
        manageLocationsButton.addActionListener(manageLocationButtonListener);
    }


    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        HomePageAdminView view = new HomePageAdminView();
        ViewHelper.showStandaloneFrame(view);
    }
}
