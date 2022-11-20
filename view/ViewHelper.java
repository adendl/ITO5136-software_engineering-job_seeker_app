package view;

import javax.swing.*;

/**
 * Helper class for developing views
 */
public class ViewHelper {
    public final static int CONTENT_WIDTH = 800;
    public final static int CONTENT_HEIGHT = 600;

    /**
     * Show a standalone frame for testing, with our view content inside it
     * This is a convenient helper for testing JPanel-based views by writing a main() function in their classes
     * Once the object is created and initialised, simply call showStandaloneFrame() to display it in a window
     */
    public static void showStandaloneFrame(JComponent content) {
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.setContentPane(content);
        mainWindow.setTitle(content.getClass().getCanonicalName());
        mainWindow.setSize(CONTENT_WIDTH, CONTENT_HEIGHT);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
