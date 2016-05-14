package com.xforg.gui;
import javax.swing.*;
import java.awt.*;

import static net.xforg.utils.SwingConsole.run;

/**
 * Created by Administrator on 2016/5/11.
 */
public class Button1 extends JFrame{
    private JButton
    b1 = new JButton("Button1"),
    b2 = new JButton("Button2");
    public Button1(){
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }
    public static void main(String[] args){
        run(new Button1(), 200, 300);
    }

}
