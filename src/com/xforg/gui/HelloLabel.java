package com.xforg.gui;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/11.
 */
public class HelloLabel {
    public static void main(String[] args) throws  Exception{
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        label.setText("Hey! This is  Different!");
    }
}
