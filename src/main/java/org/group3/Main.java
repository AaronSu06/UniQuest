package org.group3;
import java.util.List;

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
