import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by dfleuren on 14.09.2015.
 */

public class Main {

    public static void main(String[] args) {

       FileLesen fl = new FileLesen();
       //fl.lesen("Nationalhymne.txt");
        //ArrayList<String> al = fl.lesenArrayList("Natinalhymne.txt");

        FileSchreiben fs = new FileSchreiben();
        //fs.umgekehrtSchreiben(al);

        BildEinlesen bl = new BildEinlesen();
        //bl.lesen("DP.jpg");
       //bl.hexEinlesen("DP.jpg");

        DateiSchreiben ds = new DateiSchreiben();
        //ds.dataEinlesen("dead.bmp");

        DateiAendern da = new DateiAendern();
        da.hexEinlesen("test.bmp");






    }
}
