import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dfleuren on 25.09.2015.
 */
public class DateiSchreiben {

    public void dataEinlesen(String data) {

        List<byte[]> ausgabe = new ArrayList<>();

        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(data))) {

            byte[] b = new byte[16];
            int a;


            while ((a = input.read(b)) != -1) {

                byte[]lager = new byte[a];

                for (int i = 0; i < a; i++) {
                   lager[i] = b[i];
                }
                ausgabe.add(lager);
            }

            dataSchreiben(ausgabe);

        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }

    public void dataSchreiben(List<byte[]> datei){

        try
                (BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream("NEU.bmp"))){

            for(byte[] bs : datei)
                bos.write(bs);

        }catch
                (IOException e) {
            System.out.println("Fehler beim schreiben....");
        }
    }
}
