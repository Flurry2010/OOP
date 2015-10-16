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
public class PKAuslesen {
    /**
     * Created by dfleuren on 13.10.2015.
     */
        public void pk(String data) {
            try (BufferedReader br = new BufferedReader(new FileReader(data))) {

                String read;
                Pattern p = Pattern.compile("\\b(([12]\\d|0[1-9]|3[10])(0[1-9]|1[0-2])\\d\\d)(-[A-Z]-)(\\d{5})\\b");

                List<String> pks = new LinkedList<>();

                while ((read = br.readLine()) != null) {
                    Matcher m = p.matcher(read);

                    while (m.find()) {
                        pks.add(m.group());
                    }
                }
           Collections.sort(pks);
            System.out.println(pks);
            System.out.println(pks.size());
            } catch (IOException e) {
                System.out.println("Dateifehler");
            }
        }

    public void komma(String data) {
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {

            String read;
            Pattern p = Pattern.compile("^[+-]?((0|[1-9]\\d*)(\\.(\\d*))?([eE][+-]?\\d{1,3})?$)");

            List<String> kommas = new LinkedList<>();

            while ((read = br.readLine()) != null) {
                Matcher m = p.matcher(read);

                while (m.find()) {
                    kommas.add(m.group());
                }
            }
            Collections.sort(kommas);
            System.out.println(kommas);
            System.out.println(kommas.size());
        } catch (IOException e) {
            System.out.println("Dateifehler");
        }
    }


    }

