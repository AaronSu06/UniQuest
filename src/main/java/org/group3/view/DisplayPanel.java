package org.group3.view;

import java.awt.Dimension;
import java.util.*;
import java.util.Map.Entry;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.group3.model.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.group3.Main;

public class DisplayPanel extends JPanel {
	private JScrollBar scrollBar = new JScrollBar();
//	private JPanel program
//	private JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	private JScrollPane scrollPane = new JScrollPane(null, 0, 0)
	private ArrayList<UniversityPanel> universityArray = new ArrayList<>();
	private ArrayList<UniversityPanel> originalUniversityArray;
	private ArrayList<UniversityProgram> universityProgramArray = (ArrayList<UniversityProgram>) DataModel.universityProgramArrayList;
//	private ArrayList<UniversityPanel>[] sortPriority = new ArrayList[2];
//	private int[] sortType = new int[2];
//	private boolean[]sorted = new boolean[2];
	private ArrayList<UniversityPanel> userAccordanceArray = new ArrayList<>();

	public DisplayPanel() {
//		setLayout(null);
//		
		setLayout(new GridLayout(0, 4, 10, 10));
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
//		sortPriority[0] = new ArrayList<>(universityArray);
//		sortPriority[1] = new ArrayList<>(universityArray);
//		sortType[0] = -1;
//		sortType[1] = -1;
		originalUniversityArray = new ArrayList<>(universityArray);
//		add(scrollPane);

	}

//	public boolean[] getSorted() {
//		return sorted;
//	}
//
//	public void setSorted(boolean[] sorted) {
//		this.sorted = sorted;
//	}

	public ArrayList<UniversityPanel> getUserAccordanceArray() {
		return userAccordanceArray;
	}

	public void setUserAccordanceArray(ArrayList<UniversityPanel> userAccordanceArray) {
		this.userAccordanceArray = userAccordanceArray;
	}

	public ArrayList<UniversityPanel> getOriginalUniversityArray() {
		return originalUniversityArray;
	}

	public void setOriginalUniversityArray(ArrayList<UniversityPanel> originalUniversityArray) {
		this.originalUniversityArray = originalUniversityArray;
	}

//	public ArrayList<UniversityPanel>[] getSortPriority() {
//		return sortPriority;
//	}
//
//	public void setSortPriority(ArrayList<UniversityPanel>[] sortPriority) {
//		this.sortPriority = sortPriority;
//	}
//
//	public int[] getSortType() {
//		return sortType;
//	}
//
//	public void setSortType(int[] sortType) {
//		this.sortType = sortType;
//	}

	public JScrollBar getScrollBar() {
		return scrollBar;
	}

	public void setScrollBar(JScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}

	public ArrayList<UniversityPanel> getUniversityArray() {
		return universityArray;
	}

	public void setUniversityArray(ArrayList<UniversityPanel> universityArray) {
		this.universityArray = universityArray;
	}

	public ArrayList<UniversityProgram> getUniversityProgramArray() {
		return universityProgramArray;
	}

	public void setUniversityProgramArray(ArrayList<UniversityProgram> universityProgramArray) {
		this.universityProgramArray = universityProgramArray;
	}

