package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.NavigationController;
import view.UIView;
import view.CreateJobView;

public class HomePageRecruiterView implements UIView {
    private JButton createNewJobButton;
    private JPanel panelMain;
    private JButton manageListedJobsButton;
    private JButton editCategoriesButton;
    private JButton editProfileButton;

    public HomePageRecruiterView() {

    }

    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }
    public JPanel getPanelMain() {
        return panelMain;
    }

    public void addCreateNewJobButtonListener(ActionListener buttonListener) {
        createNewJobButton.addActionListener(buttonListener);
    }

    public void addEditProfileButtonListener(ActionListener buttonListener) {
        editProfileButton.addActionListener(buttonListener);
    }

    public void addEditCategoriesButtonListener(ActionListener buttonListener) {
        editCategoriesButton.addActionListener(buttonListener);
    }

    public void addManageListedJobsButtonListener(ActionListener buttonListener) {
        manageListedJobsButton.addActionListener(buttonListener);
    }

    public static void main(String[] args)
    {
        HomePageRecruiterView h = new HomePageRecruiterView();
        h.setContentPane(h.panelMain);
        h.setSize(800,600);
        h.setVisible(true);

    }
}
