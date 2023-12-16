package org.group3.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuPanel extends JPanel {
	private JLabel brand = new JLabel("Uni-Quest");
	private HeaderJButton[] frameButtons = new HeaderJButton[3];
	private JButton logOut = new JButton("Log Out");
	
	private Image pfp = new ImageIcon("Images/Profile.png").getImage().getScaledInstance(47, 47,
	java.awt.Image.SCALE_SMOOTH);
	private JButton profile = new JButton(new ImageIcon(pfp));

	public MenuPanel() {
		setLayout(null);
		setBackground(new Color(132, 199, 80));
		brand.setBounds(30, -2, 250, 50);
		brand.setFont(new Font("Sans Serif", Font.BOLD, 26));
		brand.setForeground(new Color(255, 255, 255));
		brand.setOpaque(false);
		add(brand);
		for (int i = 0; i < frameButtons.length; i++) {
			frameButtons[i] = new HeaderJButton();
			switch (i) {
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
//			frameButtons[i].setBackground(AppColors.NORMAL_GREEN);
			frameButtons[i].setForeground(new Color(207, 207, 207));
			frameButtons[i].setFont(new Font("Sans Serif", Font.BOLD, 26));
			frameButtons[i].setBounds(320 + i * 243, -2, 200, 50);
			frameButtons[i].setBorderPainted(false);
			frameButtons[i].setFocusPainted(false);
			frameButtons[i].setOpaque(false);
			add(frameButtons[i]);
		}
		logOut.setBounds(1050, -2, 160, 50);
		logOut.setFont(new Font("Sans Serif", Font.BOLD, 26));
		logOut.setForeground(new Color(255, 255, 255));
		logOut.setBorderPainted(false);
		logOut.setFocusPainted(false);
		logOut.setOpaque(false);
		add(logOut);

		profile.setBounds(1200, -2, 47, 50);
		profile.setBorderPainted(false);
		profile.setFocusPainted(false);
		profile.setOpaque(false);
		add(profile);

	}

	public JLabel getbrand() {
		return brand;
	}

	public void setbrand(JLabel brand) {
		this.brand = brand;
	}

	public HeaderJButton[] getFrameButtons() {
		return frameButtons;
	}

	public void setFrameButtons(HeaderJButton[] frameButtons) {
		this.frameButtons = frameButtons;
	}

	public JButton getLogOut() {
		return logOut;
	}

	public void setLogOut(JButton logOut) {
		this.logOut = logOut;
	}

	public JButton getProfile() {
		return profile;
	}

	public void setProfile(JButton profile) {
		this.profile = profile;
	}
}
