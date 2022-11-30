package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class SearchCandidatesView implements UIView {
    private JPanel panelMain;
    private JTextField enterKeywordsTextField;
    private JButton searchButton;
    private JComboBox locationBox;
    private JList resultsList;
    private JButton selectCategoriesButton;
    private JScrollPane scrollPane;
    private JLabel searchCandidatesLabel;
    private JLabel categoriesLabel;
    private JLabel locationLabel;


    public SearchCandidatesView() {
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

    public JTextField getEnterKeywordsTextField() {
        return enterKeywordsTextField;
    }

    public JComboBox getLocationBox() {
        return locationBox;
    }


    public JList getResultsList() {
        return resultsList;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        SearchCandidatesView s = new SearchCandidatesView();
        DefaultListModel dlm = new DefaultListModel<String>();
        for (int x = 0; x < 1000; x++)
        {
            dlm.add(x, x);
        }
        s.resultsList.setModel(dlm);
        ViewHelper.showStandaloneFrame(s);
    }
}
