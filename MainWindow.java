import javax.swing.*;
import javax.swing.border.Border;

import controller.*;
import model.User;
import view.*;

import java.awt.*;

public class MainWindow {

    JFrame mainWindow;
    JPanel mainPanel;
    JPanel navPanel;
    JPanel contentPanel;
    NavigationController navigationController;
    NavigationBar navigationBar;

    final static int NAV_HEIGHT = 32;

    MainWindow() {
        mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainWindow.setContentPane(mainPanel);
        mainWindow.setTitle("Monash Job Seeker Service");

        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS));
        navPanel.setBackground(Color.CYAN);
        navPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));
        navPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));
        navPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.BLUE);

        navigationController = new NavigationController();
        navigationController.setContentArea(contentPanel);
        navigationBar = new NavigationBar(navigationController);
        navPanel.add(navigationBar.getUIComponent());

        mainPanel.add(navPanel);
        mainPanel.add(contentPanel);
    }

    void run(int width, int height) {
        mainWindow.setSize(width, height);
        mainWindow.setLocationRelativeTo(null);

        // initialising loginController
        LoginController loginController = new LoginController(navigationController);
        loginController.showLogin();

        mainWindow.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.run(ViewHelper.CONTENT_WIDTH, ViewHelper.CONTENT_HEIGHT + NAV_HEIGHT);
    }
}
