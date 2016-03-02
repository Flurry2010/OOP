package Simon_Sagt;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dfleuren on 23.02.2016.
 */
public class Automat {

    private int pos = 0;
    private JButton[] buttons;
    private List<JButton> farben = new ArrayList<>();
    private int zustand = 1;
    private JPanel jp;
    private Icon[] hell = {new ImageIcon("src/Simon_Sagt/bilder/simon_hell-grün.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-rot.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-gelb.png"),new ImageIcon("src/Simon_Sagt/bilder/simon_hell-blau.png")};



    public Automat(JPanel jp, JButton[] buttons) {
        this.jp = jp;
        this.buttons = buttons;
    }

    public void schalten(ActionEvent e) {

        switch (zustand) {
            case 1:
                ((CardLayout) jp.getLayout()).show(jp, "Spiel");
                zustand = 2;
                schalten(null);
                break;

            case 2:
                if (e != null) break;
                int stelle = ((int) (Math.random() * 4));
                farben.add(buttons[stelle]);

                new Thread() {
                    public void run() {

                        try {
                            sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }

                        for (JButton jb : farben) {
                            //Color c = jb.getBackground();
                            Icon c = jb.getIcon();
                            //jb.setBackground(new Color(c.getRGB() | 0x808080)); //ff8080 RGB Farbe wird heller
                            jb.setIcon(hell[stelle]);

                            try {
                                sleep(2000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                            //jb.setBackground(c);
                            jb.setIcon(c);

                            try {
                                sleep(200);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        zustand = 3;
                        ((CardLayout) jp.getLayout()).show(jp, "Weiter");

                    }
                }.start();
                break;

            case 3:
                ((CardLayout) jp.getLayout()).show(jp, "Spiel");
                zustand = 4;
                break;

            case 4:
                System.out.println("bin da");
                if (e.getSource() != farben.get(pos)) {
                    zustand = 1;
                    farben.clear();
                    pos = 0;
                    ((CardLayout) jp.getLayout()).show(jp, "Start");
                    JOptionPane.showMessageDialog(jp,"!! LEIDER FALSCH !!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    System.out.println("war falsch");
                } else if (pos < farben.size() - 1) {
                    pos++;
                    System.out.println("war richtig");
                }
                else {
                    zustand = 1;
                    pos = 0;
                    ((CardLayout) jp.getLayout()).show(jp, "Next");
                    System.out.println("geht weiter");
                }
        }
    }

}
