/* Aaron Su
 * 
 */

package org.group3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HeaderJButton extends JButton {

	private JPanel panel = new JPanel();
	
	public HeaderJButton() {
		setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(this.getWidth(), 2));
		panel.setBackground(new Color(132, 199, 80));
		add(panel, BorderLayout.SOUTH);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
}
