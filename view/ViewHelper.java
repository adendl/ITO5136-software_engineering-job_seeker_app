package view;

import javax.swing.*;
import view.UIView;

/**
 * Helper class for developing views
 */
public class ViewHelper {
    public final static int CONTENT_WIDTH = 1024;
    public final static int CONTENT_HEIGHT = 768;

    /**
     * Show a standalone frame for testing, with our view content inside it
     * This is a convenient helper for testing JPanel-based views by writing a main() function in their classes
     * Once the object is created and initialised, simply call showStandaloneFrame() to display it in a window
     */
    public static void showStandaloneFrame(UIView view) {
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.setContentPane(view.getUIView());
        mainWindow.setTitle(view.getClass().getCanonicalName());
        mainWindow.setSize(CONTENT_WIDTH, CONTENT_HEIGHT);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
