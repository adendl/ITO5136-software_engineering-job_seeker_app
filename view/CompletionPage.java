package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class CompletionPage implements UIView {
    private JButton continueButton;
    private JPanel panelMain;

    public CompletionPage() {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void addContinueButtonListener(ActionListener continueButtonListener) {
        continueButton.addActionListener(continueButtonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void  main(String[] args)
    {
        CompletionPage c = new CompletionPage();
        ViewHelper.showStandaloneFrame(c);
    }
}
