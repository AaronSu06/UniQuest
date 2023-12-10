/* Aaron Su
 * 
 * sourced from: https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
 */

package org.group3.view;

import java.awt.*;
import javax.swing.border.Border;

public class RoundedBorder implements Border {
	private int radius;
    private Color color;
    
    public RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	g.setColor(color);
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
