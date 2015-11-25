package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by dfleuren on 24.11.2015.
 */
public class Sudoku {

    public static void main(String[] args) {
        new Sudoku();
    }

    public Sudoku(){

        JFrame window = new JFrame("Sudoku");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(600, 600);

        JPanel oben = new JPanel(new BorderLayout());
        JPanel zeit = new JPanel();
        JLabel time = new JLabel("Zeit:");
        JLabel uhr = new JLabel("3:12");
        uhr.setFont(new Font("arial", Font.BOLD, 30));
        uhr.setForeground(Color.BLUE);
        JPanel neuB = new JPanel(new GridLayout(2,1));
        JButton neu = new JButton("NEU");
        neuB.add(neu);

        zeit.add(time);
        zeit.add(uhr);
        oben.add(neuB,BorderLayout.EAST);
        oben.add(zeit, BorderLayout.WEST);

        window.add(oben,BorderLayout.NORTH);

        JPanel mitte = new JPanel(new GridLayout(3,3));
        mitte.setBorder(new LineBorder(Color.BLACK, 2));

        for(int i = 0; i < 9; i++ ){
            JPanel x = new JPanel(new GridLayout(3,3));
            x.setBorder(new LineBorder(Color.BLACK,2));
            for (int j = 1; j <= 9; j++){
                JLabel y = new JLabel(" " + j);
                y.setBackground(Color.WHITE);
                y.setBorder(new LineBorder(Color.BLACK));
                y.setHorizontalAlignment(SwingConstants.CENTER);
                y.setOpaque(true);
                x.add(y);
            }
            mitte.add(x, BorderLayout.CENTER);
        }
        window.add(mitte, BorderLayout.CENTER);

        JPanel unten = new JPanel(new GridLayout(2,1));
        JPanel untenO = new JPanel(new GridLayout(1,6));
        for(int i = 0; i < 6; i++) {
            JButton z = new JButton("" + (i+1));
            z.setName("" + i);
            untenO.add(z);
        }
        unten.add(untenO,BorderLayout.SOUTH);

        JPanel untenU = new JPanel(new GridLayout(1,2));
        JPanel untenU1 = new JPanel(new GridLayout(1,3));
        for(int i = 7; i <= 9; i++){
            JButton z = new JButton("" + i);
            z.setName(""+1);
            untenU1.add(z);
        }
        JPanel untenU2 = new JPanel(new BorderLayout());
        JButton clean = new JButton();
        clean.setIcon(new ImageIcon("radiergummi.jpg"));
        JButton reset = new JButton("RESET");
        untenU2.add(clean, BorderLayout.WEST);
        untenU2.add(reset,BorderLayout.CENTER);

        untenU.add(untenU1);
        untenU.add(untenU2);
        unten.add(untenU);

        window.add(unten, BorderLayout.SOUTH);



        window.setResizable(true);
       // window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }



}
