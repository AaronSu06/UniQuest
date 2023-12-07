package org.group3.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import org.jxmapviewer.viewer.GeoPosition;

public class DataModel {
  public static final String UNIVERSITY_PROGRAMS_PATH =
      "assets/data/programs.json";

  public static final HashMap<String, GeoPosition> UNIVERSITY_POSITIONS;
  static {
    UNIVERSITY_POSITIONS = new HashMap<String, GeoPosition>();
    UNIVERSITY_POSITIONS.put(
        "Algoma University",
        new GeoPosition(43.68669407110449, -79.75940593144968));
    UNIVERSITY_POSITIONS.put(
        "York University",
        new GeoPosition(43.77344793665352, -79.50189935338739));
    UNIVERSITY_POSITIONS.put(
        "Western University – King's University College",
        new GeoPosition(43.011706858743935, -81.25721739871595));
    UNIVERSITY_POSITIONS.put(
        "McMaster University",
        new GeoPosition(43.26088009710997, -79.91922893934881));
    UNIVERSITY_POSITIONS.put(
        "Royal Military College of Canada",
        new GeoPosition(44.233881545737106, -76.46750875950771));
    UNIVERSITY_POSITIONS.put(
        "University of Toronto – Mississauga",
        new GeoPosition(43.54825860929522, -79.66268816261459));
    UNIVERSITY_POSITIONS.put(
        "University of Guelph",
        new GeoPosition(43.532720645047334, -80.22618100886704));
    UNIVERSITY_POSITIONS.put(
        "Wilfrid Laurier University – Brantford Campus",
        new GeoPosition(43.14084559390083, -80.26223269029506));
    UNIVERSITY_POSITIONS.put(
        "Trent University – Durham Greater Toronto Area",
        new GeoPosition(43.889674917729586, -78.89056586647283));
    UNIVERSITY_POSITIONS.put(
        "University of Guelph-Humber",
        new GeoPosition(43.728902890411284, -79.60656199427856));
    UNIVERSITY_POSITIONS.put(
        "Brock University",
        new GeoPosition(43.11814907331891, -79.24769660432592));
    UNIVERSITY_POSITIONS.put(
        "OCAD University",
        new GeoPosition(43.65318585701635, -79.39148400147934));
    UNIVERSITY_POSITIONS.put(
        "University of Ottawa – Saint Paul University",
        new GeoPosition(45.40789189454567, -75.67614200690913));
    UNIVERSITY_POSITIONS.put(
        "University of Toronto – Scarborough",
        new GeoPosition(43.783035412245525, -79.18738186236901));
    UNIVERSITY_POSITIONS.put(
        "University of Waterloo – St. Jerome's University",
        new GeoPosition(43.468880430706534, -80.54578215070134));
    UNIVERSITY_POSITIONS.put(
        "Nipissing University",
        new GeoPosition(46.341014395821695, -79.49083598587244));
    UNIVERSITY_POSITIONS.put(
        "Lakehead University",
        new GeoPosition(48.42139509425707, -89.2621642599358));
    UNIVERSITY_POSITIONS.put(
        "Western University – Huron University College",
        new GeoPosition(43.0089761578137, -81.27770417411553));
    UNIVERSITY_POSITIONS.put(
        "University of Windsor",
        new GeoPosition(42.30431433444339, -83.06604020531722));
    UNIVERSITY_POSITIONS.put(
        "University of Waterloo – Renison University College",
        new GeoPosition(43.469487191487154, -80.54767605800518));
    UNIVERSITY_POSITIONS.put(
        "Laurentian University",
        new GeoPosition(46.4672483200357, -80.97572905237301));
    UNIVERSITY_POSITIONS.put(
        "Ontario Tech University",
        new GeoPosition(43.94564536721211, -78.89678718630573));
    UNIVERSITY_POSITIONS.put(
        "Wilfrid Laurier University – Milton Campus",
        new GeoPosition(43.51713286017272, -79.90623809670255));
    UNIVERSITY_POSITIONS.put(
        "York University – Glendon Campus",
        new GeoPosition(43.72821320613832, -79.37803848667346));
    UNIVERSITY_POSITIONS.put(
        "Wilfrid Laurier University",
        new GeoPosition(43.47385148000482, -80.52747102931143));
    UNIVERSITY_POSITIONS.put(
        "Trent University",
        new GeoPosition(44.35588088991333, -78.29027792497294));
    UNIVERSITY_POSITIONS.put(
        "University of Toronto",
        new GeoPosition(43.6633849494926, -79.39600627751973));
    UNIVERSITY_POSITIONS.put(
        "Queen's University",
        new GeoPosition(44.225280178503276, -76.49514200181694));
    UNIVERSITY_POSITIONS.put(
        "University of Waterloo",
        new GeoPosition(43.47228729604354, -80.54485799160926));
    UNIVERSITY_POSITIONS.put(
        "Western University",
        new GeoPosition(43.00959711477564, -81.27373334666575));
    UNIVERSITY_POSITIONS.put(
        "Toronto Metropolitan University",
        new GeoPosition(43.657658114959986, -79.37880137021212));
    UNIVERSITY_POSITIONS.put(
        "Carleton University",
        new GeoPosition(45.387583828086406, -75.69601636917044));
    UNIVERSITY_POSITIONS.put(
        "University of Ottawa",
        new GeoPosition(45.42310569141703, -75.68313326028367));
  }

  public static List<UniversityProgram> generateProgramList()
      throws IOException {
    FileReader reader = new FileReader(UNIVERSITY_PROGRAMS_PATH);

    Gson gson = new Gson();
    Type universityProgramListType =
        new TypeToken<List<UniversityProgram>>() {}.getType();

    List<UniversityProgram> universityProgramList =
        gson.fromJson(reader, universityProgramListType);
    //
    // for (UniversityProgram program : universityProgramList) {
    //   // System.out.println(program);
    //   System.out.println(UNIVERSITY_POSITIONS.getOrDefault(
    //       program.getUniversity(), new GeoPosition(0, 0)));
    // }

    System.out.println(universityProgramList.size());

    return universityProgramList;
  }
}
