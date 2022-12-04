package model;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ApplicationList {
    private ArrayList<JobApplication> applicationList;
    private Vector<String> colHeader;

    public ApplicationList(){
        applicationList = new ArrayList<JobApplication>();
        colHeader = new Vector<String>(List.of("Application Id", "Job ID", "Job title", "Applicant ID", "Applicant Name", "Date Applied", "Resume ID", "Message ID", "ApplicationObject"));
    }

    public ApplicationList(ArrayList<JobApplication> applicationList){
        this.applicationList = applicationList;
    }

    public ArrayList<JobApplication> getJobList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<JobApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public DefaultTableModel applicationListToTableModel(){
        Vector rows = new Vector();
        for(JobApplication j : applicationList){
            Vector newRow = new Vector();

            newRow.addElement(j.getApplicationId());
            newRow.addElement(j.getJobId());
            newRow.addElement(j.getJobTitleFromDB());
            newRow.addElement(j.getApplicantId());
            newRow.addElement(j.getApplicantNameFromDB());
            newRow.addElement(j.getDateApplied());
            newRow.addElement(j.getResumeId());
            newRow.addElement(j.getMessageId());
            newRow.addElement(j);
            rows.addElement(newRow);
        }
        return new DefaultTableModel(rows, colHeader);
    }

    /*public DefaultTableModel applicationListDft(ArrayList<Keyword> keywords) {
        System.out.println("applicationListDFT");
        resultSetToJobList(listApplicationsKeywordFilter(keywords));
        return ApplicationListToTableModel();
    }*/

    public DefaultTableModel applicationListDft(int jobId) {
        System.out.println("applicationListDFT");
        resultSetToJobList(listApplicationsByJob(jobId));
        return applicationListToTableModel();
    }

    public ResultSet listApplications()
    {
        DBConnection db = DBConnection.get();
        System.out.print("getting applications");
        return db.executeQuery("select * from JobApplication");
    }

    public ResultSet listApplicationsByJob(int jobId){
        DBConnection db = DBConnection.get();
        System.out.print("select * from JobApplication WHERE jobId = " + + jobId );
        return db.executeQuery("select * from JobApplication WHERE jobId = "  + jobId );
    }

    //public ResultSet listApplicationsKeywordFilter(ArrayList<Keyword> keywords) { return Job.listJobsCategoriesFilter(keywords);}

    public void resultSetToJobList(ResultSet rs) {
        try{
            while (rs.next()) {
                JobApplication newApplication = new JobApplication(rs);
                applicationList.add(newApplication);
            }
        }
        catch(Exception e) {
            System.err.println("Error with JobList: " + e);
        }
    }


}
