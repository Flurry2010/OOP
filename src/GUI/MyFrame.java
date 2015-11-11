package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dfleuren on 03.11.2015.
 */
public class MyFrame extends JavaFrame {

    public MyFrame()
    {

        JFrame frame = new JFrame("Die 2. Beispiel Box");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel jl = new JLabel("Mein Beispiel TEXT", JLabel.CENTER);
        jl.setForeground(Color.red);
        jl.setFont(new Font("",Font.BOLD,40));
        jl.setBackground(Color.black);
        jl.setOpaque(true);
        frame.add(jl);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(frame);
        //jl.setHorizontalAlignment(SwingConstants.CENTER);
        frame.setVisible(true);
    }
}
