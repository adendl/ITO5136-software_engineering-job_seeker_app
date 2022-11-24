package model;

import java.time.LocalDate;
import java.util.ArrayList;
public class JobSeeker extends User {
    private ArrayList<Integer> skillIds;
    private int desiredSalaryMin;
    private int desiredSalaryMax;

    public JobSeeker() {
    }

    public ArrayList<Integer> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(ArrayList<Integer> skillIds) {
        this.skillIds = skillIds;
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

    public JobSeeker(ArrayList<Integer> skillIds, int desiredSalaryMin, int desiredSalaryMax) {
        this.skillIds = skillIds;
        this.desiredSalaryMin = desiredSalaryMin;
        this.desiredSalaryMax = desiredSalaryMax;
    }

    public JobSeeker(String userId, String firstName, String lastName, String password, String userType, LocalDate dateCreated, String status, ArrayList<Integer> skillIds, int desiredSalaryMin, int desiredSalaryMax) {
        super(userId, firstName, lastName, password, userType, dateCreated, status);
        this.skillIds = skillIds;
        this.desiredSalaryMin = desiredSalaryMin;
        this.desiredSalaryMax = desiredSalaryMax;
    }
}


