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
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
