package org.group3.controller;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.group3.view.HomeFrame;
import org.group3.view.RoundedBorder;
import org.group3.model.DataModel;
import org.group3.model.UserInfo;

public class LoginController implements ActionListener {

	HomeFrame homeFrame = new HomeFrame();

	Color green = new Color(132, 199, 80);
	Color red = new Color(222, 49, 99);
	Color gray = new Color(207, 207, 207);

	public LoginController() {
		// add the action listeners for each button
		homeFrame.getLogin().addActionListener(this);
		homeFrame.getLoginBtn().addActionListener(this);
		homeFrame.getLoginAsGuest().addActionListener(this);
		homeFrame.getSignup().addActionListener(this);
		homeFrame.getEnterBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// action commands for switching between Login and Signup Panels
		if (e.getSource() == homeFrame.getLogin()) {

			// disable and enable the corresponding GUI components to match the JButton
			// clicked
			homeFrame.getConfirmPasswordText().setVisible(false);
			homeFrame.getConfirmPassword().setVisible(false);
			homeFrame.getEnterBtn().setVisible(false);

			homeFrame.getLoginBtn().setVisible(true);
			homeFrame.getLoginAsGuest().setVisible(true);

			homeFrame.getLogin().setForeground(green);
			homeFrame.getLogin().setBorder(new RoundedBorder(15, green));
			homeFrame.getSignup().setForeground(gray);
			homeFrame.getSignup().setBorder(new RoundedBorder(15, gray));
			
			// reset color scheme
			homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
		}

		if (e.getSource() == homeFrame.getSignup()) {

			// disable and enable the corresponding GUI components to match the JButton
			// clicked
			homeFrame.getLoginAsGuest().setVisible(false);
			homeFrame.getLoginBtn().setVisible(false);

			homeFrame.getConfirmPasswordText().setVisible(true);
			homeFrame.getConfirmPassword().setVisible(true);
			homeFrame.getEnterBtn().setVisible(true);

			homeFrame.getSignup().setForeground(green);
			homeFrame.getSignup().setBorder(new RoundedBorder(15, green));
			homeFrame.getLogin().setForeground(gray);
			homeFrame.getLogin().setBorder(new RoundedBorder(15, gray));
			
			// reset color scheme
			homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
		}

		// action commands for the Signup Panel
		if (e.getSource() == homeFrame.getEnterBtn()) {
			try {
				if (validInfo() && homeFrame.getPassword().getText().equals(homeFrame.getConfirmPassword().getText())) {
					DataModel.generateUserAccount(homeFrame.getUsername().getText(), homeFrame.getPassword().getText());

					homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
					homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
					homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
					JOptionPane.showMessageDialog(homeFrame, "User has signed up");
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		// action commands for the Login Panel
		if (e.getSource() == homeFrame.getLoginBtn()) {
			List<UserInfo> userInfoList = null;

			// get the user information stored in the .json file so that we don't overwrite
			// it (if it exists)
			try {
				userInfoList = DataModel.getUserAccount();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// if not null, as in a file exists, check if the username and password used to
			// login match any of that in the file
			if (userInfoList != null) {
				for (UserInfo userInfo : userInfoList) {
					if (homeFrame.getUsername().getText().equals(userInfo.getusername())
							&& homeFrame.getPassword().getText().equals(userInfo.getPassword())) {
						homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
						homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
						JOptionPane.showMessageDialog(homeFrame, "Signed in as " + homeFrame.getUsername().getText());
						break;
					}
					
					else {
						homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
						homeFrame.getPassword().setBorder(new RoundedBorder(10, red));
						JOptionPane.showMessageDialog(homeFrame, "Incorrect Username and/or Password! Please Try Again.");
						break;
					}
				}
			}
		}

		if (e.getSource() == homeFrame.getLoginAsGuest()) {
			JOptionPane.showMessageDialog(homeFrame, "Signed In As Guest!!!!");
		}
	}

	// limitations behind the signup (such as passwords must match, no space in
	// username, etc.)
	public boolean validInfo() {
		for (int i = 0; i < homeFrame.getUsername().getText().length(); i++) {
			if (Character.isWhitespace(homeFrame.getUsername().getText().charAt(i))) {
				homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
				homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
				JOptionPane.showMessageDialog(homeFrame, "Username Must Not Contain Spaces! Please Try Again.");
				return false;
			}
		}

		if (!homeFrame.getConfirmPassword().getText().equals(homeFrame.getPassword().getText())) {
			homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, red));
			JOptionPane.showMessageDialog(homeFrame, "Password Does Not Match! Please Try Again.");
			return false;
		}

		else if (homeFrame.getUsername().getText().length() <= 3) {
			homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
			JOptionPane.showMessageDialog(homeFrame, "Username Must Be Greater Than 3 Characters! Please Try Again.");
			return false;
		}

		return true;
	}
}
