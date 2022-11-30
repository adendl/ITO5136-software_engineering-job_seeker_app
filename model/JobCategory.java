package model;

import java.sql.Connection;
import java.sql.ResultSet;

public class JobCategory {
    private int categoryId;
    private String name;

    public JobCategory() {
    }

    public JobCategory(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ResultSet getJobCategory(int categoryId) {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobCategory where categoryId =" + categoryId);
        return rs;
    }

    public ResultSet listJobCategories() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobCategory");
        return rs;
    }

    public void createJobCategory() {
        Connection conn = DBConnection.connectDb();
        String sql = "INSERT INTO JobCategory (categoryId, name) VALUES (null, " + '"' + name + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
        try {
            setCategoryId(DBConnection.queryDatabase(conn, "SELECT LAST_INSERT_ROWID() FROM JobCategory").getInt("last_insert_rowid()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteJobCategory(int categoryId) {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from JobCategory where categoryId=" + categoryId);
    }

    public void updateJobCategory(int categoryId, String fieldName, String value) {
        String sql = "update JobCategory \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere categoryId=" + categoryId;
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }
}


