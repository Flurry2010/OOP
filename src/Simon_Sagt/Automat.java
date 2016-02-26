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
                farben.add(buttons[(int) (Math.random() * 4)]);

                new Thread() {
                    public void run() {

                        try {
                            sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }

                        for (JButton jb : farben) {
                            Color c = jb.getBackground();
                            jb.setBackground(new Color(c.getRGB() | 0x808080)); //ff8080 RGB Farbe wird heller

                            try {
                                sleep(2000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                            jb.setBackground(c);

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
                    System.out.println("war falsch");
                } else if (pos < farben.size() - 1) {
                    pos++;
                    System.out.println("war richtig");
                }
                else {
                    zustand = 1;
                    pos = 0;
                    ((CardLayout) jp.getLayout()).show(jp, "Start");
                    System.out.println("geht weiter");
                }
        }
    }

}
