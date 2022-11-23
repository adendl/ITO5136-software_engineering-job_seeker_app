package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class ConfirmPage implements UIView {
    private JButton yesButton;
    private JButton noButton;
    private JPanel panelMain;

    public ConfirmPage() {

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
        ConfirmPage c = new ConfirmPage();
        ViewHelper.showStandaloneFrame(c);
    }
}
