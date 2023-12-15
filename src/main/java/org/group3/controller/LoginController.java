package org.group3.controller;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.group3.model.DataModel;
import org.group3.model.UserAccount;
import org.group3.view.HomeFrame;
import org.group3.view.RoundedBorder;

public class LoginController implements ActionListener, FocusListener {

	public static String user = null;
	public List<UserAccount> userAccountList;
	private boolean incorrectInfo = false;
	// call the homeFrame class to display the GUI
	HomeFrame homeFrame = new HomeFrame();

	// Colors for the gui
	Color green = new Color(132, 199, 80);
	Color red = new Color(222, 49, 99);
	Color gray = new Color(207, 207, 207);

	public LoginController() {
		// add the focus listener for the JTextField
		homeFrame.getUsername().addFocusListener(this);
		homeFrame.getPassword().addFocusListener(this);
		homeFrame.getConfirmPassword().addFocusListener(this);

		// add the action listeners for each button
		homeFrame.getLogin().addActionListener(this);
		homeFrame.getLoginBtn().addActionListener(this);
		homeFrame.getLoginAsGuest().addActionListener(this);
		homeFrame.getSignup().addActionListener(this);
		homeFrame.getEnterBtn().addActionListener(this);
		userAccountList = getUserInfo(userAccountList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// action commands for switching between Login and Signup Panels
		if (e.getSource() == homeFrame.getLogin()) {

			isLogin();
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

			// reset text
			homeFrame.getUsername().setText("Enter Username");
			homeFrame.getPassword().setText("Enter Password");
			homeFrame.getConfirmPassword().setText("Re-Enter Password");
		}

		// action commands for the Signup Panel
		if (e.getSource() == homeFrame.getEnterBtn()) {
			try {

				// check if the information provided is valid by calling the validInfo method
				if (validInfo()) {

					// if valid, write to the .json file by calling the generateUserAccount method
					// in the DataModel class
					DataModel.generateUserAccount(homeFrame.getUsername().getText(), homeFrame.getPassword().getText());

					homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
					homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
					homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
					JOptionPane.showMessageDialog(homeFrame, "User has signed up");
					userAccountList = DataModel.getUserAccounts();
					
					isLogin();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// action commands for the Login Panel
		if (e.getSource() == homeFrame.getLoginBtn()) {

			// if not null, as in a file exists, check if the username and password used to
			// login match any of that in the file

			// if not null, as in a file exists, check if the username and password used to
			// login match any of that in the file
			if (userAccountList != null && userAccountList.size() > 0) {
				for (UserAccount userAccount : userAccountList) {
					if (homeFrame.getUsername().getText().equals(userAccount.getusername())
							&& homeFrame.getPassword().getText().equals(userAccount.getPassword())) {
						homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
						homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
						JOptionPane.showMessageDialog(homeFrame, "Signed in as " + homeFrame.getUsername().getText());

						// update the String
						user = homeFrame.getUsername().getText();

						// update the flag variable
						incorrectInfo = false;

						// switch JFrames
						homeFrame.setVisible(false);

						MainController.searchFrameController.getSearchFrame().setVisible(true);

						try {
							MainController.searchFrameController.retrieveUserInformation();
							MainController.searchFrameController.getSearchFrame().getDisplayPanel().resetToOriginal();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						break;
					}
					// update the flag variable
					else {
						incorrectInfo = true;
					}
				}

				// if the information provided is not valid, display a message
				if (incorrectInfo) {
					incorrectInfo = false;
					homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
					homeFrame.getPassword().setBorder(new RoundedBorder(10, red));
					JOptionPane.showMessageDialog(homeFrame, "Incorrect Username and/or Password! Please Try Again.");
				}
			}
		}

		// signal that the user has decided to sign in as a guest
		if (e.getSource() == homeFrame.getLoginAsGuest()) {
			// reset color scheme
			homeFrame.getUsername().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getPassword().setBorder(new RoundedBorder(10, Color.GRAY));
			JOptionPane.showMessageDialog(homeFrame, "Signed In As Guest");
			homeFrame.setVisible(false);
			MainController.searchFrameController.getSearchFrame().setVisible(true);

			user = null;
		}
	}

	public void isLogin() {
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

		// reset text
		homeFrame.getUsername().setText("Enter Username");
		homeFrame.getPassword().setText("Enter Password");
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
		} else if (homeFrame.getUsername().getText().length() <= 3) {
			homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
			homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
			JOptionPane.showMessageDialog(homeFrame, "Username Must Be Greater Than 3 Characters! Please Try Again.");
			return false;
		}
		List<UserAccount> userInfoList = null;
		userInfoList = getUserInfo(userInfoList);

		// if not null, as in a file exists, check if the username and password used to
		// login match any of that in the file
		if (userInfoList != null) {
			for (UserAccount userInfo : userInfoList) {
				if (homeFrame.getUsername().getText().equals(userInfo.getusername())) {
					homeFrame.getConfirmPassword().setBorder(new RoundedBorder(10, Color.GRAY));
					homeFrame.getUsername().setBorder(new RoundedBorder(10, red));
					JOptionPane.showMessageDialog(homeFrame, "Username Is Already Taken! Please Try Again.");
					return false;
				}
			}
		}
		return true;
	}

	public List<UserAccount> getUserInfo(List<UserAccount> userInfoList) {
		// get the user information stored in the .json file so that we don't overwrite
		// it (if it exists)
		try {
			userInfoList = DataModel.getUserAccounts();
			return userInfoList;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// When the text field is just being typed in:
		if (e.getComponent() == homeFrame.getUsername()) {
			if (homeFrame.getUsername().getText().equals("Enter Username")) {
				homeFrame.getUsername().setText("");
			}
		} else if (e.getComponent() == homeFrame.getPassword()) {
			if (homeFrame.getPassword().getText().equals("Enter Password")) {
				homeFrame.getPassword().setText("");
			}
		} else if (e.getComponent() == homeFrame.getConfirmPassword()) {
			if (homeFrame.getConfirmPassword().getText().equals("Re-Enter Password")) {
				homeFrame.getConfirmPassword().setText("");
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {

		// If the text is empty, reset the filler
		if (e.getComponent() == homeFrame.getUsername()) {
			if (homeFrame.getUsername().getText().trim().isEmpty()) {
				homeFrame.getUsername().setText("Enter Username");
			}
		} else if (e.getComponent() == homeFrame.getPassword()) {
			if (homeFrame.getPassword().getText().trim().isEmpty()) {
				homeFrame.getPassword().setText("Enter Password");
			}
		} else if (e.getComponent() == homeFrame.getConfirmPassword()) {
			if (homeFrame.getConfirmPassword().getText().trim().isEmpty()) {
				homeFrame.getConfirmPassword().setText("Re-Enter Password");
			}
		}
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}
}

