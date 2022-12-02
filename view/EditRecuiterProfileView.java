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
    private JLabel phoneNumberLabel;
    private JLabel lastNameLabel;
    private JTextField phoneNumberText;
    private JLabel companyLabel;
    private JTextField companyText;
    private JButton submitButton;
    private RecruiterProfileController controller;

    public EditRecuiterProfileView(RecruiterProfileController controller){
        this.controller = controller;
        submitButton.addActionListener((e -> {
                submitUpdate();
        }));
    }

    public void submitUpdate(){
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String email = emailText.getText();
        String phone = phoneNumberText.getText();
        String company = companyText.getText();

        controller.updateProfile(firstName, lastName, email, phone, company);
    }

    public void populateForUser(Recruiter user){
        firstNameText.setText(user.getFirstName());
        lastNameText.setText(user.getLastName());
        emailText.setText("");
        phoneNumberText.setText("");
        companyText.setText(user.getCompany());
    }

    @Override
    public JComponent getUIView() {
        return panel1;
    }
}
