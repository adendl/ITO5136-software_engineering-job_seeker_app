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
    private JComboBox comboBox2;
    private JList list1;
    private JButton selectCategoriesButton;
    private JScrollPane scrollPane;


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
                System.out.println(list1.getSelectedValuesList().toString());
            }
        });
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
        s.list1.setModel(dlm);
        ViewHelper.showStandaloneFrame(s);
    }
}
