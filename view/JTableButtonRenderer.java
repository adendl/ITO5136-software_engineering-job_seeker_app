package view;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class JTableButtonRenderer extends DefaultTableModel implements TableCellRenderer, TableCellEditor{
    private TableCellRenderer defaultRenderer;
    private TableCellEditor defaultEditor;

    public JTableButtonRenderer(){
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Component){
            return (Component)value;
        }
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    @Override
    public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int row, int column){
        if(value instanceof Component){
            return (Component)value;
        }
        return defaultEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    @Override
    public Object getCellEditorValue(){
        return null;
    }

    @Override
    public boolean isCellEditable (EventObject anEvent){
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent){
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing (){ }

    @Override
    public void addCellEditorListener(CellEditorListener l){ }

    @Override
    public void removeCellEditorListener(CellEditorListener l){ }
}


