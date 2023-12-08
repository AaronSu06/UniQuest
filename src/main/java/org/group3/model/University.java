package org.group3.model;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;

import org.group3.view.GUIUtils;
import org.jxmapviewer.viewer.GeoPosition;

public class University {
  private String name;
  private GeoPosition position;
  private String address;
  private ArrayList<UniversityProgram> programs = new ArrayList<UniversityProgram>();
  private JTextArea searchResult = new JTextArea();

  public University(String name, GeoPosition position, String address) {
    this.name = name;
    this.position = position;
    this.address = address;

    // Setup the search result button
    searchResult.setText(name);
    searchResult.setFont(new Font("Sans Serif", Font.PLAIN, 14));
    searchResult.setLineWrap(true);
    searchResult.setWrapStyleWord(true);
    searchResult.setEditable(false);
    GUIUtils.setFontRenderingHints(searchResult);
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

  public JTextArea getSearchResult() {
    return searchResult;
  }

  public void setSearchResult(JTextArea searchResult) {
    this.searchResult = searchResult;
  }

  @Override
  public String toString() {
    return "University [name=" + name + ", position=" + position + ", address=" + address + ", programs=" + programs
        + ", searchResult=" + searchResult + "]";
  }

}
