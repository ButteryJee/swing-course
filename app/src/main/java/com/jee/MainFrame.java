package com.jee;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {

private TextPanel textPanel;
private Toolbar toolbar;

    public MainFrame() {
        super("Hello World");

        setLayout(new BorderLayout());
        textPanel = new TextPanel();
        toolbar = new Toolbar();
        toolbar.setStringListener(new IStringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });
        FormPanel formPanel = new FormPanel(); 
        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent evt) {
                String name = evt.getName();
                String occupation = evt.getOccupation();
                textPanel.appendText(name + ": " + occupation + "\n");
            }
        });
        
        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
