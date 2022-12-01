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


    public static Connection connectDb()
    {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection(CONNECTION_PATH);
            System.out.println("Connected");
            return connection;
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static ResultSet queryDatabase(Connection connection, String sql)
    {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return null;
        }
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
            e.printStackTrace();

            return null;
        }
    }


}
