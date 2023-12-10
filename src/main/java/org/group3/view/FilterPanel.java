package org.group3.view;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.group3.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
public class FilterPanel extends JPanel{
	private ArrayList<JCheckBox> checkBoxArray = new ArrayList<>();
	private JLabel filterTitle = new JLabel("Filters");
	private JLabel instituionLabel = new JLabel("Institutions");
	private JLabel gradeLabel = new JLabel("Grade Range");
	private static int universityCount=0;
	private static int gradeRangeCount = 0;
	public FilterPanel() {
//		setOpaque(true);
		setLayout(new GridLayout(0,1));
		filterTitle.setFont(new Font("SansSerif", Font.BOLD,30));
		filterTitle.setPreferredSize(new Dimension(300,50));
		filterTitle.setHorizontalAlignment(SwingConstants.CENTER);;
		filterTitle.setBackground(new Color(132, 199,80,100));
		filterTitle.setOpaque(true);
//		filterTitle.setForeground(new Color(132,199,80,100));
		add(filterTitle);
		instituionLabel.setFont(new Font("SansSerif",Font.BOLD,20));
		instituionLabel.setPreferredSize(new Dimension(300,50));
		instituionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instituionLabel.setBackground(new Color(132,192,106,100));
		instituionLabel.setOpaque(true);
		add(instituionLabel);
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
		gradeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		gradeLabel.setPreferredSize(new Dimension(300,50));
		gradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gradeLabel.setBackground(new Color(132,192,106,100));
		gradeLabel.setOpaque(true);
		add(gradeLabel);
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
