package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dfleuren on 06.11.2015.
 */
public class Layout extends JavaFrame{

    public Layout() {



        JFrame frame = new JFrame("Die 2. Beispiel Box");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Einstellen Inhalt des BorderLayouts
        Color[] colors = {
                Color.RED,
                Color.BLUE,
                Color.YELLOW,
                Color.GREEN,
                Color.ORANGE};

        String[] strings = {
                "Center",
                "Norden",
                "Osten",
                "Süden",
                "Westen"};

        String[] positions = {
                BorderLayout.CENTER,
                BorderLayout.NORTH,
                BorderLayout.EAST,

                BorderLayout.WEST};


        JLabel jl;
        JButton b = new JButton(strings[1]);
        frame.add(b,positions[1]);

//        for(int i = 0; i < 5; i++){
//            jl = new JLabel(strings[i],JLabel.CENTER);
//            jl.setBackground(colors[i]);
//            jl.setOpaque(true);
//            //jl.setHorizontalAlignment(SwingConstants.CENTER);
//            frame.add(jl, positions[i]);
//        }

        frame.setSize(400,300);
        frame.setLocation(50,50);
        frame.setVisible(true);
    }

}
