package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import org.group3.model.DataModel;
import org.group3.model.UniversityProgram;
import org.group3.view.SurveyFrame;

public class SurveyController implements ActionListener {

  private boolean calculusTaken,
      functionsTaken,
      englishTaken,
      physicsTaken,
      biologyTaken,
      chemistryTaken;
  private int question2Answer, question3Answer, question4Answer, question5Answer;

  private SurveyFrame surveyFrame;

  private List<UniversityProgram> recommendedProgramList = new ArrayList<>();

  public SurveyController() {
    surveyFrame = new SurveyFrame();
    surveyFrame.setVisible(false);
    setupActionListener();
  }

  private void setupActionListener() {
    for (JCheckBox question1answer : surveyFrame.getQuestion1Answers()) {
      question1answer.addActionListener(this);
    }

    for (JCheckBox question2answer : surveyFrame.getQuestion2Answers()) {
      question2answer.addActionListener(this);
    }

    for (JCheckBox question3answer : surveyFrame.getQuestion3Answers()) {
      question3answer.addActionListener(this);
    }

    for (JCheckBox question4answer : surveyFrame.getQuestion4Answers()) {
      question4answer.addActionListener(this);
    }

    for (JCheckBox question4answer : surveyFrame.getQuestion4Answers()) {
      question4answer.addActionListener(this);
    }

    for (JCheckBox question5answer : surveyFrame.getQuestion5Answers()) {
      question5answer.addActionListener(this);
    }

    surveyFrame.getFinishButton().addActionListener(this);
  }

  public boolean isCalculusTaken() {
    return calculusTaken;
  }

  public void setCalculusTaken(boolean calculusTaken) {
    this.calculusTaken = calculusTaken;
  }

  public boolean isFunctionsTaken() {
    return functionsTaken;
  }

  public void setFunctionsTaken(boolean functionsTaken) {
    this.functionsTaken = functionsTaken;
  }

  public boolean isEnglishTaken() {
    return englishTaken;
  }

  public void setEnglishTaken(boolean englishTaken) {
    this.englishTaken = englishTaken;
  }

  public boolean isPhysicsTaken() {
    return physicsTaken;
  }

  public void setPhysicsTaken(boolean physicsTaken) {
    this.physicsTaken = physicsTaken;
  }

  public boolean isBiologyTaken() {
    return biologyTaken;
  }

  public void setBiologyTaken(boolean biologyTaken) {
    this.biologyTaken = biologyTaken;
  }

  public boolean isChemistryTaken() {
    return chemistryTaken;
  }

  public void setChemistryTaken(boolean chemistryTaken) {
    this.chemistryTaken = chemistryTaken;
  }

  public int getQuestion2Answer() {
    return question2Answer;
  }

  public void setQuestion2Answer(int question2Answer) {
    this.question2Answer = question2Answer;
  }

  public int getQuestion3Answer() {
    return question3Answer;
  }

  public void setQuestion3Answer(int question3Answer) {
    this.question3Answer = question3Answer;
  }

  public int getQuestion4Answer() {
    return question4Answer;
  }

  public void setQuestion4Answer(int question4Answer) {
    this.question4Answer = question4Answer;
  }

  public int getQuestion5Answer() {
    return question5Answer;
  }

  public void setQuestion5Answer(int question5Answer) {
    this.question5Answer = question5Answer;
  }

  public SurveyFrame getSurveyFrame() {
    return surveyFrame;
  }

  public void setSurveyFrame(SurveyFrame quizFrame) {
    this.surveyFrame = quizFrame;
  }

  public List<UniversityProgram> getRecommendedProgramList() {
    return recommendedProgramList;
  }

