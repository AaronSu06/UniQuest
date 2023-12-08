package org.group3.view;
import javax.swing.*;
public class SharedMenuPanel extends JPanel{
	private JButton[]frameButtonArray = new JButton[3];

	public SharedMenuPanel(JButton[] frameButtonArray) {
		for(int i = 0;i<frameButtonArray.length;i++) {
			frameButtonArray[i]=new JButton();
			switch(i) {
			case 0:
				frameButtonArray[i].setText("");
			}
		}
	
	}
	
}
