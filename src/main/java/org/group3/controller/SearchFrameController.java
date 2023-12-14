package org.group3.controller;

// imports
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import org.group3.model.DataModel;
import org.group3.model.LogoInput;
import org.group3.model.UserInfo;
import org.group3.view.FilterPanel;
import org.group3.view.SearchFrame;
import org.group3.view.UniversityPanel;
import org.group3.view.UniversityProgramInformationPanel;

// class
public class SearchFrameController implements ActionListener {

  // searchFrame initialization
  private SearchFrame searchFrame = new SearchFrame();

  // constructor
  public SearchFrameController() {
    // sets the frame invisible at the start
    searchFrame.setVisible(false);

    // adds the actionlisteners to components
    addActionListeners();
  }

  // getters and setters
  public SearchFrame getSearchFrame() {
    return searchFrame;
  }

  public void setSearchFrame(SearchFrame searchFrame) {
    this.searchFrame = searchFrame;
  }

  // adds the actionlisteners to all the components, so that this class can handle
  // all the events
  public void addActionListeners() {

    for (int i = 0;
        i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size();
        i++) {
      searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).addActionListener(this);
    }
    for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
      searchFrame
          .getDisplayPanel()
          .getUniversityArray()
          .get(i)
          .getUniversityButton()
          .addActionListener(this);
    }
    searchFrame.getSearchField().addActionListener(this);
    searchFrame.getSidePanel().getFilterPanel().getConfirmButton().addActionListener(this);
    searchFrame.getSidePanel().getFilterPanel().getResetButton().addActionListener(this);
    searchFrame.getSidePanel().getFilterPanel().getResetToUser().addActionListener(this);
    searchFrame.getSortMenu().getNoSort()[0].addActionListener(this);

    for (Component menu : searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
      ((JMenuItem) menu).addActionListener(this);
    }

    // adds actionlisteners to universityMenu options
    for (Component menu : searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
      ((JMenuItem) menu).addActionListener(this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getConfirmButton()) {
      HashMap<Integer, String> selectedStrings = new HashMap<Integer, String>();
      searchFrame.getDisplayPanel().resetToOriginal();

      for (int i = 0;
          i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size();
          i++) {
        if (searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).isSelected()) {
          selectedStrings.put(
              i, searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText());
        }
      }
      if (selectedStrings.size() != 0) {
        searchFrame.getDisplayPanel().filter(selectedStrings);
      }
      for (int i = 0;
          i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length;
          i++) {
        if (searchFrame
            .getSidePanel()
            .getSortPanel()
            .getProgramJRadioButtonArray()[i]
            .isSelected()) {
          break;
        }
      }
      for (int i = 0;
          i < searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray().length;
          i++) {
        if (searchFrame
            .getSidePanel()
            .getSortPanel()
            .getUniversityJRadioButtonArray()[i]
            .isSelected()) {
          break;
        }
      }

      searchFrame.repaint();
      searchFrame.revalidate();
    }
    if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetButton()) {
      searchFrame.getDisplayPanel().resetToOriginal();
      searchFrame.getSidePanel().getFilterPanel().reset();
      searchFrame.getSidePanel().getSortPanel().reset();
      searchFrame.repaint();
      searchFrame.revalidate();
    }

    for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
      if (e.getSource()
          == searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton()) {
        /*
         *
         */
        JScrollPane scroll =
            new JScrollPane(
                new UniversityProgramInformationPanel(
                    searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram()),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(
            searchFrame,
            scroll,
            "Information",
            1,
            LogoInput.imageMap.get(
                searchFrame
                    .getDisplayPanel()
                    .getUniversityArray()
                    .get(i)
                    .getProgram()
                    .getUniversity()));
        break;
      }
    }

    if (e.getSource() == searchFrame.getSearchField()) {
      // searchFrame.getDisplayPanel().resetToPrevious(1);
      searchFrame.getDisplayPanel().resetToOriginal();
      String text = searchFrame.getSearchField().getText();
      searchFrame.getDisplayPanel().search(text);
    }

    for (int i = 0;
        i < searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponentCount();
        i++) {
      if (e.getSource() == searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()[i]) {
        searchFrame.getDisplayPanel().sort(i, 0);
        searchFrame
            .getSortMenu()
            .getSortingTypes()[0]
            .setText(searchFrame.getSortMenu().getProgramJMenuArray()[0][i].getText());
      }
    }

    for (int i = 0;
        i < searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponentCount();
        i++) {
      if (e.getSource()
          == searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()[i]) {
        searchFrame.getDisplayPanel().sort(i + 4, 0);
        searchFrame
            .getSortMenu()
            .getSortingTypes()[0]
            .setText(searchFrame.getSortMenu().getUniversityJMenuArray()[0][i].getText());
      }
    }

    if (e.getSource() == searchFrame.getSortMenu().getNoSort()[0]) {
      searchFrame
          .getSortMenu()
          .getSortingTypes()[0]
          .setText(searchFrame.getSortMenu().getNoSort()[0].getText());
      // searchFrame.getDisplayPanel().resetToPrevious(0);
      searchFrame.getDisplayPanel().resetToOriginal();
    }

    if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetToUser()) {
      // System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
      // System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());
      // System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
      // System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());
      searchFrame.getDisplayPanel().resetToUser();

      for (UniversityPanel panel : searchFrame.getDisplayPanel().getUniversityArray()) {
        System.out.println(panel.getProgram());
      }
      // searchFrame.repaint();
      // searchFrame.revalidate();
    }

    //// FAVOURITING
    // for (int i = 0; i <
    //// searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
    // if (e.getSource() ==
    // searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton())
    //// {
    //// Do something
    // System.out.println(i + ": THIS IS THE ITERATION NUMBER");
    //// Note: You'll probably need to pass the program in as an argument to save
    //// the
    // stuff.
    // }
    // }

  }

  // gets the user information from the dataBase
  public void retrieveUserInformation() throws IOException {
    double avg = 0;
    UserInfo currentUser = null;

    for (UserInfo userInfo : DataModel.getUserInformation()) {
      if (userInfo.getUsername().equals(LoginController.user)) {
        currentUser = userInfo;
      }
    }

    if (currentUser == null) {
      System.out.println("Something Wnt rong");
    }

    HashMap<Integer, String> temp = new HashMap<>();
    for (Map.Entry<String, String> entry : currentUser.getCourseInfo().entrySet()) {
      for (int i = 0;
          i < searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().size();
          i++) {
        if (entry
            .getKey()
            .equals(
                searchFrame.getSidePanel().getFilterPanel().getCheckBoxArray().get(i).getText())) {
          temp.put(i, entry.getKey());
          avg += Double.parseDouble(entry.getValue());
        }
      }
    }
    avg /= temp.size();
    avg = Math.floor(avg);

    if (avg >= 60 && avg < 70) {
      System.out.println("1");
      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount(), Double.toString(avg));
    } else if (avg >= 70 && avg < 80) {

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 1, Double.toString(avg));

    } else if (avg >= 80 && avg < 90) {

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 2, Double.toString(avg));

    } else if (avg >= 90) {

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 3, Double.toString(avg));
    }

    searchFrame.getDisplayPanel().filter(temp);

    searchFrame
        .getDisplayPanel()
        .getUserAccordanceArray()
        .addAll(searchFrame.getDisplayPanel().getUniversityArray());
  }
}
