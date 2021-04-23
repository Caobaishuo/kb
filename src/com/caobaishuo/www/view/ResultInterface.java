package com.caobaishuo.www.view;

import javax.swing.*;

public class ResultInterface extends JFrame {
  public static void main(String text1) {
    JFrame jFrame = new JFrame("结果");
    jFrame.setSize(400, 400);
    jFrame.setLocationRelativeTo(null);
    JPanel panel = new JPanel();
    JTextArea jTextArea=new JTextArea(20,20);
    jTextArea.setLineWrap(true);
    jTextArea.append(text1);
    jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    panel.add(jTextArea);
    jFrame.setContentPane(panel);
    jFrame.setVisible(true);
  }

}
