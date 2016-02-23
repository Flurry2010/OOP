package Simon_Sagt;

import com.sun.prism.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dfleuren on 23.02.2016.
 */
public class Simon extends JFrame {

    private Automat auto;
    private JButton button;


    public Simon(){
        super("Simon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jp = new JPanel(new CardLayout());

        JPanel startP = new JPanel();
        JButton startB = new JButton("START");
        startB.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ((CardLayout)jp.getLayout()).show(jp,"Spiel");
            }
        });
        startP.add(startB);

        JPanel simonP = new JPanel();
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        JButton[] buttons = new JButton[4];
        for(int i = 0; i < 4; i++){
            JButton jb = buttons[i] = new JButton();
            jb.setBackground(colors[i]);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(100, 100));
            simonP.add(jb);
        }


        JPanel weiterP = new JPanel();
        JButton weiterB = new JButton("WEITER");
        weiterP.add(weiterB);

        jp.add(startP,"Start");
        jp.add(simonP,"Spiel");
        jp.add(weiterP,"Weiter");

        add(jp);

        pack();
        setVisible(true);
    }













    public static void main(String[] args) {
        new Simon();
    }

}
