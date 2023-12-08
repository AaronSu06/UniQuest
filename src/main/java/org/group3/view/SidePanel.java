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
	
//	private JPanel utilityPanel = new JPanel();
//	private JButton confirmButton = new JButton("Confirm");
//	private JButton resetButton = new JButton("Reset");

	public SidePanel() {
//		GroupLayout gl = new GroupLayout(this);
		setLayout(new GridLayout(0,1));
//		setLayout(gl);
	
		
		
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
//		filterPanel.setLocation(0, 0);
		filterPanel.setBorder(border);
		
//		filterPanel.setPreferredSize(new Dimension(300,337));
		
		add(filterPanel);

//		sortPanel.setLocation(0, 337, 300, 337);
		sortPanel.setBorder(border);
//		sortPanel.setPreferredSize(new Dimension(300,337));
//		sortPanel.setPreferredSize(new Dimension(300,100));
//		sortPanel.setPreferredSize(new Dimension(300,377));
		add(sortPanel);
//		utilityPanel.setLayout(null);
//		confirmButton.setPreferredSize(new Dimension(300,50));
//		confirmButton.setBounds(0,0,300,50);
//		utilityPanel.add(confirmButton);
//		resetButton.setPreferredSize(new Dimension(300,50));
//		resetButton.setBounds(0,50,300,50);
//		utilityPanel.add(resetButton);
//		utilityPanel.setPreferredSize(new Dimension(300,100));
//		add(utilityPanel);
//		confirmButton.setPreferredSize(new Dimension(300,50));
//		confirmButton.setBorder(border);
//		add(confirmButton);
//		gl.setVerticalGroup(
//				gl.createParallelGroup()
//				.addGroup(gl.createParallelGroup())
//				.addComponent(filterPanel)
//				.addComponent(sortPanel)
//				.addComponent(confirmButton)
//				
//				);
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
