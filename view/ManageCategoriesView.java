package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class ManageCategoriesView implements UIView {
    private JPanel panelMain;
    private JList categoryList;
    private JTextField addBox;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel deleteLabel;
    private JLabel addText;
    private JTextField deleteText;
    private JLabel titleLabel;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageCategoriesView() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addBox.getText());
                if (dlm.contains(addBox.getText()))
                {
                    System.out.println("NOT ALLOWED");
                }
                else
                {
                    dlm.addElement(addBox.getText());
                    categoryList.setModel(dlm);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dlm.contains(deleteText.getText()))
                {
                    dlm.remove(dlm.indexOf(deleteText.getText()));
                }
            }
        });
    }


    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTextField getAddBox() {
        return addBox;
    }

    public JTextField getDeleteText() {
        return deleteText;
    }

    public JList getCategoryList() {
        return categoryList;
    }

    public void addAddButtonListener(ActionListener buttonListener) {
        addButton.addActionListener(buttonListener);
    }

    public void addDeleteButtonListener(ActionListener buttonListener) {
        deleteButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ManageCategoriesView view = new ManageCategoriesView();
        ViewHelper.showStandaloneFrame(view);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
