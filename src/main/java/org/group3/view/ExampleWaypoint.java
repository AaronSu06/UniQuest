/*
 * WaypointRenderer.java
 *
 * Created on March 30, 2006, 5:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.group3.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointRenderer;

/**
 * This is a standard waypoint renderer.
 *
 * @author joshy
 */
public class ExampleWaypoint implements WaypointRenderer<Waypoint> {

  private BufferedImage img = null;

  /** Uses a default waypoint image */
  public ExampleWaypoint() {
    try {
      img =
          ImageIO.read(new File("assets/images/waypoint.png"));
    } catch (Exception ex) {
      System.out.println("Something Went Wrong!");
    }
  }

  @Override
  public void paintWaypoint(Graphics2D g, JXMapViewer map, Waypoint w) {
    if (img == null) return;

    Point2D point = map.getTileFactory().geoToPixel(w.getPosition(), map.getZoom());

    int x = (int) point.getX() - img.getWidth() / 2;
    int y = (int) point.getY() - img.getHeight();

    // g.setColor(Color.RED);
    // g.drawLine(-5, -5, +5, +5);
    // g.drawLine(-5, +5, +5, -5);
    g.drawImage(img, x, y, null);

  }
}
