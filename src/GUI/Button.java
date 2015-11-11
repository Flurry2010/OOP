package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dfleuren on 10.11.2015.
 */
public class Button {


    public void box() {
        JFrame frame = new JFrame("Die Beispiel Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("RED");
        JTextArea t = new JTextArea();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t.getBackground() == Color.RED)
                    t.setBackground(Color.white);
                else t.setBackground(Color.RED);
            }
        });
        frame.add(t);
        frame.add(b,BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
