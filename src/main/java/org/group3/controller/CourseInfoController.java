package org.group3.controller;

import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.group3.model.DataModel;
import org.group3.view.PersonalInfoFrame;

public class CourseInfoController implements ActionListener {
  private HashMap<String, String> courseInfo = new HashMap<String, String>();
  private String[] courseInfoKey = new String[6];

  // display the PersonalInfoFrame
  PersonalInfoFrame personalInfo = new PersonalInfoFrame();

  public CourseInfoController() {

    // add an action listener for only the saveBtn (information only saves when the
    // user clicks save)
    personalInfo.getSaveBtn().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // if the save button is pressed, save the information to the .json file
    if (e.getSource() == personalInfo.getSaveBtn()) {
      try {

        // clear the hashmap so no duplicates occur
        courseInfo.clear();

        // store the changes from the courseJPanel into an Array
        for (int i = 0; i < 6; i++) {
          courseInfo.put(
              personalInfo
                  .getCoursePanel()
                  .getCourse()[i]
                  .getCourseCode()
                  .getSelectedItem()
                  .toString(),
              personalInfo.getCoursePanel().getCourse()[i].getCourseMark().getText());
          courseInfoKey[i] =
              personalInfo
                  .getCoursePanel()
                  .getCourse()[i]
                  .getCourseCode()
                  .getSelectedItem()
                  .toString();
        }

        DataModel.generateUserCourseInfo(LoginController.user, courseInfo, courseInfoKey);
        JOptionPane.showMessageDialog(personalInfo, "Your Current Changes Have Been Saved.");

      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }
}
