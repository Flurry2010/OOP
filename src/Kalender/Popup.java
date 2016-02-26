//package Kalender;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//
//
///**
// * Created by Flurry on 28.01.2016.
// */
//public class Popup {
//
//    MyLabel label;
//    SimpleDateFormat sdf = new SimpleDateFormat("EEEE.MM.yyyy");
//    JTextArea ta;
//    JFrame frame;
//
//    public Popup(String x,MyLabel label){
//
//        this.label = label;
//
//        frame = new JFrame("Termine");
//        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//
//        JLabel oben = new JLabel();
//        oben.setText(label.getText() + " " + x);
//        oben.setHorizontalAlignment(SwingConstants.CENTER);
//        frame.add(oben, BorderLayout.NORTH);
//
//        ta = new JTextArea(10,10);
//        if(label.getTermin() != null)
//        ta.setText(label.getTermin().toString());
//        JScrollPane sp = new JScrollPane(ta);
//        frame.add(sp,BorderLayout.CENTER);
//
//        JPanel unten = new JPanel(new GridLayout(1,2));
//
//        ActionListener al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource() instanceof JButton);
//                switch (e.getActionCommand()){
//                    case "SAVE":
//                       speichern();
//                        frame.dispose();
//                        break;
//                    case "CLOSE":
//                        frame.dispose();
//                       break;
//                }
//            }
//        };
//        JButton save = new JButton("SAVE");
//        save.addActionListener(al);
//        JButton close = new JButton("CLOSE");
//        close.addActionListener(al);
//
//        unten.add(save);
//        unten.add(close);
//        frame.add(unten,BorderLayout.SOUTH);
//
//        frame.setSize(200, 200);
//        frame.setVisible(true);
//
//    }
//
////    public String einlesen(){
////
////
////    }
//
//
//    public void speichern() {
//        label.setTermin(ta.getText());
//
//    }
//
//}
