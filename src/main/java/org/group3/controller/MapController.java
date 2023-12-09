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
import org.jxmapviewer.viewer.GeoPosition;
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
    mapFrame.getUniversitySearchSubmit().addActionListener(this);
    
    // TODO: access all programs, add an action listener to its fav button which updates
    // user object, and writes to file
    mapFrame.getFavouriteButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource().equals(mapFrame.getUniversitySearchSubmit())) {
      ArrayList<University> universityResults =
          DataModel.findUniversityByKeyword(mapFrame.getUniversitySearchField().getText());

      addUniversityResults(universityResults);
      // Yo this is sick
      loadWaypoints(
          universityResults.size() == 0
              ? Arrays.asList(DataModel.UNIVERSITIES)
              : universityResults);
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
      mapFrame.getSideBarContentPanel().repaint();
      mapFrame.getSideBarContentPanel().revalidate();
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
    // Clear the current waypoints
    mapFrame.getWaypointPainter().setWaypoints(new HashSet<>());
    Set<Waypoint> waypoints = new HashSet<Waypoint>();
    Set<GeoPosition> positions = new HashSet<GeoPosition>();

    // This is required to zoom in properly
    for (University university : universities) {
      positions.add(university.getPosition());
    }

    for (University university : universities) {
      waypoints.add(new LabelledUniversityWaypoint(university.getPosition(), university.getName()));
    }

    mapFrame.getWaypointPainter().setWaypoints(waypoints);
    mapFrame.getMapViewer().zoomToBestFit(positions, 0.7);

    // Repaint and revalidate
    mapFrame.repaint();
    mapFrame.revalidate();
  }

  public void addUniversityInformation(University university) {
    mapFrame.getSideBarContentPanel().removeAll();
    mapFrame.addUniversityInfoGUI();

    mapFrame.getUniversityTitle().setText(university.getName());
    mapFrame.getUniversityAddress().setText(university.getAddress());

    mapFrame.repaint();
    mapFrame.revalidate();
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    if (arg0.getSource() instanceof JTextArea) {
      JTextArea clickedUniversityTextArea = (JTextArea) arg0.getSource();
      // Removes the dot in front of the text area and gets rid of the resulting space
      String universityName = clickedUniversityTextArea.getText().substring(1).trim();
      System.out.println(universityName);

      ArrayList<University> u = new ArrayList<University>();
      u.add(DataModel.findUniversitySpecific(universityName));

      loadWaypoints(u);
      addUniversityInformation(u.get(0));
    }
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
