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
public class Anzeige implements ActionListener{

    private Map<String,Comparator<Auto>> tab = new HashMap<>();
    private List<Auto> autos;
    private DefaultListModel listModel = new DefaultListModel();
    private JFrame window = new JFrame("Das Menü zur Autosortierung !!!");


    public void frame(){

        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        tab.put("Name",Auto.SORT_NAME);
        tab.put("Preis", Auto.SORT_PREIS);
        tab.put("EZ",Auto.SORT_EZ);
        tab.put("Km",Auto.SORT_KMSTAND);
        tab.put("aufsteigend",Auto.SORT_PREIS_RE);
        tab.put("absteigend",Auto.SORT_PREIS);

        this.autos = autos;

        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Anlegen des Model mit JList
        JList<Auto>list = new JList<>(this.listModel);

        // Dem Model die Daten aus der AutoListe übergeben
        for (Auto a : autos) {
            this.listModel.addElement(a.toHTML());
        }

        // SrcollPanel erstelen
        JScrollPane listeSrcoller = new JScrollPane(list);

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
        JButton nameB = new JButton("Name");
        nameB.addActionListener(this);
        JButton preisB = new JButton("Preis");
        preisB.addActionListener(this);
        JButton ezB = new JButton("EZ");
        ezB.addActionListener(this);
        JButton kmB = new JButton("Km");
        kmB.addActionListener(this);

        // Anlegen von RadioButtons
        JRadioButton nameR = new JRadioButton("Name");
        nameR.addActionListener(this);
        JRadioButton preisR = new JRadioButton("Preis");
        preisR.addActionListener(this);
        JRadioButton ezR = new JRadioButton("EZ");
        ezR.addActionListener(this);
        JRadioButton kmR = new JRadioButton("Km");
        kmR.addActionListener(this);

        // Anlegen einer RadioButtonGruppe
        ButtonGroup radio = new ButtonGroup();
        radio.add(nameR);
        radio.add(preisR);
        radio.add(ezR);
        radio.add(kmR);

        // Anlegen von CheckBoxen
        JCheckBox nameC = new JCheckBox("Name");
        nameC.addActionListener(this);
        JCheckBox preisC = new JCheckBox("Preis");
        preisC.addActionListener(this);
        JCheckBox ezC = new JCheckBox("EZ");
        ezC.addActionListener(this);
        JCheckBox kmC = new JCheckBox("Km");
        kmC.addActionListener(this);

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
        name.addActionListener(this);
        JMenuItem preis = new JMenuItem("Preis");
        preis.addActionListener(this);
        JMenuItem ez = new JMenuItem("EZ");
        ez.addActionListener(this);
        JMenuItem km = new JMenuItem("Km");
        km.addActionListener(this);

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
        nameMC.addActionListener(this);
        JCheckBoxMenuItem preisMC = new JCheckBoxMenuItem("Preis");
        preisMC.addActionListener(this);
        JCheckBoxMenuItem ezMC = new JCheckBoxMenuItem("EZ");
        ezMC.addActionListener(this);
        JCheckBoxMenuItem kmMC = new JCheckBoxMenuItem("Km");
        kmMC.addActionListener(this);

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
        nameMR.addActionListener(this);
        JRadioButtonMenuItem preisMR = new JRadioButtonMenuItem("Preis");
        preisMR.addActionListener(this);
        JRadioButtonMenuItem ezMR = new JRadioButtonMenuItem("EZ");
        ezMR.addActionListener(this);
        JRadioButtonMenuItem kmMR = new JRadioButtonMenuItem("Km");
        kmMR.addActionListener(this);

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
        aufNR.addActionListener(this);
        JRadioButtonMenuItem abNR = new JRadioButtonMenuItem("absteigend");
        abNR.addActionListener(this);
        JCheckBoxMenuItem aufPC = new JCheckBoxMenuItem("aufsteigend");
        aufPC.addActionListener(this);
        JCheckBoxMenuItem abPC = new JCheckBoxMenuItem("absteigend");
        abPC.addActionListener(this);
        JRadioButtonMenuItem aufER = new JRadioButtonMenuItem ("aufsteigend");
        aufER.addActionListener(this);
        JRadioButtonMenuItem abER = new JRadioButtonMenuItem("absteigend");
        abER.addActionListener(this);
        JCheckBoxMenuItem aufKC = new JCheckBoxMenuItem("aufsteigend");
        aufKC.addActionListener(this);
        JCheckBoxMenuItem abKC = new JCheckBoxMenuItem("absteigend");
        abKC.addActionListener(this);

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

        // Methode um herauszufinden welchen Button benutzt wurde
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()instanceof JButton){
            JButton temp = (JButton)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }
        if(e.getSource()instanceof JCheckBox){
            JCheckBox temp = (JCheckBox)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }
        if(e.getSource()instanceof JRadioButton){
            JRadioButton temp = (JRadioButton)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }
        if(e.getSource()instanceof JMenuItem){
            JMenuItem temp = (JMenuItem)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }
        if(e.getSource()instanceof JCheckBoxMenuItem){
            JCheckBoxMenuItem temp = (JCheckBoxMenuItem)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }
        if(e.getSource()instanceof JRadioButtonMenuItem){
            JRadioButtonMenuItem temp = (JRadioButtonMenuItem)e.getSource();
            System.out.println(temp.getText());
            refresh(temp.getText());
        }

    }

    // Methode zum JList refresh
    private void refresh(String x){
        Collections.sort(this.autos, tab.get(x));
        listModel.clear();
        for (Auto a : this.autos) {
            this.listModel.addElement(a.toHTML());
        }
    }
}
