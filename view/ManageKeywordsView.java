package view;

import javax.swing.*;

import controller.ManageKeywordController;

import java.sql.SQLException;

public class ManageKeywordsView implements UIView {
    private JPanel panelMain;
    private JList categoryList;
    private JTextField addBox;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel deleteLabel;
    private JLabel addText;
    private JTextField keywordValueText;
    private JLabel titleLabel;
    private JTable keywordTable;
    private JComboBox keywordTypeBox;
    private ManageKeywordController controller;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public ManageKeywordsView(ManageKeywordController controller) {
        this.controller = controller;
        addButton.addActionListener((e) ->{
            try {
                controller.addKeyword(keywordTypeBox.getSelectedItem().toString(), keywordValueText.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteButton.addActionListener((e) -> {
            try {
                controller.deleteKeyword(keywordValueText.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
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
        return keywordValueText;
    }

    public JList getCategoryList() {
        return categoryList;
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args)
    {
        ManageKeywordsView view = new ManageKeywordsView(null);
        ViewHelper.showStandaloneFrame(view);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JTable getKeywordTable() {
        return keywordTable;
    }

    public void setKeywordTable(JTable keywordTable) {
        this.keywordTable = keywordTable;
    }


    public JComboBox getKeywordTypeBox() {
        return keywordTypeBox;
    }

    public void setKeywordTypeBox(JComboBox keywordTypeBox) {
        this.keywordTypeBox = keywordTypeBox;
    }
}
