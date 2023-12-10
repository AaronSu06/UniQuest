package org.group3.model;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.group3.Main;
import org.group3.view.UniversityPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class LogoInput {
	public static HashMap<String, ImageIcon>imageMap = new HashMap<>();
	public LogoInput() {
		for (int i = 0; i < Main.programList.size(); i++) {
			String uni = Main.programList.get(i).getUniversity();
			if(!imageMap.containsKey(uni)) {
				String imagePathJpg = "assets/data/UniLogos/" + Main.programList.get(i).getUniversity() + ".jpg";
				String imagePathPng = "assets/data/UniLogos/" + Main.programList.get(i).getUniversity()  + ".png";
				BufferedImage image = null;
				try {
					image = ImageIO.read(new File(imagePathJpg));
					Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
					image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
					image.getGraphics().drawImage(scaledImage, 0, 0, null);

				} catch (IOException e2) {
					try {
						image = ImageIO.read(new File(imagePathPng));
						Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
						image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
						image.getGraphics().drawImage(scaledImage, 0, 0, null);
//						System.out.println("SUCCESS");
					} catch (IOException e3) {
						e3.printStackTrace();
//						System.out.println("FAILED IMAGE");
					}
				}
				ImageIcon imageIcon = new ImageIcon(image);
				imageMap.put(uni, imageIcon);
			}
			
		}
	}
}
