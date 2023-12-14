package org.group3.controller;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.group3.view.PersonalInfoFrame;
import org.group3.controller.LoginController;
import org.group3.model.DataModel;

public class CourseInfoController implements ActionListener {

	private HashMap<String, String> courseInfo = new HashMap<String, String>();
	private String[] courseInfoKey = new String[6];

	// display the PersonalInfoFrame
	PersonalInfoFrame personalInfo = new PersonalInfoFrame();

	public CourseInfoController() {

		// add an action listener for only the saveBtn (information only saves when the
		// user clicks save)
		personalInfo.getSaveBtn().addActionListener(this);
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

				// save the user information and display a message
				DataModel.generateUserInfo(LoginController.user, courseInfo, courseInfoKey);
				JOptionPane.showMessageDialog(personalInfo, "Your Current Changes Have Been Saved.");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
