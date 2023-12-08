package org.group3.view;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class LabelledUniversityWaypoint extends DefaultWaypoint {
  private String universityName;

  public LabelledUniversityWaypoint(GeoPosition coord, String universityName) {
    super(coord);
    this.universityName = universityName;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }
}
