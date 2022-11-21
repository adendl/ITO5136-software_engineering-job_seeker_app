package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {


    public static Connection connectDb()
    {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
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


}
