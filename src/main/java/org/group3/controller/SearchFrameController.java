package org.group3.controller;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.group3.model.LogoInput;
import org.group3.view.DisplayPanel;
import org.group3.view.SearchFrame;
import org.group3.view.UniversityInformationPanel;
import org.group3.view.UniversityPanel;

public class SearchFrameController implements ActionListener {
	private SearchFrame searchFrame = new SearchFrame();

	public SearchFrameController() {
		addActionListeners();
	}

	public void addActionListeners() {
//		for(int i = 0;i<searchFrame.getSortPanel().getProgramJRadioButtonArray().length;i++) {
//			searchFrame.getSortPanel().getProgramJRadioButtonArray()[i].addActionListener(this);
//		}
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
		}
		searchFrame.getSearchField().addActionListener(this);
	}

	public void reAddActionListeners() {
		System.out.println("RE ADDING");
		System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
		for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
			searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton().addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchFrame.getSidePanel().getSortPanel().getConfirmButton()) {
//			ArrayList<Integer> selectedIndexArray = new ArrayList<>();
//			ArrayList<String>selectedStrings = new ArrayList<String>();
			HashMap<Integer, String> selectedStrings = new HashMap<Integer, String>();
//			System.out.println("CONFIRMED");
			searchFrame.getDisplayPanel().resetToOriginal();

			for (int i = 0; i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size(); i++) {
				if (searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
//					selectedIndexArray.add(i);
//					System.out.println(i);
					selectedStrings.put(i,
							searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
//					selectedStrings.add(searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
//					System.out.println(selectedStrings.getLast());
				}

			}
			if (selectedStrings.size() != 0) {
				searchFrame.getDisplayPanel().filter(selectedStrings);

			}
//			reAddActionListeners();
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length; i++) {
//				System.out.println(searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected());
				if (searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected()) {
					searchFrame.getDisplayPanel().sort(i);
					break;
				}
			}
			for (int i = 0; i < searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray().length; i++) {
//				System.out.println(searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray()[i].isSelected());
				if (searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray()[i].isSelected()) {
					searchFrame.getDisplayPanel().sort(i+4);
					break;
				}
			}
			reAddActionListeners();

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
//				System.out.println("assets/data/UniLogos/" + searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity() + ".jpg");
//				String imagePathJpg = "assets/data/UniLogos/" + searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity() + ".jpg";
//				String imagePathPng = "assets/data/UniLogos/" + searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity()  + ".png";
//				BufferedImage image = null;
//				try {
//					image = ImageIO.read(new File(imagePathJpg));
//					Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//					image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
//					image.getGraphics().drawImage(scaledImage, 0, 0, null);
//
//				} catch (IOException e2) {
//					try {
//						image = ImageIO.read(new File(imagePathPng));
//						Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
//						image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
//						image.getGraphics().drawImage(scaledImage, 0, 0, null);
//						System.out.println("SUCCESS");
//					} catch (IOException e3) {
//						e3.printStackTrace();
//						System.out.println("FAILED IMAGE");
//					}
//				}
//				ImageIcon imageIcon = new ImageIcon(image);
				JOptionPane.showMessageDialog(searchFrame, scroll, "Information", 1, LogoInput.imageMap.get(searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity()));

//				JOptionPane.showMessageDialog(searchFrame, scroll);
			}
		}
		if (e.getSource() == searchFrame.getSidePanel().getSortPanel().getResetButton()) {
//			System.out.println("RESETTED");
			searchFrame.getDisplayPanel().resetToOriginal();
			searchFrame.getSidePanel().getFilterPanel().reset();
			searchFrame.getSidePanel().getSortPanel().reset();
			reAddActionListeners();
			searchFrame.repaint();
			searchFrame.revalidate();

		}
		if(e.getSource()==searchFrame.getSearchField()) {
			searchFrame.getDisplayPanel().resetToOriginal();
			String text = searchFrame.getSearchField().getText();
			searchFrame.getDisplayPanel().search(text);
			reAddActionListeners();
			
		}

	}

}
