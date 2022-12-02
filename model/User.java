package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class User {
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String userType;
    protected LocalDate dateCreated;
    protected String status;

    public User() {
    }

    public User(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public User(ResultSet result) throws SQLException {
        this.userId = result.getString("userId");
        this.firstName = result.getString("firstName");
        this.lastName = result.getString("lastName");
        this.userType = result.getString("userType");
        this.status = result.getString("status");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateUser(userId, "firstName", firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateUser(userId, "lastName", lastName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        updateUser(userId, "password", password);
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        updateUser(userId, "status", status);
    }



    public static ResultSet getUser(String userId) {
        ResultSet rs = DBConnection.queryDatabase("select * from User where userId='" + userId + "'");
        return rs;
    }

    public ResultSet listUsers() {
        ResultSet rs = DBConnection.queryDatabase("select * from User");
        return rs;
    }

    public void createUser() {
        String sql = "INSERT INTO User (status, dateCreated, password, lastName, firstName, userType, userId) VALUES (" +
                '"' + status + '"' + ", " +
                '"' + dateCreated + '"' + ", " +
                '"' + password + '"' + ", " +
                '"' + lastName + '"' + ", " +
                '"' + firstName + '"' + ", " +
                '"' + userType + '"' + ", " +
                '"' + userId + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }

    public void deleteUser(String userId) {
        DBConnection.queryDatabase("delete from User where userId='" + userId + "'");
    }

    public void updateUser(String userId, String fieldName, String value) {
        String sql = "update User \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere userId='" + userId + "'";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }
}







