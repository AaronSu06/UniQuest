package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.group3.view.PersonalInfoFrame;

public class MainController implements ActionListener{

//    static fields

//    calls the controllers
    public static LoginController loginController = new LoginController();
    public static MapController mapController = new MapController();
    public static SearchFrameController searchFrameController = new SearchFrameController();

//    constructor
    public MainController() {

//        sets mapframe and searchframe invisible
        mapController.getMapFrame().setVisible(false);
        searchFrameController.getSearchFrame().setVisible(false);

//        adds the actionlisteners
        addActionListeners();
    }

//    adds the actionlisteners to the menuPanels of each frame
    public void addActionListeners() {

//        adds actionlisteners to searchFrame menuPanel
        searchFrameController.getSearchFrame().getMenuPanel().getProfile().addActionListener(this);
        searchFrameController.getSearchFrame().getMenuPanel().getLogOut().addActionListener(this);
        for(JButton button:searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()) {
            button.addActionListener(this);
        }
        searchFrameController.getSearchFrame().getMenuPanel().getQuit().addActionListener(loginController);

//        adds actionlisteners to mapFrame menuPanel
        mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
        mapController.getMapFrame().getMenuPanel().getLogOut().addActionListener(this);
        mapController.getMapFrame().getMenuPanel().getProfile().addActionListener(this);
        for(JButton button:mapController.getMapFrame().getMenuPanel().getFrameButtons()) {
            button.addActionListener(this);
        }
    }
//    handles actions
    @Override
    public void actionPerformed(ActionEvent e) {

//        structure checks searchFrame menu components for switching frames

//        gives a message to say that the user is in the current frame
        if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[0]) {
            JOptionPane.showMessageDialog(null, "You are already on this screen");

//        sets quiz frame visible
        }else if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[1]) {
            searchFrameController.getSearchFrame().setVisible(false);

//        sets map frame visible
        }else if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getFrameButtons()[2]) {
            searchFrameController.getSearchFrame().setVisible(false);
            mapController.getMapFrame().setVisible(true);
        }

//        structure checks mapFrame menu components for switching frames
        if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[0]) {
            mapController.getMapFrame().setVisible(false);
            searchFrameController.getSearchFrame().setVisible(true);
        }else if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[1]) {
            mapController.getMapFrame().setVisible(false);

        }else if(e.getSource()==mapController.getMapFrame().getMenuPanel().getFrameButtons()[2]) {

            JOptionPane.showMessageDialog(null, "You are already on this screen");

        }
        if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getProfile()) {
            new CourseInfoController();
        }
        if(e.getSource()==mapController.getMapFrame().getMenuPanel().getProfile()) {
            new CourseInfoController();

        }
if(e.getSource()==searchFrameController.getSearchFrame().getMenuPanel().getLogOut()) {
            searchFrameController.getSearchFrame().setVisible(false);
            loginController.getHomeFrame().setVisible(true);
        }
        if(e.getSource()==mapController.getMapFrame().getMenuPanel().getLogOut()) {
            mapController.getMapFrame().setVisible(false);
            loginController.getHomeFrame().setVisible(true);
        }

    }

}
