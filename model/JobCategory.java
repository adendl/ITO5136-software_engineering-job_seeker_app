package model;

public class JobCategory {
    private int categoryId;
    private String name;
    private String recruiterId;

    public JobCategory() {
    }

    public JobCategory(int categoryId, String name, String recruiterId) {
        this.categoryId = categoryId;
        this.name = name;
        this.recruiterId = recruiterId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(String recruiterId) {
        this.recruiterId = recruiterId;
    }
}


