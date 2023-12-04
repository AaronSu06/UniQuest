package org.group3.model;

import java.util.List;

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

  public UniversityProgram(String name, String university, String degree,
                           String ouacProgramCode, String gradeRange,
                           String experientialLearning, String enrollment,
                           String instructionLanguage,
                           List<String> prerequisites, String notes) {
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

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getUniversity() { return university; }

  public void setUniversity(String university) { this.university = university; }

  public String getDegree() { return degree; }

  public void setDegree(String degree) { this.degree = degree; }

  public String getOuacProgramCode() { return ouacProgramCode; }

  public void setOuacProgramCode(String ouacProgramCode) {
    this.ouacProgramCode = ouacProgramCode;
  }

  public String getGradeRange() { return gradeRange; }

  public void setGradeRange(String gradeRange) { this.gradeRange = gradeRange; }

  public String getExperientialLearning() { return experientialLearning; }

  public void setExperientialLearning(String experientialLearning) {
    this.experientialLearning = experientialLearning;
  }

  public String getEnrollment() { return enrollment; }

  public void setEnrollment(String enrollment) { this.enrollment = enrollment; }

  public String getInstructionLanguage() { return instructionLanguage; }

  public void setInstructionLanguage(String instructionLanguage) {
    this.instructionLanguage = instructionLanguage;
  }

  public List<String> getPrerequisites() { return prerequisites; }

  public void setPrerequisites(List<String> prerequisites) {
    this.prerequisites = prerequisites;
  }

  public String getNotes() { return notes; }

  public void setNotes(String notes) { this.notes = notes; }

  @Override
  public String toString() {
    return "UniversityProgram{"
        + "name='" + name + '\'' + ", university='" + university + '\'' +
        ", degree='" + degree + '\'' + ", ouacProgramCode='" + ouacProgramCode +
        '\'' + ", gradeRange='" + gradeRange + '\'' +
        ", experientialLearning='" + experientialLearning + '\'' +
        ", enrollment='" + enrollment + '\'' + ", instructionLanguage='" +
        instructionLanguage + '\'' + ", prerequisites=" + prerequisites +
        ", notes='" + notes + '\'' + '}';
  }
}
