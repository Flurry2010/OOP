package GUI;

import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Flurry on 26.01.2016.
 */
public class HACal2 {

    private static final String[] DAYS = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};

    public HACal2() {

        JFrame jf = new JFrame("HA Calender 2");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jp = new JPanel(new FlowLayout());
        JPanel jp2 = new JPanel(new FlowLayout());
        GregorianCalendar cal = new GregorianCalendar();

        //Das Format für das Datum festlegen
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        JTextField tf = new JTextField(10);
        tf.setText(sdf.format(cal.getTime()));
        JLabel jl = new JLabel(DAYS[cal.get(Calendar.DAY_OF_WEEK)-1]);
        JLabel mo = new JLabel();
        JLabel tmp = new JLabel();
        JLabel so = new JLabel();
        JButton ok = new JButton("ok");

        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    cal.setTime(sdf.parse(tf.getText()));
                    jl.setText(DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);

                    //Kalender auf Montag gesetzt
                    cal.set(Calendar.DAY_OF_WEEK, 2);
                    mo.setText(sdf.format(cal.getTime()) + ", " + DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);

                    tmp.setText(cal.get(Calendar.WEEK_OF_YEAR) + ". Kw");

                    //Kalender auf Sontag gesetzt
                    cal.set(Calendar.DAY_OF_WEEK, 1);
                    so.setText(sdf.format(cal.getTime()) + ", " + DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);

                    jf.pack();
                }catch (ParseException e1){
                    JOptionPane.showMessageDialog(jf,"Die Eingabe hat das falsche Format: TT.MM.JJJJ", "Fehler im Datum",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jp.add(tf);
        jp.add(ok);
        jp.add(jl);
        jp2.add(mo);
        jp2.add(tmp);
        jp2.add(so);

        jf.add(jp,BorderLayout.NORTH);
        jf.add(jp2,BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new HACal2();
    }


}

