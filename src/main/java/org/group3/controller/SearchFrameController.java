package org.group3.controller;

//imports
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.model.UserAccount;
import org.group3.model.UserInfo;
import org.group3.view.SearchFrame;
import org.group3.view.UniversityInformationPanel;
import org.group3.view.UniversityPanel;

//class
public class SearchFrameController implements ActionListener {

//	searchFrame initialization
	private SearchFrame searchFrame = new SearchFrame();

//	constructor
	public SearchFrameController() {
//		sets the frame invisible at the start
		searchFrame.setVisible(false);

//		adds the actionlisteners to components
		addActionListeners();
	}

//	getters and setters
	public SearchFrame getSearchFrame() {
		return searchFrame;
	}

	public void setSearchFrame(SearchFrame searchFrame) {
		this.searchFrame = searchFrame;
	}

//	adds the actionlisteners to all the components, so that this class can handle all the events
	public void addActionListeners() {

		for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
			searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).addActionListener(this);
		}
		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
			searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton().addActionListener(this);
			searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton().addActionListener(this);

		}
		searchFrame.getSearchField().addActionListener(this);
		searchFrame.getSidePanel().getFilterPanel().getConfirmButton().addActionListener(this);
		searchFrame.getSidePanel().getFilterPanel().getResetButton().addActionListener(this);
		searchFrame.getSidePanel().getFilterPanel().getResetToUser().addActionListener(this);
		searchFrame.getSortMenu().getNoSort()[0].addActionListener(this);

		for (Component menu : searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
			((JMenuItem) menu).addActionListener(this);
		}

//		adds actionlisteners to universityMenu options
		for (Component menu : searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
			((JMenuItem) menu).addActionListener(this);
		}

	}

	
//	re adds the actionlisteners to removed components
//	public void reAddActionListeners() {
//		System.out.println("RE ADDING");
//		System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
//		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
//			searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton().addActionListener(this);
//			searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton().addActionListener(this);
//		}
//		for (Component menu : searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
//			((JMenuItem) menu).addActionListener(this);
//		}
//
//		for (Component menu : searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
//			((JMenuItem) menu).addActionListener(this);
//		}
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getConfirmButton()) {
			HashMap<Integer, String> selectedStrings = new HashMap<Integer, String>();
			searchFrame.getDisplayPanel().resetToOriginal();

			for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
				if (searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
					selectedStrings.put(i,
							searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
				}

			}
			if (selectedStrings.size() != 0) {
				searchFrame.getDisplayPanel().filter(selectedStrings);

			}
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length; i++) {
				if (searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected()) {
					break;
				}
			}
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel()
					.getUniversityJRadioButtonArray().length; i++) {
				if (searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].isSelected()) {
					break;
				}
			}
//			reAddActionListeners();

			searchFrame.repaint();
			searchFrame.revalidate();
		}
		if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetButton()) {
			searchFrame.getDisplayPanel().resetToOriginal();
			searchFrame.getSidePanel().getFilterPanel().reset();
			searchFrame.getSidePanel().getSortPanel().reset();
//			reAddActionListeners();
			searchFrame.repaint();
			searchFrame.revalidate();
		}

		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
			if (e.getSource() == searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton()) {
				/*
				 * 				
				 */
				JScrollPane scroll = new JScrollPane(
						new UniversityInformationPanel(
								searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram()),
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(searchFrame, scroll, "Information", 1, LogoInput.imageMap
						.get(searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity()));
				break;
			}
		}
//		if (e.getSource() == searchFrame.getSidePanel().getSortPanel().getResetButton()) {
////			System.out.println("RESETTED");
//			searchFrame.getDisplayPanel().resetToOriginal();
//			searchFrame.getSidePanel().getFilterPanel().reset();
//			searchFrame.getSidePanel().getSortPanel().reset();
////			reAddActionListeners();
//			searchFrame.repaint();
//			searchFrame.revalidate();
//
//			
//		}
		if (e.getSource() == searchFrame.getSearchField()) {
//			searchFrame.getDisplayPanel().resetToOriginal();
			searchFrame.getDisplayPanel().resetToPrevious(1);
			String text = searchFrame.getSearchField().getText();
			searchFrame.getDisplayPanel().search(text);
//			reAddActionListeners();

		}
//		for(Component menu:searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
//			if(e.getSource()==menu) {
//				
//			}
//		}
		for (int i = 0; i < searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponentCount(); i++) {
			if (e.getSource() == searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()[i]) {
				searchFrame.getDisplayPanel().sort(i, 0);
				searchFrame.getSortMenu().getSortingTypes()[0]
						.setText(searchFrame.getSortMenu().getProgramJMenuArray()[0][i].getText());
//				reAddActionListeners();

			}
//			else if(e.getSource()==searchFrame.getSortMenu().getProgramMenu()[1].getMenuComponents()[i]) {
//				searchFrame.getDisplayPanel().sort(i,1);
//				searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getProgramJMenuArray()[1][i].getText());
////				reAddActionListeners();
//
//			}
		}
//		for(int i = 0;i<searchFrame.getSortMenu().getProgramMenu()[1].getMenuComponentCount();i++) {
//			if(e.getSource()==searchFrame.getSortMenu().getProgramMenu()[1].getMenuComponents()[i]) {
//				searchFrame.getDisplayPanel().sort(i,1);
//				searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getProgramJMenuArray()[1][i].getText());
////				reAddActionListeners();
//
//			}
//		}
		for (int i = 0; i < searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponentCount(); i++) {
			if (e.getSource() == searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()[i]) {
				searchFrame.getDisplayPanel().sort(i + 4, 0);
				searchFrame.getSortMenu().getSortingTypes()[0]
						.setText(searchFrame.getSortMenu().getUniversityJMenuArray()[0][i].getText());
//				reAddActionListeners();

			}
//			else if(e.getSource()==searchFrame.getSortMenu().getUniversityMenu()[1].getMenuComponents()[i]) {
//				searchFrame.getDisplayPanel().sort(i+4,1);
//				
//				searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getUniversityJMenuArray()[1][i].getText());
////				reAddActionListeners();
//
//			}
		}
