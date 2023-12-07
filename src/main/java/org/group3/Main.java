package org.group3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import org.group3.controller.MapController;
import org.group3.model.DataModel;
import org.group3.model.UniversityProgram;

// Press Shift twice to open the Search Everywhere dialog and type `show
// whitespaces`, then press Enter. You can now see whitespace characters in your
// code.
public class Main {
  public static List<UniversityProgram> universityPrograms;
  public static void main(String[] args) {
    try {
      universityPrograms = DataModel.generateProgramList();
    } catch (Exception e) {
      System.out.println("Something went wrong...");
    }

    HashSet<String> universityNames = new HashSet<String>();

    for (UniversityProgram universityProgram : universityPrograms) {
      if (!universityNames.contains(universityProgram.getUniversity())) {
        universityNames.add(universityProgram.getUniversity());
      }
    }

    Gson gson =
        new GsonBuilder().setPrettyPrinting().create();
    String jsonString = gson.toJson(universityNames);

    try (FileWriter writer = new FileWriter("assets/data/universities.json")) {
      writer.write(jsonString);
      System.out.println("University names written");

    } catch (Exception e) {
      e.printStackTrace();
    }

    new MapController();
  }
}
