package org.group3.view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import org.group3.controller.LoginController;
import org.group3.model.DataModel;
import org.group3.model.UserInfo;

public class CourseJPanel extends JPanel {

  List<UserInfo> userInfoList = null;
  ArrayList<String> keyArr = new ArrayList<String>();

  private JLabel courseHeader = new JLabel("Course Information");
  private JLabel programHeader = new JLabel("Preferred Programs");
  private JLabel universityHeader = new JLabel("Preferred Universities");
  private JLabel[] courseNum = new JLabel[6];
  private CourseObjJPanel[] course = new CourseObjJPanel[6];

  public CourseJPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // set font and size of all components in the JFrame
    courseHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));
    programHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));
    universityHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));

    // used to center within the frame
    courseHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
    programHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
    universityHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

    // initially set the header
    add(courseHeader);
    add(Box.createRigidArea(new Dimension(0, 10)));

    // add the course JLabels and course JTextFields to the JFrame
    for (int i = 0; i < 6; i++) {
      courseNum[i] = new JLabel();
      courseNum[i].setAlignmentX(Component.CENTER_ALIGNMENT);
      courseNum[i].setFont(new Font("Sans Serif", Font.BOLD, 22));
      courseNum[i].setText("Course #" + (i + 1));
      add(courseNum[i]);

      course[i] = new CourseObjJPanel();
      course[i].setAlignmentX(Component.CENTER_ALIGNMENT);

      // add it to the JPanel
      add(course[i]);
    }

    // replace default information with saved information for that user (if
    // possible)
    try {
      // get the saved user information
      userInfoList = DataModel.getUserInformation();
    } catch (IOException e) {
      // This is for the IOException from DataMode.getUserInformation(), not for the
      // Gson
      e.printStackTrace();
      return;
    }

    // if not null, as in a file exists
    if (userInfoList != null) {

      // loop through the saved user information list
      for (UserInfo userInfo : userInfoList) {

        // check if the username matches that of the username from the saved information
        if (!(LoginController.user.equals(null))
            && LoginController.user.equals(userInfo.getUsername())) {
          fillCourseArr(userInfo);
          changeCourseInfo(userInfo);
        }
      }
    }
  }

  public JLabel[] getCourseNum() {
    return courseNum;
  }

  public void setCourseNum(JLabel[] courseNum) {
    this.courseNum = courseNum;
  }

  public CourseObjJPanel[] getCourse() {
    return course;
  }

  public void setCourse(CourseObjJPanel[] course) {
    this.course = course;
  }

  // fill a string array with the hashmap key values
  private void fillCourseArr(UserInfo userInfo) {
    for (Map.Entry<String, String> m : userInfo.getCourseInfo().entrySet()) {
      keyArr.add(m.getKey());
    }
  }

  // display the course information
  public void changeCourseInfo(UserInfo userInfo) {
    for (int i = 0; i < 6; i++) {
      course[i].getCourseCode().setSelectedItem(keyArr.get(i));
      course[i].getCourseMark().setText(userInfo.getCourseInfo().get(keyArr.get(i)));
    }
  }
}
