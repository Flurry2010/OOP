package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dfleuren on 15.01.2016.
 */
public class HACal {

    JTextField eingabe = new JTextField(20);
    JButton ok = new JButton("OK");
    JLabel tag = new JLabel();

    public HACal(){
        JFrame frame = new JFrame("HA Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel backg = new JPanel(new GridLayout(1,3));
        backg.add(eingabe);
        backg.add(ok);
        backg.add(tag);
//
        frame.add(backg,BorderLayout.NORTH);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new HACal();
    }

}
