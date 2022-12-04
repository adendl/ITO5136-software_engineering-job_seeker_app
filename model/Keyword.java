package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Keyword(String keywordType, String keywordValue) {
        this.keywordType = keywordType;
        this.keywordValue = keywordValue;
    }

    public Keyword(String keywordValue) {
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
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordId=" + keywordId);
        return rs;
    }
    public static ResultSet getKeywordByValue(String keywordValue) {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordValue='" + keywordValue + "'");
        return rs;
    }

    public static ResultSet getKeywordByValueLike(String keywordValue) {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordValue like'%" + keywordValue + "%'");
        return rs;
    }


    public static ArrayList<Keyword> getKeywordListByIds(String keywordIds) throws SQLException
    {
        ArrayList<Keyword> keywordList = new ArrayList<Keyword>();
        List<String> keywords = Arrays.asList(keywordIds.split("\\s*,\\s*"));
        for (int i = 0; i < keywords.size(); i++)
        {
            ResultSet kw = Keyword.getKeyword(Integer.parseInt(keywords.get(i)));
            keywordList.add(new Keyword(kw.getInt("keywordId"), kw.getString("keywordType"), kw.getString("keywordValue")));
        }
        return keywordList;
    }

    public static ResultSet listKeywords() {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword");
        return rs;
    }

    public static ResultSet listCategories() {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordType='category'");
        return rs;
    }

    public static ResultSet listSalary() {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordType='salary'");
        return rs;
    }

    public static ResultSet listSkills() {
        ResultSet rs = DBConnection.queryDatabase("select * from Keyword where keywordType='skill'");
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
        ResultSet rs = DBConnection.queryDatabase(sql);
        return rs;
    }

    public void createKeyword() {
        String sql = "INSERT INTO Keyword (keywordId, keywordType, keywordValue) VALUES (null, " + '"' + keywordType + '"' + ',' + '"' + keywordValue + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
        try {
            setKeywordId(DBConnection.queryDatabase("SELECT LAST_INSERT_ROWID() FROM Keyword").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteKeyword(int keywordId) {
        DBConnection.queryDatabase("delete from Keyword where keywordId=" + keywordId);
    }
}
