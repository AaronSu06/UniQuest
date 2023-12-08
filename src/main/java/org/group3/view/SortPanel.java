package org.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class SortPanel extends JPanel {
	private JPanel programOptions = new JPanel();
	private JLabel programLabel = new JLabel("Program Sorts");
//	private JRadioButton programAlphabeticalAscend = new JRadioButton("Z-A");
//	private JRadioButton programAlphabeticalDescend = new JRadioButton("A-Z");
//	private JRadioButton programGradeAscend = new JRadioButton("Low-High");
//	private JRadioButton programGradeDescend = new JRadioButton("Low-High");
	private JRadioButton[] programJRadioButtonArray = new JRadioButton[4];

	private JPanel universityOptions = new JPanel();
	private JLabel universityLabel = new JLabel("University Sorts");
//	private JRadioButton universityAlphabeticalAsecnd = new JRadioButton("Z-A");
//	private JRadioButton universityAlphabeticalDescend = new JRadioButton("A-Z");
//	private JRadioButton universityGradeAscend = new JRadioButton("Low-High");
//	private JRadioButton universityGradeDescend = new JRadioButton("Low-High");
	private JRadioButton[] universityJRadioButtonArray = new JRadioButton[4];
	private JButton confirmButton = new JButton("Confirm");
	private JButton resetButton = new JButton("Reset");

	private ButtonGroup buttonGroup = new ButtonGroup();

	public SortPanel() {
//		setLayout(new GridLayout(0,1));
		setLayout(null);
		programOptions.setLayout(new GridLayout(0,1));
//		programOptions.setLayout(null);
		programOptions.setBounds(0,0,300,168);
//		programOptions.setBounds(0, 0, 300, 168);
		programOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		programOptions.setPreferredSize(getPreferredSize());
//		programLabel.setBounds(10,0,300,50);
//		programLabel.setPreferredSize(new Dimension(300,50));
		programLabel.setBounds(0,0,300,40);
		programLabel.setHorizontalAlignment(SwingConstants.CENTER);
		programLabel.setFont(new Font("SansSerif", Font.BOLD,30));
		programOptions.add(programLabel);
		for (int i = 0; i < programJRadioButtonArray.length; i++) {
			programJRadioButtonArray[i] = new JRadioButton();
//			programJRadioButtonArray[i].setBounds(10, 40+i*29, 300, 29);
			
			programJRadioButtonArray[i].setPreferredSize(new Dimension(300,29));
			setRadioButtonText(i, 0);
			buttonGroup.add(programJRadioButtonArray[i]);
			programOptions.add(programJRadioButtonArray[i]);

		}
		add(programOptions);
		universityOptions.setLayout(new GridLayout(0,1));
//		universityOptions.setBounds(0,168,300,168);
//		universityOptions.setLayout(null);
		universityOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		universityOptions.setBounds(0,168,300,168);
//		universityLabel.setBounds(10,0,300,50);
//		universityLabel.setPreferredSize(new Dimension(300,50));
		universityLabel.setBounds(0,0,300,40);
		universityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		universityLabel.setFont(new Font("SansSerif", Font.BOLD,30));
		universityOptions.add(universityLabel);
		for (int i = 0; i < universityJRadioButtonArray.length; i++) {
			universityJRadioButtonArray[i] = new JRadioButton();
//			universityJRadioButtonArray[i].setBounds(10, 40+i*29, 300, 29);
			universityJRadioButtonArray[i].setPreferredSize(new Dimension(300,29));
			setRadioButtonText(i, 1);
			universityOptions.add(universityJRadioButtonArray[i]);

		}
		
		add(universityOptions);
		confirmButton.setBounds(0,336,300,50);
		add(confirmButton);
		resetButton.setBounds(0,386,300,50);
		add(resetButton);
	}
	

	public JPanel getProgramOptions() {
		return programOptions;
	}


	public void setProgramOptions(JPanel programOptions) {
		this.programOptions = programOptions;
	}


	public JLabel getProgramLabel() {
		return programLabel;
	}


	public void setProgramLabel(JLabel programLabel) {
		this.programLabel = programLabel;
	}


	public JRadioButton[] getProgramJRadioButtonArray() {
		return programJRadioButtonArray;
	}


	public void setProgramJRadioButtonArray(JRadioButton[] programJRadioButtonArray) {
		this.programJRadioButtonArray = programJRadioButtonArray;
	}


	public JPanel getUniversityOptions() {
		return universityOptions;
	}


	public void setUniversityOptions(JPanel universityOptions) {
		this.universityOptions = universityOptions;
	}


	public JLabel getUniversityLabel() {
		return universityLabel;
	}


	public void setUniversityLabel(JLabel universityLabel) {
		this.universityLabel = universityLabel;
	}


	public JRadioButton[] getUniversityJRadioButtonArray() {
		return universityJRadioButtonArray;
	}


	public void setUniversityJRadioButtonArray(JRadioButton[] universityJRadioButtonArray) {
		this.universityJRadioButtonArray = universityJRadioButtonArray;
	}


	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}


	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}


	public JButton getConfirmButton() {
		return confirmButton;
	}


	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}


	public JButton getResetButton() {
		return resetButton;
	}


	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}


	private void setRadioButtonText(int type, int panel) {
		if (panel == 0) {
			switch (type) {
			case 0:
				programJRadioButtonArray[type].setText("A-Z");
				break;

			case 1:
				programJRadioButtonArray[type].setText("Z-A");
				break;

			case 2:
				programJRadioButtonArray[type].setText("Grade:High to low");
				break;

			case 3:
				programJRadioButtonArray[type].setText("Grade:Low to High");
				break;
			}
		} else {
			switch (type) {
			case 0:
				universityJRadioButtonArray[type].setText("A-Z");
				break;

			case 1:
				universityJRadioButtonArray[type].setText("Z-A");
				break;

			case 2:
				universityJRadioButtonArray[type].setText("Grade:High to low");
				break;

			case 3:
				universityJRadioButtonArray[type].setText("Grade:Low to High");
				break;


			}
		}

	}

}
