package org.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import org.group3.model.DataModel;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

public class MapFrame extends JFrame {
  // Some random lake in Ontario
  public static final GeoPosition ONTARIO = new GeoPosition(52.31384133253682, -85.23039497023031);

  // Map
  private JPanel mapContainer = new JPanel();
  private JXMapViewer mapViewer = new JXMapViewer();
  private MenuPanel menuPanel = new MenuPanel();
  private WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();

  // Sidebar
  private JPanel sideBar = new JPanel();

  JPanel universitySearchPanel = new JPanel();
  JTextField universitySearchField = new JTextField("Search Schools...");
  JButton universitySearchSubmit = new JButton();

  // Sidebar content
  JPanel sideBarContentPanel = new JPanel();
  JScrollPane sideBarContentScrollPane;

  JTextArea universityTitle = new JTextArea();
  JTextArea universityAddress = new JTextArea();

  JPanel programsPanel = new JPanel();
  JScrollPane programsScrollPane;

  public MapFrame() {
    menuPanel.setBounds(0, 0, 1280, 45);
    add(menuPanel);
    addMap();
    addSideBar();

    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("UniQuest - Map");
    setSize(1280, 720);
    setLocationRelativeTo(null);

    // setVisible(true);
  }

  public MenuPanel getMenuPanel() {
    return menuPanel;
  }

  public void setMenuPanel(MenuPanel menuPanel) {
    this.menuPanel = menuPanel;
  }

  // https://github.com/msteiger/jxmapviewer2/tree/master/examples/src
  private void addMap() {
    // Create a TileFactoryInfo for Virtual Earth
    // Tiles determine how the map looks
    TileFactoryInfo info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
    DefaultTileFactory tileFactory = new DefaultTileFactory(info);

    // Setup local file cache
    // Faster load times of the map
    File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
    tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

    // Setup the tileFactory
    mapViewer.setTileFactory(tileFactory);

    // Use 16 threads in parallel to load the tiles
    // So it's faster...
    tileFactory.setThreadPoolSize(16);

    // Set the focus
    mapViewer.setZoom(13);
    mapViewer.setAddressLocation(DataModel.UNIVERSITIES[0].getPosition());

    waypointPainter.setRenderer(new UniversityWaypointRenderer());

    mapViewer.setOverlayPainter(waypointPainter);

    // Adding the controls
    addMapControls();

    /* ==== Adding to the Container ==== */
    mapViewer.setBounds(2, 0, 1080, 700);

    mapContainer.add(mapViewer);

    mapContainer.setLayout(null);

    mapContainer.setBounds(198, 45, 1082, 675);
    mapContainer.setBackground(new Color(168, 168, 168, 255));
    add(mapContainer);
  }

