package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.NavigationController;
import controller.CreateJobController;
import view.UIView;
import view.ViewHelper;
import model.Job;

public class ConfirmPage implements UIView {
    private JButton yesButton;
    private JButton noButton;
    private JPanel panelMain;
    private JLabel Confrim;
    private CreateJobController createJobControllercontroller;
    private NavigationController navigationController;

    public ConfirmPage(NavigationController navigationController,CreateJobController createJobController, Job job) {
        this.createJobControllercontroller = createJobController;
        yesButton.addActionListener((e -> {
            job.createJob();
            JOptionPane.showMessageDialog(null, "Your Job has been listed", "InfoBox: Job Listed", JOptionPane.INFORMATION_MESSAGE);
            navigationController.doBack();
        }));
        noButton.addActionListener((e -> {
            navigationController.doBack();
        }));
    }
    public JButton getYesButton() {
        return yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        //ConfirmPage c = new ConfirmPage();
        //ViewHelper.showStandaloneFrame(c);
    }
}
