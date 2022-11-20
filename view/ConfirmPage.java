package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmPage extends JFrame {
    private JButton yesButton;
    private JButton noButton;
    private JPanel panelMain;

    public ConfirmPage() {
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("no");
                dispose();
            }
        });
    }

    public static void main(String[] args)
    {
        ConfirmPage c = new ConfirmPage();
        c.setContentPane(c.panelMain);
        c.setSize(800, 600);
        c.setVisible(true);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
