package GUI;

import javax.swing.*;

/**
 * Created by dfleuren on 25.11.2015.
 */
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


