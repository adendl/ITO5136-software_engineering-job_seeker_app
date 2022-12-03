package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.JobSearchController;

public class SearchJobView implements UIView {
    private JPanel panelMain;
    private JTextField enterKeywordsText;
    private JButton searchButton;
    private JComboBox locationComboBox;
    private JButton selectCategoriesButton;
    private JScrollPane scrollPane;
    private JComboBox salaryComboBox;
    private JLabel searchJobsLabel;
    private JLabel salaryRangeLabel;
    private JLabel categoriesLabel;
    private JLabel locationLabel;
    private JComboBox categoriesComboBox;
    private JButton searchProfileButton;

    private JobSearchController controller;

    public SearchJobView(JobSearchController jobSearchController) {
            this.controller = jobSearchController;
            searchButton.addActionListener((e) -> {
                try {
                    controller.doSearch(enterKeywordsText.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });
            searchProfileButton.addActionListener((e) -> {
                controller.doProfileSearch();
            });
        }


    public JTextField getEnterKeywordsText() {
        return enterKeywordsText;
    }

    public JComboBox getLocationComboBox() {
        return locationComboBox;
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

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public void setEnterKeywordsText(JTextField enterKeywordsText) {
        this.enterKeywordsText = enterKeywordsText;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public void setLocationComboBox(JComboBox locationComboBox) {
        this.locationComboBox = locationComboBox;
    }

    public JButton getSelectCategoriesButton() {
        return selectCategoriesButton;
    }

    public void setSelectCategoriesButton(JButton selectCategoriesButton) {
        this.selectCategoriesButton = selectCategoriesButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setSalaryComboBox(JComboBox salaryComboBox) {
        this.salaryComboBox = salaryComboBox;
    }

    public JLabel getSearchJobsLabel() {
        return searchJobsLabel;
    }

    public void setSearchJobsLabel(JLabel searchJobsLabel) {
        this.searchJobsLabel = searchJobsLabel;
    }

    public JLabel getSalaryRangeLabel() {
        return salaryRangeLabel;
    }

    public void setSalaryRangeLabel(JLabel salaryRangeLabel) {
        this.salaryRangeLabel = salaryRangeLabel;
    }

    public JLabel getCategoriesLabel() {
        return categoriesLabel;
    }

    public void setCategoriesLabel(JLabel categoriesLabel) {
        this.categoriesLabel = categoriesLabel;
    }

    public JLabel getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(JLabel locationLabel) {
        this.locationLabel = locationLabel;
    }

    public JComboBox getCategoriesComboBox() {
        return categoriesComboBox;
    }

    public void setCategoriesComboBox(JComboBox categoriesComboBox) {
        this.categoriesComboBox = categoriesComboBox;
    }

    public JButton getSearchProfileButton() {
        return searchProfileButton;
    }

    public void setSearchProfileButton(JButton searchProfileButton) {
        this.searchProfileButton = searchProfileButton;
    }

    public JobSearchController getController() {
        return controller;
    }

    public void setController(JobSearchController controller) {
        this.controller = controller;
    }
}
