package org.group3.model;

import java.util.ArrayList;

public class UserProgram {

	private String username;
	private ArrayList<String> program = new ArrayList<String>();
	
	public UserProgram(String username, ArrayList<String> program) {
		super();
		this.username = username;
		this.program.addAll(program);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<String> getProgram() {
		return program;
	}

	public void setProgram(ArrayList<String> program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "UserProgram [username=" + username + ", program=" + program + "]";
	}
}

