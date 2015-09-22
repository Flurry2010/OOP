
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

        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(bild))) {

            File file = new File(bild);
            byte[] b = new byte[16];
            int a;
            int add = 0;
            //int maxAdd = ((Long)file.length()).toString().length()-1; //stimmt nicht immer, weil kein HEX-Wert
            int maxAdd = Long.toHexString(file.length()).length();

            while ((a = input.read(b)) != -1) {
                String addr = Integer.toHexString(add).toUpperCase();

                while (addr.length() < maxAdd)
                    addr = "0" + addr;

                System.out.print("0x" + addr + ":  ");

                int count = 0;
                for (int i = 0; i < a; i++) {
                    int hex = b[i] & 255;
                    String hexS = Integer.toHexString(hex).toUpperCase();
                    if (hexS.length() == 1) hexS = "0" + hexS;
                    System.out.print(hexS + " ");
                    count++;
                }

                    while (count < 16) {
                        System.out.print("   ");
                        Arrays.fill(b, (byte) 0);
                        count++;
                    }

                System.out.print(" " + new String(b).replaceAll("[^\\p{Print}]", "."));
                add += 16;

                System.out.println();
            }

        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }
}

