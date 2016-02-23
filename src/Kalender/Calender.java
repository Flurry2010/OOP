package Kalender;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calender {

    int grosse = 350;
   static public GregorianCalendar cal = new GregorianCalendar();
    private SimpleDateFormat all = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat month = new SimpleDateFormat("MM");
    private SimpleDateFormat day = new SimpleDateFormat("dd");
    private SimpleDateFormat year = new SimpleDateFormat("yyyy");
    private JLabel monat = new JLabel();
    private JLabel jahr = new JLabel();
    private JPanel blatt = new JPanel(new GridLayout(5,7));
    private JFrame frame = new JFrame();
    private Date toDay = new Date();

    private static final String[] DAYS = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
    private static final String[] DAYS1 = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};

    public Calender(){

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() instanceof JButton);
                switch (e.getActionCommand()){
                    case "LAST":
                        //cal.set(Calendar.DAY_OF_MONTH, 1);
                        cal.add(Calendar.MONTH, -1);
                        frame.remove(blatt);
                        switchMonth();
                        break;
                    case "NEXT":
                        //cal.set(Calendar.DAY_OF_MONTH, 1);
                        cal.add(Calendar.MONTH,1);
                        frame.remove(blatt);
                        switchMonth();
                        break;
                }
            }
        };

        toDay = cal.getTime();

        JPanel menu = new JPanel(new GridLayout(1,3));
        JButton last = new JButton("LAST");
        last.addActionListener(al);

        JPanel mitte = new JPanel(new GridLayout(2,1));
        mitte.setBackground(Color.DARK_GRAY);
        jahr.setForeground(Color.WHITE);
        monat.setForeground(Color.WHITE);
        mitte.add(jahr);
        mitte.add(monat);
        JButton next = new JButton("NEXT");
        next.addActionListener(al);

        menu.add(last);
        menu.add(mitte);
        menu.add(next);

        jahr.setText(year.format(cal.getTime()));
        jahr.setHorizontalAlignment(SwingConstants.CENTER);
        monat.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN));
        monat.setHorizontalAlignment(SwingConstants.CENTER);

        switchMonth();

        frame.add(menu,BorderLayout.NORTH);
        frame.setSize(grosse, grosse);
        frame.setVisible(true);
    }

    private void switchMonth() {

        blatt = new JPanel(new GridLayout(5,7));
        cal.set(Calendar.DAY_OF_MONTH, 1);

        jahr.setText(year.format(cal.getTime()));
        jahr.setHorizontalAlignment(SwingConstants.CENTER);
        monat.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN));
        monat.setHorizontalAlignment(SwingConstants.CENTER);


            for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                JLabel tag = new JLabel(cal.get(Calendar.DAY_OF_MONTH) + "");
                tag.setHorizontalAlignment(SwingConstants.CENTER);
                JLabel tag1 = new JLabel(DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);
                if(cal.get(Calendar.DAY_OF_MONTH) != cal.getActualMaximum(Calendar.DAY_OF_MONTH))
                cal.add(Calendar.DAY_OF_WEEK, 1);
                tag1.setHorizontalAlignment(SwingConstants.CENTER);
                JPanel back = new JPanel(new GridLayout(2, 1));
                back.setBorder(new LineBorder(Color.BLACK));
                back.add(tag);
                back.add(tag1);
                blatt.add(back);
            }

        for(int j = cal.getActualMaximum(Calendar.DAY_OF_MONTH); j < 35; j++){
            blatt.add(new JLabel());
        }

        frame.add(blatt, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        new Calender();
    }
}