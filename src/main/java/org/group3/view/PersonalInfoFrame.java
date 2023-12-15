package org.group3.view;

import java.awt.*;
import javax.swing.*;

public class PersonalInfoFrame extends JFrame {

	private MenuPanel menuPanel = new MenuPanel();
	private JScrollPane scrollBar = new JScrollPane();
	private InfoJPanel infoPanel = new InfoJPanel();
	private JPanel btnPanel = new JPanel();
	private JButton saveBtn = new JButton("Save");

	Color green = new Color(132, 199, 80);

	public PersonalInfoFrame() {
		
		menuPanel.setPreferredSize(new Dimension(1280, 45));

		// btnPanel settings
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		// change the properties of the save button
		saveBtn.setFont(new Font("Sans Serif", Font.BOLD, 22));
		saveBtn.setPreferredSize(new Dimension(180, 40));
		saveBtn.setForeground(green);
		saveBtn.setBorder(new RoundedBorder(15, green));
		btnPanel.add(saveBtn);

		setLayout(new BorderLayout());
		
		// preferences for the scroll bar
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setViewportView(infoPanel);

		add(menuPanel, BorderLayout.PAGE_START);
		add(scrollBar, BorderLayout.CENTER);
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

	public JScrollPane getScrollBar() {
		return scrollBar;
	}

	public void setScrollBar(JScrollPane scrollBar) {
		this.scrollBar = scrollBar;
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
	

}
