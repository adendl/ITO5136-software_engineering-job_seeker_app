package model;

import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class JobList {
    private ArrayList<Job> jobList;
    private Vector<String> colHeader;

    public JobList(){
        jobList = new ArrayList<Job>();
        colHeader = new Vector<String>(List.of("Job Id", "Category Id", "Company", "Description", "Expiry Date", "Recruiter", "LocationId", "Max Salary", "Min Salary", "Status", "Date Created", "Job Title", "IsAdvertised", "JobObject"));
    }

    public JobList(ArrayList<Job> jobList){
        this.jobList = jobList;
    }

    public ArrayList<Job> getJobList() {
        return jobList;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    public DefaultTableModel jobListToTableModel(){
        Vector rows = new Vector();
        for(Job j : jobList){
            Vector newRow = new Vector();

            newRow.addElement(j.getJobId());
            newRow.addElement(j.getCategoryId());
            newRow.addElement(j.getCompany());
            newRow.addElement(j.getDescription());
            newRow.addElement(j.getExpiryDate());
            newRow.addElement(j.getRecruiterId());
            newRow.addElement(j.getLocationId());
            newRow.addElement(j.getSalaryMax());
            newRow.addElement(j.getSalaryMin());
            newRow.addElement(j.getStatus());
            newRow.addElement(j.getDateCreated());
            newRow.addElement(j.getTitle());
            newRow.addElement(j.isAdvertised());
            newRow.addElement(j);
            rows.addElement(newRow);
        }
        return new DefaultTableModel(rows, colHeader);
    }

    public ResultSet listJobs()
    {
        return DBConnection.queryDatabase(DBConnection.connectDb(), "select * from Job");
    }

    public void resultSetToJobList(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Job newJob = new Job(rs);
            jobList.add(newJob);
        }
    }
}

