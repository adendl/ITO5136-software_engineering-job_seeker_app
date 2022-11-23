package model;

import java.util.ArrayList;

public class Recruiter extends User{
    private String company;
    private ArrayList<Integer> categoryIDList;

    public Recruiter(){
    }

    public Recruiter(String userId)
    {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Integer> getCategoryIDList() {
        return categoryIDList;
    }

    public void setCategoryIDList(ArrayList<Integer> categoryIDList) {
        this.categoryIDList = categoryIDList;
    }
}
