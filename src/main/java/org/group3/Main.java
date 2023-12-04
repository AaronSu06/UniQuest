package org.group3;

import com.google.gson.Gson;
import org.group3.model.DataModel;

// Press Shift twice to open the Search Everywhere dialog and type `show
// whitespaces`, then press Enter. You can now see whitespace characters in your
// code.
public class Main {
  public static void main(String[] args) {
    try {
      DataModel.generateProgramList();
    } catch (Exception e) {
      System.out.println("Something went wrong...");
    }
  }
}
