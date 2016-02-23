package Kalender;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Flurry on 28.01.2016.
 */
public class Termin {

    //private Date start;
    private String ereignis = "";
    //private Date ende;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");


    public Termin(String ereignis){

        //this.start = start;
        this.ereignis = ereignis;
        //this.ende = ende;
    }

    public String toString(){
        return ereignis;
    }
}
