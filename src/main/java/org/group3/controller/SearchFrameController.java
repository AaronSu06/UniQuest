package org.group3.controller;

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
import org.group3.model.UserAccount;
import org.group3.model.UserInfo;
import org.group3.view.FilterPanel;
import org.group3.view.SearchFrame;
import org.group3.view.UniversityInformationPanel;
import org.group3.view.UniversityPanel;

public class SearchFrameController implements ActionListener {
  private SearchFrame searchFrame = new SearchFrame();

  public SearchFrameController() {
    searchFrame.setVisible(false);
    addActionListeners();
  }

  public SearchFrame getSearchFrame() {
    return searchFrame;
  }

  public void setSearchFrame(SearchFrame searchFrame) {
    this.searchFrame = searchFrame;
  }

  public void addActionListeners() {

    for (int i = 0;
        i < searchFrame.getSidePanel().getSortPanel().getProgramJRadioButtonArray().length;
        i++) {
      searchFrame
          .getSidePanel()
          .getSortPanel()
          .getProgramJRadioButtonArray()[i]
          .addActionListener(this);
    }
    searchFrame.getSidePanel().getSortPanel().getConfirmButton().addActionListener(this);
    searchFrame.getSidePanel().getSortPanel().getResetButton().addActionListener(this);
    for (int i = 0;
        i < searchFrame.getSidePanel().getSortPanel().getUniversityJRadioButtonArray().length;
        i++) {
      searchFrame
          .getSidePanel()
          .getSortPanel()
          .getUniversityJRadioButtonArray()[i]
          .addActionListener(this);
    }
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
    for (Component menu : searchFrame.getSortMenu().getUniversityMenu()[0].getMenuComponents()) {
      ((JMenuItem) menu).addActionListener(this);
    }
  }

  public void reAddActionListeners() {
    System.out.println("RE ADDING");
    System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
    for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
      // searchFrame.getDisplayPanel().getUniversityArray().get(i).getFavouriteButton().addActionListener(this);
      searchFrame
          .getDisplayPanel()
          .getUniversityArray()
          .get(i)
          .getUniversityButton()
          .addActionListener(this);
    }
    for (Component menu : searchFrame.getSortMenu().getProgramMenu()[0].getMenuComponents()) {
      ((JMenuItem) menu).addActionListener(this);
    }

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
      // System.out.println(searchFrame.getSidePanel().getFilterPanel().getUniversityCount());
      // System.out.println(selectedStrings);
      // System.out.println(searchFrame.getSidePanel().getFilterPanel().getGradeRangeCount());
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
          // searchFrame.getDisplayPanel().sort(i);
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
          // searchFrame.getDisplayPanel().sort(i + 4);
          break;
        }
      }
      // reAddActionListeners();

      searchFrame.repaint();
      searchFrame.revalidate();
    }
    if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetButton()) {
      searchFrame.getDisplayPanel().resetToOriginal();
      searchFrame.getSidePanel().getFilterPanel().reset();
      searchFrame.getSidePanel().getSortPanel().reset();
      // reAddActionListeners();
      searchFrame.repaint();
      searchFrame.revalidate();
    }

    for (int i = 0; i < searchFrame.getDisplayPanel().getUniversityArray().size(); i++) {
      if (e.getSource()
          == searchFrame.getDisplayPanel().getUniversityArray().get(i).getUniversityButton()) {
        /*
         *
         */
        String universityName =
            searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram().getUniversity();

        JScrollPane scroll =
            new JScrollPane(
                new UniversityInformationPanel(
                    searchFrame.getDisplayPanel().getUniversityArray().get(i).getProgram()),
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(
            searchFrame, scroll, "Information", 1, LogoInput.imageMap.get(universityName));
        break;
      }
    }
    if (e.getSource() == searchFrame.getSearchField()) {
      // searchFrame.getDisplayPanel().resetToOriginal();
      searchFrame.getDisplayPanel().resetToPrevious(1);
      String text = searchFrame.getSearchField().getText();
      searchFrame.getDisplayPanel().search(text);
      // reAddActionListeners();

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
      searchFrame.getDisplayPanel().resetToPrevious(0);
    }
    if (e.getSource() == searchFrame.getSidePanel().getFilterPanel().getResetToUser()) {
      System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
      System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());
      searchFrame.getDisplayPanel().resetToUser();
      System.out.println(searchFrame.getDisplayPanel().getUniversityArray().size());
      System.out.println(searchFrame.getDisplayPanel().getUserAccordanceArray().size());

      for (UniversityPanel panel : searchFrame.getDisplayPanel().getUniversityArray()) {
        System.out.println(panel.getProgram());
      }
    }
  }

  public void retrieveUserInformation(UserAccount user) throws IOException {
    // UserInfo userInfo = DataModel.getUserInformation();
    double avg = 0;
    UserInfo currentUser = null;

    for (UserInfo userInfo : DataModel.getUserInformation()) {
      if (userInfo != null && userInfo.getUsername().equals(user.getusername())) {
        currentUser = userInfo;
      }
    }

    if (currentUser == null ) {
      System.out.println("No User Info Has been generated");
      return;
    }

    // Most readable java code
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
    System.out.println(avg);

    searchFrame.getSidePanel().getFilterPanel();
    System.out.println(FilterPanel.getUniversityCount());
    if (avg >= 60 && avg < 70) {
      System.out.println("1");
      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount(), Double.toString(avg));
    } else if (avg >= 70 && avg < 80) {
      System.out.println("2");

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 1, Double.toString(avg));

    } else if (avg >= 80 && avg < 90) {
      System.out.println("3");

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 2, Double.toString(avg));

    } else if (avg >= 90) {
      System.out.println("4");

      searchFrame.getSidePanel().getFilterPanel();
      temp.put(FilterPanel.getUniversityCount() + 3, Double.toString(avg));
    }
    System.out.println(temp);
    searchFrame.getDisplayPanel().filter(temp);
    searchFrame
        .getDisplayPanel()
        .getUserAccordanceArray()
        .addAll(searchFrame.getDisplayPanel().getUniversityArray());
  }
}
