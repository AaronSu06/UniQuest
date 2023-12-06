package org.group3.view;

import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 * This class contains special methods for the aesthetics of our App
 */
public class GUIUtils {
  /**
   * Enhances text rendering for a given {@code JComponent} by enabling text
   * antialiasing. Not required on all devices
   *
   * @param component The {@code JComponent} with text.
   */
  public static void setFontRenderingHints(JComponent component) {
    component.setOpaque(true);
    // Turn on text antialiasing
    component.putClientProperty(RenderingHints.KEY_TEXT_ANTIALIASING,
                                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
  }
}
