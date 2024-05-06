package com.jee;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

    private JButton btnHello;
    private JButton btnGoodbye;
    private IStringListener textListener;

    public Toolbar() {
        btnHello = new JButton("Hello");
        btnHello.addActionListener(this);
        btnGoodbye = new JButton("Good Bye");
        btnGoodbye.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(btnHello);
        add(btnGoodbye);
    }

    public void setStringListener(IStringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JButton clicked = (JButton)evt.getSource();
        if (textListener != null) {
            if (clicked.equals(btnHello)) {
                textListener.textEmitted("Hello\n");
            }
            else if (clicked.equals(btnGoodbye)) {
                textListener.textEmitted("Good Bye\n");
            }
        }
    }

    
    
}
