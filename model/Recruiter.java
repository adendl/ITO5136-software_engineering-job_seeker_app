package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Recruiter extends User {
    private String company;

    public Recruiter() {
    }

    public Recruiter(String userId) {
        this.userId = userId;
    }

    public Recruiter(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status, String company, ArrayList<Integer> categoryIdList) {
        super(userId, firstName, lastName, password, userType, dateCreated, status);
        this.company = company;

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }



}
