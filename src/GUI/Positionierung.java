package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dfleuren on 15.01.2016.
 */
public class Positionierung {


    public Positionierung(){
        JFrame frame = new JFrame("Die Beispiel Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel bild = new DragLabel(new ImageIcon("DP.jpg"));
        bild.setSize(bild.getPreferredSize());
        bild.setLocation(100, 100);

        frame.add(bild);

        JLabel text = new JLabel("DEADPOOL");
        text.setSize(text.getPreferredSize());
        text.setLocation(450, 300);

        frame.add(text);

        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Positionierung();
    }

    private class DragLabel extends JLabel{

        private Point start;
        private Point start2;

        public DragLabel(Icon icon){
            super(icon);
            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
//                    start = new Point(e.getLocationOnScreen().x - getLocation().x, e.getLocationOnScreen().y - getLocation().y);
                    start2 = new Point(e.getXOnScreen() - getLocation().x, e.getYOnScreen() - getLocation().y);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
//                    setLocation(e.getLocationOnScreen().x - start.x, e.getLocationOnScreen().y - start.y);
                    setLocation(e.getXOnScreen() - start2.x, e.getYOnScreen() - start2.y);
                }
            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }
    }

}
