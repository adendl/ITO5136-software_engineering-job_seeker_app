package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobListingsView extends JPanel{
    private JPanel panelMain;
    private JTable jobListingsTable;
    private JButton searchButton;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;

    public JobListingsView() {
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if not on first page

            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if there are more results to paginate through
            }
        });
    }

}
