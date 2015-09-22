import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dfleuren on 14.09.2015.
 */


public class FileLesen {

    public void lesen(String text) {
        try
                (BufferedReader br = new BufferedReader(
                        new FileReader(text))) {
            String zeile = null;
            while ((zeile = br.readLine()) != null)
                System.out.println(zeile);

        } catch
                (IOException e) {
            System.out.println("Fehler beim lesen....");
        }
    }



    public ArrayList<String> lesenArrayList(String text) {
        try (BufferedReader br = new BufferedReader(new FileReader(text))) {
            ArrayList<String> aList = new ArrayList<>();
            String zeile = null;
            while ((zeile = br.readLine()) != null)
                aList.add(zeile);
            return aList;

        } catch (IOException e) {
            System.out.println("Fehler beim lesen....");
        }

       return null;
    }
}
