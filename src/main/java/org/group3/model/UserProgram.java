package org.group3.model;

import java.util.ArrayList;

public class UserProgram {

	private String username;
	private ArrayList<UniversityProgram> programs = new ArrayList<UniversityProgram>();
	
	public UserProgram(String username, ArrayList<UniversityProgram> program) {
		super();
		this.username = username;
		this.programs.addAll(program);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<UniversityProgram> getPrograms() {
		return programs;
	}

	public void setPrograms(ArrayList<UniversityProgram> program) {
		this.programs = program;
	}

	@Override
	public String toString() {
		return "UserProgram [username=" + username + ", program=" + programs + "]";
	}
}

