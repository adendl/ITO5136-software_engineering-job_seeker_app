package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Vector;

public class TableModelCreator {
    public TableModelCreator (){ }

    public static DefaultTableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns =  metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            DefaultTableModel dft = new DefaultTableModel(rows, columnNames){
                public boolean isCellEditable(int row, int col) {
                    return this.getValueAt(row, col) instanceof JButton;
                }
            };
            return dft;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }


    public static DefaultTableModel resultSetToTableModelJob(ResultSet rs, Object object, List headers ) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            columnNames.addElement("JobObject");

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Job newJob = new Job();
                Vector newRow = new Vector();
                newRow.addElement(newJob.getCompany());
                newRow.addElement(newJob.getTitle());
                newRow.addElement(newJob.getDescription());
                newRow.addElement(newJob.getLocationId());
                newRow.addElement(newJob);
                /* for (int i = 1; i <= numberOfColumns; i++) {
                    newJob.addElement(rs.getObject(i));
                }
                 */
                rows.addElement(newRow);
            }

            DefaultTableModel dft = new DefaultTableModel(rows, columnNames){
                public boolean isCellEditable(int row, int col) {
                    return this.getValueAt(row, col) instanceof JButton;
                }
            };
            return dft;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void addActionColumn(DefaultTableModel table, String actionHeader, String actionString, ActionListener listener){
        int rows = table.getRowCount();
        table.addColumn(actionHeader);
        while(rows > 0) {
            JButton button = new JButton(actionString);
            button.addActionListener(listener);
            table.setValueAt(button, (rows-1), (table.getColumnCount()-1));
            --rows;
        }

    }
    public static void addActionColumn(DefaultTableModel table, String actionHeader, Icon actionIcon, ActionListener listener) {
        int rows = table.getRowCount();
        table.addColumn(actionHeader);
        while (rows > 0) {
            JButton button = new JButton(actionIcon);
            button.addActionListener(listener);
            table.setValueAt(button, (rows - 1), (table.getColumnCount() - 1));
            --rows;
        }
    }

}
