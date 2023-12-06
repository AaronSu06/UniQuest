package org.group3;
import java.util.List;

import org.group3.controller.SearchFrameController;
import org.group3.model.*;
import com.google.gson.Gson;
import org.group3.model.DataModel;
import org.group3.view.SearchFrame;

// Press Shift twice to open the Search Everywhere dialog and type `show
// whitespaces`, then press Enter. You can now see whitespace characters in your
// code.
public class Main {
	public static List<UniversityProgram> programList;
  public static void main(String[] args) {
    try {
      programList = DataModel.generateProgramList();
    } catch (Exception e) {
      System.out.println("Something went wrong...");
    }
//    new SearchFrame();
    	new SearchFrameController();
  }
}
