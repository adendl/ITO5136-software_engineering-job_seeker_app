package model;

import java.sql.ResultSet;

public class Location {
    private int locationId;
    private String state;
    private String country;


    public Location(){
    }

    public Location(int locationId){
        this.locationId = locationId;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ResultSet getJob(int locationId)
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Location where locationId=" + locationId);
        return rs;
    }

    public ResultSet listLocations()
    {
        ResultSet rs = DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Location");
        return rs;
    }

    public void deleteJob(int locationId)
    {
        DBConnection.queryDatabase(DBConnection.connectDb(), "delete from Location where locationId=" + locationId);
    }


}
