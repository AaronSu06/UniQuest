package org.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
//import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.group3.controller.SurveyController;
import org.group3.model.DataModel;
import org.group3.model.LogoInput;

public class SurveyFrame extends JFrame {

	private JLabel title = new JLabel("University Programs Survey");
	private JLabel question1 = new JLabel("What courses did you take in grade 12?");
	private JLabel question2 = new JLabel("Which of the following topics interests you the most?");
	private JLabel question3 = new JLabel("What was your favourite course in highschool");
	private JLabel question4 = new JLabel("What was your total average in highschool?");
	private JLabel question5 = new JLabel("Are you looking for a program with co-op?");

	private MenuPanel menuPanel = new MenuPanel();
	public static JButton finishButton = new JButton("Finish");

	public static JCheckBox[] question1Answers = new JCheckBox[6];
	public static JCheckBox[] question2Answers = new JCheckBox[5];
	public static JCheckBox[] question3Answers = new JCheckBox[6];
	public static JCheckBox[] question4Answers = new JCheckBox[4];
	public static JCheckBox[] question5Answers = new JCheckBox[3];

	ArrayList<UniversityPanel> universityPanelArray = new ArrayList<>();

	JPanel mainPanel = new JPanel();
	public static JPanel resultsPanel = new JPanel();
	
	private JScrollPane resultsScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	public SurveyFrame() {
//		setLocationRelativeTo(null);
		menuPanel.setBounds(0, 0, 1280, 45);
		add(menuPanel);
		setup();
	}

	public JLabel getQuestion1() {
		return question1;
	}

	public void setQuestion1(JLabel question1) {
		this.question1 = question1;
	}

	public JLabel getQuestion2() {
		return question2;
	}

	public void setQuestion2(JLabel question2) {
		this.question2 = question2;
	}

	public JLabel getQuestion3() {
		return question3;
	}

	public void setQuestion3(JLabel question3) {
		this.question3 = question3;
	}

	public JLabel getQuestion4() {
		return question4;
	}

	public void setQuestion4(JLabel question4) {
		this.question4 = question4;
	}

	public JLabel getQuestion5() {
		return question5;
	}

