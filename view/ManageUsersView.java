package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUsersView extends JFrame {
    private JPanel panelMain;
    private JList userList;
    private JTextField manageUsersBox;
    private JButton manageUsersButton;

    private JLabel manageUsersText;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageUsersView() {
        manageUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
    }

    public static void main(String[] args)
    {
        ManageUsersView m = new ManageUsersView();
        m.setContentPane(m.panelMain);
        m.setSize(800, 600);
        m.setVisible(true);

    }
}
