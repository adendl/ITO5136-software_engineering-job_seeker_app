package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidatesView extends JFrame {
    private JPanel panelMain;
    private JTable table1;
    private JButton searchButton;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;

    public CandidatesView() {

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
    public static void main(String[] args)
    {
        CandidatesView c = new CandidatesView();
        c.setContentPane(c.panelMain);
        c.setSize(800, 600);
        c.setVisible(true);
    }

}
