package ÜbungKA;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by dfleuren on 26.11.2015.
 */
public class Window implements ActionListener {

    JFrame window;
    JTextField tfL;
    JTextField tfM1;
    JTextField tfM2;
    JTextField tfR;
    JTextArea ta;

    public static void main(String[] args) {
        new Window();
    }

    public Window() {

        window = new JFrame("ExtremeText");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(900, 400);

        JPanel ground = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel links1 = new JPanel(new GridLayout(2,1));
        links1.setBorder(new TitledBorder("Datei"));

        JPanel links2 = new JPanel();
        JLabel name = new JLabel("Name:");
        tfL = new JTextField(20);
        links2.add(name);
        links2.add(tfL);

        links1.add(links2);

        JPanel links3 = new JPanel();
        JButton offen = new JButton("Öffnen");
        offen.addActionListener(this);
        offen.setActionCommand("o");
        links3.add(offen);
        JButton speicher = new JButton("Speichern");
        speicher.addActionListener(this);
        speicher.setActionCommand("s");
        links3.add(speicher);

        links1.add(links3);

        ground.add(links1);


        JPanel mitte1 = new JPanel(new GridLayout(2, 1));
        mitte1.setBorder(new TitledBorder("Einfügen"));
        JPanel mitte2 = new JPanel();
        JLabel anzahl = new JLabel("Anzahl:");
        tfM1 = new JTextField(5);
        JLabel wort = new JLabel("Wort:");
        tfM2 = new JTextField(10);
        mitte2.add(anzahl);
        mitte2.add(tfM1);
        mitte2.add(wort);
        mitte2.add(tfM2);

        mitte1.add(mitte2);

        JPanel mitte3 = new JPanel();
        JButton ein = new JButton("Einfügen");
        ein.addActionListener(this);
        ein.setActionCommand("e");
        mitte3.add(ein);

        mitte1.add(mitte3);

        ground.add(mitte1);

        JPanel rechts1 = new JPanel(new GridLayout(2, 1));
        rechts1.setBorder(new TitledBorder("Löschen"));
        JPanel rechts2 = new JPanel();
        JLabel wortR = new JLabel("Wort:");
        tfR = new JTextField(10);
        rechts2.add(wortR);
        rechts2.add(tfR);

        rechts1.add(rechts2);

        JPanel rechts3 = new JPanel();
        JButton los = new JButton("Löschen");
        los.addActionListener(this);
        los.setActionCommand("l");
        rechts3.add(los);

        rechts1.add(rechts3);

        ground.add(rechts1);

        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);
        window.add(sp, BorderLayout.CENTER);


        window.add(ground, BorderLayout.NORTH);
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }




    public void actionPerformed(ActionEvent a) {

        if (a.getSource() instanceof JButton) {

            switch (a.getActionCommand()) {
                case "o":
                    ta.setText("");
                    try (BufferedReader br = new BufferedReader(
                            new FileReader(tfL.getText()))) {
                        StringBuilder sb = new StringBuilder();
                        String zeile;
                        while ((zeile = br.readLine()) != null) {
                            sb.append(zeile);
                            sb.append("\n");
                        }
                        ta.setText(sb.toString());

                    }catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(window, "Datei nicht gefunden!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                    }catch(IOException e) {
                        JOptionPane.showMessageDialog(window, "Fehler beim einlesen!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                    }
                    tfL.setText("");
                    break;

                case "s":
                    try (BufferedWriter bw = new BufferedWriter(
                            new FileWriter(tfL.getText() + ".txt"))) {
                        bw.write(ta.getText());
                    } catch
                            (IOException e) {
                        JOptionPane.showMessageDialog(window, "Fehler beim schreiben!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                    }
                    tfL.setText("");
                    break;

                case "e":
                    try {
                        for (int i = Integer.parseInt(tfM1.getText()); i >= 0; i--)
                            ta.append(tfM2.getText());
                    }catch
                            (NumberFormatException e) {
                        JOptionPane.showMessageDialog(window,"Fehler im Feld Anzahl!", "Formatfehler", JOptionPane.ERROR_MESSAGE);
                    }
                    tfM1.setText("");
                    tfM2.setText("");
                    break;

                case "l":
                    ta.setText(ta.getText().replaceAll(tfR.getText(), ""));
                    tfR.setText("");
                    break;

                default:
                    break;

            }

        }
    }
}
