package org.group3.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.group3.Main;
import org.group3.model.DataModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;

public class FilterPanel extends JPanel {
	private ArrayList<JCheckBox> checkBoxArray = new ArrayList<>();
	private JLabel filterTitle = new JLabel("Filters");
	private JLabel favourited = new JLabel("Favourited Programs");
	private JLabel instituionLabel = new JLabel("Institutions");
	private JLabel gradeLabel = new JLabel("Grade Range");
	private JLabel prerequisiteCourseLabel = new JLabel("Prerequisite Courses");
	private JButton confirmButton = new JButton("Confirm");
	private JButton resetButton = new JButton("Reset to Default");
	private JButton resetToUser = new JButton("Reset by user information");
	private static int universityCount = 0;
	private static int gradeRangeCount = 0;

	public FilterPanel() {
//		setOpaque(true);
		setLayout(new GridLayout(0, 1));
		filterTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		filterTitle.setPreferredSize(new Dimension(300, 50));
		filterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		;
		filterTitle.setBackground(new Color(132, 199, 80, 100));
		filterTitle.setOpaque(true);
//		filterTitle.setForeground(new Color(132,199,80,100));
		add(filterTitle);
		favourited.setFont(new Font("SansSerif", Font.BOLD, 20));
		favourited.setPreferredSize(new Dimension(300, 50));
		favourited.setHorizontalAlignment(SwingConstants.CENTER);
		favourited.setBackground(new Color(132, 192, 106, 100));
		favourited.setOpaque(true);
//		add(favourited);
//		checkBoxArray.add(new JCheckBox("Favourited"));
//		checkBoxArray.get(0).setPreferredSize(new Dimension(300,50));
//		add(checkBoxArray.getFirst());
		instituionLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		instituionLabel.setPreferredSize(new Dimension(300, 50));
		instituionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instituionLabel.setBackground(new Color(132, 192, 106, 100));
		instituionLabel.setOpaque(true);
		add(instituionLabel);
		ArrayList<String> universities = new ArrayList<>();
		for (int i = 0; i < DataModel.universityProgramArrayList.size(); i++) {
			if (!universities.contains(DataModel.universityProgramArrayList.get(i).getUniversity())) {
				universities.add(DataModel.universityProgramArrayList.get(i).getUniversity());
				universityCount++;
			}
		}
		for (int i = 0; i < universities.size(); i++) {
			checkBoxArray.add(new JCheckBox(universities.get(i)));
//			checkBoxArray.get(i).setBounds(10,10+i*29, 300,29);
			checkBoxArray.get(i).setPreferredSize(new Dimension(300, 50));
			add(checkBoxArray.getLast());
		}

		gradeRangeCount += universityCount;
		gradeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		gradeLabel.setPreferredSize(new Dimension(300, 50));
		gradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gradeLabel.setBackground(new Color(132, 192, 106, 100));
		gradeLabel.setOpaque(true);
		add(gradeLabel);
//		for(int i = 0;i<6;i++) {
//			if(i==0) {
//				checkBoxArray.add(new JCheckBox("less than 50%"));
//				
//			}else {
//				checkBoxArray.add(new JCheckBox(Integer.toString(40+i*10)+"% to "+Integer.toString(50+i*10)+"%"));
//
//			}
//			checkBoxArray.getLast().setPreferredSize(new Dimension(300,50));
//			add(checkBoxArray.getLast());
//			gradeRangeCount++;
//		}
		for (int i = 0; i < 4; i++) {

			checkBoxArray
					.add(new JCheckBox(Integer.toString(60 + i * 10) + "% to " + Integer.toString(70 + i * 10) + "%"));

			checkBoxArray.getLast().setPreferredSize(new Dimension(300, 50));
			add(checkBoxArray.getLast());
			gradeRangeCount++;
		}
		prerequisiteCourseLabel.setPreferredSize(new Dimension(300, 50));
		prerequisiteCourseLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		prerequisiteCourseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prerequisiteCourseLabel.setBackground(new Color(132, 192, 106, 100));
		prerequisiteCourseLabel.setOpaque(true);
		add(prerequisiteCourseLabel);
		ArrayList<String> courseCodes = new ArrayList<String>();
//		System.out.println("RUNNING FILTER INITIAL");
		for (int i = 0; i < DataModel.universityProgramArrayList.size(); i++) {
//			System.out.println(i);
			for (String string : DataModel.universityProgramArrayList.get(i).getCourseCodes()) {
//				System.out.println(string+ "THIS IS STRING");

				if (!courseCodes.contains(string)) {
					courseCodes.add(string);
				}
			}
		}
//		System.out.println(courseCodes);
		for (int i = 0; i < courseCodes.size(); i++) {
			checkBoxArray.add(new JCheckBox(courseCodes.get(i)));
//			checkBoxArray.get(i).setBounds(10,10+i*29, 300,29);
			checkBoxArray.getLast().setPreferredSize(new Dimension(300, 50));
			add(checkBoxArray.getLast());
		}
//		confirmButton.setBounds(0,336,300,50);
		confirmButton.setPreferredSize(new Dimension(300, 50));
		add(confirmButton);
		resetButton.setPreferredSize(new Dimension(300, 50));
//		resetButton.setBounds(0,386,300,50);
		add(resetButton);
		resetToUser.setPreferredSize(new Dimension(300, 50));
		add(resetToUser);
	}

	public ArrayList<JCheckBox> getCheckBoxArray() {
		return checkBoxArray;
	}

	public void setCheckBoxArray(ArrayList<JCheckBox> checkBoxArray) {
		this.checkBoxArray = checkBoxArray;
	}

	public JLabel getFilterTitle() {
		return filterTitle;
	}

	public void setFilterTitle(JLabel filterTitle) {
		this.filterTitle = filterTitle;
	}

	public static int getUniversityCount() {
		return universityCount;
	}

	public static void setUniversityCount(int universityCount) {
		FilterPanel.universityCount = universityCount;
	}

	public static int getGradeRangeCount() {
		return gradeRangeCount;
	}

	public static void setGradeRangeCount(int gradeRangeCount) {
		FilterPanel.gradeRangeCount = gradeRangeCount;
	}

	public JLabel getInstituionLabel() {
		return instituionLabel;
	}

	public void setInstituionLabel(JLabel instituionLabel) {
		this.instituionLabel = instituionLabel;
	}

	public JLabel getGradeLabel() {
		return gradeLabel;
	}

	public void setGradeLabel(JLabel gradeLabel) {
		this.gradeLabel = gradeLabel;
	}

	public JLabel getPrerequisiteCourseLabel() {
		return prerequisiteCourseLabel;
	}

	public void setPrerequisiteCourseLabel(JLabel prerequisiteCourseLabel) {
		this.prerequisiteCourseLabel = prerequisiteCourseLabel;
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

	public JButton getResetToUser() {
		return resetToUser;
	}

	public void setResetToUser(JButton resetToUser) {
		this.resetToUser = resetToUser;
	}

	public void reset() {
		for (JCheckBox box : checkBoxArray) {
			box.setSelected(false);
		}
	}

}