//		for(int i = 0;i<searchFrame.getSortMenu().getUniversityMenu()[1].getMenuComponentCount();i++) {
//			if(e.getSource()==searchFrame.getSortMenu().getUniversityMenu()[1].getMenuComponents()[i]) {
//				searchFrame.getDisplayPanel().sort(i+4,1);
//				
//				searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getUniversityJMenuArray()[1][i].getText());
////				reAddActionListeners();
//
//			}
//		}

		if (e.getSource() == searchFrame.getSortMenu().getNoSort()[0]) {
			searchFrame.getSortMenu().getSortingTypes()[0].setText(searchFrame.getSortMenu().getNoSort()[0].getText());
			searchFrame.getDisplayPanel().resetToPrevious(0);
//			reAddActionListeners();

		}
//		else if (e.getSource()==searchFrame.getSortMenu().getNoSort()[1]) {
//			searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getNoSort()[1].getText());
//			searchFrame.getDisplayPanel().resetToPrevious(1);
//			reAddActionListeners();
//
//
//		}
//		if(e.getSource()==searchFrame.getSortMenu().getProgramMenu()[0]) {
//			searchFrame.getSortMenu().getSortingTypes()[0].setText(searchFrame.getSortMenu().getProgramMenu()[0].getText());
//			searchFrame.getDisplayPanel().sort(0);
//
//		}else if(e.getSource()==searchFrame.getSortMenu().getProgramJMenuArray()[1]) {
//			searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getProgramMenu()[1].getText());
//			searchFrame.getDisplayPanel().sort(0);
//
//		}
//		if(e.getSource()==searchFrame.getSortMenu().getUniversityJMenuArray()[0]) {
//			searchFrame.getSortMenu().getSortingTypes()[0].setText(searchFrame.getSortMenu().getProgramMenu()[0].getText());
//			searchFrame.getDisplayPanel().sort(0);
//
//		}else if(e.getSource()==searchFrame.getSortMenu().getProgramMenu()[1]) {
//			searchFrame.getSortMenu().getSortingTypes()[1].setText(searchFrame.getSortMenu().getProgramMenu()[1].getText());
//			searchFrame.getDisplayPanel().sort(0);
//
//		}

//		FAVOURITING
		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
			if (e.getSource() == searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton()) {
//				Do something
				System.out.println(i + ": THIS IS THE ITERATION NUMBER");
//				Note: You'll probably need to pass the program in as an argument to save the stuff.
			}
		}
		if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetToUser()) {
			System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
			System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());
			searchFrame.getDisplayPanel().resetToUser();
			System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
			System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());

			for (UniversityPanel panel : searchFrame.getDisplayPanel().getUniversityArray()) {
				System.out.println(panel.getProgram());
			}
//			searchFrame.repaint();
//			searchFrame.revalidate();
		}

////      FAVOURITING
//		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
//			if (e.getSource() == searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton()) {
////              Do something
//				System.out.println(i + ": THIS IS THE ITERATION NUMBER");
////              Note: You'll probably need to pass the program in as an argument to save the stuff.
//			}
//		}

	}

	public void retrieveUserInformation(UserAccount user) throws IOException {
//		UserInfo userInfo = DataModel.getUserInformation();
		double avg = 0;
		UserInfo currentUser = null;
		for (UserInfo userInfo : DataModel.getUserInformation()) {
			if (userInfo.getUsername().equals(user.getusername())) {
				currentUser = userInfo;
			}
		}
		HashMap<Integer, String> temp = new HashMap<>();
		for (Map.Entry<String, String> entry : currentUser.getCourseInfo().entrySet()) {
			for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
				if (entry.getKey()
						.equals(searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText())) {
					temp.put(i, entry.getKey());
					avg += Double.parseDouble(entry.getValue());
				}
			}
		}
		avg /= temp.size();
		avg = Math.floor(avg);
		System.out.println(avg);

		System.out.println(searchFrame.getSidePanel().getFilterPanel().getUniversityCount());
		if (avg >= 60 && avg < 70) {
			System.out.println("1");
			temp.put(searchFrame.getSidePanel().getFilterPanel().getUniversityCount(), Double.toString(avg));
		} else if (avg >= 70 && avg < 80) {
			System.out.println("2");

			temp.put(searchFrame.getSidePanel().getFilterPanel().getUniversityCount() + 1, Double.toString(avg));

		} else if (avg >= 80 && avg < 90) {
			System.out.println("3");

			temp.put(searchFrame.getSidePanel().getFilterPanel().getUniversityCount() + 2, Double.toString(avg));

		} else if (avg >= 90) {
			System.out.println("4");

			temp.put(searchFrame.getSidePanel().getFilterPanel().getUniversityCount() + 3, Double.toString(avg));

		}
		System.out.println(temp);
		searchFrame.getDisplayPanel().filter(temp);
//		searchFrame.getDisplayPanel().setUserAccordanceArray(null);
		searchFrame.getDisplayPanel().getUserAccordanceArray()
				.addAll(searchFrame.getDisplayPanel().getUniversityArray());
		for (UniversityPanel panel : searchFrame.getDisplayPanel().getUserAccordanceArray()) {
			System.out.println(panel.getProgram());
		}
		System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());

	}

}
