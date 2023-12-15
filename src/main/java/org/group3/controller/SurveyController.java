package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.group3.view.QuizFrame;
import org.group3.model.DataModel;
import org.group3.model.UniversityProgram;

public class SurveyController implements ActionListener {

	boolean calculusTaken, functionsTaken, englishTaken, physicsTaken, biologyTaken, chemistryTaken;
	int question2Answer, question3Answer, question4Answer, question5Answer;

	QuizFrame quizFrame = new QuizFrame();

	List<UniversityProgram> programList = new ArrayList<>();

	List<UniversityProgram> recommendedProgramList = new ArrayList<>();

	public SurveyController() {

		setupActionListener();
		setupProgramList();

	}

	private void setupActionListener() {

		QuizFrame.question1Answers[0].addActionListener(this);
		QuizFrame.question1Answers[1].addActionListener(this);
		QuizFrame.question1Answers[2].addActionListener(this);
		QuizFrame.question1Answers[3].addActionListener(this);
		QuizFrame.question1Answers[4].addActionListener(this);
		QuizFrame.question1Answers[5].addActionListener(this);

		QuizFrame.question2Answers[0].addActionListener(this);
		QuizFrame.question2Answers[1].addActionListener(this);
		QuizFrame.question2Answers[2].addActionListener(this);
		QuizFrame.question2Answers[3].addActionListener(this);
		QuizFrame.question2Answers[4].addActionListener(this);

		QuizFrame.question3Answers[0].addActionListener(this);
		QuizFrame.question3Answers[1].addActionListener(this);
		QuizFrame.question3Answers[2].addActionListener(this);
		QuizFrame.question3Answers[3].addActionListener(this);
		QuizFrame.question3Answers[4].addActionListener(this);
		QuizFrame.question3Answers[5].addActionListener(this);

		QuizFrame.question4Answers[0].addActionListener(this);
		QuizFrame.question4Answers[1].addActionListener(this);
		QuizFrame.question4Answers[2].addActionListener(this);
		QuizFrame.question4Answers[3].addActionListener(this);

		QuizFrame.question5Answers[0].addActionListener(this);
		QuizFrame.question5Answers[1].addActionListener(this);
		QuizFrame.question5Answers[2].addActionListener(this);

		QuizFrame.finishButton.addActionListener(this);

	}

	private void setupProgramList() {

		try {
			programList = DataModel.generateProgramList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == QuizFrame.finishButton) {

			// Question 1
			if (event.getSource() == QuizFrame.question1Answers[0])

				calculusTaken = true;

			if (event.getSource() == QuizFrame.question1Answers[1])

				functionsTaken = true;

			if (event.getSource() == QuizFrame.question1Answers[2])

				englishTaken = true;

			if (event.getSource() == QuizFrame.question1Answers[3])

				physicsTaken = true;

			if (event.getSource() == QuizFrame.question1Answers[4])

				biologyTaken = true;

			if (event.getSource() == QuizFrame.question1Answers[5])

				chemistryTaken = true;

			// Question 2
			if (event.getSource() == QuizFrame.question2Answers[0])

				question2Answer = 1;

			else if (event.getSource() == QuizFrame.question2Answers[1])

				question2Answer = 2;

			else if (event.getSource() == QuizFrame.question2Answers[2])

				question2Answer = 3;

			else if (event.getSource() == QuizFrame.question2Answers[3])

				question2Answer = 4;

			else if (event.getSource() == QuizFrame.question2Answers[4])

				question2Answer = 5;

			// Question 3
			if (event.getSource() == QuizFrame.question3Answers[0])

				question3Answer = 1;

			else if (event.getSource() == QuizFrame.question3Answers[1])

				question3Answer = 2;

			else if (event.getSource() == QuizFrame.question3Answers[2])

				question3Answer = 3;

			else if (event.getSource() == QuizFrame.question3Answers[3])

				question3Answer = 4;

			else if (event.getSource() == QuizFrame.question3Answers[4])

				question3Answer = 5;

			else if (event.getSource() == QuizFrame.question3Answers[5])

				question3Answer = 6;

			// Question 4
			if (event.getSource() == QuizFrame.question4Answers[0])

				question4Answer = 1;

			else if (event.getSource() == QuizFrame.question4Answers[1])

				question4Answer = 2;

			else if (event.getSource() == QuizFrame.question4Answers[2])

				question4Answer = 3;

			else if (event.getSource() == QuizFrame.question4Answers[3])

				question4Answer = 4;

			// Question 5
			if (event.getSource() == QuizFrame.question5Answers[0])

				question5Answer = 1;

			else if (event.getSource() == QuizFrame.question5Answers[1])

				question5Answer = 2;

			else if (event.getSource() == QuizFrame.question5Answers[2])

				question5Answer = 3;

			findPrograms();
			
			for (int x= 0; x < recommendedProgramList.size(); x++)
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

		for (int x = 0; x < programList.size(); x++) {

			if (calculusTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("MCV4U") > -1) {

					courseFound++;

				}
			}

			if (functionsTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("MHF4U") > -1) {

					courseFound++;

				}
			}

			if (englishTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("ENG4U") > -1) {

					courseFound++;

				}
			}

