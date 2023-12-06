package org.group3.view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.group3.model.*;
import javax.swing.*;

import org.group3.Main;
public class DisplayPanel extends JPanel{
	private JScrollBar scrollBar = new JScrollBar();
//	private JPanel program
//	private JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	private JScrollPane scrollPane = new JScrollPane(null, 0, 0)
	private ArrayList<UniversityPanel>universityArray = new ArrayList<>();
	public DisplayPanel() {
//		setLayout(null);
//		
		setLayout(new GridLayout(0,4,10,10));
////		scrollPane.setBounds(0,0,980,675);
////		scrollPane.setLayout(null);
////		scrollBar.setBounds(930,0,50,675);
////		scrollPane.add(scrollBar);
//		
//		int positionX = 0;
//		int positionY = 0;
//		for(int i = 0;i<Main.programList.size();i++) {
////			
//			universityArray.add(new UniversityPanel(Main.programList.get(i)));
//			universityArray.get(i).setPreferredSize(new Dimension(220,300));;
////			universityArray.get(i).setBounds(10+positionX*220+positionX*10,10+300*positionY +10*positionY,220,300);
//			add(universityArray.get(i));
//			System.out.println(universityArray.get(i).getX());
//			System.out.println(universityArray.get(i).getY());
//
////			positionX++;
////			if(positionX==4) {
////				positionX=0;
////				positionY++;
////			}
//		}
		addUniversityPanels();
//		add(scrollPane);
		
	
	}
	public void addUniversityPanels() {
		for(int i = 0;i<Main.programList.size();i++) {
			universityArray.add(new UniversityPanel(Main.programList.get(i)));
			universityArray.get(i).setPreferredSize(new Dimension(220,300));;
			add(universityArray.get(i));

		}
	}
	public void updateUniversityPanels() {
		removeAll();
		for(int i = 0;i<Main.programList.size();i++) {
			universityArray.get(i).setPreferredSize(new Dimension(220,300));;
			add(universityArray.get(i));

		}
		repaint();
		revalidate();
	}
	public void sort(int type) {
		if(type==0) {
			universityArray.sort((a,b)->a.getProgram().getName().compareTo(b.getProgram().getName()));
			updateUniversityPanels();
		}

		
	}
	public void filter() {
		
	}
}
