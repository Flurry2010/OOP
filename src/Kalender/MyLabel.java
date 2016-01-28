package Kalender;

import javax.swing.*;
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


}
