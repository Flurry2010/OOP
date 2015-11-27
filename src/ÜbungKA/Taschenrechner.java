package ÜbungKA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dfleuren on 27.11.2015.
 */
public class Taschenrechner {

    private JTextField tf = new JTextField(10);
    private JTextArea ta = new JTextArea(3,10);
    private JFrame window;
    private ActionListener al1= new ActionListener() {

        public void actionPerformed(ActionEvent e) {

        }
    };
    private ActionListener al2 = new ActionListener() {

        public void actionPerformed(ActionEvent e) {

        }
    };


    public static void main(String[] args) {
        new Taschenrechner();
    }

    public Taschenrechner(){
        window = new JFrame("Rechner");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JScrollPane sp = new JScrollPane(ta);

        window.add(sp, BorderLayout.CENTER);

        JPanel center = new JPanel(new GridLayout(2,1));
        tf.setHorizontalAlignment(SwingConstants.RIGHT);

        tf.setOpaque(false);
        center.add(tf);
        JPanel radio = new JPanel();
        ButtonGroup bg = new ButtonGroup();
        JRadioButton deg = new JRadioButton("Deg");
        JRadioButton rad = new JRadioButton("Rad");
        JRadioButton grad = new JRadioButton("Grad");
        bg.add(deg);
        bg.add(rad);
        bg.add(grad);
        radio.add(deg);
        radio.add(rad);
        radio.add(grad);
        deg.setEnabled(true);
        deg.setSelected(true);
        rad.setEnabled(false);
        grad.setEnabled(false);
        center.add(radio);


        JPanel south = new JPanel(new BorderLayout());
        JPanel eins1 = new JPanel(new BorderLayout());
        eins1.add(center,BorderLayout.NORTH);

        JPanel eins = new JPanel(new GridLayout(1,2));
        eins.add(new JButton("<--"));
        eins.add(new JButton("clear"));
        south.add(eins,BorderLayout.NORTH);

        JPanel zwei = new JPanel(new GridLayout(3,4));
         for(int i = 1; i <= 12; i++){
             JButton jb = new JButton(""+i);
             zwei.add(jb);
         }

        south.add(zwei,BorderLayout.CENTER);

        JPanel drei = new JPanel(new BorderLayout());
        JButton jb = new JButton("=");
        drei.add(jb, BorderLayout.EAST);

        JPanel dreiX = new JPanel(new GridLayout(2,1));

        JPanel drei1 = new JPanel(new GridLayout(1,3));
        drei1.add(new JButton("1"));
        drei1.add(new JButton("2"));
        drei1.add(new JButton("3"));
        dreiX.add(drei1);

        JPanel drei2 = new JPanel(new BorderLayout());
        drei2.add(new JButton("0"));
        drei2.add(new JButton(","),BorderLayout.EAST);
        dreiX.add(drei2);

        drei.add(dreiX,BorderLayout.CENTER);
        south.add(drei,BorderLayout.SOUTH);
        eins1.add(south,BorderLayout.SOUTH);

        window.add(eins1,BorderLayout.SOUTH);












        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);

    }




}
