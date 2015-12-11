package Fehler;

/**
 * Created by dfleuren on 11.12.2015.
 */
public class Auto {

    private int tank;
    private boolean reifen = true;
    private boolean motor = true;


    public void tanken() {
        tank = 100;
    }

    public void reifenwechsel() {
        reifen = true;
    }


    public void fahren() throws TankLeerException, ReifenKaputtException {
        if (tank <= 0)
            throw new TankLeerException();

        if (!reifen) {
            System.out.println("reifen kaputt");
            throw new ReifenKaputtException();
        }

        if (!motor) {
            System.out.println("motor kaputt");
            throw new MotorKaputtError();
        }

        tank--;

        reifen = (Math.random() > 0.001);

        motor = (Math.random() > 0.0001);

    }


}
