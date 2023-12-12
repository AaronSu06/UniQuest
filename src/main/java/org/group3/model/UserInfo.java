package org.group3.model;

import java.util.HashMap;

public class UserInfo {

	private String username;
	private HashMap<String, String> courseInfo = new HashMap<String, String>();

	public UserInfo(String username, HashMap<String, String> courseInfo, String[] keyArr) {
		super();
		this.username = username;
		
		for (int i = 0; i < keyArr.length; i++) {
			if (courseInfo.get(keyArr[i]) != null) {
				this.courseInfo.put(keyArr[i], courseInfo.get(keyArr[i]));
			}
		}
	}

	public HashMap<String, String> getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(HashMap<String, String> courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", courseInfo=" + courseInfo + "]";
	}
}
