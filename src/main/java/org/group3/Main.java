package org.group3;

import org.group3.model.DataModel;

public class Main {
  public static void main(String[] args) {
    try {
      DataModel.generateProgramArrayList();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
