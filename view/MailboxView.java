package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import controller.MailboxController;
import model.DBConnection;
import model.Message;
import model.TableModelCreator;

public class MailboxView implements UIView {
    private JTable tblMessages;
    private JPanel panelMain;
    private JComboBox sortByBox;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleLabel;
    private MailboxController controller;

    public MailboxView(MailboxController controller) {
        this.controller = controller;

        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select messageID, subject, sendDate, title, firstName, lastName, messageType, messageStatus\nfrom Message\nINNER JOIN Job on Message.jobId=Job.jobId\nInner Join JobSeeker on Message.senderUserId=JobSeeker.userId");
        DefaultTableModel dft = TableModelCreator.resultSetToTableModel(rs);
        ActionListener listener = e -> {
            int row = tblMessages.convertRowIndexToModel(tblMessages.getEditingRow());
            int col = tblMessages.getColumn("messageId").getModelIndex();
            DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Message where messageId=" + (Integer)tblMessages.getValueAt(row, col));
            ((DefaultTableModel)tblMessages.getModel()).removeRow(row);
        };

        TableModelCreator.addActionColumn(dft, "Delete", "Delete", listener);
        tblMessages.setModel(dft);
        tblMessages.setColumnSelectionAllowed(false);
        tblMessages.setRowSelectionAllowed(false);
        JTableButtonRenderer renderer = new JTableButtonRenderer();
        tblMessages.getColumn(tblMessages.getColumnName(tblMessages.getColumnCount() - 1)).setCellRenderer(renderer);
        tblMessages.getColumn(tblMessages.getColumnName(tblMessages.getColumnCount() - 1)).setCellEditor(renderer);
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        MailboxView view = new MailboxView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
