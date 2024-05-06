/*
 * Learning more about swing through a course.
 * I'm also using gradle for this project.
 */
package com.jee;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainFrame();
            }
        });
    }
}
