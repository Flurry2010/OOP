package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dfleuren on 06.11.2015.
 */
public class ZweiFrame extends JavaFrame {

    public JLabel neueslable() {
        JLabel jl = new JLabel("Mein Beispiel TEXT", JLabel.CENTER);
        return jl;
    }

    public ZweiFrame() {

        JFrame frame = new JFrame("Die 1. Beispiel Box");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel jl = new JLabel("Mein Beispiel TEXT", JLabel.CENTER);
        jl.setForeground(Color.red);
        jl.setFont(new Font("",Font.BOLD,40));
        jl.setBackground(Color.black);
        jl.setOpaque(true);
        frame.add(neueslable());
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(frame);
        //frame.add(jl);
        //jl.setHorizontalAlignment(SwingConstants.CENTER);
        frame.setVisible(true);

        JFrame frame2 = new JFrame("Die 2. Beispiel Box");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jl.setForeground(Color.red);
        jl.setFont(new Font("",Font.BOLD,40));
        jl.setBackground(Color.black);
        jl.setOpaque(true);
        frame2.add(neueslable());
        frame2.setSize(400, 200);
        frame2.setLocationRelativeTo(frame);
        //frame.add(jl);
        //jl.setHorizontalAlignment(SwingConstants.CENTER);
        frame2.setVisible(true);
    }


}
