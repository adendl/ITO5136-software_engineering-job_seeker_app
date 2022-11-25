package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class SearchJobView implements UIView {
    private JPanel panelMain;
    private JTextField enterKeywordsText;
    private JButton searchButton;
    private JComboBox locationComboBox;
    private JList resultsList;
    private JButton selectCategoriesButton;
    private JScrollPane scrollPane;
    private JComboBox salaryComboBox;
    private JLabel searchJobsLabel;
    private JLabel salaryRangeLabel;
    private JLabel categoriesLabel;
    private JLabel locationLabel;


    public SearchJobView() {
        selectCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scrollPane.isVisible())
                {
                    scrollPane.setVisible(false);
                }
                else
                {
                    scrollPane.setVisible(true);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(resultsList.getSelectedValuesList().toString());
            }
        });
    }


    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTextField getEnterKeywordsText() {
        return enterKeywordsText;
    }

    public JComboBox getLocationComboBox() {
        return locationComboBox;
    }

    public JList getResultsList() {
        return resultsList;
    }

    public JComboBox getSalaryComboBox() {
        return salaryComboBox;
    }

    public void addSearchJobButtonListener(ActionListener buttonListener) {
        searchButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        SearchJobView s = new SearchJobView();
        DefaultListModel dlm = new DefaultListModel<String>();
        for (int x = 0; x < 1000; x++)
        {
            dlm.add(x, x);
        }
        s.resultsList.setModel(dlm);
        ViewHelper.showStandaloneFrame(s);
    }
}
