package model;

public class Skill {
    private String description;
    private int jobseekerID;
    private int skillID;

    public Skill(){
    }

    public Skill(int skillID){
        this.skillID = skillID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getJobseekerID() {
        return jobseekerID;
    }

    public void setJobseekerID(int jobseekerID) {
        this.jobseekerID = jobseekerID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }
}
