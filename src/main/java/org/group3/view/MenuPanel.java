package org.group3.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuPanel extends JPanel{
	private JButton quit = new JButton();
	private JButton[]frameButtons = new JButton[3];
	private JButton logOut = new JButton();
	private JButton profile = new JButton();
	public MenuPanel() {
		setLayout(null);
		Border b = BorderFactory.createLineBorder(Color.BLACK);
		quit.setBounds(7,7,30,30);
		quit.setBorder(b);
		add(quit);
		for(int i = 0;i<frameButtons.length;i++) {
			frameButtons[i]=new JButton();
			switch(i) {
			case 0:
				frameButtons[i].setText("Programs");
				break;
			case 1:
				frameButtons[i].setText("Suggestions");
				break;

			case 2:
				frameButtons[i].setText("Map");
				break;

			}
			frameButtons[i].setBackground(AppColors.NORMAL_GREEN);
			frameButtons[i].setBounds(320+i*213, 7,200,30);
			add(frameButtons[i]);
		}
		logOut.setBounds(1050,7,100,30);
		logOut.setBorder(b);
		add(logOut);
		profile.setBounds(1200,7,30,30);
		profile.setBorder(b);
		add(profile);
		
//		for(JButton button:frameButtons) {
//			button.setBounds();
//		}
	}
}
