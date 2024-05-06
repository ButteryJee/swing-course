/*
 * Learning more about swing through a course.
 * I'm also using gradle for this project.
 */
package com.jee;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame("Hello World");
                frame.setSize(600, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
