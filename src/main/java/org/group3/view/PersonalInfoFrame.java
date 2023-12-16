package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class PersonalInfoFrame extends JFrame {

	private MenuPanel menuPanel = new MenuPanel();
	private JScrollPane courseScrollBar = new JScrollPane();
	private JScrollPane programScrollBar = new JScrollPane();
	private JPanel middlePanel = new JPanel();
	private InfoJPanel infoPanel = new InfoJPanel();
	private ProgramJPanel programPanel = new ProgramJPanel();
	private JPanel btnPanel = new JPanel();
	private JButton saveBtn = new JButton("Save");

	Color green = new Color(132, 199, 80);
	Color white = new Color(255, 255 , 255);

	public PersonalInfoFrame() {

		menuPanel.setPreferredSize(new Dimension(1280, 45));

		// btnPanel settings
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		// change the properties of the save button
		saveBtn.setFont(new Font("Sans Serif", Font.BOLD, 22));
		saveBtn.setPreferredSize(new Dimension(180, 40));
		saveBtn.setForeground(green);
		saveBtn.setBorder(new RoundedBorder(15, green));
		saveBtn.setFocusPainted(false);
		saveBtn.setOpaque(false);
		btnPanel.add(saveBtn);

		// middlePanel settings
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		middlePanel.add(courseScrollBar);
		middlePanel.add(programScrollBar);
		
		// set preferred size of the scrollBars
		courseScrollBar.setPreferredSize(new Dimension(600, 540));
		programScrollBar.setPreferredSize(new Dimension(600, 540));

		setLayout(new BorderLayout());

		// preferences for the scroll bar
		courseScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		courseScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		courseScrollBar.setViewportView(infoPanel);
		
		programScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		programScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		programScrollBar.setViewportView(programPanel);
		
		infoPanel.setBackground(white);

		// pack
		add(menuPanel, BorderLayout.PAGE_START);
		add(middlePanel, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.PAGE_END);

		// settings for the JFrame
		setTitle("Uni-Quest Ontario");
		setResizable(false);
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public InfoJPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(InfoJPanel coursePanel) {
		this.infoPanel = coursePanel;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public JScrollPane getcourseScrollBar() {
		return courseScrollBar;
	}

	public void setcourseScrollBar(JScrollPane courseScrollBar) {
		this.courseScrollBar = courseScrollBar;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public Color getGreen() {
		return green;
	}

	public void setGreen(Color green) {
		this.green = green;
	}

	public void update() {
		
		programScrollBar.setViewportView(new ProgramJPanel());
		
		repaint();
		revalidate();
	}
}
