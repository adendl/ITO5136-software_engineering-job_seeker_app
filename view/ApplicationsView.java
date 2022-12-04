package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ListApplicationsController;
import model.Job;
import model.JobApplication;
import model.TableModelCreator;
import view.UIView;
import view.ViewHelper;
import controller.HomeJobSeekerController;

public class ApplicationsView implements UIView {
    private JPanel panelMain;
    private JTable table1;

    private JLabel headingText;
    private HomeJobSeekerController homeJobSeekerController;
    private ListApplicationsController listApplicationsController;

    public ApplicationsView(HomeJobSeekerController controller) {
        this.homeJobSeekerController = controller;
    }

    public ApplicationsView(ListApplicationsController controller) {
        this.listApplicationsController = controller;
    }

    public void renderTableForRecruiter(){
        ActionListener listener = e1 -> {
            int row = table1.convertRowIndexToModel(table1.getEditingRow());
            int col = (table1.getModel().getColumnCount() - 2);
            System.out.println("Go Application View");
            listApplicationsController.viewApplication((JobApplication)table1.getModel().getValueAt(row, col));
        };

        TableModelCreator.addActionColumn((DefaultTableModel) table1.getModel(), "Details", "More Details", listener);

        table1.removeColumn(table1.getColumn("Resume ID"));
        table1.removeColumn(table1.getColumn("Message ID"));
        table1.removeColumn(table1.getColumn("ApplicationObject"));

        table1.setFocusable(true);
        table1.setColumnSelectionAllowed(false);
        table1.setRowSelectionAllowed(false);

        JTableButtonRenderer renderer = new JTableButtonRenderer();
        table1.getColumn("Details").setCellRenderer(renderer);
        table1.getColumn("Details").setCellEditor(renderer);
    }

    public JPanel getPanelMain() {
        return panelMain;
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
        //ApplicationsView a = new ApplicationsView(null);
        //ViewHelper.showStandaloneFrame(a);
    }

}
