package org.group3.view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;

public class SearchFrame extends JFrame {

	private FilterPanel filterPanel = new FilterPanel();
	private MenuPanel menuPanel = new MenuPanel();
	private SortPanel sortPanel = new SortPanel();
	private JScrollPane sortScrollPane = new JScrollPane(sortPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	private DisplayPanel displayPanel = new DisplayPanel();
	private JScrollPane displayScrollPane = new JScrollPane(displayPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	public SearchFrame() {
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		setSize(1280,720);
		menuPanel.setBounds(0,0,1280,45);
		menuPanel.setBorder(border);
		add(menuPanel);
		
		filterPanel.setBounds(0,45,300,337);
		filterPanel.setBorder(border);
		add(filterPanel);
		
//		sortPanel.setBounds(0,382,300,337);
//		sortPanel.setBorder(border);
//		add(sortPanel);
		
		sortScrollPane.setBounds(0,382,300,337);
		sortScrollPane.setBorder(border);
		sortScrollPane.getVerticalScrollBar().setUnitIncrement(4);
		add(sortScrollPane);
//		displayPanel.setBounds(300,45,980,675);
		
		displayScrollPane.setBounds(300,45,980,675);
		displayScrollPane.setBorder(border);
		displayScrollPane.getVerticalScrollBar().setUnitIncrement(20);
		add(displayScrollPane);
		
//		displayPanel.setBounds(300,45,980,675);
//		displayPanel.setBorder(border);
//		add(displayPanel);
		
		setVisible(true);
		repaint();
		revalidate();
		
		
	}
	public FilterPanel getFilterPanel() {
		return filterPanel;
	}
	public void setFilterPanel(FilterPanel filterPanel) {
		this.filterPanel = filterPanel;
	}
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}
	public SortPanel getSortPanel() {
		return sortPanel;
	}
	public void setSortPanel(SortPanel sortPanel) {
		this.sortPanel = sortPanel;
	}
	public JScrollPane getSortScrollPane() {
		return sortScrollPane;
	}
	public void setSortScrollPane(JScrollPane sortScrollPane) {
		this.sortScrollPane = sortScrollPane;
	}
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
	
}