  public void setRecommendedProgramList(List<UniversityProgram> recommendedProgramList) {
    this.recommendedProgramList = recommendedProgramList;
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    if (event.getSource() == surveyFrame.getFinishButton()) {

      // Question 1
      if (event.getSource() == surveyFrame.getQuestion1Answers()[0]) calculusTaken = true;

      if (event.getSource() == surveyFrame.getQuestion1Answers()[1]) functionsTaken = true;

      if (event.getSource() == surveyFrame.getQuestion1Answers()[2]) englishTaken = true;

      if (event.getSource() == surveyFrame.getQuestion1Answers()[3]) physicsTaken = true;

      if (event.getSource() == surveyFrame.getQuestion1Answers()[4]) biologyTaken = true;

      if (event.getSource() == surveyFrame.getQuestion1Answers()[5]) chemistryTaken = true;

      // Question 2
      if (event.getSource() == surveyFrame.getQuestion2Answers()[0]) question2Answer = 1;
      else if (event.getSource() == surveyFrame.getQuestion2Answers()[1]) question2Answer = 2;
      else if (event.getSource() == surveyFrame.getQuestion2Answers()[2]) question2Answer = 3;
      else if (event.getSource() == surveyFrame.getQuestion2Answers()[3]) question2Answer = 4;
      else if (event.getSource() == surveyFrame.getQuestion2Answers()[4]) question2Answer = 5;

      // Question 3
      if (event.getSource() == surveyFrame.getQuestion3Answers()[0]) question3Answer = 1;
      else if (event.getSource() == surveyFrame.getQuestion3Answers()[1]) question3Answer = 2;
      else if (event.getSource() == surveyFrame.getQuestion3Answers()[2]) question3Answer = 3;
      else if (event.getSource() == surveyFrame.getQuestion3Answers()[3]) question3Answer = 4;
      else if (event.getSource() == surveyFrame.getQuestion3Answers()[4]) question3Answer = 5;
      else if (event.getSource() == surveyFrame.getQuestion3Answers()[5]) question3Answer = 6;

      // Question 4
      if (event.getSource() == surveyFrame.getQuestion4Answers()[0]) question4Answer = 1;
      else if (event.getSource() == surveyFrame.getQuestion4Answers()[1]) question4Answer = 2;
      else if (event.getSource() == surveyFrame.getQuestion4Answers()[2]) question4Answer = 3;
      else if (event.getSource() == surveyFrame.getQuestion4Answers()[3]) question4Answer = 4;

      // Question 5
      if (event.getSource() == surveyFrame.getQuestion4Answers()[0]) question5Answer = 1;
      else if (event.getSource() == surveyFrame.getQuestion4Answers()[1]) question5Answer = 2;
      else if (event.getSource() == surveyFrame.getQuestion4Answers()[2]) question5Answer = 3;

      findPrograms();

      for (int x = 0; x < recommendedProgramList.size(); x++)
        System.out.println(recommendedProgramList.get(x));

      System.out.println(recommendedProgramList.size());
    }
  }

  private void findPrograms() {

    questionOne();
    questionTwo();
    questionThree();
    questionFour();
    questionFive();
  }

  private void questionOne() {

    int courseTaken = 0;
    int courseFound = 0;

    for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

      if (calculusTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("MCV4U") > -1) {

          courseFound++;
        }
      }

      if (functionsTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("MHF4U") > -1) {

          courseFound++;
        }
      }

      if (englishTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("ENG4U") > -1) {

          courseFound++;
        }
      }

      if (physicsTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("SPH4U") > -1) {

          courseFound++;
        }
      }

      if (biologyTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("SBI4U") > -1) {

          courseFound++;
        }
      }
      if (chemistryTaken) {

        courseTaken++;

        if (DataModel.universityProgramArrayList.get(x).getPrerequisites().indexOf("SCH4U") > -1) {

          courseFound++;
        }
      }

      if (courseTaken == courseFound)
        recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));

      courseTaken = 0;
      courseFound = 0;
    }
  }

  private void questionTwo() {

    if (question2Answer == 1) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Science"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question2Answer == 2) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Business"))
          ;

        recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question2Answer == 3) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Psychology")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Anthropology")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Sociology")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Social"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question2Answer == 4) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Law"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question2Answer == 5) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Engineering"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }
    }
  }

  private void questionThree() {

    if (question3Answer == 1 || question3Answer == 2) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Math"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question3Answer == 3) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("English")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Literature"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question3Answer == 4) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Physics"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question3Answer == 5) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Biology")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Life")
            || DataModel.universityProgramArrayList.get(x).getName().contains("Medical"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }

    } else if (question3Answer == 6) {

      for (int x = 0; x < DataModel.universityProgramArrayList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getName().contains("Chemistry"))
          recommendedProgramList.add(DataModel.universityProgramArrayList.get(x));
      }
    }
  }

  private void questionFour() {

    if (question4Answer == 1) {

      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (!DataModel.universityProgramArrayList.get(x).getGradeRange().contains("60")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("70")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("60s"))
          recommendedProgramList.remove(recommendedProgramList.get(x));
      }

    } else if (question4Answer == 2) {

      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (!DataModel.universityProgramArrayList.get(x).getGradeRange().contains("70")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("80")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("70s"))
          recommendedProgramList.remove(recommendedProgramList.get(x));
      }

    } else if (question4Answer == 3) {

      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (!DataModel.universityProgramArrayList.get(x).getGradeRange().contains("80")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("90")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("80s"))
          recommendedProgramList.remove(recommendedProgramList.get(x));
      }

    } else if (question4Answer == 3) {

      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (!DataModel.universityProgramArrayList.get(x).getGradeRange().contains("90")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("100")
            || DataModel.universityProgramArrayList.get(x).getGradeRange().contains("90s"))
          recommendedProgramList.remove(recommendedProgramList.get(x));
      }
    }
  }

  private void questionFive() {

    if (question5Answer == 1)
      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (DataModel.universityProgramArrayList.get(x).getExperientialLearning().contains("Not"))
          recommendedProgramList.remove(DataModel.universityProgramArrayList.get(x));
      }

    if (question5Answer == 2)
      for (int x = 0; x < recommendedProgramList.size(); x++) {

        if (DataModel.universityProgramArrayList
            .get(x)
            .getExperientialLearning()
            .equals("Available"))
          recommendedProgramList.remove(DataModel.universityProgramArrayList.get(x));
      }
  }
}
