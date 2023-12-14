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
import javax.swing.JScrollPane;
import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.model.University;
import org.group3.model.UniversityProgram;
import org.group3.view.AppColors;
import org.group3.view.LabelledUniversityWaypoint;
import org.group3.view.MapFrame;
import org.group3.view.ProgramInfoText;
import org.group3.view.UniversityInformationPanel;
import org.group3.view.UniversityMapFrameSearchResult;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

public class MapController implements ActionListener, MouseListener {
  MapFrame mapFrame;

  public MapController() {
    mapFrame = new MapFrame();
    mapFrame.setVisible(false);
    addActionListeners();

    addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
    addUniversitySearchResults(Arrays.asList(DataModel.UNIVERSITIES));
  }

  public MapFrame getMapFrame() {
    return mapFrame;
  }

  public void setMapFrame(MapFrame mapFrame) {
    this.mapFrame = mapFrame;
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
        addUniversitySearchResults(Arrays.asList(DataModel.UNIVERSITIES));
        addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
        JOptionPane.showMessageDialog(null, "No Results!");
      } else {
        addUniversitySearchResults(universityResults);
        addWaypoints(universityResults);
      }
    }

    if (arg0.getSource().equals(mapFrame.getFavouriteButton())) {
      // Change colour
      mapFrame.getFavouriteButton().setBackground(AppColors.BUTTON_PRESSED);
      // Do Stuff
    }
  }

  /**
   * @param universities the {@code List} that contains all of the universities
   */
  public void addUniversitySearchResults(List<University> universities) {
    mapFrame.getSideBarContentPanel().removeAll();

    // Calculate a good height for the result pane
    int preferredHeight = universities.size() * 55;
    mapFrame.getSideBarContentPanel().setPreferredSize(new Dimension(150, preferredHeight));

    // Add the search result
    for (University uni : universities) {
      UniversityMapFrameSearchResult searchResult =
          new UniversityMapFrameSearchResult(uni.getName());

      // Add a mouse listener to the university text
      searchResult.addMouseListener(
          new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
              // Get rid of the bullet point in front of the result
              String universityName = searchResult.getText().substring(1).trim();

              // Create a dummy ArrayList to hold the university since the waypoint adding
              // method can only take in lists because of how JXMapViewer's waypoit system is
              // implemented (it requires a map)
              List<University> u = new ArrayList<University>();

              u.add(DataModel.findUniversitySpecific(universityName));

              addWaypoints(u);

              // Since the university is the only thing in the arrayList.
              addUniversityInformation(u.get(0));

              // Adjust the boundaires of the sidebar accordingly
              mapFrame.getSideBarContentScrollPane().getViewport().setViewPosition(new Point(0, 0));
              mapFrame.getSideBarContentPanel().setPreferredSize(new Dimension(150, 500));
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

      mapFrame.getSideBarContentPanel().add(searchResult);

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

    System.out.println(university.getPrograms().size());

    int preferredHeight = university.getPrograms().size() * 120;

    mapFrame.getProgramsPanel().setPreferredSize(new Dimension(150, preferredHeight));

    for (UniversityProgram program : university.getPrograms()) {
      ProgramInfoText infoText = new ProgramInfoText(program.getName());

      // Dynamically add a mouse listener to the program text area
      infoText.addMouseListener(
          new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
              JScrollPane scroll =
                  new JScrollPane(
                      new UniversityInformationPanel(program),
                      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              scroll.setPreferredSize(new Dimension(500, 500));
              JOptionPane.showMessageDialog(
                  mapFrame, scroll, "Information", 1, LogoInput.imageMap.get(university.getName()));
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

    mapFrame.getProgramsScrollPane().getViewport().setViewPosition(new Point(0, 0));
    mapFrame.repaint();
    mapFrame.revalidate();
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {}

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
