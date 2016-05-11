package com.xforg.gui;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/11.
 */
public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws  Exception{
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,800);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("Hey! This is Defferent");
            }
        });
    }
}
