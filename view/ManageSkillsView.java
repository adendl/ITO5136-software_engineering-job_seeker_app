package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.HomeAdminController;
import controller.ManageSkillsController;
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
    private ManageSkillsController controller;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageSkillsView(ManageSkillsController controller) {
        this.controller = controller;

        addButton.addActionListener((e) -> {
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
        });
        deleteButton.addActionListener((e) -> {
            if (dlm.contains(deleteText.getText()))
            {
                dlm.remove(dlm.indexOf(deleteText.getText()));
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ManageSkillsView m = new ManageSkillsView(null);
        ViewHelper.showStandaloneFrame(m);
    }

}
