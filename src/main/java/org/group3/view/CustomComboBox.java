///* Aaron Su
// * 
// * sourced from: https://stackoverflow.com/questions/20683787/change-height-of-jcombobox
// */
//
//package org.group3.view;
//
//import java.awt.*;
//import javax.swing.*;
//
//public class CustomComboBox extends JLabel implements ListCellRenderer {
//
//	@Override
//    public Component getListCellRendererComponent(
//            JList list, 
//            Object value, 
//            int index, 
//            boolean isSelected, 
//            boolean cellHasFocus) {
//
//        JLabel label = new JLabel(){
//            public Dimension getPreferredSize(){
//                return new Dimension(150, 50);
//            }
//        };
//        label.setText(String.valueOf(value));
//
//        return label;
//    }
//}
