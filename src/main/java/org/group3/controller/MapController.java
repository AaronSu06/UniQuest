package org.group3.controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
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
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.model.University;
import org.group3.view.LabelledUniversityWaypoint;
import org.group3.view.MapFrame;
import org.group3.view.ProgramInfoText;
import org.group3.view.UniversityMapFrameSearchResult;
import org.group3.view.UniversityProgramInformationPanel;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;

// Code for scrolling to the top:
// https://stackoverflow.com/questions/291115/java-swing-using-jscrollpane-and-having-it-scroll-back-to-top
public class MapController implements ActionListener, MouseListener {
  private MapFrame mapFrame;

  public MapController() {
    mapFrame = new MapFrame();
    mapFrame.setVisible(false);

    mapFrame.getUniversitySearchSubmit().addActionListener(this);

    addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
    addUniversitySearchResults(Arrays.asList(DataModel.UNIVERSITIES));
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // When the user submits a search
    if (arg0.getSource().equals(mapFrame.getUniversitySearchSubmit())) {
      List<University> universityResults =
          DataModel.findUniversityByKeyword(mapFrame.getUniversitySearchField().getText());

      if (universityResults.size() == 0) {
        addWaypoints(Arrays.asList(DataModel.UNIVERSITIES));
        addUniversitySearchResults(Arrays.asList(DataModel.UNIVERSITIES));
        JOptionPane.showMessageDialog(null, "No Results!");
      } else {
        addWaypoints(universityResults);
        addUniversitySearchResults(universityResults);
      }
    }
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

  /**
   * @param universities the {@code List} that contains all of the universities
   */
  public void addUniversitySearchResults(List<University> universities) {
    mapFrame.getSideBarContentPanel().removeAll();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL; // Expand horizontally
    gbc.insets = new Insets(10, 0, 10, 0); // Padding

    // Add the search result
    for (int i = 0; i < universities.size(); i++) {
      University uni = universities.get(i);

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

      gbc.gridx = 0;
      gbc.gridy = i;

      mapFrame.getSideBarContentPanel().add(searchResult, gbc);
    }

    // Scroll to the top:
    SwingUtilities.invokeLater(
        new Runnable() {

          @Override
          public void run() {
            mapFrame.getSideBarContentScrollPane().getVerticalScrollBar().setValue(0);
          }
        });
    mapFrame.getSideBarContentPanel().repaint();
    mapFrame.getSideBarContentPanel().revalidate();
  }

  public void addUniversityInformation(University university) {
    // Remove any content that already exists
    mapFrame.getSideBarContentPanel().removeAll();
    mapFrame.getProgramsPanel().removeAll();

    // Re-add the GUI components to dispaly the univeristy info
    mapFrame.addUniversityInfoGUI();

    // Set title and addres accordingly
    mapFrame.getUniversityTitle().setText(university.getName());
    mapFrame.getUniversityAddress().setText(university.getAddress());

    // Make layout constraints
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL; // Expand horizontally
    gbc.insets = new Insets(10, 0, 10, 0); // Padding

    for (int i = 0; i < university.getPrograms().size(); i++) {
      var program = university.getPrograms().get(i);
      ProgramInfoText programInfoText = new ProgramInfoText(program.getName());

      // Dynamically add a mouse listener to the program text area
      programInfoText.addMouseListener(
          new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
              // Will display a program information panel
              JScrollPane scroll =
                  new JScrollPane(
                      new UniversityProgramInformationPanel(program),
                      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              scroll.setPreferredSize(new Dimension(500, 500));
              scroll.getVerticalScrollBar().setUnitIncrement(20);
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

      gbc.gridx = 0;
      gbc.gridy = i;

      mapFrame.getProgramsPanel().add(programInfoText, gbc);
    }

    // Scroll to the top:
    SwingUtilities.invokeLater(
        new Runnable() {

          @Override
          public void run() {
            mapFrame.getProgramsScrollPane().getVerticalScrollBar().setValue(0);
          }
        });

    mapFrame.repaint();
    mapFrame.revalidate();
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {}

  @Override
  public void mouseEntered(MouseEvent arg0) {}

  @Override
  public void mouseExited(MouseEvent arg0) {}

  @Override
  public void mousePressed(MouseEvent arg0) {}

  @Override
  public void mouseReleased(MouseEvent arg0) {}

  public MapFrame getMapFrame() {
    return mapFrame;
  }

  public void setMapFrame(MapFrame mapFrame) {
    this.mapFrame = mapFrame;
  }
}
