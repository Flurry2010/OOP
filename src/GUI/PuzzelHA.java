package GUI;

//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by dfleuren on 20.11.2015.
// */
//
//    public class PuzzelHA implements ActionListener {
//
//        private static final int XX = 4;
//        private static final int YY = 3;
//        private JButton[][] buttons = new JButton[XX][YY];
//        private int lastButton = 0;
//        private Icon lastIcon = null;
//        private boolean firstClick = true;
//
//
//        public static void main(String[] args) {
//
//            new PuzzelHA();
//        }
//
//        public PuzzelHA(){
//
//            JFrame window = new JFrame("Puzzel");
//            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            window.setLayout(new GridLayout(YY,XX));
//
//            try{
//                BufferedImage dp = ImageIO.read(new File("DP.jpg"));
//
//                int w = dp.getWidth();
//                int h = dp.getHeight();
//
//                for(int y = 0; y < YY; y++)
//                    for(int x = 0; x < XX; x++){
//                       buttons[y*XX+x] = new JButton(new ImageIcon(dp.getSubimage(x*(w/XX),y*(h/YY),w/XX,h/YY)));
//                       buttons[y*XX+x].setBorder(new LineBorder(Color.BLACK, 1));
//                       buttons[y*XX+x].setActionCommand("" + (y * XX + x));
//                       buttons[y*XX+x].setName(""+(y*XX+x));
//                       buttons[y*XX+x].addActionListener(this);
//
//                       window.add(buttons[y * XX + x]);
//                    }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            window.setResizable(false);
//            window.setLocationRelativeTo(null);
//            window.pack();
//            window.setVisible(true);
//        }
//
//
//        private boolean isDone(){
//
//            for(JButton b : buttons)
//                if (!b.getName().equals(b.getActionCommand()))
//                    return false;
//
//            return true;
//        }
//
//        private boolean inTouch(int pos){
//
//            return ((pos%XX == lastButton%XX)&& Math.abs(pos/XX-lastButton/XX) < 2)||((pos/XX == lastButton/XX)&&Math.abs(pos%XX-lastButton%XX) < 2);
//        }
//
//        private void switchButton(int pos){
//
//            if(inTouch(pos)) {
//                buttons[lastButton].setIcon(buttons[pos].getIcon());
//                buttons[pos].setIcon(null);
//
//                String temp = buttons[pos].getName();
//                buttons[pos].setName(buttons[lastButton].getName());
//                buttons[lastButton].setName(temp);
//                lastButton = pos;
//            }
//        }
//
//        public void actionPerformed(ActionEvent e) {
//
//            if(firstClick){
//                firstClick = false;
//                lastIcon = buttons[0].getIcon();
//                buttons[0].setIcon(null);
//                for(int i = 0; i < 1000; i++) {
//                    int zufall = (int) (Math.random() * XX * YY);
//                    switchButton(zufall);
//                }
//                while(lastButton % XX !=0)
//                    switchButton(lastButton - 1);
//                while(lastButton / XX !=0)
//                    switchButton(lastButton - XX);
//
//            }else {
//
//                int pos = Integer.parseInt(e.getActionCommand());
//                switchButton(pos);
//
//                if(isDone()){
//                    buttons[0].setIcon(lastIcon);
//                    firstClick = true;
//                }
//            }
//        }
//    }
