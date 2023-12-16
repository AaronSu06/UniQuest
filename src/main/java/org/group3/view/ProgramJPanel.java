package org.group3.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.group3.controller.LoginController;
import org.group3.model.DataModel;
import org.group3.model.UserProgram;

public class ProgramJPanel extends JPanel {
	private List<UserProgram> userProgramList = null;
	private JLabel programHeader = new JLabel("Preferred Programs");
	private ArrayList<JLabel> preferredProgram = new ArrayList<JLabel>();

	public ProgramJPanel() {
		// box layout for vertical packing and change the background to white
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		
		// set font and size of all components in the JFrame
		programHeader.setFont(new Font("Sans Serif", Font.BOLD, 36));
		
		// center the header
		programHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

		// add a gap and a new header
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(programHeader);
		add(Box.createRigidArea(new Dimension(0, 15)));

		// replace default preferred information with saved preferred information for
		// that
		// user (if
		// possible)
		try {
			// get the saved user information
			userProgramList = DataModel.getUserProgram();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// if not null, as in a file exists
		if (userProgramList.size() > 0) {

			// loop through the saved user information list
			for (UserProgram userProgram : userProgramList) {

				// check if the username matches that of the username from the saved information
				if (!(LoginController.user.equals(null)) && LoginController.user.equals(userProgram.getUsername())) {
					addUserProgram(userProgram.getProgram());
				}
			}
		}
	}

	// display the preferred program information
	public void addUserProgram(ArrayList<String> userProgram) {
		for (int i = 0; i < userProgram.size(); i++) {
			preferredProgram.add(new JLabel());
			preferredProgram.get(i).setText(userProgram.get(i));
			preferredProgram.get(i).setFont(new Font("Sans Serif", Font.BOLD, 18));
			preferredProgram.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
			add(preferredProgram.get(i));

			add(Box.createRigidArea(new Dimension(0, 15)));

			// replace default course information with saved course information for that
			// user (if
			// possible)
			try {
				// get the saved user program information
				userProgramList = DataModel.getUserProgram();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
