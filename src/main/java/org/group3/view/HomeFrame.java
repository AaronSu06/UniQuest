package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {

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
	private JTextField username = new JTextField("Enter Username Here");
	private JTextField password = new JTextField("Enter Password Here");
	private JTextField confirmPassword = new JTextField("Confirm Password Here");
	private JButton loginBtn = new JButton("Log In");
	private JButton loginAsGuest = new JButton("Log In As Guest");
	private JButton enterBtn = new JButton("Log In");
	
	Color green = new Color(132, 199, 80);
	Color gray = new Color(207, 207, 207);
	Color white = new Color(255, 255, 255);

	public HomeFrame() {
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
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

		// change the properties of the topPanel buttons
		login.setPreferredSize(new Dimension(180, 40));
		login.setForeground(green);
		login.setBorder(new RoundedBorder(15, green));
		
		signup.setPreferredSize(new Dimension(180, 40));
		signup.setForeground(gray);
		signup.setBorder(new RoundedBorder(15, gray));

		// pack the 2 buttons to the JPanel
		topPanel.add(login);
		topPanel.add(signup);

		bottomPanel.setLayout(null);

		// properties for the common GUI components
		imageLabel.setBounds(487, -50, 300, 300);
		welcomeLabel.setBounds(430, 134, 419, 74);
		usernameText.setBounds(455, 208, 172, 74);
		username.setBounds(460, 263, 364, 40);
		username.setOpaque(false);
		username.setBorder(new RoundedBorder(10, Color.GRAY));
		passwordText.setBounds(457, 309, 172, 74);
		password.setBounds(460, 364, 364, 40);
		password.setOpaque(false);
		password.setBorder(new RoundedBorder(10, Color.GRAY));

		// properties for the login panel
		loginBtn.setBounds(565, 427, 150, 40);
		loginBtn.setForeground(green);
		loginBtn.setBorder(new RoundedBorder(10, green));
		loginAsGuest.setBounds(515, 494, 250, 40);
		loginAsGuest.setForeground(green);
		loginAsGuest.setBorder(new RoundedBorder(10, green));

		// properties for the signup
		confirmPasswordText.setBounds(455, 408, 268, 74);
		confirmPassword.setBounds(460, 463, 364, 40);
		confirmPassword.setOpaque(false);
		confirmPassword.setBorder(new RoundedBorder(10, Color.GRAY));
		enterBtn.setBounds(572, 524, 150, 40);
		enterBtn.setForeground(green);
		enterBtn.setBorder(new RoundedBorder(10, green));

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

		// border layout for the JPanels... pack all to the JFrame
		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.PAGE_START);
		add(bottomPanel, BorderLayout.CENTER);

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