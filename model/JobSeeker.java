package model;

import java.util.ArrayList;
public class JobSeeker extends User {
    private ArrayList<Integer> skillIDs;
    private int desiredSalaryMin;
    private int desiredSalaryMax;

    public JobSeeker() {
    }

    public JobSeeker(String userId) {
        this.userId = userId;
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
}


