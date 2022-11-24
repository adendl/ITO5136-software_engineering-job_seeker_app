package controller;

import view.CreateJobView;
import model.Job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateJobController {
    public CreateJobController(CreateJobView createJobView){
        createJobView.addCreateJobButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = createJobView.getJobDescriptionText().getText();
                String title = createJobView.getJobTitleText().getText();
                String jobType = createJobView.getJobTypeText().getText();
                String company = createJobView.getCompanyText().getText();
                String salaryRange = createJobView.getSalaryRangeText().getText();

                //need to cinstruct properly.
                Job newJob = new Job();
            }
        });
    }
}
