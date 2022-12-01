package model;

import java.sql.ResultSet;
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
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    }

    public enum UserType {JOBSEEKER, RECRUITER, ADMIN}


    public static ResultSet getUser(String userId) {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from User where userId='" + userId + "'");
        return rs;
    }

    public static ResultSet listUsers() {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from User");
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
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }

    public void deleteUser(String userId) {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from User where userId='" + userId + "'");
    }

    public void updateUser(String userId, String fieldName, String value) {
        String sql = "update User \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere userId='" + userId + "'";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }
}







