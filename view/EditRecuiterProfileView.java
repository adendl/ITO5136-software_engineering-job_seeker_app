package view;

import controller.NavigationController;
import controller.RecruiterProfileController;
import model.Recruiter;
import model.User;

import javax.swing.*;

public class EditRecuiterProfileView implements UIView {
    private JPanel panel1;
    private JLabel editProfileLabel;
    private JLabel firstNameLabel;
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JLabel emailLabel;
    private JTextField emailText;
    private JLabel lastNameLabel;
    private JLabel companyLabel;
    private JTextField companyText;
    private JButton submitButton;
    private RecruiterProfileController controller;

    public EditRecuiterProfileView(RecruiterProfileController controller, Recruiter user){
        this.controller = controller;
        setRecruiterDetails(user);
        submitButton.addActionListener((e -> {
                submitUpdate();
        }));
    }

    public void setRecruiterDetails(Recruiter user){
        firstNameText.setText(user.getFirstName());
        lastNameText.setText(user.getLastName());
        emailText.setText(user.getUserId());
        companyText.setText(user.getCompany());
    }
    public void submitUpdate(){
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String email = emailText.getText();
        String company = companyText.getText();
        controller.updateProfile(firstName, lastName, email, company);
    }

    @Override
    public JComponent getUIView() {
        return panel1;
    }
}
