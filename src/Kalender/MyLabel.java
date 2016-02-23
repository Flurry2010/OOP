package Kalender;

import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dfleuren on 28.01.2016.
 */
public class MyLabel extends JLabel {

    private String termin;
    private String start;
    private String ende;
    private Date datum;
   static private SimpleDateFormat sdf = new SimpleDateFormat("EEEE.MM.yyyy");


    public MyLabel(String termin,String start, String ende,Date datum){
        super();
        this.termin = termin;
        this.start = start;
        this.ende = ende;
        this.datum = datum;
    }

    public void gui(){

        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        popup.setSize(200, 200);

        JLabel date = new JLabel(sdf.format(datum));
        date.setHorizontalAlignment(SwingConstants.CENTER);
        popup.add(date, BorderLayout.NORTH);
        
        JPanel anzeige = new JPanel();
        JPanel links = new JPanel(new GridLayout(3,1));
        JPanel rechts = new JPanel(new GridLayout(3,1));
        JLabel st = new JLabel("Beginn: ");
        links.add(st);
        JLabel stZ = new JLabel(start);
        rechts.add(stZ);
        JLabel ereig = new JLabel("Ereignis: ");
        links.add(ereig);
        JLabel ereigT = new JLabel(termin);
        rechts.add(ereigT);
        JLabel end = new JLabel("Ende: ");
        links.add(end);
        JLabel endZ = new JLabel(ende);
        rechts.add(endZ);
        
        anzeige.add(links);
        anzeige.add(rechts);
        
        JButton neu = new JButton("new");
        JButton save = new JButton("save");
        JButton close = new JButton("close");
        
        JPanel unten = new JPanel(new GridLayout(1,3));
        unten.add(neu);
        unten.add(save);
        unten.add(close);


        popup.add(anzeige,BorderLayout.CENTER);
        popup.add(unten,BorderLayout.SOUTH);
        popup.setSize(200, 200);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        MyLabel ml = new MyLabel("OOP Kausur","07:00","11:00",Calender.cal.getTime());
        ml.gui();
    }
=======
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Flurry on 28.01.2016.
 */
public class MyLabel extends JLabel{


    private Termin termin;
    private Termin[] lager = new Termin[1];



    public MyLabel(String text){
        super(text);
    }


    public void setTermin(String y){
        lager[0] = new Termin(y);
    }

    public Termin getTermin(){
        return this.lager[0];
    }


>>>>>>> origin/master
}
