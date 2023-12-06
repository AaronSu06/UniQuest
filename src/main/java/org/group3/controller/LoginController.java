package org.group3.controller;

import java.awt.event.*;
import org.group3.view.HomeFrame;
import org.group3.model.DataModel;

public class LoginController implements ActionListener {

	HomeFrame homeFrame = new HomeFrame();
	DataModel dataModel = new DataModel();

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
			
			// disable and enable the corresponding GUI components to match the JButton clicked
			System.out.println("Login clicked");
			homeFrame.getConfirmPasswordText().setVisible(false);
			homeFrame.getConfirmPassword().setVisible(false);
			homeFrame.getEnterBtn().setVisible(false);
			
			homeFrame.getLoginBtn().setVisible(true);
			homeFrame.getLoginAsGuest().setVisible(true);
		}
		
		if (e.getSource() == homeFrame.getSignup()) {
			
			// disable and enable the corresponding GUI components to match the JButton clicked
			System.out.println("Signup clicked");
			homeFrame.getLoginAsGuest().setVisible(false);
			homeFrame.getLoginBtn().setVisible(false);
			
			homeFrame.getConfirmPasswordText().setVisible(true);
			homeFrame.getConfirmPassword().setVisible(true);
			homeFrame.getEnterBtn().setVisible(true);
		}
		
		// action commands for the Signup Panel
		if (e.getSource() == homeFrame.getEnterBtn()) {
			System.out.println("Signup clicked");
			dataModel.generateUserAccount(homeFrame.getUsername().getText(), homeFrame.getPassword().getText());
		}
		
		// action commands for the Login Panel
		if (e.getSource() == homeFrame.getLoginBtn()) {
			System.out.println("Login clicked");
//			dataModel.getUserList();
		}
		
		if (e.getSource() == homeFrame.getLoginAsGuest()) {
			System.out.println("Logged in as guest");
		}
	}
}