  // Method to add mouse controls to the map
  private void addMapControls() {
    MouseInputListener mia = new PanMouseInputListener(mapViewer);
    mapViewer.addMouseListener(mia);
    mapViewer.addMouseMotionListener(mia);

    mapViewer.addMouseMotionListener(new CenterMapListener(mapViewer));

    mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));

    mapViewer.addKeyListener(new PanKeyListener(mapViewer));
  }

  public void addSideBar() {
    // sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.PAGE_AXIS));
    sideBar.setLayout(null);
    sideBar.setBounds(0, 45, 198, 675);
    sideBar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    sideBar.setBackground(Color.WHITE);

    addUniversitySearchBar();
    // sideBarContentPanel.setLayout(new BoxLayout(sideBarContentPanel,
    // BoxLayout.Y_AXIS));

    sideBarContentPanel.setBackground(Color.WHITE);

    // Create a top-aligned grid bag layout
    // https://stackoverflow.com/questions/23951882/how-to-align-the-elements-to-the-top-in-a-gridbaglayout
    GridBagLayout gbl = new GridBagLayout();
    sideBarContentPanel.setLayout(gbl);
    gbl.columnWidths = new int[] {0, 0, 0, 0};
    gbl.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl.columnWeights = new double[] {0.0, 0.0, 1.0, Double.MIN_VALUE};
    gbl.rowWeights =
        new double[] {
          0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
        };

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.gridx = 0;

    sideBarContentScrollPane = new JScrollPane(sideBarContentPanel);
    sideBarContentScrollPane.setBounds(24, 75, 150, 590);
    sideBarContentScrollPane.setPreferredSize(new Dimension(15, 590));
    sideBarContentScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    sideBarContentScrollPane.setHorizontalScrollBarPolicy(
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    sideBarContentScrollPane.setVerticalScrollBarPolicy(
        ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    sideBarContentScrollPane.getVerticalScrollBar().setUnitIncrement(20);

    // On first load: don't display the sideBar content
    // addSideBarContent();

    gbc.gridy = 0;
    sideBar.add(sideBarContentScrollPane, gbc);

    add(sideBar);
  }

  // University search bar
  public void addUniversitySearchBar() {
    universitySearchPanel.setBounds(24, 35, 150, 32);
    // universitySearchPanel.setPreferredSize(new Dimension(150,32));
    universitySearchPanel.setBackground(AppColors.LIGHT_GREEN);
    // Get rid of the border
    universitySearchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    universitySearchPanel.setLayout(null);

    // Search Field
    universitySearchField.setBounds(0, 0, 118, 32);
    universitySearchField.setOpaque(true);
    universitySearchField.setBackground(AppColors.LIGHT_GREEN);

    // Get rid of the borders and add some padding
    universitySearchField.setBorder(
        // Pass in values: top, left, bottom, right -> in this order
        // top: 0px, left: 5px, bottom: 0px, right: 5px
        BorderFactory.createEmptyBorder(0, 5, 0, 5));

    // Remove text when gained focus -> get's rid of default text
    universitySearchField.addFocusListener(
        new FocusListener() {
          // When the text field is just being typed in:
          public void focusGained(FocusEvent e) {
            if (universitySearchField.getText().equals("Search Schools..."))
              // Empty the filler text
              universitySearchField.setText("");
          }

          // When the text field is no longer being typed in
          public void focusLost(FocusEvent e) {
            // If the text is emtpy, reset the filler
            if (universitySearchField.getText().trim().isEmpty()) {
              universitySearchField.setText("Search Schools...");
            }
          }
        });

    GUIUtils.setFontRenderingHints(universitySearchField);

    // Submit button
    universitySearchSubmit.setIcon(new ImageIcon("assets/images/search.png"));
    universitySearchSubmit.setSelectedIcon(new ImageIcon("assets/images/search.png"));
    universitySearchSubmit.setBackground(AppColors.BUTTON_NORMAL);

    // Get rid of the border
    universitySearchSubmit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

    // Replace button styling
    universitySearchSubmit.setUI(new CustomButtonUI());
    universitySearchSubmit.setBounds(118, 0, 32, 32);

    universitySearchPanel.add(universitySearchField);
    universitySearchPanel.add(universitySearchSubmit);

    sideBar.add(universitySearchPanel);
  }

  public void addUniversityInfoGUI() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.gridx = 0;

    // Title and address
    // Set an arbitrary boundary
    // For some reason, this allows for dynamically-sized JTextAreas with fixed
    // width
    universityTitle.setBounds(0, 0, 150, 10);
    universityTitle.setText("York University");
    universityTitle.setFont(new Font("Sans Serif", Font.BOLD, 20));
    // So that text is contained and wrapped
    universityTitle.setLineWrap(true);
    universityTitle.setWrapStyleWord(true);
    universityTitle.setEditable(false);
    GUIUtils.setFontRenderingHints(universityTitle);
    gbc.gridy = 0;
    sideBarContentPanel.add(universityTitle, gbc);

    // Set an arbitrary boundary
    universityAddress.setBounds(0, 0, 150, 10);
    universityAddress.setText("200 University Ave W, Waterloo ON N2L 3G1, Canada");
    universityAddress.setFont(new Font("Sans Serif", Font.PLAIN, 14));
    universityAddress.setLineWrap(true);
    universityAddress.setWrapStyleWord(true);
    universityAddress.setEditable(false);
    GUIUtils.setFontRenderingHints(universityAddress);
    gbc.gridy = 1;
    sideBarContentPanel.add(universityTitle, gbc);
    gbc.gridy = 2;
    sideBarContentPanel.add(universityAddress, gbc);

    // Add programs

    GridBagLayout gbl = new GridBagLayout();
    programsPanel.setLayout(gbl);
    gbl.columnWidths = new int[] {0, 0, 0, 0};
    gbl.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl.columnWeights = new double[] {0.0, 0.0, 1.0, Double.MIN_VALUE};
    gbl.rowWeights =
        new double[] {
          0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
        };

    programsPanel.setBackground(AppColors.LIGHT_GREEN);
    programsScrollPane = new JScrollPane(programsPanel);
    programsScrollPane.setPreferredSize(new Dimension(150, 420));
    programsScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    programsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    programsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    programsScrollPane.getVerticalScrollBar().setUnitIncrement(20);
    gbc.gridy = 3;
    sideBarContentPanel.add(programsScrollPane, gbc);
  }

  public static GeoPosition getOntario() {
    return ONTARIO;
  }

  public JPanel getMapContainer() {
    return mapContainer;
  }

  public void setMapContainer(JPanel mapContainer) {
    this.mapContainer = mapContainer;
  }

  public JXMapViewer getMapViewer() {
    return mapViewer;
  }

  public void setMapViewer(JXMapViewer mapViewer) {
    this.mapViewer = mapViewer;
  }

  public WaypointPainter<Waypoint> getWaypointPainter() {
    return waypointPainter;
  }

  public void setWaypointPainter(WaypointPainter<Waypoint> waypointPainter) {
    this.waypointPainter = waypointPainter;
  }

  public JPanel getSideBar() {
    return sideBar;
  }

  public void setSideBar(JPanel sideBar) {
    this.sideBar = sideBar;
  }

  public JPanel getUniversitySearchPanel() {
    return universitySearchPanel;
  }

  public void setUniversitySearchPanel(JPanel universitySearchPanel) {
    this.universitySearchPanel = universitySearchPanel;
  }

  public JTextField getUniversitySearchField() {
    return universitySearchField;
  }

  public void setUniversitySearchField(JTextField universitySearchField) {
    this.universitySearchField = universitySearchField;
  }

  public JButton getUniversitySearchSubmit() {
    return universitySearchSubmit;
  }

  public void setUniversitySearchSubmit(JButton universitySearchSubmit) {
    this.universitySearchSubmit = universitySearchSubmit;
  }

  public JPanel getSideBarContentPanel() {
    return sideBarContentPanel;
  }

  public void setSideBarContentPanel(JPanel sideBarContentPanel) {
    this.sideBarContentPanel = sideBarContentPanel;
  }

  public JScrollPane getSideBarContentScrollPane() {
    return sideBarContentScrollPane;
  }

  public void setSideBarContentScrollPane(JScrollPane sideBarContentScrollPane) {
    this.sideBarContentScrollPane = sideBarContentScrollPane;
  }

  public JTextArea getUniversityTitle() {
    return universityTitle;
  }

  public void setUniversityTitle(JTextArea universityTitle) {
    this.universityTitle = universityTitle;
  }

  public JTextArea getUniversityAddress() {
    return universityAddress;
  }

  public void setUniversityAddress(JTextArea universityAddress) {
    this.universityAddress = universityAddress;
  }

  public JPanel getProgramsPanel() {
    return programsPanel;
  }

  public void setProgramsPanel(JPanel programsPanel) {
    this.programsPanel = programsPanel;
  }

  public JScrollPane getProgramsScrollPane() {
    return programsScrollPane;
  }

  public void setProgramsScrollPane(JScrollPane programsScrollPane) {
    this.programsScrollPane = programsScrollPane;
  }
}
