package org.group3;

import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.view.SearchFrame;
import org.group3.controller.LoginController;
import org.group3.controller.MainController;
import org.group3.controller.MapController;
import org.group3.controller.SearchFrameController;

public class Main {
	public static LogoInput logoInput;
  public static void main(String[] args) {
    try {
      DataModel.generateProgramArrayList();
      logoInput=new LogoInput();
    } catch (Exception e) {
      e.printStackTrace();
    }
<<<<<<< Updated upstream
    new MainController();
=======
    
    new LoginController();
//    new CourseInfoController();
>>>>>>> Stashed changes
  }
}
