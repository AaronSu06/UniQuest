package org.group3.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LogoInput {
  public static HashMap<String, ImageIcon> imageMap = new HashMap<>();
  public static ImageIcon favouritingStar;

  public LogoInput() {
    try {
      BufferedImage star = ImageIO.read(new File("assets/data/favouritingButton.png"));
      Image scaledImage = star.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
      star = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
      star.getGraphics().drawImage(scaledImage, 0, 0, null);
      favouritingStar = new ImageIcon(star);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    for (int i = 0; i < DataModel.universityProgramArrayList.size(); i++) {
      String uni = DataModel.universityProgramArrayList.get(i).getUniversity();
      // System.out.println(uni);
      if (!imageMap.containsKey(uni)) {
        String imagePathJpg =
            "assets/data/UniLogos/"
                + DataModel.universityProgramArrayList.get(i).getUniversity()
                + ".jpg";
        String imagePathPng =
            "assets/data/UniLogos/"
                + DataModel.universityProgramArrayList.get(i).getUniversity()
                + ".png";
        BufferedImage image = null;
        try {
          image = ImageIO.read(new File(imagePathJpg));
          Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
          image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
          image.getGraphics().setColor(Color.WHITE);
          image.getGraphics().fillRect(0, 0, image.getWidth(), image.getHeight());

          image.getGraphics().drawImage(scaledImage, 0, 0, null);

        } catch (IOException e2) {
          try {
            image = ImageIO.read(new File(imagePathPng));
            Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            image = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
            image.getGraphics().setColor(Color.WHITE);
            image.getGraphics().fillRect(0, 0, image.getWidth(), image.getHeight());

            image.getGraphics().drawImage(scaledImage, 0, 0, null);
          } catch (IOException e3) {
            e3.printStackTrace();
            // System.out.println("FAILED IMAGE");
          }
        }
        // System.out.println("SUCCESS");
        ImageIcon imageIcon = new ImageIcon(image);
        imageMap.put(uni, imageIcon);
      }
    }
  }
}
