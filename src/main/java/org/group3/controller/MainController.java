package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MainController implements ActionListener {

	// static fields

	// calls the controllers
	public static LoginController loginController = new LoginController();
	public static MapController mapController = new MapController();
	public static SearchFrameController searchFrameController = new SearchFrameController();
	public static SurveyController surveyController = new SurveyController();
	public static CourseInfoController courseInfoController;

	// constructor
	public MainController() {

		// sets mapframe and searchframe invisible
		mapController.getMapFrame().setVisible(false);
		searchFrameController.getSearchFrame().setVisible(false);
		surveyController.getQuizFrame().setVisible(false);
		
		// adds the actionlisteners
		addActionListeners();
	}

	// adds the actionlisteners to the menuPanels of each frame
	public void addActionListeners() {

		// adds actionlisteners to searchFrame menuPanel
		searchFrameController.getSearchFrame().getMenuPanel().getProfile().addActionListener(this);
		searchFrameController.getSearchFrame().getMenuPanel().getLogOut().addActionListener(this);
		searchFrameController.getSearchFrame().getMenuPanel().getQuit().addActionListener(this);

		for (JButton button : searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}

		// adds actionlisteners to mapFrame menuPanel
//    mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
		mapController.getMapFrame().getMenuPanel().getLogOut().addActionListener(this);
		mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
		mapController.getMapFrame().getMenuPanel().getQuit().addActionListener(this);

		for (JButton button : mapController.getMapFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}

		// adds actionlisteners to searchFrame menuPanel
		surveyController.getQuizFrame().getMenuPanel().getProfile().addActionListener(this);
		surveyController.getQuizFrame().getMenuPanel().getLogOut().addActionListener(this);
		surveyController.getQuizFrame().getMenuPanel().getQuit().addActionListener(this);

		for (JButton button : surveyController.getQuizFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}
		
		
//    loginController.getHomeFrame().getMenuPanel().getProfile().addActionListener(this);
//    loginController.getHomeFrame().getMenuPanel().getLogOut().addActionListener(this);
//    loginController.getHomeFrame().getMenuPanel().getQuit().addActionListener(this);
//
//    for (JButton button : loginController.getHomeFrame().getMenuPanel().getFrameButtons()) {
//      button.addActionListener(this);
//    }

	}
	
	// handles actions
	@Override
	public void actionPerformed(ActionEvent e) {

		// structure checks searchFrame menu components for switching frames

		// gives a message to say that the user is in the current frame
		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");

			// sets quiz frame visible
		} else if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[1]) {
			searchFrameController.getSearchFrame().setVisible(false);
			surveyController.getQuizFrame().setVisible(true);

			// sets map frame visible
		} else if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[2]) {
			searchFrameController.getSearchFrame().setVisible(false);
			mapController.getMapFrame().setVisible(true);
		}

		// structure checks mapFrame menu components for switching frames
		if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[0]) {
			mapController.getMapFrame().setVisible(false);
			searchFrameController.getSearchFrame().setVisible(true);
		} else if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[1]) {
			mapController.getMapFrame().setVisible(false);
			surveyController.getQuizFrame().setVisible(true);

		} else if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[2]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");

		}

		// structure checks mapFrame menu components for switching frames
		if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[0]) {
			surveyController.getQuizFrame().setVisible(false);
			searchFrameController.getSearchFrame().setVisible(true);
		} else if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");

		} else if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[2]) {
			surveyController.getQuizFrame().setVisible(false);
			mapController.getMapFrame().setVisible(true);

		}
		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getProfile()) {
			searchFrameController.getSearchFrame().setVisible(false);
			courseInfoController.getPersonalInfo().setVisible(true);

		}
		if (e.getSource() == mapController.getMapFrame().getMenuPanel().getProfile()) {
			mapController.getMapFrame().setVisible(false);
			courseInfoController.getPersonalInfo().setVisible(true);

		}
		if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getProfile()) {
//    	new CourseInfoController();
			surveyController.getQuizFrame().setVisible(false);
			courseInfoController.getPersonalInfo().setVisible(true);
		}
		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getLogOut()
				|| e.getSource() == mapController.getMapFrame().getMenuPanel().getLogOut()
				|| e.getSource() == surveyController.getQuizFrame().getMenuPanel().getLogOut()||e.getSource()==courseInfoController.getPersonalInfo().getMenuPanel().getLogOut()) {
			searchFrameController.getSearchFrame().setVisible(false);
			mapController.getMapFrame().setVisible(false);
			surveyController.getQuizFrame().setVisible(false);
			courseInfoController.getPersonalInfo().setVisible(false);
			loginController.getHomeFrame().setVisible(true);
		}

		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getQuit()
				|| e.getSource() == mapController.getMapFrame().getMenuPanel().getQuit()
				|| e.getSource() == surveyController.getQuizFrame().getMenuPanel().getQuit()||e.getSource()==courseInfoController.getPersonalInfo().getMenuPanel().getQuit()) {

			System.exit(0);
		}
	}

	
}
