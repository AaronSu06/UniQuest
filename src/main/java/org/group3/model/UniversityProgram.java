package org.group3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversityProgram {
	private String name;
	private String university;
	private String degree;
	private String ouacProgramCode;
	private String gradeRange;
	private String experientialLearning;
	private String enrollment;
	private String instructionLanguage;
	private List<String> prerequisites;
	private String notes;

	public UniversityProgram(String name, String university, String degree, String ouacProgramCode, String gradeRange,
			String experientialLearning, String enrollment, String instructionLanguage, List<String> prerequisites,
			String notes) {
		this.name = name;
		this.university = university;
		this.degree = degree;
		this.ouacProgramCode = ouacProgramCode;
		this.gradeRange = gradeRange;
		this.experientialLearning = experientialLearning;
		this.enrollment = enrollment;
		this.instructionLanguage = instructionLanguage;
		this.prerequisites = prerequisites;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "UniversityProgram{" + "name='" + name + '\'' + ", university='" + university + '\'' + ", degree='"
				+ degree + '\'' + ", ouacProgramCode='" + ouacProgramCode + '\'' + ", gradeRange='" + gradeRange + '\''
				+ ", experientialLearning='" + experientialLearning + '\'' + ", enrollment='" + enrollment + '\''
				+ ", instructionLanguage='" + instructionLanguage + '\'' + ", prerequisites=" + prerequisites
				+ ", notes='" + notes + '\'' + '}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getOuacProgramCode() {
		return ouacProgramCode;
	}

	public void setOuacProgramCode(String ouacProgramCode) {
		this.ouacProgramCode = ouacProgramCode;
	}

	public String getGradeRange() {
		return gradeRange;
	}

	public void setGradeRange(String gradeRange) {
		this.gradeRange = gradeRange;
	}

	public String getExperientialLearning() {
		return experientialLearning;
	}

	public void setExperientialLearning(String experientialLearning) {
		this.experientialLearning = experientialLearning;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getInstructionLanguage() {
		return instructionLanguage;
	}

	public void setInstructionLanguage(String instructionLanguage) {
		this.instructionLanguage = instructionLanguage;
	}

	public List<String> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<String> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getGrade() {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(getGradeRange());
		ArrayList<String> modifiers = new ArrayList<>();
		boolean modifierExists = true;
		String range = getGradeRange().toLowerCase();

		while (modifierExists) {
			modifierExists = false;
			int highIndex = range.indexOf("high");
			int midIndex = range.indexOf("mid");
			int lowIndex = range.indexOf("low");

			if (highIndex != -1 && (midIndex == -1 || highIndex < midIndex)
					&& (lowIndex == -1 || highIndex < lowIndex)) {
				modifiers.add("high");
				range = range.replaceFirst("high", "");
				modifierExists = true;
			} else if (midIndex != -1 && (lowIndex == -1 || midIndex < lowIndex)) {
				modifiers.add("mid");
				range = range.replaceFirst("mid", "");

				modifierExists = true;
			} else if (lowIndex != -1) {
				range = range.replaceFirst("low", "");

				modifiers.add("low");
				modifierExists = true;
			}
		}
		int avg = 0;
		int count = 0;
		// System.out.println("RUNNING GET GRADE");
		while (m.find()) {
			int currentGrade = Integer.parseInt(m.group());
			if (currentGrade > 100) {
				break;
			}
			// System.out.println("PRINTING MATCH");
			// System.out.println(m.group());
//      avg += Integer.parseInt(m.group());
			avg += currentGrade;
			if (modifiers.size() > 0) {
				switch (modifiers.getFirst()) {
				case "high":
					avg += 8;
					break;
				case "mid":
					avg += 5;
					break;
				case "low":
					avg += 2;
					break;
				}
			}
			count++;
		}
		// if (m.find()) {
		// return Integer.parseInt(m.group());
		// }
		if (count > 0) {
			return avg / count;

		} else {
			return avg;
		}
	}

	public ArrayList<String> getCourseCodes() {
		ArrayList<String> courseCodes = new ArrayList<>();
		for(String prereq:getPrerequisites()) {
			Pattern pattern = Pattern.compile("[A-Za-z]+\\d+");
			Matcher matcher = pattern.matcher(prereq);

			while (matcher.find()) {
				
				if(matcher.group().length()<5) {
					if(prereq.toLowerCase().contains("math")) {
						courseCodes.add(matcher.group()+" Math");
					}else if(prereq.toLowerCase().contains("english")) {
						courseCodes.add(matcher.group()+" English");
					}
				}else {
					courseCodes.add(matcher.group());

				}
			}
		}
		return courseCodes;
		
	}
	public boolean containsCourseCode(String courseCode) {
		ArrayList<String>courseCodes = getCourseCodes();
		for(String code:courseCodes) {
			if(courseCode.contains(code)) {
				return true;
			}
		}
		return false;
	}
}