	public void setQuestion5(JLabel question5) {
		this.question5 = question5;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public static JButton getFinishButton() {
		return finishButton;
	}

	public static void setFinishButton(JButton finishButton) {
		SurveyFrame.finishButton = finishButton;
	}

	public static JCheckBox[] getQuestion1Answers() {
		return question1Answers;
	}

	public static void setQuestion1Answers(JCheckBox[] question1Answers) {
		SurveyFrame.question1Answers = question1Answers;
	}

	public static JCheckBox[] getQuestion2Answers() {
		return question2Answers;
	}

	public static void setQuestion2Answers(JCheckBox[] question2Answers) {
		SurveyFrame.question2Answers = question2Answers;
	}

	public static JCheckBox[] getQuestion3Answers() {
		return question3Answers;
	}

	public static void setQuestion3Answers(JCheckBox[] question3Answers) {
		SurveyFrame.question3Answers = question3Answers;
	}

	public static JCheckBox[] getQuestion4Answers() {
		return question4Answers;
	}

	public static void setQuestion4Answers(JCheckBox[] question4Answers) {
		SurveyFrame.question4Answers = question4Answers;
	}

	public static JCheckBox[] getQuestion5Answers() {
		return question5Answers;
	}

	public static void setQuestion5Answers(JCheckBox[] question5Answers) {
		SurveyFrame.question5Answers = question5Answers;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JScrollPane getMainScrollPane() {
		return resultsScrollPane;
	}

	public void setMainScrollPane(JScrollPane mainScrollPane) {
		this.resultsScrollPane = mainScrollPane;
	}

	public void setup() {

		setLocationRelativeTo(null);
		menuPanel.setBounds(0, 0, 1280, 45);
		add(menuPanel);
		// setting size, title and layout
		setSize(1280, 720);
		setTitle("University Application - Survey Frame");
		setBackground(Color.white);
		setLayout(null);

		// closes the program when exit button is pressed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle();
		setMainPanel();

		setVisible(true);

	}

	public void setTitle() {

		title.setBounds(310, 90, 620, 75);
		title.setFont(new Font("Georgia", Font.PLAIN, 50));
		title.setForeground(Color.decode("#BFEE90"));

		add(title);

	}

	public void setMainPanel() {

		mainPanel.setBounds(100, 200, 1080, 425);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(null);

		finishButton.setBounds(1150, 635, 100, 40);
		finishButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		finishButton.setBackground(Color.LIGHT_GRAY);
		finishButton.setForeground(Color.decode("#070707"));
		finishButton.setBorderPainted(false);
		finishButton.setOpaque(true);

		resultsScrollPane = new JScrollPane(resultsPanel);
		resultsScrollPane.setBounds(100, 200, 1080, 425);
		resultsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(finishButton);

		setQuestions();

		add(mainPanel);

	}

	public void setQuestions() {

		question1.setBounds(75, 50, 400, 50);
		question1.setFont(new Font("Georgia", Font.PLAIN, 20));
		question1.setForeground(Color.decode("#BFEE90"));

		question2.setBounds(550, 50, 550, 50);
		question2.setFont(new Font("Georgia", Font.PLAIN, 20));
		question2.setForeground(Color.decode("#BFEE90"));

		question3.setBounds(50, 175, 500, 50);
		question3.setFont(new Font("Georgia", Font.PLAIN, 20));
		question3.setForeground(Color.decode("#BFEE90"));

		question4.setBounds(600, 175, 425, 50);
		question4.setFont(new Font("Georgia", Font.PLAIN, 20));
		question4.setForeground(Color.decode("#BFEE90"));

		question5.setBounds(350, 300, 500, 50);
		question5.setFont(new Font("Georgia", Font.PLAIN, 20));
		question5.setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question1);
		mainPanel.add(question2);
		mainPanel.add(question3);
		mainPanel.add(question4);
		mainPanel.add(question5);

		setAnswerBoxes();

	}

	public void setAnswerBoxes() {

		question1Answers[0] = new JCheckBox("Calculus and Vectors");
		question1Answers[0].setBounds(50, 90, 200, 50);
		question1Answers[0].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[0].setForeground(Color.decode("#BFEE90"));

		question1Answers[1] = new JCheckBox("Advanced Functions");
		question1Answers[1].setBounds(200, 90, 170, 50);
		question1Answers[1].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[1].setForeground(Color.decode("#BFEE90"));

		question1Answers[2] = new JCheckBox("English");
		question1Answers[2].setBounds(350, 90, 170, 50);
		question1Answers[2].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[2].setForeground(Color.decode("#BFEE90"));

		question1Answers[3] = new JCheckBox("Physics");
		question1Answers[3].setBounds(50, 120, 170, 50);
		question1Answers[3].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[3].setForeground(Color.decode("#BFEE90"));

		question1Answers[4] = new JCheckBox("Biology");
		question1Answers[4].setBounds(200, 120, 170, 50);
		question1Answers[4].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[4].setForeground(Color.decode("#BFEE90"));

		question1Answers[5] = new JCheckBox("Chemistry");
		question1Answers[5].setBounds(350, 120, 170, 50);
		question1Answers[5].setFont(new Font("Georgia", Font.PLAIN, 13));
		question1Answers[5].setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question1Answers[0]);
		mainPanel.add(question1Answers[1]);
		mainPanel.add(question1Answers[2]);
		mainPanel.add(question1Answers[3]);
		mainPanel.add(question1Answers[4]);
		mainPanel.add(question1Answers[5]);

		question2Answers[0] = new JCheckBox("Science");
		question2Answers[0].setBounds(575, 90, 200, 50);
		question2Answers[0].setFont(new Font("Georgia", Font.PLAIN, 13));
		question2Answers[0].setForeground(Color.decode("#BFEE90"));

		question2Answers[1] = new JCheckBox("Business");
		question2Answers[1].setBounds(725, 90, 170, 50);
		question2Answers[1].setFont(new Font("Georgia", Font.PLAIN, 13));
		question2Answers[1].setForeground(Color.decode("#BFEE90"));

		question2Answers[2] = new JCheckBox("Social Sciences");
		question2Answers[2].setBounds(875, 90, 170, 50);
		question2Answers[2].setFont(new Font("Georgia", Font.PLAIN, 13));
		question2Answers[2].setForeground(Color.decode("#BFEE90"));

		question2Answers[3] = new JCheckBox("Law");
		question2Answers[3].setBounds(675, 120, 170, 50);
		question2Answers[3].setFont(new Font("Georgia", Font.PLAIN, 13));
		question2Answers[3].setForeground(Color.decode("#BFEE90"));

		question2Answers[4] = new JCheckBox("Engineering");
		question2Answers[4].setBounds(800, 120, 170, 50);
		question2Answers[4].setFont(new Font("Georgia", Font.PLAIN, 13));
		question2Answers[4].setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question2Answers[0]);
		mainPanel.add(question2Answers[1]);
		mainPanel.add(question2Answers[2]);
		mainPanel.add(question2Answers[3]);
		mainPanel.add(question2Answers[4]);

