package org.group3;

import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.controller.MainController;

public class Main {
  public static void main(String[] args) {
    try {
      DataModel.generateProgramArrayList();
      new LogoInput();
    } catch (Exception e) {
      e.printStackTrace();
    }
    new MainController();
  }
}
