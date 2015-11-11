package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by dfleuren on 10.11.2015.
 */
public class Menu {

    public void frame(){

        JFrame window = new JFrame("Das Menü");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Zur Veranschaulichung erstellen wir hier eine Border
        Border bo = new LineBorder(Color.black);

        // Erstellung einer Menüleiste
        JMenuBar bar = new JMenuBar();

        // Wir setzen unsere Umrandung für unsere JMenuBar
        bar.setBorder(bo);

        // Erzeugung eines Objektes der Klasse JMenu
        JMenu ansicht = new JMenu("Ansicht");

        // Erzeugung eines Objektes der Klasse JSeparator
        JSeparator sep1 = new JSeparator();
        JSeparator sep2 = new JSeparator();
        JSeparator sep3 = new JSeparator();
        JSeparator sep4 = new JSeparator();


        //RadioButton Gruppe anlegen
        ButtonGroup anz = new ButtonGroup();

        // Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
        JRadioButtonMenuItem standard = new JRadioButtonMenuItem("Standard");
        JRadioButtonMenuItem wiss = new JRadioButtonMenuItem("Wissenschaftlich");
        JRadioButtonMenuItem pro = new JRadioButtonMenuItem("Programmierer");
        JRadioButtonMenuItem stat = new JRadioButtonMenuItem("Statistik");

        anz.add(standard);
        anz.add(wiss);
        anz.add(pro);
        anz.add(stat);


        // JCheckBoxMenuItem wird unserem JMenu hinzugefügt
        ansicht.add(standard);
        ansicht.add(wiss);
        ansicht.add(pro);
        ansicht.add(stat);

        // JSeparator wird unserem JMenu hinzugefügt
        ansicht.add(sep1);

        // Erzeugung eines Objektes der Klasse JRadioButtonMenuItem
        JCheckBoxMenuItem radioB1 = new JCheckBoxMenuItem("Verlauf");
        JCheckBoxMenuItem radioB2 = new JCheckBoxMenuItem("Ziffergruppierung");

        // JRadioButtonMenuItem wird unserem JMenu hinzugefügt
        ansicht.add(radioB1);
        ansicht.add(radioB2);

        // JSeparator wird unserem JMenu hinzugefügt
        ansicht.add(sep2);

        //RadioButton Gruppe anlegen
        ButtonGroup basis = new ButtonGroup();

        // Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
        JRadioButtonMenuItem bas = new JRadioButtonMenuItem("Basismodus");
        JRadioButtonMenuItem ein = new JRadioButtonMenuItem("Einheitenumrechner");
        JRadioButtonMenuItem dat = new JRadioButtonMenuItem("Datumsberechner");

        basis.add(bas);
        basis.add(ein);
        basis.add(dat);

        // Neues Menü erstellen
        JMenu arb = new JMenu("Arbeitsblätter");

        // JCheckBoxMenuItem wird unserem JMenu hinzugefügt
        ansicht.add(bas);
        ansicht.add(ein);
        ansicht.add(dat);
        ansicht.add(arb);

        // Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
        JRadioButtonMenuItem x = new JRadioButtonMenuItem("1");
        JRadioButtonMenuItem y = new JRadioButtonMenuItem("2");
        JRadioButtonMenuItem z = new JRadioButtonMenuItem("3");
        JRadioButtonMenuItem a = new JRadioButtonMenuItem("4");

        arb.add(x);
        arb.add(y);
        arb.add(z);
        arb.add(a);



        // Erzeugung eines Objektes der Klasse JMenu
        JMenu bearbeiten = new JMenu("Bearbeiten");

        JMenuItem copy = new JMenuItem("Kopieren");
        JMenuItem paste = new JMenuItem("Einfügen");

        // Wir fügen das JMenuItem unserem JMenu hinzu
        bearbeiten.add(copy);
        bearbeiten.add(paste);
        bearbeiten.add(sep3);

        JMenu verlauf = new JMenu("Verlauf");

        JCheckBoxMenuItem c = new JCheckBoxMenuItem("a");
        JCheckBoxMenuItem d = new JCheckBoxMenuItem("b");
        JCheckBoxMenuItem e = new JCheckBoxMenuItem("c");
        JCheckBoxMenuItem f = new JCheckBoxMenuItem("d");

        bearbeiten.add(verlauf);
        verlauf.add(c);
        verlauf.add(d);
        verlauf.add(e);
        verlauf.add(f);

        JMenu frag = new JMenu("?");
        JMenuItem help = new JMenuItem("Hilfe");
        JMenuItem info = new JMenuItem("Info");


        frag.add(help);
        frag.add(sep4);
        frag.add(info);


        // Menü wird der Menüleiste hinzugefügt
        bar.add(ansicht);
        bar.add(bearbeiten);
        bar.add(frag);

        window.add(bar);
        // Fenstergrösse festlegen
        window.setSize(400, 200);

        //Fester position festlegen
        window.setLocationRelativeTo(window);

        // Menüleiste wird für den Dialog gesetzt
        window.setJMenuBar(bar);

        // Wir lassen unseren Dialog anzeigen
        window.setVisible(true);


    }






}
