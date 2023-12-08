package org.group3.view;
import java.awt.Dimension;
import java.util.*;
import java.util.Map.Entry;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.group3.model.*;
import javax.swing.*;

import org.group3.Main;
public class DisplayPanel extends JPanel{
	private JScrollBar scrollBar = new JScrollBar();
//	private JPanel program
//	private JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	private JScrollPane scrollPane = new JScrollPane(null, 0, 0)
	private ArrayList<UniversityPanel>universityArray = new ArrayList<>();
	
	private ArrayList<UniversityProgram>universityProgramArray = (ArrayList<UniversityProgram>) Main.programList;
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
		removeAll();
		universityArray.clear();
		
		for(int i = 0;i<Main.programList.size();i++) {
			universityArray.add(new UniversityPanel(universityProgramArray.get(i)));
			universityArray.get(i).setPreferredSize(new Dimension(220,300));;
			add(universityArray.get(i));

		}
		repaint();
		revalidate();
	}
//	public void filteredUniversities(HashMap<Integer, UniversityProgram>hashmap) {
//		removeAll();
//		universityArray.clear();
//		for(int i = 0;i<hashmap.size();i++){
//			universityArray.add(new UniversityPanel(hashmap.get(i)));
//			universityArray.get(i).setPreferredSize(new Dimension(220,300));;
//			add(universityArray.get(i));
//			System.out.println(i);
//		}
//		repaint();
//		revalidate();
//			
//	}
//	public void filterUniversities() {
//		
//	}
	public void updateUniversityPanels(ArrayList<UniversityPanel>universityPanelArray) {
		removeAll();
		for(int i = 0;i<universityPanelArray.size();i++) {
			universityPanelArray.get(i).setPreferredSize(new Dimension(220,300));
			add(universityPanelArray.get(i));
		}
//		if(universityProgramArray.size()>0) {
//			for(int i = 0;i<universityProgramArray.size();i++) {
//				universityArray.get(i).setPreferredSize(new Dimension(220,300));;
//				add(universityArray.get(i));
//				
//
//			}
//		}
	
		repaint();
		revalidate();
	}
	public void sort(int type) {
		if(type==0) {
			universityArray.sort((a,b)->a.getProgram().getName().compareTo(b.getProgram().getName()));
			updateUniversityPanels(universityArray);
		}else if(type==1) {
			universityArray.sort((a,b)->a.getProgram().getName().compareTo(b.getProgram().getName()));
			Collections.reverse(universityArray);
			updateUniversityPanels(universityArray);
		}else if(type==2) {
			Collections.sort(universityProgramArray,Comparator.comparing(UniversityProgram::getGrade));
//			for(UniversityProgram uni:universityProgramArray) {
//				System.out.println(uni);
//
//			}
			Collections.reverse(universityProgramArray);
			addUniversityPanels();
//			updateUniversityPanels();
//			universityArray.getFirst().getProgram().getGrade();

		}else if(type==3) {
			Collections.sort(universityProgramArray,Comparator.comparing(UniversityProgram::getGrade));

			addUniversityPanels();
		}else if(type==4) {
			
		}else if(type==5) {
			
		}else if(type==6) {
			
		}else if(type==7) {
			
		}

		
	}
	public void filter(HashMap<Integer,String>selectedFilters) {
		ArrayList<UniversityPanel>tempArray = new ArrayList<>(universityArray);
		System.out.println(selectedFilters);
		for(Map.Entry<Integer, String> filter:selectedFilters.entrySet()) {
			for(int i = 0;i<tempArray.size();i++) {
//				System.out.println(filter.getKey());
				if (filter.getKey() <= FilterPanel.getUniversityCount()&&filter.getValue().equals(tempArray.get(i).getProgram().getUniversity())
						) {
//					
					
				
				}else if(filter.getKey()>FilterPanel.getUniversityCount()&&filter.getKey()<=FilterPanel.getGradeRangeCount()&&((convertToInteger(filter.getValue())==(tempArray.get(i).getProgram().getGrade())))) {
				
				}else {
					tempArray.remove(i);
					i--;
				}
			}
		}
//		System.out.println(tempArray);
		updateUniversityPanels(tempArray);
	}
	 public double convertToInteger(String filters) {
		  Pattern p = Pattern.compile("\\d+");
	      Matcher m = p.matcher(filters);

	      if(m.find()) {
	          return Integer.parseInt(m.group());
	      }

	      return -1;
	  }
//	public void filter(ArrayList<String>selectedFilters) {
//		removeAll();
//		
//		ArrayList<UniversityPanel>tempArray = new ArrayList<>(universityArray);
//		for(String filters:selectedFilters) {
//			for(int i = 0;i<tempArray.size();i++) {
////				System.out.println(tempArray.get(i).getName());
//				if(tempArray.get(i).getProgram().getName().equals(filters)) {
//					tempArray.remove(i);
//					i--;
//				}
//			}
//		}
////		System.out.println("RAN FILTER");
//		updateUniversityPanels(tempArray);
////		HashMap<Integer, UniversityProgram>filteredList = new HashMap<>();
////		HashMap<Integer,UniversityProgram>hashMapVersion = convertArrayListToHashMap(Main.programList);
////		if(selectedFilters.size()!=0) {
////			for(String selected:selectedFilters) {
////				Predicate<Map.Entry<Integer, UniversityProgram>> predicate = entry -> entry.getValue().getName().equals(selected);
////				Map<Integer, UniversityProgram> filteredPrograms =  filterMap(hashMapVersion, predicate);			
////				universityArray.clear();
////				filteredList.putAll(filteredPrograms);
////				
////			}
////			filteredUniversities(filteredList);
////		}
//		
//		
//	}
//	private HashMap<Integer, UniversityProgram> 
//    convertArrayListToHashMap(List<UniversityProgram> programList) 
//    { 
//  
//        HashMap<Integer, UniversityProgram> hashMap = new HashMap<>(); 
//  
//        for(int i = 0;i<programList.size();i++) {
//        	hashMap.put(i, programList.get(i));
//        }
//  
//        return hashMap; 
//    } 
//	public  <T> List<T> filterObjects(List<T> list, Predicate<T> predicate) {
//        return list.stream()
//            .filter(predicate)
//            .collect(Collectors.toList());
//    }
//	public <K, V> HashMap<K, V> filterMap(HashMap<Integer, UniversityProgram>map, Predicate<? super Entry<Integer, UniversityProgram>> predicate) {
//        return (HashMap<K, V>) map.entrySet().stream()
//            .filter(predicate)
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
	public void resetToOriginal() {
		updateUniversityPanels(universityArray);
	}
}
