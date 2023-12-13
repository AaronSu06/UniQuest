package org.group3.view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SortMenu extends JPanel{
//	private JPanel programOptions = new JPanel();
//	private JLabel programLabel = new JLabel("Program Sorts");
//	private JRadioButton[] programJMenuArray = new JRadioButton[4];
//	private JPanel universityOptions = new JPanel();
//	private JLabel universityLabel = new JLabel("University Sorts");
//	private JRadioButton[] universityJMenuArray = new JRadioButton[2];
	private JMenuBar sorts = new JMenuBar();
	private JMenu[] sortingTypes = new JMenu[2];
	private JMenu[] programMenu = new JMenu[2];
	private JMenu[] universityMenu = new JMenu[2];
	private JMenuItem[] noSort = new JMenuItem[2];
	private ArrayList<JMenuItem> array = new ArrayList<>();
	private JMenuItem[][] programJMenuArray = new JMenuItem[2][4];
	private JMenuItem[][] universityJMenuArray = new JMenuItem[2][2];

	public SortMenu() {
		
		sortingTypes[0] = new JMenu("Primary Sort");
		sortingTypes[0].setPreferredSize(new Dimension(230,45));
//		sortingTypes[1] = new JMenu("Secondary Sort");
//		sortingTypes[1].setPreferredSize(new Dimension(230,45));
		programMenu[0]=new JMenu("Program Sorts");

		for (int i = 0; i < programJMenuArray[0].length; i++) {
			programJMenuArray[0][i] = new JMenuItem();
//			programJMenuArray[i].setBounds(10, 40+i*29, 300, 29);
			
			programJMenuArray[0][i].setPreferredSize(new Dimension(300, 29));
			setJMenuItemText(i ,0,0);
			programMenu[0].add(programJMenuArray[0][i]);
		}
		programMenu[0].setPreferredSize(new Dimension(230,45));
		
//		programMenu[1]=new JMenu("Program Sorts");
//		for (int i = 0; i < programJMenuArray[1].length; i++) {
//			programJMenuArray[1][i] = new JMenuItem();
////			programJMenuArray[i].setBounds(10, 40+i*29, 300, 29);
//			
//			programJMenuArray[1][i].setPreferredSize(new Dimension(300, 29));
//			setJMenuItemText(i,0,1);
//			programMenu[1].add(programJMenuArray[1][i]);
//		}
//		programMenu[1].setPreferredSize(new Dimension(230,45));
		sortingTypes[0].add(programMenu[0]);
//		sortingTypes[1].add(programMenu[1]);
		universityMenu[0]=new JMenu("University Sorts");

		for (int i = 0; i < universityJMenuArray[0].length; i++) {
			universityJMenuArray[0][i] = new JMenuItem();
//			universityJMenuArray[i].setBounds(10, 40+i*29, 300, 29);
			universityJMenuArray[0][i].setPreferredSize(new Dimension(300, 29));
			setJMenuItemText(i,1,0);
			universityMenu[0].add(universityJMenuArray[0][i]);
		}
//		universityMenu[1]=new JMenu("University Sorts");
//
//		for (int i = 0; i < universityJMenuArray[1].length; i++) {
//			universityJMenuArray[1][i] = new JMenuItem();
////			universityJMenuArray[i].setBounds(10, 40+i*29, 300, 29);
//			universityJMenuArray[1][i].setPreferredSize(new Dimension(300, 29));
//			setJMenuItemText(i,1,1);
//
//			universityMenu[1].add(universityJMenuArray[1][i]);
//		}
		sortingTypes[0].add(universityMenu[0]);

//		sortingTypes[1].add(universityMenu[1]);
		noSort[0]=new JMenuItem("No Sort");
		
		sortingTypes[0].add(noSort[0]);
//		noSort[1]=new JMenuItem("No sort");
//		sortingTypes[1].add(noSort[1]);
		sortingTypes[0].setBounds(0,0,300,45);
		sorts.add(sortingTypes[0]);
//		sorts.add(sortingTypes[1]);
		add(sorts);

	}
	

	


	public JMenuBar getSorts() {
		return sorts;
	}





	public void setSorts(JMenuBar sorts) {
		this.sorts = sorts;
	}





	public JMenu[] getSortingTypes() {
		return sortingTypes;
	}


	public void setSortingTypes(JMenu[] sortingTypes) {
		this.sortingTypes = sortingTypes;
	}


	public JMenu[] getProgramMenu() {
		return programMenu;
	}


	public void setProgramMenu(JMenu[] programMenu) {
		this.programMenu = programMenu;
	}


	public JMenu[] getUniversityMenu() {
		return universityMenu;
	}


	public void setUniversityMenu(JMenu[] universityMenu) {
		this.universityMenu = universityMenu;
	}


	public JMenuItem[] getNoSort() {
		return noSort;
	}


	public void setNoSort(JMenuItem[] noSort) {
		this.noSort = noSort;
	}








	public JMenuItem[][] getProgramJMenuArray() {
		return programJMenuArray;
	}





	public void setProgramJMenuArray(JMenuItem[][] programJMenuArray) {
		this.programJMenuArray = programJMenuArray;
	}





	public JMenuItem[][] getUniversityJMenuArray() {
		return universityJMenuArray;
	}





	public void setUniversityJMenuArray(JMenuItem[][] universityJMenuArray) {
		this.universityJMenuArray = universityJMenuArray;
	}





	private void setJMenuItemText(int type, int menu, int array) {
		if (menu == 0) {
			switch (type) {
			case 0:
				programJMenuArray[array][type].setText("A-Z");
				break;

			case 1:
				programJMenuArray[array][type].setText("Z-A");
				break;

			case 2:
				programJMenuArray[array][type].setText("Grade:High to low");
				break;

			case 3:
				programJMenuArray[array][type].setText("Grade:Low to High");
				break;
			}
		} else {
			switch (type) {
			case 0:
				universityJMenuArray[array][type].setText("A-Z");
				break;

			case 1:
				universityJMenuArray[array][type].setText("Z-A");
				break;

			
			}
		}

	}

	public void reset() {
//		for(JRadioButton button: programJMenuArray) {
//			button.setSelected(false);
//		}
//		for(JRadioButton button: universityJMenuArray) {
//			button.setSelected(false);
//		}
//		for(int i = 0;i<programJMenuArray.length;i++) {
//			programJMenuArray[i].setSelected(false);
//
//		}
//		for(int i = 0;i<universityJMenuArray.length;i++) {
//			universityJMenuArray[i].setSelected(false);
//
//		}

	}

}
