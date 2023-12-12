package org.group3.view;

import java.awt.Font;
import javax.swing.JTextArea;

public class ProgramInfoText extends JTextArea {
  public ProgramInfoText(String programName) {
    // Setup the search result button
    setText("• " + programName);
    setFont(new Font("Sans Serif", Font.PLAIN, 12));
    setBackground(AppColors.LIGHT_GREEN);
    setLineWrap(true);
    setWrapStyleWord(true);
    setEditable(false);
    setBounds(0, 0, 150, 10);
    GUIUtils.setFontRenderingHints(this);
  }
}
