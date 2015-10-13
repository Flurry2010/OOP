package RegEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by dfleuren on 13.10.2015.
 */
public class IPFinder {

    public void ip(String data) {
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {

            String read;
            Pattern p = Pattern.compile("(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])");

            List<String> ips = new LinkedList<>();

            while ((read = br.readLine()) != null) {
                Matcher m = p.matcher(read);

                while (m.find()) {
                   // ips.add(m.group());
                    System.out.printf("%02X.%02X.%02X.%02X\n",
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4)));
                }
            }
//            Collections.sort(ips);
//            System.out.println(ips);
//            System.out.println(ips.size());
        } catch (IOException e) {
            System.out.println("Dateifehler");
        }
    }
}





