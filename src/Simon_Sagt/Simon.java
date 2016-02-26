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

    private Automat automat;
    private JButton button;


    public Simon(){
        super("Simon");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jp = new JPanel(new CardLayout());



        JPanel startP = new JPanel(new BorderLayout());
        JButton startB = new JButton("START");

        ActionListener actL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               automat.schalten(e);
            }
        };

        startB.addActionListener(actL);
        startP.add(startB,BorderLayout.CENTER);

        JPanel simonP = new JPanel(new GridLayout(2,2));
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        JButton[] buttons = new JButton[4];

        automat = new Automat(jp,buttons);

        for(int i = 0; i < 4; i++){
            JButton jb = buttons[i] = new JButton();
            jb.setBackground(colors[i]);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(100, 100));
            jb.addActionListener(actL);
            simonP.add(jb);
        }


        JPanel weiterP = new JPanel(new BorderLayout());
        JButton weiterB = new JButton("WEITER");

        weiterB.addActionListener(actL);
        weiterP.add(weiterB,BorderLayout.CENTER);

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