	public void addUniversityPanels() {
		removeAll();
		universityArray.clear();
//		universityArray =new ArrayList<>();

		for (int i = 0; i < DataModel.universityProgramArrayList.size(); i++) {
			universityArray.add(new UniversityPanel(universityProgramArray.get(i)));
			universityArray.get(i).setPreferredSize(new Dimension(220, 300));
//			System.out.println(universityArray.get(i).getProgram().getUniversity());

//			Image sizeToFit = LogoInput.imageMap.get(universityArray.get(i).getProgram().getUniversity()).getImage().getScaledInstance(universityArray.get(i).getUniversityButton().getWidth(),universityArray.get(i).getUniversityButton().getHeight(), Image.SCALE_SMOOTH);
//			universityArray.get(i).getUniversityButton().setIcon(new ImageIcon(sizeToFit));
			universityArray.get(i).getUniversityButton().setContentAreaFilled(false);
			universityArray.get(i).getUniversityButton()
					.setIcon(LogoInput.imageMap.get(universityArray.get(i).getProgram().getUniversity()));
//			universityArray.get(i).getUniversityButton().setHorizontalAlignment(SwingConstants.LEFT);
//			universityArray.get(i).getUniversityButton().setVerticalAlignment(SwingConstants.TOP);
//			universityArray.get(i).getUniversityButton().setHorizontalTextPosition(SwingConstants.LEFT);

//			String imagePathJpg = "assets/data/UniLogos/" + getUniversityArray().get(i).getProgram().getUniversity() + ".jpg";
//			String imagePathPng = "assets/data/UniLogos/" + getUniversityArray().get(i).getProgram().getUniversity()  + ".png";
//			BufferedImage image = null;
//			try {
//				image = ImageIO.read(new File(imagePathJpg));
//				Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//				image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
//				image.getGraphics().drawImage(scaledImage, 0, 0, null);
//
//			} catch (IOException e2) {
//				try {
//					image = ImageIO.read(new File(imagePathPng));
//					Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//					image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
//					image.getGraphics().drawImage(scaledImage, 0, 0, null);
////					System.out.println("SUCCESS");
//				} catch (IOException e3) {
//					e3.printStackTrace();
////					System.out.println("FAILED IMAGE");
//				}
//			}
//			ImageIcon imageIcon = new ImageIcon(image);
//			universityArray.get(i).getUniversityButton().setIcon(imageIcon);
//			
			add(universityArray.get(i));

		}
//		System.out.println("ADDING");
//		System.out.println(universityArray.size());
		repaint();
		revalidate();
	}

	public void updateUniversityPanels(ArrayList<UniversityPanel> universityPanelArray) {
		removeAll();
		for (int i = 0; i < universityPanelArray.size(); i++) {
			universityPanelArray.get(i).setPreferredSize(new Dimension(220, 300));
			add(universityPanelArray.get(i));
		}

		universityArray.clear();
		universityArray.addAll(universityPanelArray);
//		universityArray = universityPanelArray;

		repaint();
		revalidate();
	}

	public void sort(int type, int priority) {
//		System.out.println("RAN "+type+" "+priority);
//		System.out.println(sortType[0]+"sort 1," + sortType[1]+"sort 2");
		ArrayList<UniversityPanel> sortedArray = new ArrayList<>();
		sortedArray.addAll(universityArray);
//		if (priority == 0 && sortType[0] != -1) {
//			System.out.println("FIRST");
//			sortedArray = new ArrayList<>(sortPriority[0]);
//		} else if (priority == 1 && sortType[1] != -1) {
//			System.out.println("SECOND");
//
//			sortedArray = new ArrayList<>(sortPriority[1]);
//		} else {
//			System.out.println("LAST");
//
//			sortedArray = new ArrayList<>(getUniversityArray());
//		}
//		sortType[priority]=type;
//		System.out.println(sortedArray);
		if (priority == 0) {
			if (type == 0) {

				sortedArray.sort((a, b) -> a.getProgram().getName().compareTo(b.getProgram().getName()));
				updateUniversityPanels(sortedArray);
			} else if (type == 1) {
				sortedArray.sort((a, b) -> a.getProgram().getName().compareTo(b.getProgram().getName()));
				Collections.reverse(sortedArray);
				updateUniversityPanels(sortedArray);

			} else if (type == 2) {
				Collections.sort(sortedArray, new Comparator<UniversityPanel>() {

					@Override
					public int compare(UniversityPanel o1, UniversityPanel o2) {
						return Integer.compare(o1.getProgram().getGrade(), o2.getProgram().getGrade());
					}

				});

				Collections.reverse(sortedArray);
				updateUniversityPanels(sortedArray);

			} else if (type == 3) {
				Collections.sort(sortedArray, new Comparator<UniversityPanel>() {

					@Override
					public int compare(UniversityPanel o1, UniversityPanel o2) {
						return Integer.compare(o1.getProgram().getGrade(), o2.getProgram().getGrade());
					}

				});
				updateUniversityPanels(sortedArray);
			} else if (type == 4) {
//				universityArray.sort((a, b) -> a.getProgram().getUniversity().compareTo(b.getProgram().getUniversity()));
//				updateUniversityPanels(universityArray);
				sortedArray.sort((a, b) -> a.getProgram().getUniversity().compareTo(b.getProgram().getUniversity()));
				updateUniversityPanels(sortedArray);

			} else if (type == 5) {
				sortedArray.sort((a, b) -> a.getProgram().getUniversity().compareTo(b.getProgram().getUniversity()));
				Collections.reverse(sortedArray);
				updateUniversityPanels(sortedArray);
			}
//			sorted[0]=true;
//			sort(sortType[1], 1);
		}

	}

