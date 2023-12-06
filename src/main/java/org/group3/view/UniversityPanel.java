package org.group3.view;
import java.awt.Color;

import javax.swing.*;

import org.group3.Main;
import org.group3.model.*;
public class UniversityPanel extends JPanel{
	private JLabel universityLabel = new JLabel();
	private JButton universityButton = new JButton();
	private UniversityProgram program;
	public UniversityPanel(UniversityProgram program) {
		super();
		this.program = program;
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		universityLabel.setText(program.getName());
		universityLabel.setBounds(20,0,200,50);
//		System.out.println(program.getName());
		add(universityLabel);
		
		universityButton.setBounds(0,50,250,250);
		add(universityButton);
		
	}
	public JLabel getUniversityLabel() {
		return universityLabel;
	}
	public void setUniversityLabel(JLabel universityLabel) {
		this.universityLabel = universityLabel;
	}
	public JButton getUniversityButton() {
		return universityButton;
	}
	public void setUniversityButton(JButton universityButton) {
		this.universityButton = universityButton;
	}
	public UniversityProgram getProgram() {
		return program;
	}
	public void setProgram(UniversityProgram program) {
		this.program = program;
	}
	

}
