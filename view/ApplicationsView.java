package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;
import controller.HomeJobSeekerController;

public class ApplicationsView implements UIView {
    private JPanel panelMain;
    private JTable table1;
    private JButton searchButton;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;
    private HomeJobSeekerController controller;

    public ApplicationsView(HomeJobSeekerController controller) {
        this.controller = controller;
        // TODO: we might not need these buttons? the table can probably handle everything
        previousButton.addActionListener((e) -> {
            // only display if not on first page
        });
        nextButton.addActionListener((e) -> {
            // only display if there are more results to paginate through
        });
        sortByButton.addActionListener((e) -> {
            // sort the list, if there's items in it
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ApplicationsView a = new ApplicationsView(null);
        ViewHelper.showStandaloneFrame(a);
    }

}
