package org.group3.view;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class SearchFrame extends JFrame {

  // private FilterPanel filterPanel = new FilterPanel();
  private MenuPanel menuPanel = new MenuPanel();
  // private SortPanel sortPanel = new SortPanel();
  // private JButton confirmButton = new JButton("Confirm");
  private SidePanel sidePanel = new SidePanel();
  private JTextField searchField = new JTextField("Search for program or university");
  private JScrollPane sideScrollPane = new JScrollPane(
      sidePanel,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  // private JScrollPane sortScrollPane = new JScrollPane(sortPanel,
  // JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
  // JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  private DisplayPanel displayPanel = new DisplayPanel();
  private JScrollPane displayScrollPane = new JScrollPane(
      displayPanel,
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

  public SearchFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setResizable(false);
    menuPanel.setBounds(0,0,1280,45);
    menuPanel.setBorder(border);
    add(menuPanel);
    searchField.setBounds(300, 45, 980, 45);
    // searchField.setBorder(border);
    searchField.setBackground(new Color(182, 215, 168));
    searchField.setOpaque(true);
    add(searchField);
    sideScrollPane.setBounds(0, 45, 300, 640);
    // sideScrollPane.setBorder(border);
    sideScrollPane.getVerticalScrollBar().setUnitIncrement(20);
    // sideScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    add(sideScrollPane);

    displayScrollPane.setBounds(300, 90, 965, 675);
    // displayScrollPane.setBorder(border);
    displayScrollPane.getVerticalScrollBar().setUnitIncrement(20);
    add(displayScrollPane);

    // displayPanel.setBounds(300,45,980,675);
    // displayPanel.setBorder(border);
    // add(displayPanel);

//    setVisible(true);
    repaint();
    revalidate();
  }

  // public FilterPanel getFilterPanel() {
  // return filterPanel;
  // }
  // public void setFilterPanel(FilterPanel filterPanel) {
  // this.filterPanel = filterPanel;
  // }
  public MenuPanel getMenuPanel() {
    return menuPanel;
  }

  public void setMenuPanel(MenuPanel menuPanel) {
    this.menuPanel = menuPanel;
  }

  // public SortPanel getSortPanel() {
  // return sortPanel;
  // }
  // public void setSortPanel(SortPanel sortPanel) {
  // this.sortPanel = sortPanel;
  // }

  public DisplayPanel getDisplayPanel() {
    return displayPanel;
  }

  public void setDisplayPanel(DisplayPanel displayPanel) {
    this.displayPanel = displayPanel;
  }

  public JScrollPane getDisplayScrollPane() {
    return displayScrollPane;
  }

  public void setDisplayScrollPane(JScrollPane displayScrollPane) {
    this.displayScrollPane = displayScrollPane;
  }

  public SidePanel getSidePanel() {
    return sidePanel;
  }

  public void setSidePanel(SidePanel sidePanel) {
    this.sidePanel = sidePanel;
  }

  public JTextField getSearchField() {
    return searchField;
  }

  public void setSearchField(JTextField searchField) {
    this.searchField = searchField;
  }

  public JScrollPane getSideScrollPane() {
    return sideScrollPane;
  }

  public void setSideScrollPane(JScrollPane sideScrollPane) {
    this.sideScrollPane = sideScrollPane;
  }
}
