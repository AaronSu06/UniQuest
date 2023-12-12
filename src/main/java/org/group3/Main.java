package org.group3;

import org.group3.model.DataModel;
import org.group3.model.LogoInput;

public class Main {
	public static LogoInput logoInput;
  public static void main(String[] args) {
    try {
      DataModel.generateProgramArrayList();
      logoInput=new LogoInput();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