			if (physicsTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("SPH4U") > -1) {

					courseFound++;

				}
			}

			if (biologyTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("SBI4U") > -1) {

					courseFound++;

				}
			}
			if (chemistryTaken) {

				courseTaken++;

				if (programList.get(x).getPrerequisites().indexOf("SCH4U") > -1) {

					courseFound++;

				}
			}

			if (courseTaken == courseFound)

				recommendedProgramList.add(programList.get(x));

			courseTaken = 0;
			courseFound = 0;
		}

	}

	private void questionTwo() {

		if (question2Answer == 1) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Science"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question2Answer == 2) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Business"))
					;

				recommendedProgramList.add(programList.get(x));

			}

		} else if (question2Answer == 3) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Psychology")
						|| programList.get(x).getName().contains("Anthropology")
						|| programList.get(x).getName().contains("Sociology")
						|| programList.get(x).getName().contains("Social"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question2Answer == 4) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Law"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question2Answer == 5) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Engineering"))

					recommendedProgramList.add(programList.get(x));

			}

		}

	}

	private void questionThree() {

		if (question3Answer == 1 || question3Answer == 2) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Math"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question3Answer == 3) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("English")
						|| programList.get(x).getName().contains("Literature"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question3Answer == 4) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Physics"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question3Answer == 5) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Biology") || programList.get(x).getName().contains("Life")
						|| programList.get(x).getName().contains("Medical"))

					recommendedProgramList.add(programList.get(x));

			}

		} else if (question3Answer == 6) {

			for (int x = 0; x < programList.size(); x++) {

				if (programList.get(x).getName().contains("Chemistry"))

					recommendedProgramList.add(programList.get(x));

			}

		}

	}

	private void questionFour() {

		if (question4Answer == 1) {

			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (!programList.get(x).getGradeRange().contains("60")
						|| programList.get(x).getGradeRange().contains("70")
						|| programList.get(x).getGradeRange().contains("60s"))

					recommendedProgramList.remove(recommendedProgramList.get(x));

			}

		} else if (question4Answer == 2) {

			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (!programList.get(x).getGradeRange().contains("70")
						|| programList.get(x).getGradeRange().contains("80")
						|| programList.get(x).getGradeRange().contains("70s"))

					recommendedProgramList.remove(recommendedProgramList.get(x));

			}

		} else if (question4Answer == 3) {

			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (!programList.get(x).getGradeRange().contains("80")
						|| programList.get(x).getGradeRange().contains("90")
						|| programList.get(x).getGradeRange().contains("80s"))

					recommendedProgramList.remove(recommendedProgramList.get(x));
			}

		} else if (question4Answer == 3) {

			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (!programList.get(x).getGradeRange().contains("90")
						|| programList.get(x).getGradeRange().contains("100")
						|| programList.get(x).getGradeRange().contains("90s"))

					recommendedProgramList.remove(recommendedProgramList.get(x));

			}
		}
	}

	private void questionFive() {

		if (question5Answer == 1)
			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (programList.get(x).getExperientialLearning().contains("Not"))

					recommendedProgramList.remove(programList.get(x));

			}
		
		if (question5Answer == 2)
			for (int x = 0; x < recommendedProgramList.size(); x++) {

				if (programList.get(x).getExperientialLearning().equals("Available"))

					recommendedProgramList.remove(programList.get(x));

			}
	}
}
