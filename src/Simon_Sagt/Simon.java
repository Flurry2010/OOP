package Simon_Sagt;

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
        JButton startB = new JButton();
        startB.setIcon(new ImageIcon("src/Simon_Sagt/bilder/simon_start.png"));
        startB.setBorder(null);


        ActionListener actL = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               automat.schalten(e);
            }
        };

        startB.addActionListener(actL);
        startP.add(startB,BorderLayout.CENTER);

        JPanel simonP = new JPanel(new GridLayout(2,2));
        //Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        Icon[] icon = {new ImageIcon("src/Simon_Sagt/bilder/simon_hell-grün.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-rot.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-gelb.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-blau.png")};
        JButton[] buttons = new JButton[4];

        automat = new Automat(jp,buttons);

        for(int i = 0; i < 4; i++){
            JButton jb = buttons[i] = new JButton();
            jb.setIcon(icon[i]);
            jb.setBorder(null);
            jb.setName(""+i);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(125, 125));
            jb.addActionListener(actL);
            simonP.add(jb);
        }


        JPanel weiterP = new JPanel(new BorderLayout());
        JButton weiterB = new JButton();
        weiterB.setIcon(new ImageIcon("src/Simon_Sagt/bilder/simon_weiter.png"));
        weiterB.setBorder(null);
        weiterB.addActionListener(actL);
        weiterP.add(weiterB,BorderLayout.CENTER);

        JPanel nextP = new JPanel(new BorderLayout());
        JButton nextB = new JButton();
        nextB.setIcon(new ImageIcon("src/Simon_Sagt/bilder/simon_next.png"));
        nextB.setBorder(null);
        nextB.addActionListener(actL);
        nextP.add(nextB, BorderLayout.CENTER);

        jp.add(startP,"Start");
        jp.add(simonP,"Spiel");
        jp.add(weiterP,"Weiter");
        jp.add(nextP,"Next");

        add(jp);

        pack();
        setVisible(true);
    }













    public static void main(String[] args) {

        new Simon();
    }

}
