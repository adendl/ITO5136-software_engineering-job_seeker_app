import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompletionPage extends JFrame {
    private JButton continueButton;
    private JPanel panelMain;

    public CompletionPage() {
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void  main(String[] args)
    {
        CompletionPage c = new CompletionPage();
        c.setContentPane(c.panelMain);
        c.setSize(800, 600);
        c.setVisible(true);
    }
}
