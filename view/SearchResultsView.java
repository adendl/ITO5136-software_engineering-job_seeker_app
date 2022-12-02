package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;
import controller.SearchAlgorithmController;

public class SearchResultsView implements UIView {
    private JPanel panelMain;
    private JTextField searchTextField;
    private JTable table1;
    private JButton searchButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;
    private SearchAlgorithmController controller;

    public SearchResultsView(SearchAlgorithmController controller) {
        this.controller = controller;
        searchButton.addActionListener((e) -> {
            controller.backToSearch(searchTextField.getText());
        });
        // TODO: more button listeners? table can sort and scroll so the buttons for sorting and pagination are probably useless
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        SearchResultsView j = new SearchResultsView(null);
        ViewHelper.showStandaloneFrame(j);
    }

}
