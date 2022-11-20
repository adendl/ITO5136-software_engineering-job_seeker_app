package view;

import javax.swing.*;

public interface UIView {
    /**
     * Return a component suitable for display in the main content area of the app
     * This would typically be a JPanel or similar container
     * Every view must implement this to be compatible with the navigation system
     */
    public JComponent getUIView();
}
