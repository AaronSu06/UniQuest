package org.group3.view;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointRenderer;

public class UniversityWaypointRenderer implements WaypointRenderer<Waypoint> {
  private static final int ZOOM_THRESHOLD = 8;

  private BufferedImage img = null;

  /** Uses a default waypoint image */
  public UniversityWaypointRenderer() {
    try {
      img = ImageIO.read(new File("assets/images/waypoint.png"));
    } catch (Exception ex) {
      System.err.println("Could not read waypoint image");
    }
  }

  @Override
  public void paintWaypoint(Graphics2D g, JXMapViewer map, Waypoint w) {
    if (img == null) return;
    if (!(w instanceof LabelledUniversityWaypoint)) return;

    LabelledUniversityWaypoint luw = (LabelledUniversityWaypoint) w;

    Point2D point = map.getTileFactory().geoToPixel(luw.getPosition(), map.getZoom());

    int x = (int) point.getX() - img.getWidth() / 2;
    int y = (int) point.getY() - img.getHeight();

    g.drawImage(img, x, y, null);
    
    // Only draw the labels if the map is zoomed in to a certain degree
    if (map.getZoom() <= ZOOM_THRESHOLD) {
      g.drawString(luw.getUniversityName(), x - 4 * (luw.getUniversityName().length() / 2), y);
    }
  }
}
