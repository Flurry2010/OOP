package Mobile;



import GUI.JavaFrame;
import GUI.Layout;
import javafx.scene.layout.Background;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;


/**
 * Created by dfleuren on 09.11.2015.
 */
public class Anzeige{


    public void frame(List<Auto> autos){
        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel listModel = new DefaultListModel();
        JList<Auto> list = new JList<>(listModel);

        JScrollPane listeSrcoller = new JScrollPane(list);
        box.add(listeSrcoller, BorderLayout.CENTER);

        for (Auto a : autos) {
            listModel.addElement(a.toHTML());
        }

        //box.setSize(600, 500);
        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);

    }

    public void frame1(JList<Auto> list){
        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        JScrollPane listeSrcoller = new JScrollPane(list);
        box.add(listeSrcoller, BorderLayout.CENTER);

        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);
    }

    public void menu(List<Auto> autos){

        JFrame window = new JFrame("Das Menü zur Autosortierung !!!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Anlegen des Model mit JList
        DefaultListModel listModel=new DefaultListModel();
        JList<Auto>list = new JList<>(listModel);

        for (Auto a : autos) {
            listModel.addElement(a.toHTML());
        }

        JTextArea ta = new JTextArea("dick Titten");

        // SrcollPanel erstelen
        JScrollPane listeSrcoller = new JScrollPane(ta);

        // Anlegen von JPanel
        JPanel links = new JPanel();
        JPanel rechts = new JPanel();
        JPanel unten = new JPanel();

        //Rahme für die Panels
        links.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        rechts.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        unten.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));

        // Neues Layout erzwingen
        links.setLayout(new GridLayout(4, 1));
        rechts.setLayout(new GridLayout(4, 1));

        // Anlegen von Buttons
        JButton nameB = new JButton("NAME");
        JButton preisB = new JButton("PREIS");
        JButton ezB = new JButton("EZ");
        JButton kmB = new JButton("KM");

        // Anlegen von RadioButtons
        JRadioButton nameR = new JRadioButton("NAME");
        JRadioButton preisR = new JRadioButton("PREIS");
        JRadioButton ezR = new JRadioButton("EZ");
        JRadioButton kmR = new JRadioButton("KM");

        // Anlegen einer RadioButtonGruppe
        ButtonGroup radio = new ButtonGroup();
        radio.add(nameR);
        radio.add(preisR);
        radio.add(ezR);
        radio.add(kmR);

        // Anlegen von CheckBoxen
        JCheckBox nameC = new JCheckBox("NAME");
        JCheckBox preisC = new JCheckBox("PREIS");
        JCheckBox ezC = new JCheckBox("EZ");
        JCheckBox kmC = new JCheckBox("KM");

        // BackgroundColor für die Panel
        nameR.setBackground(Color.LIGHT_GRAY);
        preisR.setBackground(Color.LIGHT_GRAY);
        ezR.setBackground(Color.LIGHT_GRAY);
        kmR.setBackground(Color.LIGHT_GRAY);
        nameC.setBackground(Color.LIGHT_GRAY);
        preisC.setBackground(Color.LIGHT_GRAY);
        ezC.setBackground(Color.LIGHT_GRAY);
        kmC.setBackground(Color.LIGHT_GRAY);
        unten.setBackground(Color.GRAY);

        // Anlegen einer CheckBoxGruppe
        ButtonGroup check = new ButtonGroup();
        check.add(nameC);
        check.add(preisC);
        check.add(ezC);
        check.add(kmC);

        // Buttons dem JPanel zuweisen
        links.add(nameC);
        links.add(preisC);
        links.add(ezC);
        links.add(kmC);

        rechts.add(nameR);
        rechts.add(preisR);
        rechts.add(ezR);
        rechts.add(kmR);

        unten.add(nameB);
        unten.add(preisB);
        unten.add(ezB);
        unten.add(kmB);

        // Elemente dem Fenster hinzufügen
        window.add(listeSrcoller,BorderLayout.CENTER);
        window.add(links,BorderLayout.WEST);
        window.add(rechts,BorderLayout.EAST);
        window.add(unten, BorderLayout.SOUTH);

        // Erstellung einer Menüleiste
        JMenuBar bar = new JMenuBar();

        // Umrandung für die JMenuBar
        bar.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        bar.setBackground(Color.gray);

        // Erzeugung eines Menüpunktes
        JMenu ansicht = new JMenu("Ansicht");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenu auswahl = new JMenu("Auswahl");

        // Textfarbe ändern
        ansicht.setForeground(Color.WHITE);
        bearbeiten.setForeground(Color.WHITE);
        auswahl.setForeground(Color.WHITE);

        // Erzeugung eines Trenners (Trennstrich)
        JSeparator sep1 = new JSeparator();
        JSeparator sep2 = new JSeparator();
        JSeparator sep3 = new JSeparator();
        JSeparator sep4 = new JSeparator();

        // Farbe vom Trenner festlegen
        sep1.setBackground(Color.WHITE);
        sep2.setBackground(Color.WHITE);
        sep3.setBackground(Color.WHITE);
        sep4.setBackground(Color.WHITE);

        // MenüItems erstellen
        JMenuItem name = new JMenuItem("Name");
        JMenuItem preis = new JMenuItem("Preis");
        JMenuItem ez = new JMenuItem("EZ");
        JMenuItem km = new JMenuItem("Km");

        // BackgroundColor und Textfarbe für die MenüItems festlegen
        name.setBackground(Color.BLACK);
        name.setForeground(Color.WHITE);
        preis.setBackground(Color.BLACK);
        preis.setForeground(Color.WHITE);
        ez.setBackground(Color.BLACK);
        ez.setForeground(Color.WHITE);
        km.setBackground(Color.BLACK);
        km.setForeground(Color.WHITE);

        // MenüItem dem Menüpunkt hinzufügen
        ansicht.add(name);
        ansicht.add(sep1);
        ansicht.add(preis);
        ansicht.add(sep2);
        ansicht.add(ez);
        ansicht.add(sep3);
        ansicht.add(km);

        // JCheckBoxMenuItem erstellen
        JCheckBoxMenuItem nameMC = new JCheckBoxMenuItem("Name");
        JCheckBoxMenuItem preisMC = new JCheckBoxMenuItem("Preis");
        JCheckBoxMenuItem ezMC = new JCheckBoxMenuItem("EZ");
        JCheckBoxMenuItem kmMC = new JCheckBoxMenuItem("Km");

        // Anlegen einer JCheckBoxMenüItem ButtonGruppe
        ButtonGroup jcheck = new ButtonGroup();
        jcheck.add(nameMC);
        jcheck.add(preisMC);
        jcheck.add(ezMC);
        jcheck.add(kmMC);

        // BackgroundColor und Textfarbe für die JCheckBoxMenuItem festlegen
        nameMC.setBackground(Color.BLACK);
        nameMC.setForeground(Color.WHITE);
        preisMC.setBackground(Color.BLACK);
        preisMC.setForeground(Color.WHITE);
        ezMC.setBackground(Color.BLACK);
        ezMC.setForeground(Color.WHITE);
        kmMC.setBackground(Color.BLACK);
        kmMC.setForeground(Color.WHITE);

        // JRadioButtonMenuItem erstellen
        JRadioButtonMenuItem nameMR = new JRadioButtonMenuItem ("Name");
        JRadioButtonMenuItem preisMR = new JRadioButtonMenuItem("Preis");
        JRadioButtonMenuItem ezMR = new JRadioButtonMenuItem("EZ");
        JRadioButtonMenuItem kmMR = new JRadioButtonMenuItem("Km");

        // Anlegen einer JRadioButtonMenuItem ButtonGruppe
        ButtonGroup jradio = new ButtonGroup();
        jradio.add(nameMR);
        jradio.add(preisMR);
        jradio.add(ezMR);
        jradio.add(kmMR);

        // BackgroundColor und Textfarbe für die JRadioButtonMenuItem festlegen
        nameMR.setBackground(Color.BLACK);
        nameMR.setForeground(Color.WHITE);
        preisMR.setBackground(Color.BLACK);
        preisMR.setForeground(Color.WHITE);
        ezMR.setBackground(Color.BLACK);
        ezMR.setForeground(Color.WHITE);
        kmMR.setBackground(Color.BLACK);
        kmMR.setForeground(Color.WHITE);

        // JRadioButtonMenuItem und JCheckBoxMenuItem dem Menüpunkt hinzufügen
        bearbeiten.add(nameMC);
        bearbeiten.add(preisMC);
        bearbeiten.add(ezMC);
        bearbeiten.add(kmMC);
        bearbeiten.add(sep4);
        bearbeiten.add(nameMR);
        bearbeiten.add(preisMR);
        bearbeiten.add(ezMR);
        bearbeiten.add(kmMR);

        // UnterMenü für Auswahl erzeugen
        JMenu nameM = new JMenu("Name");
        JMenu preisM = new JMenu("Preis");
        JMenu ezM = new JMenu("EZ");
        JMenu kmM = new JMenu("Km");

        // JRadioButtonMenuItem und JCheckBoxMenuItem für das UnterMenü erzeugen
        JRadioButtonMenuItem aufNR = new JRadioButtonMenuItem ("aufsteigend");
        JRadioButtonMenuItem abNR = new JRadioButtonMenuItem("absteigend");
        JCheckBoxMenuItem aufPC = new JCheckBoxMenuItem("aufsteigend");
        JCheckBoxMenuItem abPC = new JCheckBoxMenuItem("absteigend");
        JRadioButtonMenuItem aufER = new JRadioButtonMenuItem ("aufsteigend");
        JRadioButtonMenuItem abER = new JRadioButtonMenuItem("absteigend");
        JCheckBoxMenuItem aufKC = new JCheckBoxMenuItem("aufsteigend");
        JCheckBoxMenuItem abKC = new JCheckBoxMenuItem("absteigend");

        // Anlegen einer JRadioButtonMenuItem ButtonGruppe
        ButtonGroup jradioNR = new ButtonGroup();
        ButtonGroup jCheckPC = new ButtonGroup();
        ButtonGroup jradioER = new ButtonGroup();
        ButtonGroup jCheckKC = new ButtonGroup();
        jradioNR.add(aufNR);
        jradioNR.add(abNR);
        jCheckPC.add(aufPC);
        jCheckPC.add(abPC);
        jradioER.add(aufER);
        jradioER.add(abER);
        jCheckKC.add(aufKC);
        jCheckKC.add(abKC);

        // JRadioButtonMenuItem und JCheckBoxMenuItem dem UmterMenü hinzufügen
        nameM.add(aufNR);
        nameM.add(abNR);
        preisM.add(aufPC);
        preisM.add(abPC);
        ezM.add(aufER);
        ezM.add(abER);
        kmM.add(aufKC);
        kmM.add(abKC);

        // UnterMenü dem Menüpunkt Bearbeiten hinzufügen
        auswahl.add(nameM);
        auswahl.add(sep1);
        auswahl.add(preisM);
        auswahl.add(sep2);
        auswahl.add(ezM);
        auswahl.add(sep3);
        auswahl.add(kmM);

        // Menü wird der Menüleiste hinzugefügt
        bar.add(ansicht);
        bar.add(bearbeiten);
        bar.add(auswahl);

        // Fenstergrösse festlegen
        window.setSize(700,600);

        // Festergrösse fest
        window.setResizable(false);

        //Fester position festlegen
        window.setLocationRelativeTo(window);

        // Menüleiste wird für den Dialog gesetzt
        window.setJMenuBar(bar);

        // Wir lassen unseren Dialog anzeigen
        window.setVisible(true);
    }
}
