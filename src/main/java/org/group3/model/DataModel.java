package org.group3.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DataModel {
  public static final String universityProgramsPath =
      "assets/data/programs.json";

public static List<UniversityProgram> generateProgramList()
      throws IOException {
    FileReader reader = new FileReader(universityProgramsPath);

    Gson gson = new Gson();
    Type universityProgramListType =
        new TypeToken<List<UniversityProgram>>() {}.getType();

    List<UniversityProgram> universityProgramList =
        gson.fromJson(reader, universityProgramListType);

    for (UniversityProgram program : universityProgramList) {
      System.out.println(program);
    }

    System.out.println(universityProgramList.size());

    return universityProgramList;
  }
}
