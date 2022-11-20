package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmPage extends JPanel {
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

    public static void main(String[] args)
    {
        ConfirmPage c = new ConfirmPage();
        c.setSize(800, 600);
        c.setVisible(true);
    }
}
