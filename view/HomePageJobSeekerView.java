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
        searchJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        viewApplicationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        viewInvitationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
