package org.group3.controller;

import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.group3.model.DataModel;
import org.group3.view.PersonalInfoFrame;

public class CourseInfoController implements ActionListener {
	private HashMap<String, String> courseInfo = new HashMap<String, String>();
	private String[] courseInfoKey = new String[6];

	// display the PersonalInfoFrame
	PersonalInfoFrame personalInfo;

	public CourseInfoController() {
		
		personalInfo = new PersonalInfoFrame();

		// add an action listener for only the saveBtn (information only saves when the
		// user clicks save)
		personalInfo.getSaveBtn().addActionListener(this);
	}

	public HashMap<String, String> getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(HashMap<String, String> courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String[] getCourseInfoKey() {
		return courseInfoKey;
	}

	public void setCourseInfoKey(String[] courseInfoKey) {
		this.courseInfoKey = courseInfoKey;
	}

	public PersonalInfoFrame getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoFrame personalInfo) {
		this.personalInfo = personalInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if the save button is pressed, save the information to the .json file
		if (e.getSource() == personalInfo.getSaveBtn()) {
			try {

				// clear the hashmap
				courseInfo.clear();

				// store the changes from the courseJPanel into an Array
				for (int i = 0; i < 6; i++) {
					courseInfo.put(
							personalInfo.getInfoPanel().getCourse()[i].getCourseCode().getSelectedItem().toString(),
							personalInfo.getInfoPanel().getCourse()[i].getCourseMark().getText());
					courseInfoKey[i] = personalInfo.getInfoPanel().getCourse()[i].getCourseCode().getSelectedItem()
							.toString();
				}

				if (isValid()) {
					// save the user information and display a message
					DataModel.generateUserInfo(LoginController.user, courseInfo, courseInfoKey);
					JOptionPane.showMessageDialog(personalInfo, "Your Current Changes Have Been Saved.");
					personalInfo.setVisible(false);
					MainController.searchFrameController.getSearchFrame().setVisible(true);
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public boolean isValid() {
		for (int i = 0; i < 6; i++) {

			for (int x = i + 1; x < 6; x++) {
				if (personalInfo.getInfoPanel().getCourse()[i].getCourseCode().getSelectedItem().toString()
						.equals(personalInfo.getInfoPanel().getCourse()[x].getCourseCode().getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(personalInfo, "You Cannot Have Multiple of the Same Course! Please Try Again.");
					return false;
				}
				
				if (Double.parseDouble(personalInfo.getInfoPanel().getCourse()[i].getCourseMark().getText()) > 100) {
					JOptionPane.showMessageDialog(personalInfo, "Invalid Course Mark! Please Try Again");
					return false;
				}
			}
		}
		
		return true;
	}
}
