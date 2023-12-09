package org.group3.view;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.group3.Main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
public class FilterPanel extends JPanel{
	private ArrayList<JCheckBox> checkBoxArray = new ArrayList<>();
	private JLabel filterTitle = new JLabel("Filters");
	private static int universityCount=0;
	private static int gradeRangeCount = 0;
	public FilterPanel() {
		setLayout(new GridLayout(0,1));
		filterTitle.setFont(new Font("SansSerif", Font.BOLD,30));
		filterTitle.setPreferredSize(new Dimension(300,50));
		filterTitle.setHorizontalAlignment(SwingConstants.CENTER);;
		add(filterTitle);
		
		ArrayList<String>universities = new ArrayList<>();
		for(int i = 0 ;i<Main.programList.size();i++) {
			if(!universities.contains(Main.programList.get(i).getUniversity())) {
				universities.add(Main.programList.get(i).getUniversity());
				universityCount++;
			}
		}
		for(int i = 0;i<universities.size();i++) {
			checkBoxArray.add(new JCheckBox(universities.get(i)));
//			checkBoxArray.get(i).setBounds(10,10+i*29, 300,29);
			checkBoxArray.get(i).setPreferredSize(new Dimension(300,50));
			add(checkBoxArray.getLast());
		}
		gradeRangeCount+=universityCount;
		for(int i = 0;i<6;i++) {
			if(i==0) {
				checkBoxArray.add(new JCheckBox("less than 50%"));
				
			}else {
				checkBoxArray.add(new JCheckBox(Integer.toString(40+i*10)+"% to "+Integer.toString(50+i*10)+"%"));

			}
			checkBoxArray.getLast().setPreferredSize(new Dimension(300,50));
			add(checkBoxArray.getLast());
			gradeRangeCount++;
		}
	}

	public ArrayList<JCheckBox> getCheckBoxArray() {
		return checkBoxArray;
	}

	public void setCheckBoxArray(ArrayList<JCheckBox> checkBoxArray) {
		this.checkBoxArray = checkBoxArray;
	}

	public JLabel getFilterTitle() {
		return filterTitle;
	}

	public void setFilterTitle(JLabel filterTitle) {
		this.filterTitle = filterTitle;
	}

	public static int getUniversityCount() {
		return universityCount;
	}

	public static void setUniversityCount(int universityCount) {
		FilterPanel.universityCount = universityCount;
	}

	public static int getGradeRangeCount() {
		return gradeRangeCount;
	}

	public static void setGradeRangeCount(int gradeRangeCount) {
		FilterPanel.gradeRangeCount = gradeRangeCount;
	}
	public void reset() {
		for(JCheckBox box:checkBoxArray) {
			box.setSelected(false);
		}
	}
	
	
	
}
