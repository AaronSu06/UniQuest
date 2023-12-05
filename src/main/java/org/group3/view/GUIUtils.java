package org.group3.view;

import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

public class GUIUtils {
  // I got this from chatgpt
  // Turns on font aliasing -> makes it look less ugly
  // TODO add this to a view utils class as a public and static method
  public static void setFontRenderingHints(JComponent component) {
    component.setOpaque(true);
    // Turn on text antialiasing
    component.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
                                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
  }
}
