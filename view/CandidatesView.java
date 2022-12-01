package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class CandidatesView implements UIView {
    private JPanel panelMain;
    private JTable table1;
    private JButton searchButton;
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public void addPreviousButtonListener(ActionListener previousButtonListener) {
        previousButton.addActionListener(previousButtonListener);
    }

    public void addNextButtonListener(ActionListener nextButtonListener) {
        nextButton.addActionListener(nextButtonListener);
    }
    public static void main(String[] args)
    {
        CandidatesView c = new CandidatesView();
        ViewHelper.showStandaloneFrame(c);
    }

}
