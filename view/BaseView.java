package view;

import javax.swing.*;

public abstract class BaseView {
    final static int CONTENT_WIDTH = 800;
    final static int CONTENT_HEIGHT = 600;

    /**
     * Return a component suitable for display in the main content area of the app
     * This would typically be a JPanel or similar container
     * Every view must implement this to be compatible with the navigation system
     */
    public abstract JComponent getUIView();

    /**
     * Show a standalone frame for testing, with our view content inside it
     * This is a convenient helper for testing JPanel-based views by writing a main() function in their classes
     * Once the object is created and initialised, simply call showStandaloneFrame() to display it in a window
     */
    public void showStandaloneFrame() {
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.setContentPane(getUIView());
        mainWindow.setTitle(this.getClass().getCanonicalName());
        mainWindow.setSize(CONTENT_WIDTH, CONTENT_HEIGHT);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
