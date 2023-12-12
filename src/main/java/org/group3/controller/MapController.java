package org.group3.controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.group3.model.DataModel;
import org.group3.model.University;
import org.group3.model.UniversityProgram;
import org.group3.view.LabelledUniversityWaypoint;
import org.group3.view.MapFrame;
import org.group3.view.ProgramInfoText;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

public class MapController implements ActionListener, MouseListener {
  MapFrame mapFrame;

  public MapController() {
    mapFrame = new MapFrame();

    addMouseListeners();
    addActionListeners();

    addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
    addUniversityResults(Arrays.asList(DataModel.UNIVERSITIES));
  }

  public void addMouseListeners() {
    for (University university : DataModel.UNIVERSITIES) {
      university.getSearchResult().addMouseListener(this);
    }
  }

  public void addActionListeners() {
    mapFrame.getUniversitySearchSubmit().addActionListener(this);

    // TODO: access all programs, add an action listener to its fav button which
    // updates
    // user object, and writes to file

    mapFrame.getFavouriteButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource().equals(mapFrame.getUniversitySearchSubmit())) {
      List<University> universityResults =
          DataModel.findUniversityByKeyword(mapFrame.getUniversitySearchField().getText());

      if (universityResults.size() == 0) {
        addUniversityResults(Arrays.asList(DataModel.UNIVERSITIES));
        addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
        JOptionPane.showMessageDialog(null, "No Results!");
      } else {
        addUniversityResults(universityResults);
        addWaypoints(universityResults);
      }
    }

    if (arg0.getSource().equals(mapFrame.getFavouriteButton())) {
      // Do Stuff
    }
  }

  /**
   * @param universities the {@code List} that contains all of the universities
   */
  public void addUniversityResults(List<University> universities) {
    mapFrame.getSideBarContentPanel().removeAll();
    for (University uni : universities) {
      // uni.getSearchResult().setPreferredSize(new Dimension(150,100));
      mapFrame.getSideBarContentPanel().add(uni.getSearchResult());
      JLabel invisibleLabel = new JLabel();
      invisibleLabel.setPreferredSize(new Dimension(150, 20));
      mapFrame.getSideBarContentPanel().add(invisibleLabel);
    }
    mapFrame.getSideBarContentPanel().repaint();
    mapFrame.getSideBarContentPanel().revalidate();
  }

  /**
   * @param universities is the {@code List} univerisites to render waypoints for
   */
  public void addWaypoints(List<University> universities) {
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

    int preferredHeight = university.getPrograms().size() * 70;

    mapFrame.getProgramsPanel().setPreferredSize(new Dimension(150, preferredHeight));

    for (UniversityProgram program : university.getPrograms()) {
      ProgramInfoText infoText = new ProgramInfoText(program.getName());
      infoText.addMouseListener(
          new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
              System.out.println("Favourited Program!");
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {}

            @Override
            public void mouseExited(MouseEvent arg0) {}

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}
          });
      mapFrame.getProgramsPanel().add(infoText);

      JLabel invisibleLabel = new JLabel();
      invisibleLabel.setPreferredSize(new Dimension(150, 20));
      mapFrame.getProgramsPanel().add(invisibleLabel);
    }

    mapFrame.repaint();
    mapFrame.revalidate();
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    // Display the university information (Programs, address, etc.)
    if (arg0.getSource() instanceof JTextArea) {
      JTextArea clickedUniversityTextArea = (JTextArea) arg0.getSource();
      // Removes the dot in front of the text area and gets rid of the resulting space
      String universityName = clickedUniversityTextArea.getText().substring(1).trim();

      List<University> u = new ArrayList<University>();
      u.add(DataModel.findUniversitySpecific(universityName));

      addWaypoints(u);

      addUniversityInformation(u.get(0));

      mapFrame.getSideBarContentScrollPane().getViewport().setViewPosition(new Point(0, 0));
      mapFrame.getSideBarContentPanel().setPreferredSize(new Dimension(150, 500));
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
