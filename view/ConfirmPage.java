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
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("no");
            }
        });
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
