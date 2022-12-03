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
            controller.backToSearch(searchTextField.getText());
        });
        // TODO: more button listeners? table can sort and scroll so the buttons for sorting and pagination are probably useless
        ActionListener listener = e1 -> {
            int row = table1.convertRowIndexToModel(table1.getEditingRow());
            int col = table1.getColumn("JobObject").getModelIndex();
            controller.showJobDetails((Job)table1.getValueAt(row, col));
        };

        TableModelCreator.addActionColumn((DefaultTableModel) table1.getModel(), "Job Details", "More Details", listener);
        TableColumnModel tcm = table1.getColumnModel();

        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("JobObject")));
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Category Id")));
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("IsAdvertised")));
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
