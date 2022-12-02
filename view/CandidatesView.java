package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import model.DBConnection;
import model.TableModelCreator;
import view.UIView;
import view.ViewHelper;

public class CandidatesView implements UIView {
    private JPanel panelMain;
    private JTable jobSeekerTable;
    private JButton searchButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;

    public CandidatesView() {
        ResultSet rs = DBConnection.queryDatabase("select userID, firstName, LastName, email, phoneNumber, city, state from JobSeeker\njoin Location");
        DefaultTableModel dft = TableModelCreator.resultSetToTableModel(rs);
        ActionListener listener = e -> {
            System.out.println("Button Clicked");
        };

        TableModelCreator.addActionColumn(dft, "Candidate Details", "More Information", listener);
        jobSeekerTable.setModel(dft);
        jobSeekerTable.setColumnSelectionAllowed(false);
        jobSeekerTable.setRowSelectionAllowed(false);
        JTableButtonRenderer renderer = new JTableButtonRenderer();
        jobSeekerTable.getColumn(jobSeekerTable.getColumnName(jobSeekerTable.getColumnCount() - 1)).setCellRenderer(renderer);
        jobSeekerTable.getColumn(jobSeekerTable.getColumnName(jobSeekerTable.getColumnCount() - 1)).setCellEditor(renderer);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if not on first page
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // only display if there are more results to paginate through
            }
        });
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTable getTable1() {
        return jobSeekerTable;
    }

    public static void main(String[] args)
    {
        CandidatesView c = new CandidatesView();
        ViewHelper.showStandaloneFrame(c);
    }

}
