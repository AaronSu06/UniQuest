package org.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
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

// https://github.com/msteiger/jxmapviewer2/tree/master/examples/src

public class MapFrame extends JFrame {
  // Some random lake in Ontario
  public static final GeoPosition ONTARIO =
      new GeoPosition(52.31384133253682, -85.23039497023031);

  // Map
  private JPanel mapContainer = new JPanel();
  private JXMapViewer mapViewer = new JXMapViewer();

  // Sidebar
  private JPanel sideBar = new JPanel();

  JPanel universitySearch = new JPanel();
  JTextField universitySearchField = new JTextField();
  JButton universitySearchSubmit = new JButton();

  JLabel universityName = new JLabel();

  public MapFrame() {
    addMap();
    addSideBar();

    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("UniQuest - Map");
    setSize(1280, 720);
    setVisible(true);
  }

  public void addMap() {
    // Create a TileFactoryInfo for Virtual Earth
    TileFactoryInfo info =
        new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
    DefaultTileFactory tileFactory = new DefaultTileFactory(info);

    // Setup local file cache
    File cacheDir = new File(System.getProperty("user.home") + File.separator +
                             ".jxmapviewer2");
    tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));

    // Setup JXMapViewer
    mapViewer.setTileFactory(tileFactory);

    // Use 16 threads in parallel to load the tiles
    // So it's faster...
    tileFactory.setThreadPoolSize(16);

    // Set the focus
    mapViewer.setZoom(13);
    mapViewer.setAddressLocation(ONTARIO);

    // Adding the controls
    addMapControls();

    /* ==== Adding to the Container ==== */
    mapViewer.setBounds(2, 0, 1080, 720);

    mapContainer.add(mapViewer);

    mapContainer.setLayout(null);

    mapContainer.setBounds(198, 0, 1082, 720);
    mapContainer.setBackground(new Color(168, 168, 168, 255));
    add(mapContainer);
  }

  // Method to add mouse controls to the map
  public void addMapControls() {
    MouseInputListener mia = new PanMouseInputListener(mapViewer);
    mapViewer.addMouseListener(mia);
    mapViewer.addMouseMotionListener(mia);

    mapViewer.addMouseMotionListener(new CenterMapListener(mapViewer));

    mapViewer.addMouseWheelListener(
        new ZoomMouseWheelListenerCursor(mapViewer));

    mapViewer.addKeyListener(new PanKeyListener(mapViewer));
  }

  public void addSideBar() {
    sideBar.setLayout(null);
    sideBar.setBounds(0, 0, 198, 720);
    sideBar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    sideBar.setBackground(Color.WHITE);

    addUniversitySearchBar();

    add(sideBar);
  }

  // University search bar
  public void addUniversitySearchBar() {
    universitySearch.setBounds(24, 16, 150, 32);
    universitySearch.setBackground(AppColors.LIGHT_GREEN);
    universitySearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    universitySearch.setLayout(null);

    universitySearchField.setBounds(0, 0, 118, 32);
    universitySearchField.setOpaque(false);
    universitySearchField.setBorder(
        BorderFactory.createEmptyBorder(5, 5, 0, 5));
    universitySearchField.setCaret(new DefaultCaret());
    universitySearchField.setCaretPosition(0);

    universitySearchSubmit.setIcon(new ImageIcon("assets/images/search.png"));
    universitySearchSubmit.setSelectedIcon(
        new ImageIcon("assets/images/search.png"));
    universitySearchSubmit.setBackground(AppColors.MUTED_GREEN);
    universitySearchSubmit.setBorder(
        BorderFactory.createEmptyBorder(0, 0, 0, 0));
    universitySearchSubmit.setUI(new CustomButtonUI());
    universitySearchSubmit.setBounds(118, 0, 32, 32);
    universitySearchSubmit.addActionListener(
        (e) -> System.out.println("Hi (Submit University)"));

    universitySearch.add(universitySearchField);
    universitySearch.add(universitySearchSubmit);

    sideBar.add(universitySearch);
  }
}
