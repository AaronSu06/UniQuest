package org.group3.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.group3.view.HeaderJButton;
import org.group3.view.MenuPanel;

public class MainController implements ActionListener {

	// static fields

	// calls the controllers
	public static LoginController loginController = new LoginController();
	public static MapController mapController = new MapController();
	public static SearchFrameController searchFrameController = new SearchFrameController();
	public static SurveyController surveyController = new SurveyController();
	public static CourseInfoController courseInfoController = new CourseInfoController();

	// constructor
	public MainController() {

		// sets mapframe and searchframe invisible
		mapController.getMapFrame().setVisible(false);
		searchFrameController.getSearchFrame().setVisible(false);
		surveyController.getSurveyFrame().setVisible(false);

		// adds the actionlisteners
		addActionListeners();
	}

	// adds the actionlisteners to the menuPanels of each frame
	public void addActionListeners() {

		// adds actionlisteners to searchFrame menuPanel
		searchFrameController.getSearchFrame().getMenuPanel().getProfile().addActionListener(this);
		searchFrameController.getSearchFrame().getMenuPanel().getLogOut().addActionListener(this);

		for (JButton button : searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}

		// adds actionlisteners to mapFrame menuPanel
//    mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
		mapController.getMapFrame().getMenuPanel().getLogOut().addActionListener(this);
		mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);

		for (JButton button : mapController.getMapFrame().getMenuPanel().getFrameButtons()) {
			button.addActionListener(this);
		}

		// adds actionlisteners to searchFrame menuPanel
		surveyController.getQuizFrame().getMenuPanel().getProfile().addActionListener(this);
		surveyController.getQuizFrame().getMenuPanel().getLogOut().addActionListener(this);

