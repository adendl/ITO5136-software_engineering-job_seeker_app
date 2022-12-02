package view;

import controller.ManageLocationsController;

import javax.swing.*;

public class ManageLocationsView implements UIView{
    private JPanel panel1;
    private JLabel manageLocationsLabel;
    private JList list1;
    private JTextField addLocationText;
    private JButton addButton;
    private JTextField deleteLocationText;
    private JButton deleteButton;
    private JLabel deleteLocationLabel;
    private JLabel addLocationLabel;
    private ManageLocationsController controller;

    public ManageLocationsView(ManageLocationsController controller){
        this.controller = controller;
        addButton.addActionListener((e -> {

        }));
        deleteButton.addActionListener((e -> {

        }));
    }

    @Override
    public JComponent getUIView() {
        return panel1;
    }
}
