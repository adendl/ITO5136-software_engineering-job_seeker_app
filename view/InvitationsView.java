package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.UIView;
import view.ViewHelper;

public class InvitationsView implements UIView {
    private JPanel panelMain;
    private JTable table1;
    private JButton sortByButton;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel headingText;

    public InvitationsView() {
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public void addNextButtonListener(ActionListener buttonListener) {
        nextButton.addActionListener(buttonListener);
    }
    public void addPreviousButtonListener(ActionListener buttonListener) {
        previousButton.addActionListener(buttonListener);
    }

    @Override
    public JComponent getUIView() {
        return panelMain;
    }

    public static void main(String[] args) {
        InvitationsView view = new InvitationsView();
        ViewHelper.showStandaloneFrame(view);
    }
}
