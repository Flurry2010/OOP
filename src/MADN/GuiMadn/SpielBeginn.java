package MADN.GuiMadn;

import MADN.images.Images;
import MADN.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by dfleuren on 19.01.2016.
 */
public class SpielBeginn extends JDialog {

    private Spieler[] startAufstellung = new Spieler[4];
    private JButton weiter = new JButton("Weiter");
    private int groesse = 320;

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
        oben.add(new JLabel("Ziehen Sie die....", JLabel.CENTER));
        oben.add(new JLabel("in die gewünschte....", JLabel.CENTER));
        add(oben, BorderLayout.NORTH);

        JPanel mitte = new JPanel(null);
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                DragLabel dl = (DragLabel)e.getSource();
                //ausserhalb des Fensters?
                if(     dl.getX() < -dl.getWidth()/2 ||
                        dl.getY() < -dl.getHeight()/2 ||
                        dl.getX() > groesse-dl.getWidth()/2||
                        dl.getY() > groesse-dl.getHeight()/2)
                    dl.setLocation(groesse / 2, groesse / 2);
                //über dem Kreis?
                //oben links
                else if(dl.getX() < dl.getWidth() && dl.getY() < dl.getHeight()){
                    dl.setLocation(0,0);
                }
                //oben rechts
                else if(dl.getX() > groesse-dl.getWidth()*2 && dl.getY() < dl.getHeight()){
                    dl.setLocation(groesse - dl.getWidth(), 0);
                }
                //über links unten
                else if(dl.getX()<dl.getWidth()&& dl.getY() > groesse-dl.getHeight()*2){
                    dl.setLocation(0,groesse-dl.getHeight());

                }
                //über rechts unten
                else if(dl.getX()>groesse-dl.getWidth()*2&& dl.getY() > groesse-dl.getHeight()*2) {
                    dl.setLocation(groesse - dl.getWidth(), groesse - dl.getHeight());

                }
            }
        };

        DragLabel dl = new DragLabel(Images.FIGUR_ROT);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2, groesse / 2);
        dl.addMouseListener(ma);
        mitte.add(dl);

        dl = new DragLabel(Images.FIGUR_GELB);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2, groesse / 2 - dl.getHeight());
        dl.addMouseListener(ma);
        mitte.add(dl);

        dl = new DragLabel(Images.FIGUR_GRUEN);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2 - dl.getWidth(), groesse / 2);
        dl.addMouseListener(ma);
        mitte.add(dl);

        dl = new DragLabel(Images.FIGUR_BLAU);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2 - dl.getHeight(), groesse / 2 - dl.getWidth());
        dl.addMouseListener(ma);
        mitte.add(dl);




        JLabel jl = new JLabel(Images.KREIS_GRAU);
        jl.setSize(jl.getPreferredSize());
        jl.setLocation(0, 0);
        mitte.add(jl);

        jl = new JLabel(Images.KREIS_GRAU);
        jl.setSize(jl.getPreferredSize());
        jl.setLocation(groesse - jl.getWidth(), 0);
        mitte.add(jl);

        jl = new JLabel(Images.KREIS_GRAU);
        jl.setSize(jl.getPreferredSize());
        jl.setLocation(0, groesse - jl.getHeight());
        mitte.add(jl);

        jl = new JLabel(Images.KREIS_GRAU);
        jl.setSize(jl.getPreferredSize());
        jl.setLocation(groesse - jl.getWidth(), groesse - jl.getHeight());
        mitte.add(jl);

        mitte.setPreferredSize(new Dimension(groesse, groesse));



        add(mitte, BorderLayout.CENTER);

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
