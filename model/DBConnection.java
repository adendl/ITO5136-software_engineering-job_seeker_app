package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import java.sql.ResultSetMetaData;

public class DBConnection {
    static String CONNECTION_PATH = "jdbc:sqlite:test.db";
    static DBConnection INSTANCE = null;
    Connection connection;

    // constructor is private because we only want our get() method calling it
    private DBConnection(String connectionPath) {
        try {
            connection = DriverManager.getConnection(connectionPath);
        }
        catch (SQLException e) {
            System.out.println("error connecting to database: " + e);
        }
    }

    // get our DBConnection, creating an instance if none exists
    // this method is synchronized so only one thread can run it at a time
    public synchronized static DBConnection get()
    {
        if (INSTANCE == null) {
            INSTANCE = new DBConnection(CONNECTION_PATH);
        }
        return INSTANCE;
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        }
        catch(SQLException e)
        {
            System.err.println("queryDatabase failed: " + e.getMessage());
            return null;
        }
    }

    public static ResultSet queryDatabase(String sql)
    {
        return DBConnection.get().executeQuery(sql);
    }

    // query the last inserted row id for a given table, used to set ID on various entities after they've been inserted to the database
    public int getLatestItemId(String fromTable) throws SQLException {
        return queryDatabase("SELECT LAST_INSERT_ROWID() FROM " + fromTable).getInt("last_insert_rowid()");
    }

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            System.out.println("resultSetToTableModel failed");
            e.printStackTrace();

            return null;
        }
    }
}
