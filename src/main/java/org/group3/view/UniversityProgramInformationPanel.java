package org.group3.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import org.group3.controller.LoginController;
import org.group3.model.DataModel;
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

  private ArrayList<UniversityProgram> programList = new ArrayList<>();

  public UniversityProgramInformationPanel(UniversityProgram program) {

    // Setting the layout to a top-aligned GridBagLayout
    // The code to top-align the layout is from
    // https://stackoverflow.com/questions/23951882/how-to-align-the-elements-to-the-top-in-a-gridbaglayout
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
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    setLayout(gbl);
    nameTextArea.setColumns(43);
    nameTextArea.setText("Program: " + program.getName());
    nameTextArea.setLayout(null);
    nameTextArea.setLineWrap(true);
    nameTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(nameTextArea);
    gbc.gridy = 0;
    add(nameTextArea, gbc);

    universityTextArea.setColumns(43);
    universityTextArea.setText("University: " + program.getUniversity());
    universityTextArea.setLineWrap(true);
    universityTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(universityTextArea);
    gbc.gridy++;
    add(universityTextArea, gbc);

    degreeTextArea.setColumns(43);
    degreeTextArea.setText("Degree: " + program.getDegree());
    degreeTextArea.setLineWrap(true);
    degreeTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(degreeTextArea);
    gbc.gridy++;
    add(degreeTextArea, gbc);

    ouacProgramCodeButton.setColumns(43);
    ouacProgramCodeButton.setText("OUAC code: " + program.getOuacProgramCode());
    ouacProgramCodeButton.setForeground(new Color(0, 128, 0));
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

    gradeRangeTextArea.setColumns(43);
    gradeRangeTextArea.setText("Grade Range: " + program.getGradeRange());
    gradeRangeTextArea.setLineWrap(true);
    gradeRangeTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(gradeRangeTextArea);
    gbc.gridy++;
    add(gradeRangeTextArea, gbc);

    experientialLearningTextArea.setColumns(43);
    experientialLearningTextArea.setText(
        "Experiential Learning: " + program.getExperientialLearning());
    experientialLearningTextArea.setLineWrap(true);
    experientialLearningTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(experientialLearningTextArea);
    gbc.gridy++;
    add(experientialLearningTextArea, gbc);

    enrollmentTextArea.setColumns(43);
    enrollmentTextArea.setText("Enrollment: " + program.getEnrollment());
    enrollmentTextArea.setLineWrap(true);
    enrollmentTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(enrollmentTextArea);
    gbc.gridy++;
    add(enrollmentTextArea, gbc);

    instructionLanguageTextArea.setColumns(43);
    instructionLanguageTextArea.setText(
        "Instructional Language: " + program.getInstructionLanguage());
    instructionLanguageTextArea.setLineWrap(true);
    instructionLanguageTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(instructionLanguageTextArea);
    gbc.gridy++;
    add(instructionLanguageTextArea, gbc);

    prerequisiteTextAreaHeader.setColumns(43);
    GUIUtils.setFontRenderingHints(prerequisiteTextAreaHeader);
    gbc.gridy++;
    add(prerequisiteTextAreaHeader, gbc);

    for (String prereq : program.getPrerequisites()) {
      JTextArea prereqTextArea = new JTextArea(prereq);
      prereqTextArea.setColumns(43);
      prereqTextArea.setLineWrap(true);
      prereqTextArea.setWrapStyleWord(true);
      GUIUtils.setFontRenderingHints(prereqTextArea);

      prerequisitesTextAreaArray.add(prereqTextArea);
      prerequisitesTextAreaArray.getLast().setColumns(43);
      gbc.gridy++;
      add(prerequisitesTextAreaArray.getLast(), gbc);
    }

    if (program.getNotes() != null) {
      notesTextArea.setText("Notes: " + program.getNotes());
    } else {
      notesTextArea.setText("Notes: None");
    }

    notesTextArea.setColumns(43);
    notesTextArea.setLineWrap(true);
    notesTextArea.setWrapStyleWord(true);
    GUIUtils.setFontRenderingHints(notesTextArea);
    gbc.gridy++;
    add(notesTextArea, gbc);

    favouriteProgramButton.setText("Favourite");
    favouriteProgramButton.setHorizontalAlignment(SwingConstants.CENTER);

    // saves the program to the user's favourited
    favouriteProgramButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            if (!LoginController.user.equals(null)) {

              programList.add(program);
              System.out.println(programList);

              try {
                DataModel.generateUserProgram(LoginController.user, programList);

              } catch (IOException e1) {
                e1.printStackTrace();
              }
            }
          }
        });
    GUIUtils.setFontRenderingHints(favouriteProgramButton);
    gbc.gridy++;
    add(favouriteProgramButton, gbc);

    setBackground(Color.WHITE);
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
