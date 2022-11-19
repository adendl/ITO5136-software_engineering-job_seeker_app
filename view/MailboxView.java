package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailboxView extends JFrame {
    private JTable table1;
    private JPanel panelmain;
    private JComboBox sortByBox;
    private JButton previousButton;
    private JButton nextButton;

    public MailboxView() {
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
