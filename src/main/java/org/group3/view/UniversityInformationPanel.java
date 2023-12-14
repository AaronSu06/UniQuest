package org.group3.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.group3.controller.LoginController;
import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.model.UniversityProgram;
import org.group3.model.UserInfo;

public class UniversityInformationPanel extends JPanel {
	private JLabel nameLabel=new JLabel();
	private JLabel universityLabel=new JLabel();
	private JLabel degreeLabel=new JLabel();
	private JButton ouacProgramCodeButton = new JButton();
	private JLabel gradeRangeLabel=new JLabel();
	private JLabel experientialLearningLabel=new JLabel();
	private JLabel enrollmentLabel=new JLabel();
	private JLabel instructionLanguageLabel=new JLabel();
	private JLabel prerequisiteLabelHeader = new JLabel("Prerequisites:");
	private ArrayList<JLabel> prerequisitesLabelArray=new ArrayList<JLabel>();
	private JLabel notesLabel=new JLabel();
	private JButton favouriteUniversityButton = new JButton(LogoInput.favouritingStar);
	private JButton favouriteProgramButton = new JButton(LogoInput.favouritingStar);

	public UniversityInformationPanel(UniversityProgram program) {
		setLayout(new GridLayout(0,1));
		nameLabel.setText("Program: "+program.getName());
		nameLabel.setPreferredSize(new Dimension(500,50));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setLayout(null);
		favouriteProgramButton.setBounds(480,0,20,20);
		favouriteProgramButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for(UserInfo user:DataModel.getUserInformation()) {
						if(user.getUsername().equals(LoginController.user)) {
							
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		nameLabel.add(favouriteProgramButton);
		add(nameLabel);
		universityLabel.setText("University: "+program.getUniversity());
		universityLabel.setPreferredSize(new Dimension(500,50));
		universityLabel.setHorizontalAlignment(SwingConstants.LEFT);
		favouriteUniversityButton.setBounds(480,0,20,20);
		favouriteUniversityButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					for(UserInfo user:DataModel.getUserInformation()) {
						if(user.getUsername().equals(LoginController.user)) {
							
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		universityLabel.add(favouriteUniversityButton);
		nameLabel.add(favouriteProgramButton);

		add(universityLabel);
		degreeLabel.setText("Degree: "+program.getDegree());
		degreeLabel.setPreferredSize(new Dimension(500,50));
		degreeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(degreeLabel);
		ouacProgramCodeButton.setText("OUAC code: "+program.getOuacProgramCode());
		ouacProgramCodeButton.setPreferredSize(new Dimension(500,50));
		ouacProgramCodeButton.setHorizontalAlignment(SwingConstants.LEFT);
		ouacProgramCodeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String ouacCode = program.getOuacProgramCode();
				StringSelection selection = new StringSelection(ouacCode);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, null);
				JOptionPane.showMessageDialog(null, "Code Copied!");
			}
			
		});
		add(ouacProgramCodeButton);
		gradeRangeLabel.setText("Grade Range: "+program.getGradeRange());
		gradeRangeLabel.setPreferredSize(new Dimension(500,50));
		gradeRangeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(gradeRangeLabel);
		experientialLearningLabel.setText("Experientail Learning: "+program.getExperientialLearning());
		experientialLearningLabel.setPreferredSize(new Dimension(500,50));
		experientialLearningLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(experientialLearningLabel);
		enrollmentLabel.setText("Enrollment: "+program.getEnrollment());
		enrollmentLabel.setPreferredSize(new Dimension(500,50));
		enrollmentLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(enrollmentLabel);
		instructionLanguageLabel.setText("Instructional Language: "+program.getInstructionLanguage());
		instructionLanguageLabel.setPreferredSize(new Dimension(500,50));
		instructionLanguageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(instructionLanguageLabel);
		prerequisiteLabelHeader.setPreferredSize(new Dimension(500,50));
		prerequisiteLabelHeader.setHorizontalAlignment(SwingConstants.LEFT);
		add(prerequisiteLabelHeader);
		for(String prereq:program.getPrerequisites()) {
			prerequisitesLabelArray.add(new JLabel(prereq));
			prerequisitesLabelArray.getLast().setPreferredSize(new Dimension(500,50));
			prerequisitesLabelArray.getLast().setHorizontalAlignment(SwingConstants.LEFT);
			add(prerequisitesLabelArray.getLast());
			
		}
		if(program.getNotes()!=null) {
			notesLabel.setText("Notes: "+program.getNotes());

		}else {
			notesLabel.setText("Notes: None");
		}
		notesLabel.setPreferredSize(new Dimension(500,50));
		notesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(notesLabel);
		
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getUniversityLabel() {
		return universityLabel;
	}

	public void setUniversityLabel(JLabel universityLabel) {
		this.universityLabel = universityLabel;
	}

	public JLabel getDegreeLabel() {
		return degreeLabel;
	}

	public void setDegreeLabel(JLabel degreeLabel) {
		this.degreeLabel = degreeLabel;
	}

	public JButton getOuacProgramCodeButton() {
		return ouacProgramCodeButton;
	}

	public void setOuacProgramCodeButton(JButton ouacProgramCodeButton) {
		this.ouacProgramCodeButton = ouacProgramCodeButton;
	}

	public JLabel getGradeRangeLabel() {
		return gradeRangeLabel;
	}

	public void setGradeRangeLabel(JLabel gradeRangeLabel) {
		this.gradeRangeLabel = gradeRangeLabel;
	}

	public JLabel getExperientialLearningLabel() {
		return experientialLearningLabel;
	}

	public void setExperientialLearningLabel(JLabel experientialLearningLabel) {
		this.experientialLearningLabel = experientialLearningLabel;
	}

	public JLabel getEnrollmentLabel() {
		return enrollmentLabel;
	}

	public void setEnrollmentLabel(JLabel enrollmentLabel) {
		this.enrollmentLabel = enrollmentLabel;
	}

	public JLabel getInstructionLanguageLabel() {
		return instructionLanguageLabel;
	}

	public void setInstructionLanguageLabel(JLabel instructionLanguageLabel) {
		this.instructionLanguageLabel = instructionLanguageLabel;
	}

	public ArrayList<JLabel> getPrerequisitesLabelArray() {
		return prerequisitesLabelArray;
	}

	public void setPrerequisitesLabelArray(ArrayList<JLabel> prerequisitesLabelArray) {
		this.prerequisitesLabelArray = prerequisitesLabelArray;
	}

	public JLabel getNotesLabel() {
		return notesLabel;
	}

	public void setNotesLabel(JLabel notesLabel) {
		this.notesLabel = notesLabel;
	}
	
}
