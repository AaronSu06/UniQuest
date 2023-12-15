package org.group3.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import org.group3.model.UniversityProgram;

// class
public class UniversityProgramInformationPanel extends JPanel {
  // Fields
  private JTextArea nameTextArea = new JTextArea();
  private JTextArea universityTextArea = new JTextArea();
  private JTextArea degreeTextArea = new JTextArea();
  private JTextArea ouacProgramCodeButton = new JTextArea();
  private JTextArea gradeRangeTextArea = new JTextArea();
  private JTextArea experientialLearningTextArea = new JTextArea();
  private JTextArea enrollmentTextArea = new JTextArea();
  private JTextArea instructionLanguageTextArea = new JTextArea();
  private JTextArea prerequisiteTextAreaHeader = new JTextArea("Prerequisites:");
  private ArrayList<JTextArea> prerequisitesTextAreaArray = new ArrayList<JTextArea>();
  private JTextArea notesTextArea = new JTextArea();
  private JButton favouriteProgramButton = new JButton();

  public UniversityProgramInformationPanel(UniversityProgram program) {
    GridBagLayout gbl = new GridBagLayout();
    setLayout(gbl);
    gbl.columnWidths = new int[] {0, 0, 0, 0};
    gbl.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl.columnWeights = new double[] {0.0, 0.0, 1.0, Double.MIN_VALUE};
    gbl.rowWeights =
        new double[] {
          0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
        };

    GridBagConstraints gbc = new GridBagConstraints();
    // gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0, 0, 0, 0);
    gbc.gridx = 0;

    setLayout(gbl);
    nameTextArea.setColumns(50);
    nameTextArea.setText("Program: " + program.getName());
    nameTextArea.setPreferredSize(new Dimension(500, 50));
    nameTextArea.setLayout(null);
    nameTextArea.setLineWrap(true);
    nameTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(nameTextArea);
    gbc.gridy = 0;
    add(nameTextArea, gbc);

    universityTextArea.setColumns(50);
    universityTextArea.setText("University: " + program.getUniversity());
    universityTextArea.setPreferredSize(new Dimension(500, 50));
    universityTextArea.setLineWrap(true);
    universityTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(universityTextArea);
    gbc.gridy++;
    add(universityTextArea, gbc);

    degreeTextArea.setColumns(50);
    degreeTextArea.setText("Degree: " + program.getDegree());
    degreeTextArea.setPreferredSize(new Dimension(500, 50));
    degreeTextArea.setLineWrap(true);
    degreeTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(degreeTextArea);
    gbc.gridy++;
    add(degreeTextArea, gbc);

    ouacProgramCodeButton.setColumns(50);
    ouacProgramCodeButton.setText("OUAC code: " + program.getOuacProgramCode());
    ouacProgramCodeButton.setPreferredSize(new Dimension(500, 50));
    ouacProgramCodeButton.addMouseListener(
        new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent arg0) {
            String ouacCode = program.getOuacProgramCode();
            StringSelection selection = new StringSelection(ouacCode);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
            JOptionPane.showMessageDialog(null, "Code Copied!");
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
    gbc.gridy++;
    GUIUtils.setFontRenderingHints(ouacProgramCodeButton);
    add(ouacProgramCodeButton, gbc);

    gradeRangeTextArea.setColumns(50);
    gradeRangeTextArea.setText("Grade Range: " + program.getGradeRange());
    gradeRangeTextArea.setPreferredSize(new Dimension(500, 50));
    gradeRangeTextArea.setLineWrap(true);
    gradeRangeTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(gradeRangeTextArea);
    gbc.gridy++;
    add(gradeRangeTextArea, gbc);

    experientialLearningTextArea.setColumns(50);
    experientialLearningTextArea.setText(
        "Experiential Learning: " + program.getExperientialLearning());
    experientialLearningTextArea.setPreferredSize(new Dimension(500, 50));
    experientialLearningTextArea.setLineWrap(true);
    experientialLearningTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(experientialLearningTextArea);
    gbc.gridy++;
    add(experientialLearningTextArea, gbc);

    enrollmentTextArea.setColumns(50);
    enrollmentTextArea.setText("Enrollment: " + program.getEnrollment());
    enrollmentTextArea.setPreferredSize(new Dimension(500, 50));
    enrollmentTextArea.setLineWrap(true);
    enrollmentTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(enrollmentTextArea);
    gbc.gridy++;
    add(enrollmentTextArea, gbc);

    instructionLanguageTextArea.setColumns(50);
    instructionLanguageTextArea.setText(
        "Instructional Language: " + program.getInstructionLanguage());
    instructionLanguageTextArea.setPreferredSize(new Dimension(500, 50));
    instructionLanguageTextArea.setLineWrap(true);
    instructionLanguageTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(instructionLanguageTextArea);
    gbc.gridy++;
    add(instructionLanguageTextArea, gbc);

    prerequisiteTextAreaHeader.setColumns(50);
//    prerequisiteTextAreaHeader.setPreferredSize(new Dimension(500, 50));
    GUIUtils.setFontRenderingHints(prerequisiteTextAreaHeader);
    gbc.gridy++;
    add(prerequisiteTextAreaHeader, gbc);

    for (String prereq : program.getPrerequisites()) {
      JTextArea prereqTextArea = new JTextArea(prereq);
      prereqTextArea.setColumns(50);
      prereqTextArea.setLineWrap(true);
      prereqTextArea.setWrapStyleWord(true);
      GUIUtils.setFontRenderingHints(prereqTextArea);

      prerequisitesTextAreaArray.add(prereqTextArea);
      prerequisitesTextAreaArray.getLast().setPreferredSize(new Dimension(500, 50));
      gbc.gridy++;
      add(prerequisitesTextAreaArray.getLast(), gbc);
    }
    if (program.getNotes() != null) {
      notesTextArea.setText("Notes: " + program.getNotes());
    } else {
      notesTextArea.setText("Notes: None");
    }

    notesTextArea.setColumns(50);
    notesTextArea.setLineWrap(true);
    notesTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(notesTextArea);
    gbc.gridy++;
    add(notesTextArea, gbc);

    favouriteProgramButton.setText("Favourite Program");
    favouriteProgramButton.setPreferredSize(new Dimension(150, 50));
    favouriteProgramButton.setHorizontalAlignment(SwingConstants.CENTER);
    
//  saves the program to the user's favourited 
    favouriteProgramButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    });
    GUIUtils.setFontRenderingHints(favouriteProgramButton);
    gbc.gridy++;
    add(favouriteProgramButton, gbc);
  }

  public JTextArea getNameTextArea() {
    return nameTextArea;
  }

  public void setNameTextArea(JTextArea nameTextArea) {
    this.nameTextArea = nameTextArea;
  }

  public JTextArea getUniversityTextArea() {
    return universityTextArea;
  }

  public void setUniversityTextArea(JTextArea universityTextArea) {
    this.universityTextArea = universityTextArea;
  }

  public JTextArea getDegreeTextArea() {
    return degreeTextArea;
  }

  public void setDegreeTextArea(JTextArea degreeTextArea) {
    this.degreeTextArea = degreeTextArea;
  }

  public JTextArea getGradeRangeTextArea() {
    return gradeRangeTextArea;
  }

  public void setGradeRangeTextArea(JTextArea gradeRangeTextArea) {
    this.gradeRangeTextArea = gradeRangeTextArea;
  }

  public JTextArea getExperientialLearningTextArea() {
    return experientialLearningTextArea;
  }

  public void setExperientialLearningTextArea(JTextArea experientialLearningTextArea) {
    this.experientialLearningTextArea = experientialLearningTextArea;
  }

  public JTextArea getEnrollmentTextArea() {
    return enrollmentTextArea;
  }

  public void setEnrollmentTextArea(JTextArea enrollmentTextArea) {
    this.enrollmentTextArea = enrollmentTextArea;
  }

  public JTextArea getInstructionLanguageTextArea() {
    return instructionLanguageTextArea;
  }

  public void setInstructionLanguageTextArea(JTextArea instructionLanguageTextArea) {
    this.instructionLanguageTextArea = instructionLanguageTextArea;
  }

  public ArrayList<JTextArea> getPrerequisitesTextAreaArray() {
    return prerequisitesTextAreaArray;
  }

  public void setPrerequisitesTextAreaArray(ArrayList<JTextArea> prerequisitesTextAreaArray) {
    this.prerequisitesTextAreaArray = prerequisitesTextAreaArray;
  }

  public JTextArea getNotesTextArea() {
    return notesTextArea;
  }

  public void setNotesTextArea(JTextArea notesTextArea) {
    this.notesTextArea = notesTextArea;
  }
}
