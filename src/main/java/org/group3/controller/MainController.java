package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.group3.view.PersonalInfoFrame;

public class MainController implements ActionListener{
	public static LoginController loginController = new LoginController();
	public static MapController mapController = new MapController();
	public static SearchFrameController searchFrameController = new SearchFrameController();
	
	public MainController() {
		mapController.getMapFrame().setVisible(false);
		searchFrameController.getSearchFrame().setVisible(false);
		addActionListeners();
	}
	public void addActionListeners() {
		searchFrameController.getSearchFrame().getMenuPanel().getProfile().addActionListener(this);
		
		for(JButton button:searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}
		mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
		for(JButton button:mapController.getMapFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");
			
		}else if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[1]) {
			searchFrameController.getSearchFrame().setVisible(false);
			
		}else if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[2]) {
			searchFrameController.getSearchFrame().setVisible(false);
			mapController.getMapFrame().setVisible(true);
		}
		if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[0]) {
			mapController.getMapFrame().setVisible(false);
			searchFrameController.getSearchFrame().setVisible(true);
		}else if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[1]) {
			mapController.getMapFrame().setVisible(false);
			
		}else if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[2]) {
			
			JOptionPane.showMessageDialog(null, "You are already on this screen");

		}
		if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getProfile()) {
			new CourseInfoController();
		}
		if(e.getSource()==mapController.getMapFrame().getMenuPanel().getProfile()) {
			new CourseInfoController();

		}
		
	}
	
}
