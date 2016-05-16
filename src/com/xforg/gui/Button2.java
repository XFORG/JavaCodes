package com.xforg.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.xforg.utils.SwingConsole.run;

/**
 * Created by Administrator on 2016/5/11.
 */
public class Button2 extends JFrame {
    private JButton
    b1 = new JButton("Button 1"),
    b2 = new JButton("Button 2");
    private JTextField txt = new JTextField(10);
    class ButtonListener implements ActionListener{/*在点击Button以后将会发生的动作，即对点击Button事件的监听*/
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    }
    private ButtonListener bl = new ButtonListener();
    public Button2(){
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }
    public static void main(String[] args){
        run(new Button2(), 200, 500);
    }
}
