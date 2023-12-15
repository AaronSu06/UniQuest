package org.group3.view;

import java.awt.Font;
import javax.swing.JTextArea;

public class ProgramInfoText extends JTextArea {
  public ProgramInfoText(String programName) {
    // Setup the search result button
    setText("• " + programName);
    setFont(new Font("Sans Serif", Font.PLAIN, 10));
    setBackground(AppColors.LIGHT_GREEN);
    setLineWrap(true);
    setWrapStyleWord(true);
    setEditable(false);
    setColumns(15);
    GUIUtils.setFontRenderingHints(this);
  }
}
