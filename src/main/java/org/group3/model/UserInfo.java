package org.group3.model;

public class UserInfo {

	private String username;
	private String password;
	
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + "]";
	}
}
