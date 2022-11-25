package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class ManageSkillsView implements UIView {
    private JPanel panelMain;
    private JList skillsList;
    private JTextField addText;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel deleteLabel;
    private JLabel addLabel;
    private JTextField deleteText;
    private JScrollPane scrollPane;
    private JLabel titleLabel;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageSkillsView() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addText.getText());
                if (dlm.contains(addText.getText()))
                {
                    System.out.println("NOT ALLOWED");
                }
                else
                {
                    dlm.addElement(addText.getText());
                    skillsList.setModel(dlm);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dlm.contains(deleteText.getText()))
                {
                    dlm.remove(dlm.indexOf(deleteText.getText()));
                }
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTextField getAddText() {
        return addText;
    }

    public JTextField getDeleteText() {
        return deleteText;
    }

    public JList getSkillsList(){
        return skillsList;
    }

    public void addAddButtonListener(ActionListener buttonListener) {
        addButton.addActionListener(buttonListener);
    }

    public void addDeleteButtonListener(ActionListener buttonListener) {
        deleteButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ManageSkillsView m = new ManageSkillsView();
        ViewHelper.showStandaloneFrame(m);
    }

}
