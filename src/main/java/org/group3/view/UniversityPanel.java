package org.group3.view;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.group3.Main;
import org.group3.model.*;
public class UniversityPanel extends JPanel{
	private JLabel universityLabel = new JLabel();
	private JButton universityButton = new JButton();
	private UniversityProgram program;
	private ImageIcon image;
//	private JButton favouriteButton = new JButton(LogoInput.favouritingStar);
	public UniversityPanel(UniversityProgram program) {
		super();
		this.program = program;
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		universityLabel.setText(program.getName());
		universityLabel.setBounds(0,0,250,50);
		universityLabel.setBackground(new Color(159,226,135,100));
		universityLabel.setForeground(Color.BLACK);
		universityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		universityLabel.setOpaque(true);
		//		System.out.println(program.getName());
//		favouriteButton.setBounds(0,0,20,20);
		add(universityLabel);
		
		universityButton.setBounds(0,50,250,250);
//		universityButton.setIcon(imageIcon);
		add(universityButton);
		
	}
//	public JButton getFavouriteButton() {
//		return favouriteButton;
//	}
//	public void setFavouriteButton(JButton favouriteButton) {
//		this.favouriteButton = favouriteButton;
//	}
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
