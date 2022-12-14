package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Job;
import model.TableModelCreator;
import view.UIView;
import view.ViewHelper;
import controller.SearchAlgorithmController;

public class SearchResultsView implements UIView {
    private JPanel panelMain;

    public void setSearchTextField(JTextField searchTextField) {
        this.searchTextField = searchTextField;
    }

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
            controller.backToSearch();
        });
        // TODO: more button listeners? table can sort and scroll so the buttons for sorting and pagination are probably useless
    }

    public void renderTable(){
        ActionListener listener = e1 -> {
            int row = table1.convertRowIndexToModel(table1.getEditingRow());
            int col = (table1.getModel().getColumnCount() - 2);
            controller.showJobDetails((Job)table1.getModel().getValueAt(row, col));
            System.out.println("Go to Job View");
        };

        TableModelCreator.addActionColumn((DefaultTableModel) table1.getModel(), "Job Details", "More Details", listener);

        table1.removeColumn(table1.getColumn("LocationId"));
        table1.removeColumn(table1.getColumn("Recruiter"));
        table1.removeColumn(table1.getColumn("Status"));
        table1.removeColumn(table1.getColumn("Keywords"));
        table1.removeColumn(table1.getColumn("IsAdvertised"));
        table1.removeColumn(table1.getColumn("JobObject"));

        table1.setFocusable(true);
        table1.setColumnSelectionAllowed(false);
        table1.setRowSelectionAllowed(false);

        JTableButtonRenderer renderer = new JTableButtonRenderer();
        table1.getColumn("Job Details").setCellRenderer(renderer);
        table1.getColumn("Job Details").setCellEditor(renderer);
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
