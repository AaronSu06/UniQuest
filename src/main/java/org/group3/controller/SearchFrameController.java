/* William Qian, Aaron Su
 * 
 */

package org.group3.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.view.DisplayPanel;
import org.group3.view.SearchFrame;
import org.group3.view.UniversityInformationPanel;
import org.group3.view.UniversityPanel;

public class SearchFrameController implements ActionListener {
	private SearchFrame searchFrame = new SearchFrame();
	private ArrayList<String> programList = new ArrayList<String>();

	public SearchFrameController() {
		searchFrame.setVisible(false);
		addActionListeners();
	}

	public SearchFrame getSearchFrame() {
		return searchFrame;
	}

	public void setSearchFrame(SearchFrame searchFrame) {
		this.searchFrame = searchFrame;
	}

	public void addActionListeners() {

		for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length; i++) {
			searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].addActionListener(this);
		}
		searchFrame.getSidePanel().getSortPanel().getConfirmButton().addActionListener(this);
		searchFrame.getSidePanel().getSortPanel().getResetButton().addActionListener(this);
		for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray().length; i++) {
			searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].addActionListener(this);
		}
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
//		searchFrame.getSortMenu().getNoSort()[1].addActionListener(this);
		
//		for(JMenuItem menu:searchFrame.getSortMenu().getUniversityJMenuArray()[0]) {
//			menu.addActionListener(this);
//		}
//		for(JMenuItem menu:searchFrame.getSortMenu().getUniversityJMenuArray()[1]) {
//			menu.addActionListener(this);
//		}
		for(Component menu:searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
			((JMenuItem)menu).addActionListener(this);
		}
//		for(Component menu:searchFrame.getSortMenu().getProgramMenu()[1].getMenuComponents()) {
//			((JMenuItem)menu).addActionListener(this);
//		}
//		for(JMenuItem menu:searchFrame.getSortMenu().getProgramJMenuArray()[0]) {
//			menu.addActionListener(this);
//		}
		for(Component menu:searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
			((JMenuItem)menu).addActionListener(this);
		}
//		for(Component menu:searchFrame.getSortMenu().getUniversityMenu()[1].getMenuComponents()) {
//			((JMenuItem)menu).addActionListener(this);
//		}
//		for(JMenuItem menu:searchFrame.getSortMenu().getProgramJMenuArray()[1]) {
//			menu.addActionListener(this);
//		}
		
	}

	public void reAddActionListeners() {
		System.out.println("RE ADDING");
		System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
//			searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton().addActionListener(this);
			searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton().addActionListener(this);
			searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton().addActionListener(this);
		}
		for(Component menu:searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
			((JMenuItem)menu).addActionListener(this);
		}
//		for(Component menu:searchFrame.getSortMenu().getProgramMenu()[1].getMenuComponents()) {
//			((JMenuItem)menu).addActionListener(this);
//		}

		for(Component menu:searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
			((JMenuItem)menu).addActionListener(this);
		}
//		for(Component menu:searchFrame.getSortMenu().getUniversityMenu()[1].getMenuComponents()) {
//			((JMenuItem)menu).addActionListener(this);
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == searchFrame.getSidePanel().getSortPanel().getConfirmButton()) {
//			HashMap<Integer, String> selectedStrings = new HashMap<Integer, String>();
//			searchFrame.getDisplayPanel().resetToOriginal();
//
//			for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
//				if (searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
//					selectedStrings.put(i,
//							searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
//				}
//
//			}
//			System.out.println(selectedStrings);
//			System.out.println(searchFrame.getSidePanel().getFilterPanel().getUniversityCount());
//			System.out.println(searchFrame.getSidePanel().getFilterPanel().getGradeRangeCount());
//			if (selectedStrings.size() != 0) {
//				searchFrame.getDisplayPanel().filter(selectedStrings);
//
//			}
//			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length; i++) {
//				if (searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected()) {
////					searchFrame.getDisplayPanel().sort(i);
//					break;
//				}
//			}
//			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel()
//					.getUniversityJRadioButtonArray().length; i++) {
//				if (searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].isSelected()) {
////					searchFrame.getDisplayPanel().sort(i + 4);
//					break;
//				}
//			}
////			reAddActionListeners();
//
//			searchFrame.repaint();
//			searchFrame.revalidate();
//
//		}
		if(e.getSource()==searchFrame.getSidePanel().getFilterPanel().getConfirmButton()) {
			HashMap<Integer, String> selectedStrings = new HashMap<Integer, String>();
			searchFrame.getDisplayPanel().resetToOriginal();

			for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
				if (searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
					selectedStrings.put(i,
							searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
				}

			}
			System.out.println(selectedStrings);
			System.out.println(searchFrame.getSidePanel().getFilterPanel().getUniversityCount());
			System.out.println(searchFrame.getSidePanel().getFilterPanel().getGradeRangeCount());
			if (selectedStrings.size() != 0) {
				searchFrame.getDisplayPanel().filter(selectedStrings);

			}
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length; i++) {
				if (searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected()) {
//					searchFrame.getDisplayPanel().sort(i);
					break;
				}
			}
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel()
					.getUniversityJRadioButtonArray().length; i++) {
				if (searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].isSelected()) {
//					searchFrame.getDisplayPanel().sort(i + 4);
					break;
				}
			}
//			reAddActionListeners();

			searchFrame.repaint();
			searchFrame.revalidate();
		}
		if(e.getSource()==searchFrame.getSidePanel().getFilterPanel().getResetButton()) {
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
		for(int i = 0;i<searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponentCount();i++) {
			if(e.getSource()==searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()[i]) {
				searchFrame.getDisplayPanel().sort(i,0);
				searchFrame.getSortMenu().getSortingTypes()[0].setText(searchFrame.getSortMenu().getProgramJMenuArray()[0][i].getText());
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
		for(int i = 0;i<searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponentCount();i++) {
			if(e.getSource()==searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()[i]) {
				searchFrame.getDisplayPanel().sort(i+4,0);
				searchFrame.getSortMenu().getSortingTypes()[0].setText(searchFrame.getSortMenu().getUniversityJMenuArray()[0][i].getText());
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
		
		
		if(e.getSource()==searchFrame.getSortMenu().getNoSort()[0]) {
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
				
				if (!LoginController.user.equals(null)) {
					
						programList.add(searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityLabel().getText() + " at " + searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity());
						
						try {
							DataModel.generateUserProgram(LoginController.user, programList);
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				}
				
				System.out.println(i + ": THIS IS THE ITERATION NUMBER");
//				Note: You'll probably need to pass the program in as an argument to save the stuff.
			}
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

}
