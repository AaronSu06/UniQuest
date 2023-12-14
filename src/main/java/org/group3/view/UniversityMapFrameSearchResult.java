package org.group3.view;

import java.awt.Font;

import javax.swing.JTextArea;

public class UniversityMapFrameSearchResult extends JTextArea {
  public UniversityMapFrameSearchResult(String name) {
    // Setup the search result button
    setText("• " + name);
    setFont(new Font("Sans Serif", Font.PLAIN, 12));
    setLineWrap(true);
    setWrapStyleWord(true);
    setEditable(false);
    setBounds(0, 0, 150, 10);
    GUIUtils.setFontRenderingHints(this);
  }
}
