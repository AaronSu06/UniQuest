package org.group3.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import org.group3.model.DataModel;
import org.group3.model.UniversityProgram;

public class CourseObjJPanel extends JPanel {

	private ArrayList<String> courseList = new ArrayList<String>();
	private JComboBox<ArrayList> courseCode;
	private JTextField courseMark = new JTextField("Course Mark");

	// Colors for the gui
	Color green = new Color(132, 199, 80);
	Color red = new Color(222, 49, 99);
	Color gray = new Color(207, 207, 207);

	public CourseObjJPanel() {
		
		// test courses
//		for (int i = 0; i < 10; i++) {
//			courseList.add("Course " + (i + 1));
//		}
		for(int i =0;i<DataModel.universityProgramArrayList.size();i++) {
//			System.out.println(i);
			for(String string: DataModel.universityProgramArrayList.get(i).getCourseCodes()) {
//				System.out.println(string+ "THIS IS STRING");
				
				if(!courseList.contains(string)) {
					courseList.add(string);
				}
			}
		}
		
		courseCode = new JComboBox(courseList.toArray());

		// flow layout for organizing horizontally
		setLayout(new FlowLayout(FlowLayout.CENTER, 13, 3));
		
		// round the JTextField
		courseMark.setBorder(new RoundedBorder(10, Color.GRAY));
		
		// set the size of the components
//		courseCode.setRenderer(new CustomComboBox());
		courseMark.setPreferredSize(new Dimension(117, 40));
		
		
		
		// add them to the JLabel
		add(courseCode);
		add(courseMark);
	}

	// getters and setters
	public JComboBox<ArrayList> getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(JComboBox<ArrayList> courseCode) {
		this.courseCode = courseCode;
	}

	public JTextField getCourseMark() {
		return courseMark;
	}

	public void setCourseMark(JTextField courseMark) {
		this.courseMark = courseMark;
	}

}
