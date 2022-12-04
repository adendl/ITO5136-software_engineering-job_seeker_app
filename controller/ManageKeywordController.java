package controller;

import model.DBConnection;
import model.Keyword;
import view.ManageKeywordsView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.Keyword.getKeywordByValue;

public class ManageKeywordController {
    NavigationController navigationController;
    ManageKeywordsView manageKeywordsView;

    public ManageKeywordController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    public void showManageKeywords() throws SQLException {
        this.manageKeywordsView = new ManageKeywordsView(this);
        loadKeywords();
        navigationController.pushView(manageKeywordsView);
    }

    public void addKeyword(String keywordType, String keywordValue) throws SQLException {
        Keyword keyword = new Keyword(keywordType, keywordValue);
        keyword.createKeyword();
        loadKeywords();
    }

    public void deleteKeyword(String keywordValue) throws SQLException {
        Keyword.deleteKeyword(getKeywordByValue(keywordValue).getInt("keywordId"));
        loadKeywords();

    }

    public void doCategoryDelete(String name){
        //TODO
    }

    public void loadKeywords() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        ResultSet rs = Keyword.listKeywords();
        manageKeywordsView.getKeywordTable().setModel(DBConnection.resultSetToTableModel(rs));
    }
}
