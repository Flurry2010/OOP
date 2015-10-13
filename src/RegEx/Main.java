package RegEx;

/**
 * Created by dfleuren on 29.09.2015.
 */
public class Main {

    public static void main(String[] args) {

//        PatternMachting pm = new PatternMachting();
//        pm.einlesen("bibel.txt");

        IPFinder ip = new IPFinder();
        ip.ip("ip.log");

    }
}
