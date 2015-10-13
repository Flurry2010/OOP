package RegEx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dfleuren on 29.09.2015.
 */
public class PatternMachting {

    public void einlesen(String data) {

        try (BufferedReader br = new BufferedReader(
                        new FileReader(data))) {

           // Pattern p = Pattern.compile("\\b[aA]n[a-zäüöß]+"); //findet alles was mit an oder An anfängt
            Pattern p = Pattern.compile("\\b([ÄÖÜßäöü][a-z+])|([a-zA-Z][a-z]*[äöüß][a-z]*)"); //findet alle Worte mit Umlauten
            String input;
            int counter = 0;

            while( (input = br.readLine()) != null){
              Matcher m = p.matcher(input);

                if(m.find()) //findet alle im Text
                  System.out.println(m.group());

                while(m.find())
                    counter++;
            }

            System.out.println(counter);

        } catch (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }

}
