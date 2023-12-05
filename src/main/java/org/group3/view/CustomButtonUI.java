package org.group3.view;

import java.awt.Graphics;
import javax.swing.AbstractButton;
import javax.swing.plaf.basic.BasicButtonUI;

public class CustomButtonUI extends BasicButtonUI {
  @Override
  protected void paintButtonPressed(Graphics g, AbstractButton b) {
    g.setColor(AppColors.NORMAL_GREEN); // TRANSPARENT 
    g.fillRect(0, 0, b.getWidth(), b.getHeight());

    // Draw the button's text
    g.setColor(b.getForeground());
    paintText(g, b, b.getBounds(), b.getText());
  }
}
