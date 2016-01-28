package Kalender;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Calender {

    int grosse = 350;
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat all = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat day = new SimpleDateFormat("dd");
    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    JLabel monat = new JLabel();
    JLabel jahr = new JLabel();
    JPanel blatt = new JPanel(new GridLayout(5,7));
    JFrame frame = new JFrame();
    Date toDay = new Date();


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
                        cal.add(Calendar.MONTH, -1);
                        frame.remove(blatt);
                        switchMonth();
                        break;
                    case "NEXT":
                        cal.add(Calendar.MONTH,1);
                        frame.remove(blatt);
                        switchMonth();
                        break;
                }
            }
        };



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

        toDay=cal.getTime();
        switchMonth();

        frame.add(menu,BorderLayout.NORTH);
        frame.setSize(grosse, grosse);
        frame.setVisible(true);
    }

    private void switchMonth() {

        blatt = new JPanel(new GridLayout(5,7));

        jahr.setText(year.format(cal.getTime()));
        jahr.setHorizontalAlignment(SwingConstants.CENTER);
        monat.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN));
        monat.setHorizontalAlignment(SwingConstants.CENTER);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                if(e.getSource() instanceof MyLabel){
                    new Popup(monat.getText()+" "+jahr.getText(),(MyLabel)e.getSource());

                }
            }
        };

            for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                MyLabel tag = new MyLabel(cal.get(Calendar.DAY_OF_MONTH) + "");
                tag.setHorizontalAlignment(SwingConstants.CENTER);
                MyLabel tag1 = new MyLabel(DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);
                if(cal.get(Calendar.DAY_OF_MONTH) != cal.getActualMaximum(Calendar.DAY_OF_MONTH))
                cal.add(Calendar.DAY_OF_WEEK, 1);
                tag1.setHorizontalAlignment(SwingConstants.CENTER);
                JPanel back = new JPanel(new GridLayout(2, 1));
                tag.addMouseListener(ma);
                tag1.addMouseListener(ma);
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