import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dfleuren on 14.09.2015.
 */
public class FileSchreiben {

    public void umgekehrtSchreiben(ArrayList<String> a){

        try
                (BufferedWriter bw = new BufferedWriter(
                        new FileWriter("Umgekehrt.txt"))){
            for(int i = a.size()-1; i >= 0; i--){
                bw.write(a.get(i));
                bw.newLine();
            }


        }catch
                (IOException e) {
            System.out.println("Fehler beim schreiben....");
        }
    }




}
