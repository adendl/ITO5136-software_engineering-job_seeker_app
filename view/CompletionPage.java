package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.NavigationController;
import view.UIView;
import view.ViewHelper;

public class CompletionPage implements UIView {
    private JButton continueButton;
    private JPanel panelMain;
    NavigationController navigationController;

    public CompletionPage(NavigationController navigationController) {
        this.navigationController = navigationController;
        continueButton.addActionListener((e -> {

        }));
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void  main(String[] args)
    {
        //CompletionPage c = new CompletionPage();
        //ViewHelper.showStandaloneFrame(c);
    }
}
