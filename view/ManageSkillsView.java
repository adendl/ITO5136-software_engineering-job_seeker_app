package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageSkillsView extends JPanel {
    private JPanel panelMain;
    private JList skillsList;
    private JTextField addBox;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel deleteText;

    private JLabel addText;
    private JTextField deleteBox;
    private JScrollPane scrollPane;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageSkillsView() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addBox.getText());
                if (dlm.contains(addBox.getText()))
                {
                    System.out.println("NOT ALLOWED");
                }
                else
                {
                    dlm.addElement(addBox.getText());
                    skillsList.setModel(dlm);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dlm.contains(deleteBox.getText()))
                {
                    dlm.remove(dlm.indexOf(deleteBox.getText()));
                }
            }
        });
    }

    public static void main(String[] args)
    {
        ManageSkillsView m = new ManageSkillsView();
        m.setSize(800, 600);
        m.setVisible(true);

    }

}
