package org.group3.view;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import org.group3.controller.LoginController;
import org.group3.view.PersonalInfoFrame;
import org.group3.model.DataModel;
import org.group3.model.UniversityProgram;
import org.group3.model.UserInfo;
import org.group3.model.UserProgram;

public class InfoJPanel extends JPanel {

	// instance variables
	List<UserInfo> userInfoList = null;
	ArrayList<String> keyArr = new ArrayList<String>();

	private JLabel courseHeader = new JLabel("Course Information");
	private JLabel[] courseNum = new JLabel[6];
	private CourseObjJPanel[] course = new CourseObjJPanel[6];

	public InfoJPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// set font and size of all components in the JFrame
		courseHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));

		// used to center within the frame
		courseHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

		// initially set the header
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(courseHeader);
		add(Box.createRigidArea(new Dimension(0, 15)));

		// add the course JLabels and course JTextFields to the JFrame
		for (int i = 0; i < 6; i++) {
			courseNum[i] = new JLabel();
			courseNum[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			courseNum[i].setFont(new Font("Sans Serif", Font.BOLD, 22));
			courseNum[i].setText("Course #" + (i + 1));
			add(courseNum[i]);

			course[i] = new CourseObjJPanel();
			course[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			int index = i;

			// ensure that the JTextField can only accept numbers (as well as backspace)
			course[i].getCourseMark().addKeyListener(new KeyAdapter() {
				@SuppressWarnings("static-access")
				public void keyPressed(KeyEvent ke) {
					if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == ke.VK_BACK_SPACE) {
						course[index].getCourseMark().setEditable(true);
					} else {
						course[index].getCourseMark().setEditable(false);
					}
				}
			});

			// remove or default to text based on when JTextField is pressed
			course[i].getCourseMark().addFocusListener(new FocusListener() {
				// When the text field is just being typed in:
				public void focusGained(FocusEvent e) {
					if (course[index].getCourseMark().getText().equals("Course Mark"))
						// Empty the filler text
						course[index].getCourseMark().setText("");
				}

				// When the text field is no longer being typed in
				public void focusLost(FocusEvent e) {
					// If the text is emtpy, reset the filler
					if (course[index].getCourseMark().getText().trim().isEmpty()) {
						course[index].getCourseMark().setText("Course Mark");
					}
				}
			});

			// add it to the JPanel
			add(course[i]);
		}

		// replace default course information with saved course information for that
		// user (if
		// possible)
		try {
			// get the saved user information
			userInfoList = DataModel.getUserInformation();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// if not null, as in a file exists
		if (userInfoList.size() > 0) {

			// loop through the saved user information list
			for (UserInfo userInfo : userInfoList) {

				// check if the username matches that of the username from the saved information
				if (LoginController.user != null && LoginController.user.equals(userInfo.getUsername())) {
					fillCourseArr(userInfo);
					changeCourseInfo(userInfo);
				}
			}
		}
	}

	// getters and setters
	public JLabel[] getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(JLabel[] courseNum) {
		this.courseNum = courseNum;
	}

	public CourseObjJPanel[] getCourse() {
		return course;
	}

	public void setCourse(CourseObjJPanel[] course) {
		this.course = course;
	}

	// fill a string array with the hashmap key values
	private void fillCourseArr(UserInfo userInfo) {
		for (Map.Entry<String, String> m : userInfo.getCourseInfo().entrySet()) {
			keyArr.add(m.getKey());
		}
	}

	// display the course information
	public void changeCourseInfo(UserInfo userInfo) {
		for (int i = 0; i < userInfo.getCourseInfo().size(); i++) {
			course[i].getCourseCode().setSelectedItem(keyArr.get(i));
			
			if (!course[i].getCourseCode().getSelectedItem().toString().equals("Nil")) {
				course[i].getCourseMark().setText(userInfo.getCourseInfo().get(keyArr.get(i)));
			}
		}
	}
}
