package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group3.view.SearchFrame;

public class SearchFrameController implements ActionListener{
	private SearchFrame searchFrame = new SearchFrame();
	public SearchFrameController() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<searchFrame.getSortPanel().getProgramJRadioButtonArray().length;i++) {
			if(e.getSource()==searchFrame.getSortPanel().getProgramJRadioButtonArray()[i]) {
				
				
			}
			
		}
		
	}
	
	
}
