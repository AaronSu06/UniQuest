package org.group3.view;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import org.group3.model.DataModel;
import org.group3.model.UserInfo;

public class CourseJPanel extends JPanel {

	private JLabel courseHeader = new JLabel("Course Information");
	private JLabel programHeader = new JLabel("Preferred Programs");
	private JLabel universityHeader = new JLabel("Preferred Universities");
	private JLabel[] courseNum = new JLabel[6];
	private CourseObjJPanel[] course = new CourseObjJPanel[6];

	public CourseJPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set font and size of all components in the JFrame
		courseHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));
		programHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));
		universityHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));

		// used to center within the frame
		courseHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		programHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		universityHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

		// initially set the header
		add(courseHeader);
		add(Box.createRigidArea(new Dimension(0, 10)));

		// add the course JLabels and course JTextFields to the JFrame
		for (int i = 0; i < 6; i++) {
			courseNum[i] = new JLabel();
			courseNum[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			courseNum[i].setFont(new Font("Sans Serif", Font.BOLD, 22));
			courseNum[i].setText("Course #" + (i + 1));
			add(courseNum[i]);

			course[i] = new CourseObjJPanel();
			course[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			
			// replace default information with saved information for that user (if possible)
			try {
				// get the saved user information
				List<UserInfo> userInfoList = DataModel.getUserInformation();

//				// if not null, as in a file exists, add it to the user ArrayList
//				if (userInfoList != null) {
//					for (UserInfo userInfo : userInfoList) {
//						users.add(userInfo);
//					}
//				}
				
				course[i].getCourseCode().setSelectedItem(DataModel.getUserInformation());
				course[i].getCourseMark().setText(DataModel.getUserInformation().toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			add(course[i]);
		}
	}

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
}
