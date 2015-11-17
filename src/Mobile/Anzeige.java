package Mobile;



import GUI.JavaFrame;
import GUI.Layout;

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

        JFrame window = new JFrame("Das Menü");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Anlegen des Model mit JList
        DefaultListModel listModel=new DefaultListModel();
        JList<Auto>list = new JList<>(listModel);

        for (Auto a : autos) {
            listModel.addElement(a.toHTML());
        }

        // SrcollPanel erstelen
        JScrollPane listeSrcoller = new JScrollPane(list);

        // Anlegen von JPanel
        JPanel links = new JPanel();
        JPanel rechts = new JPanel();
        JPanel unten = new JPanel();

        // Neues Layout erzwingen
        links.setLayout(new GridLayout(1,3));

        // Anlegen von Buttons
        JButton nameB = new JButton();
        JButton preisB = new JButton();
        JButton ezB = new JButton();
        JButton kmB = new JButton();

        // Anlegen von RadioButtons
        JRadioButton nameR = new JRadioButton();
        JRadioButton preisR = new JRadioButton();
        JRadioButton ezR = new JRadioButton();
        JRadioButton kmR = new JRadioButton();

        // Anlegen einer RadioButtonGruppe
        ButtonGroup radio = new ButtonGroup();
        radio.add(nameR);
        radio.add(preisR);
        radio.add(ezR);
        radio.add(kmR);

        // Anlegen von CheckBoxen
        JCheckBox nameC = new JCheckBox();
        JCheckBox preisC = new JCheckBox();
        JCheckBox ezC = new JCheckBox();
        JCheckBox kmC = new JCheckBox();

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

        rechts.add(nameC);
        rechts.add(preisC);
        rechts.add(ezC);
        rechts.add(kmC);

        //Elemente dem Fenster hinzufügen
        window.add(listeSrcoller,BorderLayout.CENTER);
        window.add(links,BorderLayout.WEST);
        window.add(rechts,BorderLayout.EAST);
        window.add(unten,BorderLayout.SOUTH);

        // Zur Veranschaulichung einen Border
        Border border = new LineBorder(Color.black);

        // Erstellung einer Menüleiste
        JMenuBar bar = new JMenuBar();

        // Wir setzen unsere Umrandung für unsere JMenuBar
        bar.setBorder(border);

        // Erzeugung eines Objektes der Klasse JMenu
        JMenu ansicht=new JMenu("Ansicht");

        // Erzeugung eines Objektes der Klasse JSeparator
        JSeparator sep1=new JSeparator();

        // Menü wird der Menüleiste hinzugefügt


        // Fenstergrösse festlegen
        window.setSize(600,600);

        //Fester position festlegen
        window.setLocationRelativeTo(window);

        // Menüleiste wird für den Dialog gesetzt
        window.setJMenuBar(bar);

        // Wir lassen unseren Dialog anzeigen
        window.setVisible(true);
    }
}
