package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UIView;
import view.ViewHelper;

public class CreateMessageView implements UIView {
    private JTextField subjectTextField;
    private JTextPane invitationMessageTextPane;
    private JButton sendInvitationButton;
    private JPanel panelMain;
    private JLabel toLabel;
    private JLabel subjectLabel;
    private JTextField textField1;
    private JLabel newInvitationMessageLabel;

    public CreateMessageView() {
        sendInvitationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        CreateMessageView view = new CreateMessageView();
        ViewHelper.showStandaloneFrame(view);
    }
}
