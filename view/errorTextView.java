package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class errorTextView extends JPanel {
    private JPanel errorPanel;
    private JLabel errorText;
    private JButton confirmButton;

    public errorTextView() {

    }

    public JPanel getErrorPanel() {
        return errorPanel;
    }

    public void setErrorText(JLabel errorText) {
        this.errorText = errorText;
    }

    public void addConfirmButtonListener(ActionListener confirmButtonListener) {
        confirmButton.addActionListener(confirmButtonListener);
    }
}
