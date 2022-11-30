package model;

import java.sql.ResultSet;

public class Location {
    private int locationId;
    private String state;

    private String city;


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location(int locationId, String state, String city) {
        this.locationId = locationId;
        this.state = state;
        this.city = city;
    }

    public Location() {
    }

    public static ResultSet getLocation(int locationId)
    {
        ResultSet rs = DBConnection.queryDatabase("select * from Location where locationId=" + locationId);
        return rs;
    }

    public static ResultSet getLocationByCity(String city)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Location where city='" + city + "'");
        return rs;
    }

    public static ResultSet listLocations()
    {
        ResultSet rs = DBConnection.queryDatabase("select * from Location");
        return rs;
    }

    public void deleteJob(int locationId)
    {
        DBConnection.queryDatabase("delete from Location where locationId=" + locationId);
    }


}
