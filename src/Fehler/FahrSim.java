package Fehler;

/**
 * Created by dfleuren on 11.12.2015.
 */
public class FahrSim {

    public static void main(String[] args) {

        Auto auto = new Auto();
        auto.tanken();

        for (int i = 0; i < 1000; i++)

            try {
                auto.fahren();
                System.out.print(i + " ");

            } catch (TankLeerException e) {
                System.out.println("\n"+"tank leer");
                auto.tanken();
            } catch (ReifenKaputtException e) {
                System.out.println("\n"+"reifen kaputt");
                auto.reifenwechsel();
            }
    }
}
