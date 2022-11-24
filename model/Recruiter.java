package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Recruiter extends User {
    private String company;
    private ArrayList<Integer> categoryIdList;

    public Recruiter() {
    }

    public Recruiter(String company, ArrayList<Integer> categoryIDList) {
        this.company = company;
        this.categoryIdList = categoryIDList;
    }

    public Recruiter(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status, String company, ArrayList<Integer> categoryIdList) {
        super(userId, firstName, lastName, password, userType, dateCreated, status);
        this.company = company;
        this.categoryIdList = categoryIdList;


    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Integer> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(ArrayList<Integer> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }
}
