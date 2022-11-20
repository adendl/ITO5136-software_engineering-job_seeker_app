package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class errorTextView extends JPanel {
    private JPanel errorPanel;
    private JLabel errorText;
    private JButton confirmButton;

    public errorTextView() {
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
