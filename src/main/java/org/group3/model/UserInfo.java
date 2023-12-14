package org.group3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInfo {

  private String username;

  // SO THATS THE PROBLEM
  private ArrayList<UniversityProgram> favouritedPrograms;
  private ArrayList<University> favouritedUniverisites;

  private HashMap<String, String> courseInfo = new HashMap<String, String>();

  public UserInfo(
      String username,
      ArrayList<UniversityProgram> favouritedPrograms,
      ArrayList<University> favouritedUniverisites,
      HashMap<String, String> courseInfo,
      String[] keyArr) {
    super();
    this.username = username;
    this.favouritedPrograms = favouritedPrograms;
    this.favouritedUniverisites = favouritedUniverisites;

    for (int i = 0; i < keyArr.length; i++) {
      if (courseInfo.get(keyArr[i]) != null) {
        this.courseInfo.put(keyArr[i], courseInfo.get(keyArr[i]));
      }
    }
  }

  public HashMap<String, String> getCourseInfo() {
    return courseInfo;
  }

  public void setCourseInfo(HashMap<String, String> courseInfo) {
    this.courseInfo = courseInfo;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<UniversityProgram> getFavouritedPrograms() {
    return favouritedPrograms;
  }

  public void setFavouritedPrograms(ArrayList<UniversityProgram> favouritedPrograms) {
    this.favouritedPrograms = favouritedPrograms;
  }

  public List<University> getFavouritedUniverisites() {
    return favouritedUniverisites;
  }

  public void setFavouritedUniverisites(ArrayList<University> favouritedUniverisites) {
    this.favouritedUniverisites = favouritedUniverisites;
  }

  @Override
  public String toString() {
    return "UserInfo [username=" + username + ", courseInfo=" + courseInfo + "]";
  }
}