		question3Answers[0] = new JCheckBox("Calculus and Vectors");
		question3Answers[0].setBounds(50, 215, 200, 50);
		question3Answers[0].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[0].setForeground(Color.decode("#BFEE90"));

		question3Answers[1] = new JCheckBox("Advanced Functions");
		question3Answers[1].setBounds(200, 215, 170, 50);
		question3Answers[1].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[1].setForeground(Color.decode("#BFEE90"));

		question3Answers[2] = new JCheckBox("English");
		question3Answers[2].setBounds(350, 215, 170, 50);
		question3Answers[2].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[2].setForeground(Color.decode("#BFEE90"));

		question3Answers[3] = new JCheckBox("Physics");
		question3Answers[3].setBounds(50, 245, 170, 50);
		question3Answers[3].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[3].setForeground(Color.decode("#BFEE90"));

		question3Answers[4] = new JCheckBox("Biology");
		question3Answers[4].setBounds(200, 245, 170, 50);
		question3Answers[4].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[4].setForeground(Color.decode("#BFEE90"));

		question3Answers[5] = new JCheckBox("Chemistry");
		question3Answers[5].setBounds(350, 245, 170, 50);
		question3Answers[5].setFont(new Font("Georgia", Font.PLAIN, 13));
		question3Answers[5].setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question3Answers[0]);
		mainPanel.add(question3Answers[1]);
		mainPanel.add(question3Answers[2]);
		mainPanel.add(question3Answers[3]);
		mainPanel.add(question3Answers[4]);
		mainPanel.add(question3Answers[5]);

		question4Answers[0] = new JCheckBox("60%-70%");
		question4Answers[0].setBounds(675, 215, 200, 50);
		question4Answers[0].setFont(new Font("Georgia", Font.PLAIN, 13));
		question4Answers[0].setForeground(Color.decode("#BFEE90"));

		question4Answers[1] = new JCheckBox("70%-80%");
		question4Answers[1].setBounds(800, 215, 170, 50);
		question4Answers[1].setFont(new Font("Georgia", Font.PLAIN, 13));
		question4Answers[1].setForeground(Color.decode("#BFEE90"));

		question4Answers[2] = new JCheckBox("80%-90%");
		question4Answers[2].setBounds(675, 245, 170, 50);
		question4Answers[2].setFont(new Font("Georgia", Font.PLAIN, 13));
		question4Answers[2].setForeground(Color.decode("#BFEE90"));

		question4Answers[3] = new JCheckBox("90%-100%");
		question4Answers[3].setBounds(800, 245, 170, 50);
		question4Answers[3].setFont(new Font("Georgia", Font.PLAIN, 13));
		question4Answers[3].setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question4Answers[0]);
		mainPanel.add(question4Answers[1]);
		mainPanel.add(question4Answers[2]);
		mainPanel.add(question4Answers[3]);

		question5Answers[0] = new JCheckBox("Yes");
		question5Answers[0].setBounds(340, 340, 200, 50);
		question5Answers[0].setFont(new Font("Georgia", Font.PLAIN, 13));
		question5Answers[0].setForeground(Color.decode("#BFEE90"));

		question5Answers[1] = new JCheckBox("No");
		question5Answers[1].setBounds(500, 340, 170, 50);
		question5Answers[1].setFont(new Font("Georgia", Font.PLAIN, 13));
		question5Answers[1].setForeground(Color.decode("#BFEE90"));

		question5Answers[2] = new JCheckBox("Doesn't matter");
		question5Answers[2].setBounds(660, 340, 170, 50);
		question5Answers[2].setFont(new Font("Georgia", Font.PLAIN, 13));
		question5Answers[2].setForeground(Color.decode("#BFEE90"));

		mainPanel.add(question5Answers[0]);
		mainPanel.add(question5Answers[1]);
		mainPanel.add(question5Answers[2]);

	}

	public void addResultsPanel() {

		remove(mainPanel);

		resultsPanel.setBounds(100, 200, 964, 425);
		resultsPanel.setBackground(Color.LIGHT_GRAY);
		resultsPanel.setLayout(new GridLayout(0,4,10,10));
		
		resultsScrollPane = new JScrollPane(resultsPanel);
		resultsScrollPane.setBounds(100, 200, 1080, 425);
		resultsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		for (int x = 0; x < SurveyController.recommendedProgramList.size(); x++) {
		universityPanelArray.add(new UniversityPanel(SurveyController.recommendedProgramList.get(x)));
	      universityPanelArray.get(x).setPreferredSize(new Dimension(220, 300));
	      
	      Image sizeToFit =
	    		 LogoInput.imageMap.get(universityPanelArray.get(x).getProgram().getUniversity()).getImage().getScaledInstance(universityPanelArray.get(x).getUniversityButton().getWidth(),universityPanelArray.get(x).getUniversityButton().getHeight(),
	    	      Image.SCALE_SMOOTH);
	    		 universityPanelArray.get(x).getUniversityButton().setIcon(new
	    	      ImageIcon(sizeToFit));
	      universityPanelArray.get(x).getUniversityButton().setContentAreaFilled(false);
	      universityPanelArray.get(x).getUniversityButton().setIcon(LogoInput.imageMap.get(universityPanelArray.get(x).getProgram().getUniversity()));
	      resultsPanel.add(universityPanelArray.get(x));
	      repaint();
	      revalidate();
	      
	      universityPanelArray.get(x).getUniversityButton().setHorizontalAlignment(SwingConstants.LEFT);
	      universityPanelArray.get(x).getUniversityButton().setVerticalAlignment(SwingConstants.TOP);
	      universityPanelArray.get(x).getUniversityButton().setHorizontalTextPosition(SwingConstants.LEFT);

	      String imagePathJpg = "assets/data/UniLogos/" +
	      getUniversityPanelArray().get(x).getProgram().getUniversity() + ".jpg";
	      String imagePathPng = "assets/data/UniLogos/" +
	    		  getUniversityPanelArray().get(x).getProgram().getUniversity() + ".png";
	      BufferedImage image = null;
	      try {
	      image = ImageIO.read(new File(imagePathJpg));
	      Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	      image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
	      image.getGraphics().drawImage(scaledImage, 0, 0, null);
	      
	      } catch (IOException e2) {
	      try {
	      image = ImageIO.read(new File(imagePathPng));
	      Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	      image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
	      image.getGraphics().drawImage(scaledImage, 0, 0, null);
	      System.out.println("SUCCESS");
	      } catch (IOException e3) {
	      e3.printStackTrace();
	      System.out.println("FAILED IMAGE");
	      }
	      }
	      ImageIcon imageIcon = new ImageIcon(image);
	      universityPanelArray.get(x).getUniversityButton().setIcon(imageIcon);
	      
	     resultsPanel.add(universityPanelArray.get(x));
	     System.out.println("ADDED");
	      
		}
		
		  repaint();
		  revalidate();
		
		resultsScrollPane.setViewportView(resultsPanel);
		add(resultsScrollPane);


	}

	public ArrayList<UniversityPanel> getUniversityPanelArray() {
		return universityPanelArray;
	}

	public void setUniversityPanelArray(ArrayList<UniversityPanel> universityPanelArray) {
		this.universityPanelArray = universityPanelArray;
	}

	public static JPanel getResultsPanel() {
		return resultsPanel;
	}

	public static void setResultsPanel(JPanel resultsPanel) {
		SurveyFrame.resultsPanel = resultsPanel;
	}

}
