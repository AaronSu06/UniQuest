package org.group3.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SidePanel extends JPanel {
	private FilterPanel filterPanel = new FilterPanel();
	private SortPanel sortPanel = new SortPanel();
	

	public SidePanel() {
//		GroupLayout gl = new GroupLayout(this);
		setLayout(new GridLayout(0,1));
//		setLayout(gl);
		setOpaque(false);
		
		
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		filterPanel.setBorder(border);
		
		
		add(filterPanel);
//
//		sortPanel.setBorder(border);
//		add(sortPanel);

	}

	public FilterPanel getFilterPanel() {
		return filterPanel;
	}

	public void setFilterPanel(FilterPanel filterPanel) {
		this.filterPanel = filterPanel;
	}

	public SortPanel getSortPanel() {
		return sortPanel;
	}

	public void setSortPanel(SortPanel sortPanel) {
		this.sortPanel = sortPanel;
	}

//	public JPanel getUtilityPanel() {
//		return utilityPanel;
//	}
//
//	public void setUtilityPanel(JPanel utilityPanel) {
//		this.utilityPanel = utilityPanel;
//	}
//
//	public JButton getConfirmButton() {
//		return confirmButton;
//	}
//
//	public void setConfirmButton(JButton confirmButton) {
//		this.confirmButton = confirmButton;
//	}
//
//	public JButton getResetButton() {
//		return resetButton;
//	}
//
//	public void setResetButton(JButton resetButton) {
//		this.resetButton = resetButton;
//	}
	
}
