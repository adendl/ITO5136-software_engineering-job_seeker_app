package model;

import java.util.ArrayList;
public class JobSeeker extends User{
    private ArrayList<Integer> skillIDs;
    private int desiredSalaryMin;
    private int desiredSalaryMax;
    private int resumeID;

    public JobSeeker (){
    }

    public JobSeeker(int jobSeekerID){
        this.userID = jobSeekerID;
    }

    public ArrayList<Integer> getSkillIDs() {
        return skillIDs;
    }

    public void setSkillIDs(ArrayList<Integer> skillIDs) {
        this.skillIDs = skillIDs;
    }

    public int getDesiredSalaryMin() {
        return desiredSalaryMin;
    }

    public void setDesiredSalaryMin(int desiredSalaryMin) {
        this.desiredSalaryMin = desiredSalaryMin;
    }

    public int getDesiredSalaryMax() {
        return desiredSalaryMax;
    }

    public void setDesiredSalaryMax(int desiredSalaryMax) {
        this.desiredSalaryMax = desiredSalaryMax;
    }

    public int getResumeID() {
        return resumeID;
    }

    public void setResumeID(int resumeID) {
        this.resumeID = resumeID;
    }
}
