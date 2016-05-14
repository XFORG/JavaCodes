package net.xforg.utils;
import javax.swing.*;

/**
 * Created by Administrator on 2016/5/11.
 */
public class SwingConsole {
    public static void
    run(final JFrame f, final int width, final  int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }
}
