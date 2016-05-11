package com.xforg.gui;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/5/11.
 */
public class SubmitSwingProgram extends JFrame{
    JLabel label;
    public SubmitSwingProgram(){
        super("Hello Swing!");
        label = new JLabel("A Label");
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setVisible(true);
    }
    static SubmitSwingProgram ssp;
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp = new SubmitSwingProgram();
            }
        });
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ssp.label.setText("Hey! This is Defferent！");
            }
        });
    }

}
