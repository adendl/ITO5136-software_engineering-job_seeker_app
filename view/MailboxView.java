package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.MailboxController;
import model.Message;

public class MailboxView implements UIView {
    private JTable table1;
    private JPanel panelMain;
    private JComboBox sortByBox;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleLabel;
    private MailboxController controller;

    public MailboxView(MailboxController controller) {
        this.controller = controller;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public JComboBox getSortByBox() {
        return sortByBox;
    }

    public void setSortByBox(JComboBox sortByBox) {
        this.sortByBox = sortByBox;
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
        MailboxView view = new MailboxView(null);
        ViewHelper.showStandaloneFrame(view);
    }
}
