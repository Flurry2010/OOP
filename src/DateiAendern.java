import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dfleuren on 25.09.2015.
 */
public class DateiAendern {

    public void hexEinlesen(String data) {

        File fileOut = new File("neu.txt");

        try (BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(data));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut))) {

            File fileIn = new File(data);
            byte[] b = new byte[16];
            int a;
            int add = 0;
            int maxAdd = Long.toHexString(fileIn.length()).length();

            while ((a = input.read(b)) != -1) {
                StringBuilder sb = new StringBuilder(Integer.toHexString(add).toUpperCase());

                while (sb.length() < maxAdd)
                    sb.insert(0, "0");

                sb.append(": ");

                for (int i = 0; i < a; i++) {
                    int hex = b[i] & 255;
                    String hexS = Integer.toHexString(hex).toUpperCase();
                    if (hexS.length() == 1) hexS = "0" + hexS;
                    sb.append(hexS).append(" ");
                }
                if (a < 16) {
                    byte[] temp = new byte[a];

                    for (int i = 0; i < a; i++) {
                        temp[i] = b[i];
                    }

                    while (a < 16) {
                        sb.append("   ");
                        a++;
                    }
                }
                    sb.append(" ");
                    sb.append(new String(b).replaceAll("[^\\p{Print}]", ".")); //regular expression (p ist ein set (print nur druckbare Zeichen)
                    add += 16;
                    bw.append(sb);
                    bw.newLine();
            }
        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
        hexSchreiben("neu.txt");
    }

    public void hexSchreiben(String data) {

        List<byte[]> ausgabe = new ArrayList<>();
        String input;

        try (BufferedReader br = new BufferedReader(
                new FileReader(data));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("HA Ausgabe.bmp"))) {

            while ((input = br.readLine())!=null) {

                int begin = input.indexOf(':');
                input = input.substring(begin + 2, begin + 49);
                String[] split = input.split(" ");

                byte[] lager = new byte[split.length];

                for (int i = 0; i < split.length; i++) {
                    lager[i] = (byte) Integer.parseInt(split[i], 16);

//                byte[] lager = new byte[16];
//                String[] split = input.split(":")[1].trim().split(" ");
//                int i = 0;
//                while(i < 16 && !split[i].equals("")){
//                lager[i] = (byte) Integer.parseInt(split[i], 16);
//                    i++;
                }
                ausgabe.add(lager);
            }
                for (byte[] x : ausgabe)
                    bos.write(x);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}






