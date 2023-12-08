package org.group3.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataModel {
	public static final String universityProgramsPath = "assets/data/programs.json";
	public static final String userInfoPath = "assets/data/userInfo.json";

	public static List<UniversityProgram> generateProgramList() throws IOException {
		FileReader reader = new FileReader(universityProgramsPath);

		Gson gson = new Gson();
		Type universityProgramListType = new TypeToken<List<UniversityProgram>>() {
		}.getType();

		List<UniversityProgram> universityProgramList = gson.fromJson(reader, universityProgramListType);

		for (UniversityProgram program : universityProgramList) {
			System.out.println(program);
		}

		System.out.println(universityProgramList.size());

		return universityProgramList;
	}

	public static void generateUserAccount(String username, String password) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		
		// get the user information stored in the .json file so that we don't overwrite it (if it exists)
		List<UserInfo> userInfoList = getUserAccount();
		
		// if not null, as in a file exists, add it to the user ArrayList
		if (userInfoList != null) {
			for (UserInfo userInfo : userInfoList) {
				users.add(userInfo);
			}
		}
		
		// add the current user information to the user ArrayList
		users.add(new UserInfo(username, password));
		
		// read and write to the .json file
		String jsonString = gson.toJson(users);
		try (FileWriter writer = new FileWriter(userInfoPath)) {
			writer.write(jsonString);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<UserInfo> getUserAccount() throws IOException {
		Gson gson = new Gson();
		FileReader reader = new FileReader(userInfoPath);
		
		try {
			Type userInfoListType = new TypeToken<List<UserInfo>>() {
			}.getType();

			List<UserInfo> userInfoList = gson.fromJson(reader, userInfoListType);
			
			return userInfoList;
			
		} catch(Exception e) {
			return null;
		}
	}
}