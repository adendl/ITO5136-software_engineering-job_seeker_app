package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Keyword {

    private int keywordId;
    private String keywordType;
    private String keywordValue;

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(String keywordType) {
        this.keywordType = keywordType;
    }

    public String getKeywordValue() {
        return keywordValue;
    }

    public void setKeywordValue(String keywordValue) {
        this.keywordValue = keywordValue;
    }

    public Keyword() {
    }

    public Keyword(int keywordId, String keywordType, String keywordValue) {
        this.keywordId = keywordId;
        this.keywordType = keywordType;
        this.keywordValue = keywordValue;
    }

    @Override
    public boolean equals(Object ob)
    {
        if (!(ob instanceof Keyword)) {
            return false;
        }

        Keyword k = (Keyword)ob;

        return k.keywordId == this.keywordId;
    }

    public static ResultSet getKeyword(int keywordId) {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Keyword where keywordId=" + keywordId);
        return rs;
    }

    public static ResultSet listKeywords() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Keyword");
        return rs;
    }

    public static ResultSet listCategories() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Keyword where keywordType='category'");
        return rs;
    }

    public static ResultSet listSkills() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Keyword where keywordType='skill'");
        return rs;
    }

    public static ResultSet getKeywords(ArrayList<Integer> keywordIds) {
        String sql = "select * from Skill where skillId in (";
        for (int i = 0; i < keywordIds.size(); i++) {
            if (i == 0) {
                sql += keywordIds.get(i);
            } else {
                sql += String.format(", %o", keywordIds.get(i));
            }
        }
        sql += ")";
        System.out.println(sql);
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        return rs;
    }

    public void createJobCategory() {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO Keyword (keywordId, keywordType, keywordValue) VALUES (null, " + '"' + keywordType + '"' + ',' + '"' + keywordValue + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        try {
            setKeywordId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM Keyword").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteKeyword(int categoryId) {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Keyword where keywordId=" + keywordId);
    }
}
