package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Recruiter extends User {

    private String userId;
    private String company;

    public Recruiter() {
    }


    public Recruiter(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status, String company, ArrayList<Integer> categoryIdList) {
        super(userId, firstName, lastName, password, userType, dateCreated, status);
        this.company = company;
    }

    public Recruiter(String userId){
        this.userId = userId;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public static Recruiter getRecruiterObjectByUserId(String userId) throws SQLException {
        ResultSet rs = DBConnection.queryDatabase("SELECT * FROM User where userId='" + userId + "'");
        Recruiter recruiter = new Recruiter();
        recruiter.setFirstName(rs.getString("firstName"));
        recruiter.setLastName(rs.getString("lastName"));
        recruiter.setUserId(rs.getString("userId"));
        System.out.println("recruiter object values: " + recruiter.getFirstName() + recruiter.getLastName() + recruiter.getCompany());
        return recruiter;
    }

    public void createRecruiter(){
        String sql = "INSERT INTO Recruiter (email, firstName, lastName, company) VALUES (" +
                '"' + this.userId + '"' + "," +
                '"' + this.firstName + '"' + "," +
                '"' + this.lastName + '"' + "," +
                '"' + this.company + '"' + ")";
        System.out.println(sql);
        DBConnection.queryDatabase(sql);
    }

    public void updateRecruiter(String userId, String fieldName, String value){
        String sql = "update Recruiter \nset " + fieldName + " = " + '"' + value + '"' + "\nwhere email='" + userId + "'";
        System.out.println(sql);
        ResultSet rs = DBConnection.queryDatabase(sql);
    }
}
