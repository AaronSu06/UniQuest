/* Aaron Su, Kevin
 *
 */

package org.group3.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jxmapviewer.viewer.GeoPosition;

/*
 * Class for handling the data of our app: Follows the CRUD (Create retrieve update destroy) pattern
 * */
public class DataModel {
  public static final String UNIVERSITY_PROGRAMS_PATH = "assets/data/programs.json";
  public static final String USER_ACCOUNT_PATH = "assets/data/userAccount.json";
  public static final String USER_INFO_PATH = "assets/data/userInfo.json";
  public static final String USER_PROGRAM_PATH = "assets/data/userSavedProgram.json";
  public static final String USER_UNI_PATH = "assets/data/userSavedUni.json";

  // Data creation: generating all of the universities
  public static final University[] UNIVERSITIES =
      new University[] {
        new University(
            "Algoma University",
            new GeoPosition(43.68669407110449, -79.75940593144968),
            "24 Queen St E Suite 102/103, Brampton, ON L6V 1A3"),
        new University(
            "York University",
            new GeoPosition(43.77344793665352, -79.50189935338739),
            "4700 Keele St, Toronto, ON M3J 1P3"),
        new University(
            "Western University – King's University College",
            new GeoPosition(43.011706858743935, -81.25721739871595),
            "266 Epworth Ave, London, ON N6A 2M3"),
        new University(
            "McMaster University",
            new GeoPosition(43.26088009710997, -79.91922893934881),
            "1280 Main St W, Hamilton, ON L8S 4L8"),
        new University(
            "Royal Military College of Canada",
            new GeoPosition(44.233881545737106, -76.46750875950771),
            "13 General Crerar Crescent, Kingston, ON K7K 7B4"),
        new University(
            "University of Toronto – Mississauga",
            new GeoPosition(43.54825860929522, -79.66268816261459),
            "3359 Mississauga Rd, Mississauga, ON L5L 1C6"),
        new University(
            "University of Guelph",
            new GeoPosition(43.532720645047334, -80.22618100886704),
            "50 Stone Rd E, Guelph, ON N1G 2W1"),
        new University(
            "Wilfrid Laurier University – Brantford Campus",
            new GeoPosition(43.14084559390083, -80.26223269029506),
            "73 George St, Brantford, ON N3T 2Y3"),
        new University(
            "Trent University – Durham Greater Toronto Area",
            new GeoPosition(43.889674917729586, -78.89056586647283),
            "55 Thornton Rd S, Oshawa, ON L1J 5Y1"),
        new University(
            "University of Toronto – Scarborough",
            new GeoPosition(43.783035412245525, -79.18738186236901),
            "1265 Military Trail, Scarborough, ON M1C 1A4"),
        new University(
            "University of Waterloo – St. Jerome's University",
            new GeoPosition(43.468880430706534, -80.54578215070134),
            "290 Westmount Rd N, Waterloo, ON N2L 3G3"),
        new University(
            "Nipissing University",
            new GeoPosition(46.34101422149974, -79.49083181203889),
            "100 College Dr, North Bay, ON P1B 8L7"),
        new University(
            "Lakehead University",
            new GeoPosition(48.42111170787049, -89.26069787520397),
            "955 Oliver Rd, Thunder Bay, ON P7B 5E1"),
        new University(
            "Western University – Huron University College",
            new GeoPosition(43.0089761578137, -81.27770417411553),
            "1349 Western Rd, London, ON N6G 1H3"),
        new University(
            "University of Windsor",
            new GeoPosition(42.30431433444339, -83.06604020531722),
            "401 Sunset Ave, Windsor, ON N9B 3P4"),
        new University(
            "University of Waterloo – Renison University College",
            new GeoPosition(43.469487191487154, -80.54767605800518),
            "240 Westmount Rd N, Waterloo, ON N2L 3G4"),
        new University(
            "Laurentian University",
            new GeoPosition(46.4672483200357, -80.97572905237301),
            "935 Ramsey Lake Rd, Sudbury, ON P3E 2C6"),
        new University(
            "Ontario Tech University",
            new GeoPosition(43.94564536721211, -78.89678718630573),
            "2000 Simcoe St N, Oshawa, ON L1G 0C5"),
        new University(
            "Wilfrid Laurier University – Milton Campus",
            new GeoPosition(43.51713286017272, -79.90623809670255),
            "555 Industrial Dr, Milton, ON L9T 5E1"),
        new University(
            "York University – Glendon Campus",
            new GeoPosition(43.72821320613832, -79.37803848667346),
            "2275 Bayview Ave, North York, ON M4N 3M6"),
        new University(
            "Wilfrid Laurier University",
            new GeoPosition(43.47385206789465, -80.5274677450519),
            "75 University Ave W, Waterloo, ON N2L 3C5"),
        new University(
            "Trent University",
            new GeoPosition(44.35588088991333, -78.29027792497294),
            "1600 W Bank Dr, Peterborough, ON K9L 0G2"),
        new University(
            "University of Toronto",
            new GeoPosition(43.6633849494926, -79.39600627751973),
            "27 King's College Cir, Toronto, ON M5S 1A1"),
        new University(
            "Queen's University",
            new GeoPosition(44.225280178503276, -76.49514200181694),
            "99 University Ave, Kingston, ON K7L 3N6"),
        new University(
            "University of Waterloo",
            new GeoPosition(43.47228729604354, -80.54485799160926),
            "200 University Ave W, Waterloo, ON N2L 3G1"),
        new University(
            "Western University",
            new GeoPosition(43.00959711477564, -81.27373334666575),
            "1151 Richmond St, London, ON N6A 3K7"),
        new University(
            "Toronto Metropolitan University",
            new GeoPosition(43.657658114959986, -79.37880137021212),
            "350 Victoria St, Toronto, ON M5B 2K3"),
        new University(
            "Carleton University",
            new GeoPosition(45.387583828086406, -75.69601636917044),
            "1125 Colonel By Dr, Ottawa, ON K1S 5B6"),
        new University(
            "University of Ottawa",
            new GeoPosition(45.42310569141703, -75.68313326028367),
            "75 Laurier Ave E, Ottawa, ON K1N 6N5"),
        new University(
            "OCAD University",
            new GeoPosition(43.65318514660098, -79.39148463108539),
            "100 McCaul St, Toronto, ON M5T 1W1"),
        new University(
            "Brock University",
            new GeoPosition(43.118133965949355, -79.24768682535174),
            "1812 Sir Isaac Brock Way, St. Catharines, ON L2S 3A1"),
        new University(
            "University of Guelph-Humber",
            new GeoPosition(43.72797139577033, -79.6060059157344),
            "207 Humber College Blvd, Etobicoke, ON M9W 5L7"),
        new University(
            "University of Ottawa – Saint Paul University",
            new GeoPosition(45.40789036638955, -75.67614447576598),
            "223 Main St, Ottawa, ON K1S 1C4")
      };

