package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
public class JobSeeker extends User{
    private String skillIds;
    private String phoneNumber;
    private int locationId;
    private String userId;

    public JobSeeker(String skillIds, String phoneNumber, int locationId, String userId) {
        this.skillIds = skillIds;
        this.phoneNumber = phoneNumber;
        this.locationId = locationId;
        this.userId = userId;
    }

    public JobSeeker(String userId) {
        this.userId = userId;
    }

    public JobSeeker() {
    }

    public JobSeeker(ResultSet rs) throws SQLException {
        this.userId = rs.getString("userId");
        this.phoneNumber = rs.getString("phoneNumber");
        this.locationId = rs.getInt("locationId");
        this.skillIds = rs.getString("skillIds");
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
        updateJobSeeker(userId, "locationId", locationId);
    }



    public String getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(String skillIds) {
        this.skillIds = skillIds;
        updateJobSeeker(userId, "skillIds", skillIds);
    }



    public static ResultSet getJobSeeker(String userId) {
        ResultSet rs = DBConnection.queryDatabase("select * from JobSeeker where userId='" + userId + "'");
        return rs;
    }

    public void createJobSeeker() {
        String sql = "INSERT INTO JobSeeker (userId, phoneNumber, locationId, skillIds) VALUES (" +
                '"' + userId + '"' + ", " +
                '"' + phoneNumber + '"' + ", " +
                locationId + ", " +
                '"' + skillIds + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }

    public void updateJobSeeker(String userId, String fieldName, String value) {
        String sql = "update JobSeeker \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere userId='" + userId + "'";
        System.out.println(sql);
        ResultSet rs = DBConnection.queryDatabase(sql);
    }
}



