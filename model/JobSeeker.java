package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
public class JobSeeker extends User {
    private ArrayList<Integer> skillIds;
    private String phoneNumber;

    public JobSeeker() {
    }

    public JobSeeker(ResultSet rs) throws SQLException {
        this.userId = rs.getString("userId");
        this.phoneNumber = rs.getString("phoneNumber");
        this.locationId = rs.getInt("locationId");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        updateJobSeeker(userId, "phoneNumber", phoneNumber);

    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        updateJobSeeker(userId, "locationId", locationId);
    }
    private int locationId;



    public ArrayList<Integer> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(ArrayList<Integer> skillIds) {
        this.skillIds = skillIds;
    }


    public JobSeeker(ArrayList<Integer> skillIds) {
        this.skillIds = skillIds;
    }

    public JobSeeker(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status, ArrayList<Integer> skillIds) {
        super(userId, firstName, lastName, password, userType, dateCreated, status);
        this.skillIds = skillIds;

    }

    public static ResultSet getJobSeeker(String userId) {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from JobSeeker where userId='" + userId + "'");
        return rs;
    }

    public void createJobSeeker() {
        String sql = "INSERT INTO JobSeeker (userId, phoneNumber, locationId, skillIds) VALUES (" +
                '"' + userId + '"' + ", " +
                '"' + phoneNumber + '"' + ", " +
                locationId + ", " +
                '"' + skillIds + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }

    public void updateJobSeeker(String userId, String fieldName, String value) {
        String sql = "update JobSeeker \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere userId='" + userId + "'";
        System.out.println(sql);
        DBConnection.queryDatabase(DBConnection.connectDb(), sql);
    }
}


