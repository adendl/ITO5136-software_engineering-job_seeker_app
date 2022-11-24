package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MailboxView implements UIView {
    private JTable table1;
    private JPanel panelMain;
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        MailboxView view = new MailboxView();
        ViewHelper.showStandaloneFrame(view);
    }
}
