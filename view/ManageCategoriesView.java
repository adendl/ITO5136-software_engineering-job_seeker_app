package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageCategoriesView extends JFrame {
    private JPanel panelMain;
    private JList categoryList;
    private JTextField addBox;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel deleteText;

    private JLabel addText;
    private JTextField deleteBox;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageCategoriesView() {
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
                    categoryList.setModel(dlm);
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
        ManageCategoriesView m = new ManageCategoriesView();
        m.setContentPane(m.panelMain);
        m.setSize(800, 600);
        m.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
