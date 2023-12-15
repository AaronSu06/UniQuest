package org.group3.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;



public class QuizFrame extends JFrame {

	JLabel title = new JLabel("University Programs Survey");
	JLabel question1 = new JLabel("What courses did you take in grade 12?");
	JLabel question2 = new JLabel("Which of the following topics interests you the most?");
	JLabel question3 = new JLabel("What was your favourite course in highschool");
	JLabel question4 = new JLabel("What was your total average in highschool?");
	JLabel question5 = new JLabel("Are you looking for a program with co-op?");

	public static JButton finishButton = new JButton("Finish");

	public static JCheckBox[] question1Answers = new JCheckBox[6];
	public static JCheckBox[] question2Answers = new JCheckBox[5];
	public static JCheckBox[] question3Answers = new JCheckBox[6];
	public static JCheckBox[] question4Answers = new JCheckBox[4];
	public static JCheckBox[] question5Answers = new JCheckBox[3];

	JPanel mainPanel = new JPanel();

	JScrollPane mainScrollPane = new JScrollPane();

	public QuizFrame() {

		setup();
	}

	public void setup() {

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

}
