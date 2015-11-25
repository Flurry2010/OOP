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
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dfleuren on 23.11.2015.
 */
public class PuzzelHA implements ActionListener {

    private JFrame window;
    private JPanel game;
    private int XX = 2;
    private int YY = 3;
    private String bildNr = "1";
    private PuzzelHAButton[][] buttons;
    private int lastButtonX = 0;
    private int lastButtonY = 0;
    private Icon lastIcon = null;
    private boolean firstClick = true;
    private Map<String, BufferedImage> bilder = getBilder();


    public static void main(String[] args) {

        new PuzzelHA();

    }

    public PuzzelHA() {

        window = new JFrame("PuzzelHA");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        //window.setLayout(new GridLayout(YY, XX));



        //-----------------Menü erstellen---------------------------------------
        JMenuBar menu = new JMenuBar();
        menu.setBorder(new LineBorder(Color.BLACK));

        JMenu spiel = new JMenu("Spiel");
        JMenuItem reset = new JMenuItem("Reset");
        reset.addActionListener(this);
        reset.setActionCommand("reset");
        spiel.add(reset);

        JMenu ansicht = new JMenu("Ansicht");
        JMenu bild = new JMenu("BildNr.");
        ansicht.add(bild);
        ButtonGroup bg1 = new ButtonGroup();

        for (int j = 1; j <= bilder.size(); j++) {
            JRadioButtonMenuItem bn = new JRadioButtonMenuItem("" + j);
            bn.setName(""+j);
            bn.setActionCommand("b");
            bn.addActionListener(this);
            bg1.add(bn);
            bild.add(bn);
        }

        JMenu pg = new JMenu("Puzzelgröße");
        ansicht.add(pg);
        ButtonGroup bg2 = new ButtonGroup();

        for (int i = 1; i <= 4; i++) {
            JRadioButtonMenuItem pgb = new JRadioButtonMenuItem("" + (i * 2) + "x" + (i * 2-1));
            pgb.setActionCommand("g" + i);
            pgb.addActionListener(this);
            bg2.add(pgb);
            pg.add(pgb);
        }

        JMenu help = new JMenu("?");
        JMenuItem info = new JMenuItem("Info");
        help.add(info);

        menu.add(spiel);
        menu.add(ansicht);
        menu.add(help);
        window.add(menu);
        window.setJMenuBar(menu);

        //---------------- Menü END-------------------------------------

        baueButton();

        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
    }

    //--------------------------Bilder finden und Map füllen---------------------------------------------
    private Map<String, BufferedImage> getBilder() {

        try {
            Map<String, BufferedImage> temp = new TreeMap<>();
           // String pfadName = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Bilder\\";
            String pfadName = "C:\\Users\\Flurry\\OOP\\OOP\\Bilder\\";
            String dateiName = "";
            for (int z = 1; z < 255; z++) {
                dateiName = z + ".jpg";
                File img = new File(pfadName + dateiName);
                if (img.exists()) {
                    BufferedImage bi = ImageIO.read(img);
                    BufferedImage nbi = resize(bi, 800, 600);
                    temp.put("" + z, nbi);
                }
            }
            System.out.println("Es wurde " + temp.size() + " Bilder gefunden!\n\n");
            return temp;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Es wurden keine Bilder gefunden!\n\n");
            return null;
        }
    }

