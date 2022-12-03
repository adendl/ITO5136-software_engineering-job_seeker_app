package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.NavigationController;
import view.UIView;
import view.ViewHelper;

public class ConfirmPage implements UIView {
    private JButton yesButton;
    private JButton noButton;
    private JPanel panelMain;
    private NavigationController navigationController;

    public ConfirmPage(NavigationController navigationController) {
        this.navigationController = navigationController;

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

    public void addYesButtonListener(ActionListener yesButtonListener) {
        yesButton.addActionListener(yesButtonListener);
    }

    public void addNoButtonListener(ActionListener noButtonListener) {
        noButton.addActionListener(noButtonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
       // ConfirmPage c = new ConfirmPage();
       // ViewHelper.showStandaloneFrame(c);
    }
}
