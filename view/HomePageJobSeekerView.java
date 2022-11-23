package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class HomePageJobSeekerView implements UIView {
    private JButton searchJobsButton;
    private JPanel panelMain;
    private JButton viewApplicationsButton;
    private JButton viewInvitationsButton;
    private JButton editProfileButton;

    public HomePageJobSeekerView() {

    }

    public JButton getSearchJobsButton() {
        return searchJobsButton;
    }

    public void addSearchJobsButtonListener(ActionListener buttonListener) {
        searchJobsButton.addActionListener(buttonListener);
    }

    public void addViewApplicationsButtonListener(ActionListener buttonListener) {
        viewApplicationsButton.addActionListener(buttonListener);
    }

    public void addViewInvitationsButtonListener(ActionListener buttonListener) {
        viewInvitationsButton.addActionListener(buttonListener);
    }

    public void addEditProfileButtonListener(ActionListener buttonListener) {
        editProfileButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        HomePageJobSeekerView view = new HomePageJobSeekerView();
        ViewHelper.showStandaloneFrame(view);
    }
}
