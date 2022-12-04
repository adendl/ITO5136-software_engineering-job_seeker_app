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
        colHeader = new Vector<String>(List.of("Job Id", "Job Title", "Company", "LocationId", "Location", "Description", "Salary Range", "Expiry Date", "Match Score", "Recruiter", "Status", "Date Created", "Keywords", "IsAdvertised", "JobObject"));
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
            newRow.addElement(j.getTitle());
            newRow.addElement(j.getCompany());
            newRow.addElement(j.getLocationId());
            newRow.addElement(j.getLocationFromDb());
            newRow.addElement(j.getDescription());
            newRow.addElement(j.getSalary());
            newRow.addElement(j.getExpiryDate());
            newRow.addElement(String.format("%.2f%%", j.getMatchScore() * 100));
            newRow.addElement(j.getRecruiterId());
            newRow.addElement(j.getStatus());
            newRow.addElement(j.getDateCreated());
            newRow.addElement(j.getKeyword());
            newRow.addElement(j.isAdvertised());
            newRow.addElement(j);
            rows.addElement(newRow);
        }
        return new DefaultTableModel(rows, colHeader);
    }

    public DefaultTableModel jobListDft(ArrayList<Keyword> keywords) {
        System.out.println("jobListDFT");
        resultSetToJobList(listJobsKeywordFilter(keywords), keywords);
        return jobListToTableModel();
    }

    public DefaultTableModel jobListDft(User user) {
        System.out.println("jobListDFT");
        resultSetToJobList(listJobsByRecruiter(user));
        return jobListToTableModel();
    }

    public ResultSet listJobs()
    {
        return Job.listJobs();
    }

    public ResultSet listJobsByRecruiter(User user){
        DBConnection db = DBConnection.get();
        System.out.print("select * from Job where recruiterId = " + "\"" + user.getUserId() + "\"");
        return db.executeQuery("select * from Job where recruiterId = " + "\"" + user.getUserId() + "\"");
    }

    public ResultSet listJobsKeywordFilter(ArrayList<Keyword> keywords) { return Job.listJobsCategoriesFilter(keywords);}

    public void resultSetToJobList(ResultSet rs, ArrayList<Keyword> searchKeywords) {
        try{
            while (rs.next()) {
                Job newJob = new Job(rs);
                newJob.calculateMatch(searchKeywords);
                System.out.println("job: " + newJob.getTitle() + " match score: " + newJob.getMatchScore());
                jobList.add(newJob);
            }
        }
            catch(Exception e) {
                System.err.println("Error with JobList: " + e);
            }
    }
}


