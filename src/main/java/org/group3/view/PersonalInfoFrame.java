package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class PersonalInfoFrame extends JFrame {

	private JScrollPane scrollBar;
	private CourseJPanel coursePanel = new CourseJPanel();
	private JPanel btnPanel = new JPanel();
	private JButton saveBtn = new JButton("Save");

	Color green = new Color(132, 199, 80);

	public PersonalInfoFrame() {

		// btnPanel settings
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		// change the properties of the save button
		saveBtn.setFont(new Font("Sans Serif", Font.BOLD, 22));
		saveBtn.setPreferredSize(new Dimension(180, 40));
		saveBtn.setForeground(green);
		saveBtn.setBorder(new RoundedBorder(15, green));
		btnPanel.add(saveBtn);

		setLayout(new BorderLayout());

		add(coursePanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.PAGE_END);

//		add(programHeader);
//		add(universityHeader);

		// settings for the JFrame
		setTitle("Uni-Quest Ontario");
		setResizable(false);
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public CourseJPanel getCoursePanel() {
		return coursePanel;
	}

	public void setCoursePanel(CourseJPanel coursePanel) {
		this.coursePanel = coursePanel;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

}
