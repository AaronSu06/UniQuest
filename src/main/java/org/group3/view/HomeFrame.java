package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {

	// 3 panels are used, 2 of which will swap with one another according to the
	// topPanel
	private JPanel topPanel = new JPanel();
	private JPanel loginPanel = new JPanel();

	// instance variables for the panels
	private JButton login = new JButton("LOG IN");
	private JButton signup = new JButton("SIGN UP");
	private JLabel imageLabel = new JLabel(new ImageIcon("images/Logo.png"));
	private JLabel welcomeLabel = new JLabel(new ImageIcon("images/Welcome.png"));
	private JLabel usernameText = new JLabel("Username");
	private JLabel passwordText = new JLabel("Password");
	private JLabel confirmPasswordText = new JLabel("Confirm Password");
	private JTextArea username = new JTextArea();
	private JTextArea password = new JTextArea();
	private JTextArea confirmPassword = new JTextArea();
	private JButton loginBtn = new JButton(new ImageIcon("images/Login.png"));
	private JButton loginAsGuest = new JButton(new ImageIcon("images/GuestLogin.png"));
	private JButton enterBtn = new JButton(new ImageIcon("images/Login.png"));

	public HomeFrame() {
		// set font and size of all components in the JFrame
		login.setFont(new Font("Sans Serif", Font.BOLD, 22));
		signup.setFont(new Font("Sans Serif", Font.BOLD, 22));
		usernameText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		passwordText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		confirmPasswordText.setFont(new Font("Sans Serif", Font.BOLD, 22));
		username.setFont(new Font("Sans Serif", Font.PLAIN, 22));

		// flow layout for the topPanel
		topPanel.setLayout(new FlowLayout());
		login.setPreferredSize(new Dimension(180, 40));
		signup.setPreferredSize(new Dimension(180, 40));

		// pack the 2 buttons to the JPanel
		topPanel.add(login);
		topPanel.add(signup);

		loginPanel.setLayout(null);

		// positions for the common GUI components
		imageLabel.setBounds(487, 5, 300, 300);
		welcomeLabel.setBounds(424, 199, 419, 74);
		usernameText.setBounds(452, 273, 172, 74);
		username.setBounds(452, 323, 354, 40);
		passwordText.setBounds(452, 374, 172, 74);
		password.setBounds(452, 424, 354, 40);

		// positions for the login panel
		loginBtn.setBounds(557, 487, 150, 40);
		loginAsGuest.setBounds(507, 554, 250, 40);

		// positions for the signup
		confirmPasswordText.setBounds(452, 473, 268, 74);
		confirmPassword.setBounds(452, 518, 364, 40);
		enterBtn.setBounds(572, 584, 150, 40);
		
		// initially disable the positions for the signup
		confirmPasswordText.setVisible(false);
		confirmPassword.setVisible(false);
		enterBtn.setVisible(false);

		// pack all the necessary GUI components to the JPanel
		loginPanel.add(imageLabel);
		loginPanel.add(welcomeLabel);
		loginPanel.add(usernameText);
		loginPanel.add(username);
		loginPanel.add(passwordText);
		loginPanel.add(password);
		loginPanel.add(loginBtn);
		loginPanel.add(loginAsGuest);
		loginPanel.add(confirmPasswordText);
		loginPanel.add(confirmPassword);
		loginPanel.add(enterBtn);

		// border layout for the JPanels... pack all to the JFrame
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.PAGE_START);
		add(loginPanel, BorderLayout.CENTER);

		// settings for the JFrame
		this.setTitle("Uni-Quest Ontario");
		this.setResizable(false);
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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

	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(JPanel loginPanel) {
		this.loginPanel = loginPanel;
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

	public JTextArea getUsername() {
		return username;
	}

	public void setUsername(JTextArea username) {
		this.username = username;
	}

	public JTextArea getPassword() {
		return password;
	}

	public void setPassword(JTextArea password) {
		this.password = password;
	}

	public JTextArea getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(JTextArea confirmPassword) {
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