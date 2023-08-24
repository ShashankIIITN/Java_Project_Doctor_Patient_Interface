package com.mycompany.oopsproject;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class RoundedLineBorder extends JPanel {

  public RoundedLineBorder() {
    super(true);

    JLabel label = new JLabel("<html>Stack<br/>Overflow</html>");
    LineBorder line = new LineBorder(Color.blue, 1, true); // color, thickness, rounded
    label.setBorder(line);
    add(label, BorderLayout.CENTER);
  }
}