  public static ArrayList<UniversityProgram> universityProgramArrayList;
  public static ArrayList<UniversityProgram> favouritedProgramArrayList = new ArrayList<>();

  /*
   * === Database Creation Methods ===
   */

  /**
   * Generates all of the university programs needed for our app
   *
   * @throws Exception when the file is not found, or when any error occurs when reading the json
   *     file
   */
  public static void generateProgramArrayList() throws Exception {
    FileReader reader = new FileReader(UNIVERSITY_PROGRAMS_PATH);

    Gson gson = new Gson();
    Type universityProgramArrayListType =
        new TypeToken<ArrayList<UniversityProgram>>() {}.getType();

    universityProgramArrayList = gson.fromJson(reader, universityProgramArrayListType);
    for (UniversityProgram universityProgram : universityProgramArrayList) {
      University university = findUniversitySpecific(universityProgram.getUniversity());
      if (university == null) {
        System.out.println(universityProgram);
      }
      university.getPrograms().add(universityProgram);
    }
  }

  /*
   * === Retrieval Methods ===
   */

  /**
   * @param universityName The exact name of the university to find
   * @return the {@code University} associated with univeristyName
   */
  public static University findUniversitySpecific(String universityName) {
    for (University university : UNIVERSITIES) {
      if (university.getName().equals(universityName)) {
        return university;
      }
    }
    return null;
  }

  public static ArrayList<University> findUniversityByKeyword(String keyword) {
    keyword = keyword.toLowerCase();
    ArrayList<University> results = new ArrayList<University>();
    for (University university : UNIVERSITIES) {
      if (university.getName().toLowerCase().contains(keyword)) results.add(university);
    }
    return results;
  }

  // INFORMATION FOR USER ACCOUNT
  public static void generateUserAccount(String username, String password) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    ArrayList<UserAccount> users = new ArrayList<UserAccount>();

