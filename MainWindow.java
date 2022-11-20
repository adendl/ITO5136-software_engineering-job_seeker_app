import javax.swing.*;

import controller.NavigationController;
import view.NavigationBar;

import java.awt.*;

public class MainWindow {
    JFrame mainWindow;
    JPanel mainPanel;
    JPanel navPanel;
    JPanel contentPanel;
    NavigationController navigationController;
    NavigationBar navigationBar;

    final static int CONTENT_WIDTH = 800;
    final static int CONTENT_HEIGHT = 600;
    final static int NAV_HEIGHT = 32;

    MainWindow() {
        mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainWindow.setContentPane(mainPanel);
        mainWindow.setTitle("title goes here");

        navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS));
        navPanel.setBackground(Color.CYAN);
        navPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));
        navPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));
        navPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, NAV_HEIGHT));

        contentPanel = new JPanel();
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
        mainWindow.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.run(CONTENT_WIDTH, CONTENT_HEIGHT+NAV_HEIGHT);
    }
}