    //-----------------------------Bilder immer auf 800x600 ändern----------------------------------------------
    private BufferedImage resize(BufferedImage img, int newW, int newH) {
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

    //----------------Buttons erstellen------------------------------------------------------------------------
    private void baueButton() {

        game = new JPanel(new GridLayout(YY, XX));
        buttons = new PuzzelHAButton[YY][XX];

        for (int y = 0; y < YY; y++)
            for (int x = 0; x < XX; x++) {
                buttons[y][x] = new PuzzelHAButton(new ImageIcon(bilder.get(bildNr).getSubimage(x * (bilder.get(bildNr).getWidth() / XX), y * (bilder.get(bildNr).getHeight() / YY), bilder.get(bildNr).getWidth() / XX, bilder.get(bildNr).getHeight() / YY)));
                buttons[y][x].setBorder(new LineBorder(Color.BLACK, 1));
                buttons[y][x].setActionCommand("" + y + x);
                buttons[y][x].setName("" + y + x);
                buttons[y][x].setPosY(y);
                buttons[y][x].setPosX(x);
                buttons[y][x].addActionListener(this);
                this.game.add(buttons[y][x]);
            }
        window.getContentPane().add(game);
    }

    //---------------------Spielablauf------------------------------------------------------------
    private boolean isDone() {

        for (JButton[] b : buttons) {
            for (JButton button : b) {
                if (!button.getName().equals(button.getActionCommand()))
                    return false;
            }
        }
        return true;
    }

    private void switchButton(int posY, int posX) {

        if (inTouch(posY, posX)) {

            buttons[lastButtonY][lastButtonX].setIcon(buttons[posY][posX].getIcon());
            buttons[posY][posX].setIcon(null);

            String puffer = buttons[posY][posX].getName();
            buttons[posY][posX].setName(buttons[(int) lastButtonY][lastButtonX].getName());
            buttons[lastButtonY][lastButtonX].setName(puffer);

            lastButtonX = posX;
            lastButtonY = posY;
        }
    }

    private boolean inTouch(int posY, int posX) {

        if (posY == lastButtonY && (posX - 1 == lastButtonX || posX + 1 == lastButtonX)) {
            return true;
        } else if (posX == lastButtonX && (posY - 1 == lastButtonY || posY + 1 == lastButtonY)) {
            return true;
            //wenn y = y dann muss x = x +1 | x-1
            //wenn x = x dann muss y = y+1 | y-1
        }
        return false;
    }

    //--------------------ActionEvent-------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() instanceof PuzzelHAButton){
            if (firstClick) {
                firstClick = false;
                lastIcon = buttons[0][0].getIcon();
                buttons[0][0].setIcon(null);
                for (int i = 0; i < 10000; i++) {
                    int zufallY = (int) ((Math.random() * YY) + 0);
                    int zufallX = (int) ((Math.random() * XX) + 0);
                    switchButton(zufallY, zufallX);
                }
                //ToDo: unwiederrufbare Operationen vermeiden?
                // funktion klären und abfangen
            /*while(lastButton % XX != 0)
                switchButton(lastButton-1);
            while (lastButton != "00")
                switchButton(lastButton-XX);*/

            } else {
                PuzzelHAButton tmp = (PuzzelHAButton) e.getSource();
                int posY = tmp.getPosY();
                int posX = tmp.getPosX();

                switchButton(posY, posX);
                if (isDone()) {
                    buttons[0][0].setIcon(lastIcon);
                    firstClick = true;
                }
            }

        }else if(e.getSource() instanceof JMenuItem) {
            if (e.getActionCommand().equals("reset")) {
                window.getContentPane().removeAll();
                baueButton();
                window.revalidate();
            }

            if(e.getSource() instanceof JRadioButtonMenuItem) {
                switch (e.getActionCommand()) {
                    case "g1":
                        neu(4,3);
                        break;
                    case "g2":
                        neu(4,3);
                        break;
                    case "g3":
                        neu(6,5);
                        break;
                    case "g4":
                        neu(8,7);
                        break;
                    case "b":
                        JRadioButtonMenuItem temp = (JRadioButtonMenuItem)e.getSource();
                        bildNr=temp.getName();
                        neu(XX,YY);
                        break;
                    default:
                        System.out.println("jhbsdusdv");
                        break;
                }
            }

        }
    }

    //--------------------refresh Window----------------------------------
    private void neu (int xx, int yy){
        XX=xx;
        YY=yy;
        lastButtonY=0;
        lastButtonX=0;
        lastIcon=null;
        firstClick=true;
        window.getContentPane().removeAll();
        baueButton();
        window.revalidate();
    }

    //---------Neue Klasse Button
    public class PuzzelHAButton extends JButton {

        private int posX;
        private int posY;

        public PuzzelHAButton(Icon icon) {
            super(icon);
        }

        public int getPosX() {
            return posX;
        }

        public void setPosX(int posX) {

            this.posX = posX;
        }

        public int getPosY() {

            return posY;
        }

        public void setPosY(int posY) {
            this.posY = posY;
        }
    }


}
