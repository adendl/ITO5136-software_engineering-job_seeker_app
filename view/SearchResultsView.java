package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class SearchResultsView implements UIView {
    private JPanel panelMain;
    private JTextField searchTextField;
    private JTable table1;
    private JButton searchButton;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;

    public SearchResultsView() {

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public JTable getTable1() {
        return table1;
    }

    public void addSearchButtonListener(ActionListener buttonListener) {
        searchButton.addActionListener(buttonListener);
    }

    public void addNextButtonListener(ActionListener buttonListener) {
        nextButton.addActionListener(buttonListener);
    }

    public void addPreviousButtonListener(ActionListener buttonListener) {
        previousButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        SearchResultsView j = new SearchResultsView();
        ViewHelper.showStandaloneFrame(j);
    }

}
