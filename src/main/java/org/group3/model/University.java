package org.group3.model;

import java.util.ArrayList;
import org.jxmapviewer.viewer.GeoPosition;

public class University {
  private String name;
  private GeoPosition position;
  private String address;
  private ArrayList<UniversityProgram> programs = new ArrayList<UniversityProgram>();

  public University(String name, GeoPosition position, String address) {
    this.name = name;
    this.position = position;
    this.address = address;

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GeoPosition getPosition() {
    return position;
  }

  public void setPosition(GeoPosition position) {
    this.position = position;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ArrayList<UniversityProgram> getPrograms() {
    return programs;
  }

  public void setPrograms(ArrayList<UniversityProgram> programs) {
    this.programs = programs;
  }
}
