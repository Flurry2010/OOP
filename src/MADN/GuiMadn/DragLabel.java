package MADN.GuiMadn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dfleuren on 22.01.2016.
 */
public class DragLabel extends JLabel {

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
