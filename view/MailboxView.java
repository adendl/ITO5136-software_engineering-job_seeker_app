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

        ResultSet rs = DBConnection.queryDatabase("select messageID, subject, sendDate, title, firstName, lastName, messageType, messageStatus\nfrom Message\nINNER JOIN Job on Message.jobId=Job.jobId\nInner Join JobSeeker on Message.senderUserId=JobSeeker.userId");
        DefaultTableModel dft = TableModelCreator.resultSetToTableModel(rs);
        ActionListener listener = e -> {
            int row = tblMessages.convertRowIndexToModel(tblMessages.getEditingRow());
            int col = tblMessages.getColumn("messageId").getModelIndex();
            DBConnection.queryDatabase("delete from Message where messageId=" + (Integer)tblMessages.getValueAt(row, col));
            ((DefaultTableModel)tblMessages.getModel()).removeRow(row);
        };

        Icon trash = new ImageIcon("icon/trash.png");
        TableModelCreator.addActionColumn(dft, "Delete", trash, listener);
        int col = dft.findColumn("messageStatus");
        Icon unread = new ImageIcon("icon/closed-envelope.png");
        Icon read = new ImageIcon("icon/open-envelope.png");
        for(int i = 0; i < dft.getRowCount(); i++){
            JButton button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = tblMessages.convertRowIndexToModel(tblMessages.getEditingRow());

                }
            });
            if (dft.getValueAt(i, col).toString().equals("Read")){
                button.setIcon(read);
                dft.setValueAt(button, i, col);
            }
            else{
                button.setIcon(unread);
                dft.setValueAt(button, i, col);
            }
        }
        tblMessages.setModel(dft);
        tblMessages.setColumnSelectionAllowed(false);
        tblMessages.setRowSelectionAllowed(false);
        JTableButtonRenderer renderer = new JTableButtonRenderer();
        tblMessages.getColumn("messageStatus").setCellRenderer(renderer);
        tblMessages.getColumn("messageStatus").setCellEditor(renderer);
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

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        MailboxView view = new MailboxView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
