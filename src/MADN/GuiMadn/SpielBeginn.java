package MADN.GuiMadn;

import MADN.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by dfleuren on 19.01.2016.
 */
public class SpielBeginn extends JDialog {

    private Spieler[] startAufstellung = new Spieler[4];
    private JButton weiter = new JButton("Weiter");


    public SpielBeginn(){

        super((JFrame) null, "Mensch Ärger dich nicht!", true);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                startAufstellung = null;
                setVisible(false);
            }
        });

        JPanel oben = new JPanel(new GridLayout(2,1));
        oben.add(new JLabel("Zihen Sie die....", JLabel.CENTER));
        oben.add(new JLabel("ind die gewünschte....", JLabel.CENTER));
        add(oben, BorderLayout.NORTH);

        weiter.setEnabled(false);
        weiter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(weiter, BorderLayout.SOUTH);
        pack();
        setVisible(true);





    }

    public Spieler[] getStartaufstellung(){

        return startAufstellung;
    }
}
