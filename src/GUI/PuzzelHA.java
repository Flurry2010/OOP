package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dfleuren on 23.11.2015.
 */
public class PuzzelHA implements ActionListener{

    private static int XX = 4;
    private static int YY = 3;
    private String bildNr = "1";
    private JButton[][] buttons = new JButton[YY][XX];
    private int lastButton = 0;
    private Icon lastIcon = null;
    private boolean firstClick = true;
    private Map<String,BufferedImage> bilder = new TreeMap<>();




    public static void main(String[] args) {

        new PuzzelHA();
    }

    public PuzzelHA(){

        JFrame window = new JFrame("PuzzelHA");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLayout(new GridLayout(YY, XX));

        JMenuBar menu = new JMenuBar();
        menu.setBorder(new LineBorder(Color.BLACK));

        JMenu spiel = new JMenu("Spiel");
        JMenuItem reset = new JMenuItem("Reset");
        spiel.add(reset);

        JMenu ansicht = new JMenu("Ansicht");
        JMenu bild = new JMenu("BildNr");
        ansicht.add(bild);
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButtonMenuItem bn1 = new JRadioButtonMenuItem("1");
        bn1.setSelected(true);
        bg1.add(bn1);
        bild.add(bn1);

        JMenu pg = new JMenu("Puzzelgröße");
        ansicht.add(pg);
        ButtonGroup bg2 = new ButtonGroup();
        JRadioButton pgb1 = new JRadioButton("4x3");
        pgb1.setName("1");
        pgb1.setSelected(true);
        pg.add(pgb1);
        for(int i = 2; i <= 5; i++) {
            JRadioButtonMenuItem pgb = new JRadioButtonMenuItem("" + (i*3) + "x" + (i*3-1));
            pgb.setName("" + i);
            bg2.add(pgb);
            pg.add(pgb);
        }

        JMenu help = new JMenu("?");
        JMenuItem info = new JMenuItem("Info");
        help.add(info);

        try{
            String pfadName = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Bilder\\";
            String dateiName = "";
            for (int z = 1; z < 255; z++) {
                dateiName = "0" + z + ".jpg";
                File img = new File(pfadName + dateiName);
                if (img.exists()) {
                    BufferedImage bi = ImageIO.read(img);
                   BufferedImage nbi = resize(bi,800,600);
                    bilder.put(""+z,nbi);
                }
            }
            System.out.println("Es wurde " + bilder.size() + " Bilder gefunden!\n\n");

            for(int y = 0; y < YY; y++)
                for(int x = 0; x < XX; x++){
                    buttons[y][x] = new JButton(new ImageIcon(bilder.get(bildNr).getSubimage(x*(bilder.get(bildNr).getWidth()/XX), y*(bilder.get(bildNr).getHeight()/YY), bilder.get(bildNr).getWidth()/XX, bilder.get(bildNr).getHeight()/YY)));
                    buttons[y][x].setBorder(new LineBorder(Color.BLACK, 1));
                    buttons[y][x].setActionCommand("" + y + x);
                    buttons[y][x].setName(""+ y + x);
                    buttons[y][x].addActionListener(this);

                    window.add(buttons[y][x]);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int j = 2; j <= bilder.size(); j++){
            JRadioButtonMenuItem bn = new JRadioButtonMenuItem(""+j);
            bn.setName(""+j);
            bg1.add(bn);
            bild.add(bn);
        }

        menu.add(spiel);
        menu.add(ansicht);
        menu.add(help);
        window.add(menu);
        window.setJMenuBar(menu);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }


//    private boolean isDone(){
//
//        for(JButton[] b : buttons)
//            if (!b.getName().equals(b.getActionCommand()))
//                return false;
//
//        return true;
//    }
//
//    private boolean inTouch(int pos){
//
//        return ((pos%XX == lastButton%XX)&& Math.abs(pos/XX-lastButton/XX) < 2)||((pos/XX == lastButton/XX)&&Math.abs(pos%XX-lastButton%XX) < 2);
//    }
//
//    private void switchButton(int pos){
//
//        if(inTouch(pos)) {
//            buttons[lastButton].setIcon(buttons[pos].getIcon());
//            buttons[pos].setIcon(null);
//
//            String temp = buttons[pos].getName();
//            buttons[pos].setName(buttons[lastButton].getName());
//            buttons[lastButton].setName(temp);
//            lastButton = pos;
//        }
//    }
//
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()instanceof JRadioButtonMenuItem){
            JRadioButtonMenuItem temp = (JRadioButtonMenuItem)e.getSource();
            temp.getText();
        }

//        if(firstClick){
//            firstClick = false;
//            lastIcon = buttons[0].getIcon();
//            buttons[0].setIcon(null);
//            for(int i = 0; i < 1000; i++) {
//                int zufall = (int) (Math.random() * XX * YY);
//                switchButton(zufall);
//            }
//            while(lastButton % XX !=0)
//                switchButton(lastButton - 1);
//            while(lastButton / XX !=0)
//                switchButton(lastButton - XX);
//
//        }else {
//
//            int pos = Integer.parseInt(e.getActionCommand());
//            switchButton(pos);
//
//            if(isDone()){
//                buttons[0].setIcon(lastIcon);
//                firstClick = true;
//            }
//        }
//
//
    }

}