	public void filter(HashMap<Integer, String> selectedFilters) {
		ArrayList<UniversityPanel> tempArray = new ArrayList<>(universityArray);
		ArrayList<UniversityPanel> jointArray = new ArrayList<>();
		for (Map.Entry<Integer, String> filter : selectedFilters.entrySet()) {
			int filter1 = convertToInteger(filter.getValue());
			int filter2 = convertToInteger(filter.getValue().replace(Integer.toString(filter1), ""));
//			
			for (int i = 0; i < tempArray.size(); i++) {
				if (filter.getKey() < FilterPanel.getUniversityCount()
						&& filter.getValue().equals(tempArray.get(i).getProgram().getUniversity())) {
//					

				} else if (filter.getKey() >= FilterPanel.getUniversityCount()
						&& filter.getKey() < FilterPanel.getGradeRangeCount()
						&& (filter2 >= (tempArray.get(i).getProgram().getGrade()))
						&& filter1 <= tempArray.get(i).getProgram().getGrade()) {

				} else if (filter.getKey() >= FilterPanel.getUniversityCount()
						&& filter.getKey() < FilterPanel.getGradeRangeCount() && (filter2 == 0)
						&& filter1 <= tempArray.get(i).getProgram().getGrade()) {

				}

				else if (filter.getKey() >= FilterPanel.getGradeRangeCount()
						&& tempArray.get(i).getProgram().containsCourseCode(filter.getValue())) {

				} else {
					tempArray.remove(i);
					i--;
				}
			}

			for (UniversityPanel uni : tempArray) {
				if (!jointArray.contains(uni)) {
					jointArray.add(uni);
				}
			}
			tempArray = jointArray;

		}

		updateUniversityPanels(jointArray);
	}

	public void search(String string) {
		string = string.toLowerCase();
		ArrayList<UniversityPanel> matches = new ArrayList<>();
		for (UniversityPanel program : universityArray) {
			if (program.getProgram().getName().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getUniversity().toLowerCase().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getDegree().toLowerCase().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getOuacProgramCode().toLowerCase().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getGradeRange().toLowerCase().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getExperientialLearning().toLowerCase().contains(string)) {
				matches.add(program);
			} else if (program.getProgram().getInstructionLanguage().toLowerCase().contains(string)) {
				matches.add(program);
			} else {
				for (String prerequisite : program.getProgram().getPrerequisites()) {
					if (prerequisite.toLowerCase().contains(string)) {
						matches.add(program);
						break;
					}
				}
			}
			if (program.getProgram().getEnrollment() != null) {
				if (program.getProgram().getEnrollment().toLowerCase().contains(string)) {
					if (matches.size() == 0) {
						matches.add(program);
					} else if (matches.getLast() != program) {
						matches.add(program);
					}
				}

			}
			if (program.getProgram().getNotes() != null) {
				if (program.getProgram().getNotes().toLowerCase().contains(string)) {
					if (matches.size() == 0) {
						matches.add(program);
					} else if (matches.getLast() != program) {
						matches.add(program);
					}
				}

			}

		}
		updateUniversityPanels(matches);
	}

	public int convertToInteger(String filters) {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(filters);

		if (m.find()) {
			return Integer.parseInt(m.group());
		}

		return -1;
	}

//	resets the filters and sorting to original
	public void resetToOriginal() {
		
//		calls the update method passing in the original array
		updateUniversityPanels(originalUniversityArray);
	}

	public void resetToPrevious(int arrayIndex) {

	}

	public void resetToUser() {
		updateUniversityPanels(userAccordanceArray);

	}

}
