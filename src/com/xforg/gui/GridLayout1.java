package com.xforg.gui;//: gui/GridLayout1.java
// Demonstrates GridLayout.
import javax.swing.*;
import java.awt.*;
import static com.xforg.utils.SwingConsole.run;

public class GridLayout1 extends JFrame {
  public GridLayout1() {
    setLayout(new GridLayout(7,3));/*创建一个放置组件的表格*/
    for(int i = 0; i < 21; i++)
      add(new JButton("Button " + i));
  }
  public static void main(String[] args) {
    run(new GridLayout1(), 600, 600);
  }
}
