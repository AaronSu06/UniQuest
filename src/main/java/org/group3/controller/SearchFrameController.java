package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.group3.view.SearchFrame;

public class SearchFrameController implements ActionListener{
	private SearchFrame searchFrame = new SearchFrame();
	public SearchFrameController() {
		addActionListeners();
	}
	public void addActionListeners() {
//		for(int i = 0;i<searchFrame.getSortPanel().getProgramJRadioButtonArray().length;i++) {
//			searchFrame.getSortPanel().getProgramJRadioButtonArray()[i].addActionListener(this);
//		}
		for(int i = 0;i<searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length;i++) {
			searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].addActionListener(this);
		}
		searchFrame.getSidePanel().getSortPanel().getConfirmButton().addActionListener(this);
		searchFrame.getSidePanel().getSortPanel().getResetButton().addActionListener(this);
		for(int i = 0;i<searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray().length;i++) {
			searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].addActionListener(this);
		}
		for(int i = 0;i<searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size();i++) {
			searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchFrame.getSidePanel().getSortPanel().getConfirmButton()) {
//			ArrayList<Integer> selectedIndexArray = new ArrayList<>();
			ArrayList<String>selectedStrings = new ArrayList<String>();
			System.out.println("CONFIRMED");
			for(int i = 0;i<searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size();i++) {
				if(searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
//					selectedIndexArray.add(i);
					selectedStrings.add(searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
				}
				
			}
			searchFrame.getDisplayPanel().filter(selectedStrings);
			for(int i = 0;i<searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length;i++) {
				System.out.println(searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected());
				if(searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected()) {
					searchFrame.getDisplayPanel().sort(i);
					break;
				}
			}
			searchFrame.repaint();
			searchFrame.revalidate();
			
		}
		if(e.getSource()==searchFrame.getSidePanel().getSortPanel().getResetButton()) {
			System.out.println("RESETTED");
		}
		
		
	}
	
	
}
