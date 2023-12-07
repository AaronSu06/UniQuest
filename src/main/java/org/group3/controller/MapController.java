package org.group3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group3.view.MapFrame;

public class MapController implements ActionListener {
  MapFrame mapFrame;

  public MapController() {
    mapFrame = new MapFrame();
  }

  public void addActionListeners() {

  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }
}
