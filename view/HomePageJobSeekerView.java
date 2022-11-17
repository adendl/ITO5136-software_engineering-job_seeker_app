package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageJobSeekerView extends JFrame{
    private JButton searchJobsButton;
    private JPanel panelMain;
    private JButton viewApplicationsButton;
    private JButton viewInterviewInvitationsButton;
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
        viewInterviewInvitationsButton.addActionListener(new ActionListener() {
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

    public static void main(String[] args)
    {
        HomePageJobSeekerView h = new HomePageJobSeekerView();
        h.setContentPane(h.panelMain);
        h.setSize(800,600);
        h.setVisible(true);

    }
}
