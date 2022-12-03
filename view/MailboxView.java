package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.MailboxController;
import model.Mailbox;
import model.Message;
import model.TableModelCreator;

public class MailboxView implements UIView {
    private JTable tblMessages;
    private JPanel panelMain;
    private JComboBox sortByBox;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleLabel;
    private JScrollPane messageViewScrollPane;
    private MailboxController controller;
    //private DefaultTableModel dft;

    public MailboxView(MailboxController controller) {
        this.controller = controller;

    }

    public void renderTable() {
        ActionListener deleteAction = e -> {
            int deleteRow = tblMessages.convertRowIndexToModel(tblMessages.getEditingRow());
            int objCol = (tblMessages.getModel().getColumnCount()-2);
            controller.deleteMessageAction((Message)tblMessages.getValueAt(deleteRow, objCol));
            ((DefaultTableModel)tblMessages.getModel()).removeRow(deleteRow);
        };
        DefaultTableModel dft = (DefaultTableModel)tblMessages.getModel();

        Icon trash = new ImageIcon("icon/trash.png");
        TableModelCreator.addActionColumn(dft, "Delete", trash, deleteAction);
        int statusCol = dft.findColumn("Message Status");
        Icon unread = new ImageIcon("icon/closed-envelope.png");
        Icon read = new ImageIcon("icon/open-envelope.png");

        for(int i = 0; i < dft.getRowCount(); i++){
            JButton button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = tblMessages.convertRowIndexToModel(tblMessages.getEditingRow());
                    int col = tblMessages.convertColumnIndexToModel(tblMessages.getEditingColumn());
                    int objCol = (tblMessages.getModel().getColumnCount()-2);
                    Message message = (Message) tblMessages.getModel().getValueAt(row, objCol);
                    controller.showMessage(message);
                    JButton button = (JButton)dft.getValueAt(row, col);
                    button.setIcon(read);
                }
            });

            if (dft.getValueAt(i, statusCol).toString().equals("read")){
                button.setIcon(read);
                dft.setValueAt(button, i, statusCol);
            }
            else{
                button.setIcon(unread);
                dft.setValueAt(button, i, statusCol);
            }
        }

        tblMessages.removeColumn(tblMessages.getColumn("Message ID"));
        tblMessages.removeColumn(tblMessages.getColumn("Message Object"));
        tblMessages.removeColumn(tblMessages.getColumn("Recipient"));
        tblMessages.setColumnSelectionAllowed(false);
        tblMessages.setRowSelectionAllowed(false);
        JTableButtonRenderer renderer = new JTableButtonRenderer();
        tblMessages.getColumn("Message Status").setCellRenderer(renderer);
        tblMessages.getColumn("Message Status").setCellEditor(renderer);
        tblMessages.getColumn("Delete").setCellRenderer(renderer);
        tblMessages.getColumn("Delete").setCellEditor(renderer);
        tblMessages.setRowHeight(50);

    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JComboBox getSortByBox() {
        return sortByBox;
    }

    public void setSortByBox(JComboBox sortByBox) {
        this.sortByBox = sortByBox;
    }

    public void addNextButtonListener(ActionListener buttonListener) {
        nextButton.addActionListener(buttonListener);
    }
    public void addPreviousButtonListener(ActionListener buttonListener) {
        previousButton.addActionListener(buttonListener);
    }

    public JTable getTblMessages() {
        return tblMessages;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) throws SQLException {
        MailboxView view = new MailboxView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
