package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageAdminView extends JFrame{
    private JButton manageUsersButton;
    private JPanel panelMain;
    private JButton manageCategoriesButton;
    private JButton manageSkillsButton;
    private JButton manageLocationsButton;

    public HomePageAdminView() {
        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        manageCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        manageSkillsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        manageLocationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args)
    {
        HomePageAdminView h = new HomePageAdminView();
        h.setContentPane(h.panelMain);
        h.setSize(800,600);
        h.setVisible(true);

    }
}
