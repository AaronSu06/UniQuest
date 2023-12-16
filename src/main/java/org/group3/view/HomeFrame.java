package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {

	// background
	private JLabel background = new JLabel(new ImageIcon("images/Background.png"));

	// 3 panels are used, 2 of which will swap with one another according to the
	// topPanel
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();

	// instance variables for the panels
	private JButton login = new JButton("LOG IN");
	private JButton signup = new JButton("SIGN UP");
	private JLabel imageLabel = new JLabel(new ImageIcon("images/Logo.png"));
	private JLabel welcomeLabel = new JLabel(new ImageIcon("images/Welcome.png"));
	private JLabel usernameText = new JLabel("Username");
	private JLabel passwordText = new JLabel("Password");
	private JLabel confirmPasswordText = new JLabel("Confirm Password");
	private JTextField username = new JTextField("Enter Username");
	private JTextField password = new JTextField("Enter Password");
	private JTextField confirmPassword = new JTextField("Re-Enter Password");
	private JButton loginBtn = new JButton("Log In");
	private JButton loginAsGuest = new JButton("Log In As Guest");
	private JButton enterBtn = new JButton("Sign Up");

	Color green = new Color(132, 199, 80);
	Color gray = new Color(207, 207, 207);
	Color white = new Color(255, 255, 255);

	public HomeFrame() {
		// settings for the JFrame
		setTitle("Uni-Quest Ontario");
		setResizable(false);
		setLayout(null);
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// add the background to the JFrame
		background.setBounds(0, 0, 1280, 720);
		add(background);
		
		// make the JPanels transparent
		topPanel.setOpaque(false);
		bottomPanel.setOpaque(false);

		// border layout for the JPanels... pack all to the background JLabel
		background.setLayout(new BorderLayout());
		background.add(topPanel, BorderLayout.PAGE_START);
		background.add(bottomPanel, BorderLayout.CENTER);

		// set font and size of all components in the JFrame
		login.setFont(new Font("Sans Serif", Font.BOLD, 22));
		signup.setFont(new Font("Sans Serif", Font.BOLD, 22));
		usernameText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		passwordText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		confirmPasswordText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		loginBtn.setFont(new Font("Sans Serif", Font.BOLD, 22));
		loginAsGuest.setFont(new Font("Sans Serif", Font.BOLD, 22));
		enterBtn.setFont(new Font("Sans Serif", Font.BOLD, 22));

		// flow layout for the topPanel
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		// change the properties of the topPanel buttons
		login.setPreferredSize(new Dimension(180, 40));
		login.setForeground(green);
		login.setBorder(new RoundedBorder(15, green));
		login.setFocusPainted(false);
		login.setOpaque(false);

		signup.setPreferredSize(new Dimension(180, 40));
		signup.setForeground(gray);
		signup.setBorder(new RoundedBorder(15, gray));
		signup.setFocusPainted(false);
		signup.setOpaque(false);

		// pack the 2 buttons to the JPanel
		topPanel.add(login);
		topPanel.add(signup);

		// -----------------------------------------------------------
		
		// null layout for the bottomPanel
		bottomPanel.setLayout(null);

		// properties for the common GUI components
		imageLabel.setBounds(487, -80, 300, 300);
		welcomeLabel.setBounds(430, 104, 419, 74);
		usernameText.setBounds(465, 158, 172, 74);
		username.setBounds(458, 213, 364, 40);
		username.setOpaque(false);
		username.setBorder(new RoundedBorder(10, Color.GRAY));
		passwordText.setBounds(465, 249, 172, 74);
		password.setBounds(458, 304, 364, 40);
		password.setOpaque(false);
		password.setBorder(new RoundedBorder(10, Color.GRAY));

		// properties for the login panel
		loginBtn.setBounds(565, 384, 150, 40);
		loginBtn.setForeground(green);
		loginBtn.setBorder(new RoundedBorder(10, green));
		loginBtn.setFocusPainted(false);
		loginBtn.setOpaque(false);
		loginAsGuest.setBounds(515, 454, 250, 40);
		loginAsGuest.setForeground(green);
		loginAsGuest.setBorder(new RoundedBorder(10, green));
		loginAsGuest.setFocusPainted(false);
		loginAsGuest.setOpaque(false);

		// properties for the signup
		confirmPasswordText.setBounds(465, 340, 289, 74);
		confirmPassword.setBounds(458, 395, 364, 40);
		confirmPassword.setOpaque(false);
		confirmPassword.setBorder(new RoundedBorder(10, Color.GRAY));
		enterBtn.setBounds(565, 465, 150, 40);
		enterBtn.setForeground(green);
		enterBtn.setBorder(new RoundedBorder(10, green));
		enterBtn.setFocusPainted(false);
		enterBtn.setOpaque(false);

		// initially disable the components for the signup
		confirmPasswordText.setVisible(false);
		confirmPassword.setVisible(false);
		enterBtn.setVisible(false);

		// pack all the necessary GUI components to the JPanel
		bottomPanel.add(imageLabel);
		bottomPanel.add(welcomeLabel);
		bottomPanel.add(usernameText);
		bottomPanel.add(username);
		bottomPanel.add(passwordText);
		bottomPanel.add(password);
		bottomPanel.add(loginBtn);
		bottomPanel.add(loginAsGuest);
		bottomPanel.add(confirmPasswordText);
		bottomPanel.add(confirmPassword);
		bottomPanel.add(enterBtn);

		setVisible(true);
	}

	public JPanel getTopPanel() {
		return topPanel;
	}

	public void setTopPanel(JPanel topPanel) {
		this.topPanel = topPanel;
	}

	public JLabel getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(JLabel usernameText) {
		this.usernameText = usernameText;
	}

	public JLabel getPasswordText() {
		return passwordText;
	}

	public void setPasswordText(JLabel passwordText) {
		this.passwordText = passwordText;
	}

	public JLabel getConfirmPasswordText() {
		return confirmPasswordText;
	}

	public void setConfirmPasswordText(JLabel confirmPasswordText) {
		this.confirmPasswordText = confirmPasswordText;
	}

	public JPanel getbottomPanel() {
		return bottomPanel;
	}

	public void setbottomPanel(JPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getSignup() {
		return signup;
	}

	public void setSignup(JButton signup) {
		this.signup = signup;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	public JTextField getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(JTextField confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getLoginAsGuest() {
		return loginAsGuest;
	}

	public void setLoginAsGuest(JButton loginAsGuest) {
		this.loginAsGuest = loginAsGuest;
	}

	public JButton getEnterBtn() {
		return enterBtn;
	}

	public void setEnterBtn(JButton enterBtn) {
		this.enterBtn = enterBtn;
	}
}
