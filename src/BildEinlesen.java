
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


/**
 * Created by dfleuren on 18.09.2015.
 */
public class BildEinlesen {

    public void lesen(String bild) {

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(bild))) {

            byte[] b = new byte[16];
            int a;

            while ((a = in.read(b)) != -1) {
                System.out.println();
                for (int i = 0; i < a; i++) {
                    int h = b[i] & 255;
                    String hex = Integer.toHexString(h).toUpperCase();
                    if (hex.length() == 1) hex = "0" + hex;
                    System.out.print(hex + " ");
                }
            }
        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }

    public void hexEinlesen(String bild) {

        long start = System.currentTimeMillis();
        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(bild))) {

            File file = new File(bild);
            byte[] b = new byte[16];
            int a;
            int add = 0;
            //int maxAdd = ((Long)file.length()).toString().length()-1; //stimmt nicht immer, weil kein HEX-Wert
            int maxAdd = Long.toHexString(file.length()).length();

            while ((a = input.read(b)) != -1) {
                StringBuilder sb = new StringBuilder(Integer.toHexString(add).toUpperCase());
                //String addr = Integer.toHexString(add).toUpperCase();

                while (sb.length() < maxAdd)
                    sb.insert(0,"0");
                   // addr = "0" + addr;

                sb.append(":  ");
                //System.out.print("0x" + addr + ":  ");

                int count = 0;
                for (int i = 0; i < a; i++) {
                    int hex = b[i] & 255;
                    String hexS = Integer.toHexString(hex).toUpperCase();
                    if (hexS.length() == 1) hexS = "0" + hexS;
                    sb.append(hexS + " ");
                    //System.out.print(hexS + " ");
                    count++;
                }

                    while (count < 16) {
                        sb.append("   ");
                        //System.out.print("   ");
                        b[a] = 0;
                        count++;
                    }

                sb.append(" " + new String(b).replaceAll("[^\\p{Print}]", ".")); //regular expression (p ist ein set (print nur druckbare Zeichen)
                System.out.println(sb);
                add += 16;
            }

        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }
}