    // get the user information stored in the .json file so that we don't overwrite
    // it (if it exists)
    List<UserAccount> userAccountList = getUserAccounts();

    // if not null, as in a file exists, add it to the user ArrayList
    if (userAccountList.size() > 0) {
      for (UserAccount userInfo : userAccountList) {
        users.add(userInfo);
      }
    }

    // add the current user information to the user ArrayList
    users.add(new UserAccount(username, password));

    // read and write to the .json file
    String jsonString = gson.toJson(users);
    try (FileWriter writer = new FileWriter(USER_ACCOUNT_PATH)) {
      writer.write(jsonString);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<UserAccount> getUserAccounts() throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(USER_ACCOUNT_PATH);

    // try to fetch the information in the specified file path from the .json file
    try {
      Type userInfoListType = new TypeToken<List<UserAccount>>() {}.getType();

      List<UserAccount> userInfoList = gson.fromJson(reader, userInfoListType);

      return userInfoList;

    } catch (Exception e) {
      return null;
    }
  }

  // INFORMATION FOR USER COURSES
  public static void generateUserInfo(
      String username, HashMap<String, String> courseInfo, String[] keyArr) throws IOException {

    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    ArrayList<UserInfo> users = new ArrayList<UserInfo>();

    // get the user information stored in the .json file so that we don't overwrite
    // it (if it exists)
    List<UserInfo> userInfoList = getUserInformation();

    // if not null, as in a file exists, add it to the user ArrayList
    if (userInfoList.size() > 0) {
      for (UserInfo userInfo : userInfoList) {

        // if the user already has existing information saved, don't add the information
        // so that we won't have duplicates of the same user
        if (!(userInfo.getUsername().equals(username))) {
          users.add(userInfo);
        }
      }
    }

    // add the current user information to the user ArrayList
    users.add(new UserInfo(username, courseInfo, keyArr));

    // read and write to the .json file
    String jsonString = gson.toJson(users);
    try (FileWriter writer = new FileWriter(USER_INFO_PATH)) {
      writer.write(jsonString);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<UserInfo> getUserInformation() throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(USER_INFO_PATH);

    // try to fetch the information in the specified file path from the .json file
    try {
      Type userInfoListType = new TypeToken<List<UserInfo>>() {}.getType();

      List<UserInfo> userInfoList = gson.fromJson(reader, userInfoListType);

      return userInfoList;

    } catch (Exception e) {
      return null;
    }
  }

  // INFORMATION FOR PREFERRED PROGRAMS
  public static void generateUserProgram(String username, ArrayList<UniversityProgram> program)
      throws IOException {
	program.addAll(favouritedProgramArrayList);
	
    Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    ArrayList<UserProgram> users = new ArrayList<UserProgram>();

    // get the user information stored in the .json file so that we don't overwrite
    // it (if it exists)
    List<UserProgram> userInfoList = getUserProgram();

    // if not null, as in a file exists, add it to the user ArrayList
    if (userInfoList.size() > 0) {
      for (UserProgram userInfo : userInfoList) {

        // if the user already has existing information saved, don't add the information
        // so that we won't have duplicates of the same user
        if (!(userInfo.getUsername().equals(username))) {
          // Add all the current programs to the list -> data stays persistent
          users.add(userInfo);
        } else {
          for (UniversityProgram up : userInfo.getPrograms()) {
            program.add(up);
          }
        }

        // remove the most recent index from the given ArrayList if there are duplicate
        // programs
        for (int i = 0; i < program.size(); i++) {

          for (int x = i + 1; x < program.size(); x++) {

            if (program.get(i).equals(program.get(x))) {
              program.remove(i);
            }
          }
        }
      }
    }

    System.out.println(program);

    // add the current user information to the user ArrayList
    users.add(new UserProgram(username, program));
    favouritedProgramArrayList.clear();
    favouritedProgramArrayList.addAll(program);
    // read and write to the .json file
    String jsonString = gson.toJson(users);
    try (FileWriter writer = new FileWriter(USER_PROGRAM_PATH)) {
      writer.write(jsonString);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<UserProgram> getUserProgram() throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(USER_PROGRAM_PATH);

    // try to fetch the information in the specified file path from the .json file
    try {
      Type userInfoListType = new TypeToken<List<UserProgram>>() {}.getType();

      List<UserProgram> userInfoList = gson.fromJson(reader, userInfoListType);

      return userInfoList;

    } catch (Exception e) {
      return null;
    }
  }
}
