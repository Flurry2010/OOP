import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by dfleuren on 25.09.2015.
 */
public class DateiAendern {

    public void hexEinlesen(String bild) {

        //long start = System.currentTimeMillis();
        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(bild))) {

            File file = new File(bild);
            byte[] b = new byte[16];
            int a;
            int add = 0;
            int maxAdd = Long.toHexString(file.length()).length();

            while ((a = input.read(b)) != -1) {
                StringBuilder sb = new StringBuilder(Integer.toHexString(add).toUpperCase());

                while (sb.length() < maxAdd)
                    sb.insert(0,"0");

                sb.append(":  ");

                int count = 0;
                for (int i = 0; i < a; i++) {
                    int hex = b[i] & 255;
                    String hexS = Integer.toHexString(hex).toUpperCase();
                    if (hexS.length() == 1) hexS = "0" + hexS;
                    sb.append(hexS + " ");
                    count++;
                }

                while (count < 16) {
                    sb.append("   ");
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
        //System.out.println(System.currentTimeMillis() - start);
    }


}