		for (JButton button : surveyController.getSurveyFrame().getMenuPanel().getFrameButtons()) {
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
			surveyController.getSurveyFrame().setVisible(true);

			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].setForeground(new Color(255, 255, 255));
			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].getPanel()
					.setBackground(new Color(255, 255, 255));

			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]
					.setForeground(new Color(207, 207, 207));
			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0].getPanel()
					.setBackground(new Color(132, 199, 80));

			// sets map frame visible
		} else if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[2]) {
			searchFrameController.getSearchFrame().setVisible(false);
			mapController.getMapFrame().setVisible(true);

			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].setForeground(new Color(255, 255, 255));
			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].getPanel()
					.setBackground(new Color(255, 255, 255));

			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]
					.setForeground(new Color(207, 207, 207));
			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0].getPanel()
					.setBackground(new Color(132, 199, 80));
		}

		// structure checks mapFrame menu components for switching frames
		if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[0]) {
			mapController.getMapFrame().setVisible(false);
			searchFrameController.getSearchFrame().setVisible(true);

			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]
					.setForeground(new Color(255, 255, 255));
			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0].getPanel()
					.setBackground(new Color(255, 255, 255));

			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].setForeground(new Color(207, 207, 207));
			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].getPanel()
					.setBackground(new Color(132, 199, 80));

		} else if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[1]) {
			mapController.getMapFrame().setVisible(false);
			surveyController.getSurveyFrame().setVisible(true);

			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].setForeground(new Color(255, 255, 255));
			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].getPanel()
					.setBackground(new Color(255, 255, 255));

			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].setForeground(new Color(207, 207, 207));
			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].getPanel()
					.setBackground(new Color(132, 199, 80));

		} else if (e.getSource() == mapController.getMapFrame().getMenuPanel().getFrameButtons()[2]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");

		}

		// structure checks mapFrame menu components for switching frames
		if (e.getSource() == surveyController.getSurveyFrame().getMenuPanel().getFrameButtons()[0]) {
			surveyController.getSurveyFrame().setVisible(false);
			searchFrameController.getSearchFrame().setVisible(true);

			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]
					.setForeground(new Color(255, 255, 255));
			searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0].getPanel()
					.setBackground(new Color(255, 255, 255));

			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].setForeground(new Color(207, 207, 207));
			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].getPanel()
					.setBackground(new Color(132, 199, 80));
		} else if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1]) {
			JOptionPane.showMessageDialog(null, "You are already on this screen");

		} else if (e.getSource() == surveyController.getSurveyFrame().getMenuPanel().getFrameButtons()[2]) {
			surveyController.getSurveyFrame().setVisible(false);
			mapController.getMapFrame().setVisible(true);

			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].setForeground(new Color(255, 255, 255));
			mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].getPanel()
					.setBackground(new Color(255, 255, 255));

			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].setForeground(new Color(207, 207, 207));
			surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].getPanel()
					.setBackground(new Color(132, 199, 80));
		}

		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getProfile()) {

			if (LoginController.user != null) {
				searchFrameController.getSearchFrame().setVisible(false);
				courseInfoController.getPersonalInfo().update();
				courseInfoController.getPersonalInfo().setVisible(true);
			}

			else {
				JOptionPane.showMessageDialog(null, "You Must Login To View This Page!");
			}

		}
		if (e.getSource() == mapController.getMapFrame().getMenuPanel().getProfile()) {

			if (LoginController.user != null) {
				mapController.getMapFrame().setVisible(false);
				courseInfoController.getPersonalInfo().update();
				courseInfoController.getPersonalInfo().setVisible(true);
			}

			else {
				JOptionPane.showMessageDialog(null, "You Must Login To View This Page!");
			}

		}
		if (e.getSource() == surveyController.getQuizFrame().getMenuPanel().getProfile()) {

			if (LoginController.user != null) {
				surveyController.getQuizFrame().setVisible(false);
				courseInfoController.getPersonalInfo().update();
				courseInfoController.getPersonalInfo().setVisible(true);
			}

			else {
				JOptionPane.showMessageDialog(null, "You Must Login To View This Page!");
			}
		}
		if (e.getSource() == searchFrameController.getSearchFrame().getMenuPanel().getLogOut()
				|| e.getSource() == mapController.getMapFrame().getMenuPanel().getLogOut()
				|| e.getSource() == surveyController.getQuizFrame().getMenuPanel().getLogOut()) {
			searchFrameController.getSearchFrame().setVisible(false);
			mapController.getMapFrame().setVisible(false);
			surveyController.getQuizFrame().setVisible(false);
			loginController.isLogin();
			loginController.getHomeFrame().setVisible(true);
		}
	}

	

	// method to add the MenuPanel action listeners in the CourseInfoController
	public static void enableCourseInfoController() {
		courseInfoController = new CourseInfoController();
		courseInfoController.getPersonalInfo().setVisible(false);

		for (JButton button : courseInfoController.getPersonalInfo().getMenuPanel().getFrameButtons()) {
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// structure checks personalInfoFrame menu components for switching frames
					if (e.getSource() == courseInfoController.getPersonalInfo().getMenuPanel().getFrameButtons()[0]) {
						courseInfoController.getPersonalInfo().setVisible(false);
						searchFrameController.getSearchFrame().setVisible(true);

						searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]
								.setForeground(new Color(255, 255, 255));
						searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0].getPanel()
								.setBackground(new Color(255, 255, 255));
					}

					else if (e.getSource() == courseInfoController.getPersonalInfo().getMenuPanel()
							.getFrameButtons()[1]) {
						courseInfoController.getPersonalInfo().setVisible(false);
						surveyController.getSurveyFrame().setVisible(true);

						surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1]
								.setForeground(new Color(255, 255, 255));
						surveyController.getQuizFrame().getMenuPanel().getFrameButtons()[1].getPanel()
								.setBackground(new Color(255, 255, 255));
					}

					else if (e.getSource() == courseInfoController.getPersonalInfo().getMenuPanel()
							.getFrameButtons()[2]) {
						courseInfoController.getPersonalInfo().setVisible(false);
						mapController.getMapFrame().setVisible(true);

						mapController.getMapFrame().getMenuPanel().getFrameButtons()[2]
								.setForeground(new Color(255, 255, 255));
						mapController.getMapFrame().getMenuPanel().getFrameButtons()[2].getPanel()
								.setBackground(new Color(255, 255, 255));
					}
				}

			});
		}

		// adds actionlisteners to personalInfoFrame menuPanel
		courseInfoController.getPersonalInfo().getMenuPanel().getProfile().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You are already on this screen");
			}
		});

		courseInfoController.getPersonalInfo().getMenuPanel().getLogOut().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchFrameController.getSearchFrame().setVisible(false);
				mapController.getMapFrame().setVisible(false);
				surveyController.getSurveyFrame().setVisible(false);
				courseInfoController.getPersonalInfo().setVisible(false);
				loginController.isLogin();
				loginController.getHomeFrame().setVisible(true);
			}
		});
	}
}
