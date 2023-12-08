package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.group3.model.DataModel;
import org.group3.model.University;
import org.group3.view.LabelledUniversityWaypoint;
import org.group3.view.MapFrame;
import org.jxmapviewer.viewer.Waypoint;

public class MapController implements ActionListener, MouseListener {
  MapFrame mapFrame;

  public MapController() {
    mapFrame = new MapFrame();

    addMouseListeners();
    addActionListeners();

    loadWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
  }

  public void addMouseListeners() {
    for (University university : DataModel.UNIVERSITIES) {
      university.getSearchResult().addMouseListener(this);
    }
  }

  public void addActionListeners() {
    // TODO: access all programs, add an action listener to its button which updates
    // user object, and writes to file

    mapFrame.getUniversitySearchSubmit().addActionListener(this);
    mapFrame.getFavouriteButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource().equals(mapFrame.getUniversitySearchSubmit())) {
      ArrayList<University> universityResults = DataModel
          .findUniversityByKeyword(mapFrame.getUniversitySearchField().getText());

      // update the GUI: get rid of all components on the sidebar content; loop
      addUniversityResults(universityResults);
    }

    if (arg0.getSource().equals(mapFrame.getFavouriteButton())) {
      // Do Stuff
    }
  }

  /**
   * @param universities the {@code ArrayList} that contains all of the universities
   */
  public void addUniversityResults(ArrayList<University> universities) {
    mapFrame.getSideBarContentPanel().removeAll();
    if (universities.isEmpty()) {
      JOptionPane.showMessageDialog(null, "No results!");
      return;
    }

    for (University uni : universities) {
      mapFrame.getSideBarContentPanel().add(uni.getSearchResult());
    }

    mapFrame.getSideBarContentPanel().repaint();
    mapFrame.getSideBarContentPanel().revalidate();
  }

  /**
   * @param universities is the univerisites to render waypoints for
   */
  public void loadWaypoints(List<University> universities) {
    // Set the waypoint painter of the map to an empty HashSet to clear the
    // waypoints
    mapFrame.getWaypointPainter().setWaypoints(new HashSet<Waypoint>());

    Set<Waypoint> waypoints = new HashSet<Waypoint>();

    for (University university : universities) {
      waypoints.add(new LabelledUniversityWaypoint(university.getPosition(), university.getName()));
    }

    mapFrame.getWaypointPainter().setWaypoints(waypoints);
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    if (!(arg0.getSource() instanceof JTextArea)) return;
    JTextArea clickedUniversityTextArea = (JTextArea) arg0.getSource();
    // Removes the dot in front of the text area and gets rid of the resulting space
    String universityName = clickedUniversityTextArea.getText().substring(1).trim();
    System.out.println(universityName);

    University clickedUniversity = DataModel.findUniversitySpecific(universityName);
    System.out.println(clickedUniversity);

  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
}
