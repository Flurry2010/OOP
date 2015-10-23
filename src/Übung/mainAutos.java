package Übung;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dfleuren on 20.10.2015.
 */
public class mainAutos {
    public static void main(String[] args) {

        Autos a = new Autos();
        List<File> addr = new ArrayList<>();
        int count = 0;

        System.out.println("Dateien werden eingelesen");

        for (int i = 0; i <= 32; i++) {
            String daten = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_" + i + ".txt";
            File file = new File(daten);
            if (file.exists()) {
                addr.add(file);
                System.out.print(".");
                count++;
            }
        }
        System.out.println();
        System.out.println("Es wurden " + count + " Dateien gefunden" + "\n");
        System.out.println("Daten werden verarbeitet \n");
        a.einlesen(addr);
    }
}
