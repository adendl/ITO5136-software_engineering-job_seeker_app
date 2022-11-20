package model;

public class JobCategory {
    private int categoryID;
    private String name;
    private String recruiterID;

    public JobCategory(){
    }

    public JobCategory(int categoryID){
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecruiterID() {
        return recruiterID;
    }

    public void setRecruiterID(String recruiterID) {
        this.recruiterID = recruiterID;
    }
}
