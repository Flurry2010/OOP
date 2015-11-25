package ÜbungKA;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Flurry on 18.11.2015.
 */
public class Fenster {

    public static void main(String[] args) {

        JFrame window = new JFrame("1. Kurzarbeit");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //-----------------MENÜ-----------------------------------------
        JMenuBar bar = new JMenuBar();

        //----------------FILE------------------------------------------
        JMenu file = new JMenu("File");

        JMenuItem neu = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem close = new JMenuItem("Close");

        JMenu convert = new JMenu("Convert To");
        JMenuItem windows = new JMenuItem("Windows");
        JMenuItem unix = new JMenuItem("Unix");
        JMenuItem mac = new JMenuItem("MacOS");

        convert.add(windows);
        convert.add(unix);
        convert.add(mac);

        JMenuItem refresh = new JMenuItem("Refresh");

        file.add(neu);
        file.add(open);
        file.add(close);
        file.add(convert);
        file.add(refresh);

        bar.add(file);

         //-------------------EDIT---------------------------------------------
        JMenu edit = new JMenu("Edit");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        JMenu expand = new JMenu("Expand To");
        JMenuItem next = new JMenuItem("Next Element");
        JMenuItem prev = new JMenuItem("Previous Element");

        expand.add(next);
        expand.add(prev);

        JMenuItem find = new JMenuItem("Find");
        JMenuItem replace = new JMenuItem("Replace");

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(expand);
        edit.add(find);
        edit.add(replace);

        bar.add(edit);

        //-----------------SOURCE-----------------------------------------------
        JMenu source = new JMenu("Source");

        JMenuItem toogle = new JMenuItem("Toogle Comment");
        JMenuItem sleft = new JMenuItem("Shift left");
        JMenuItem sright = new JMenuItem("Shift right");

        source.add(toogle);
        source.add(sleft);
        source.add(sright);

        bar.add(source);

        //-----------------Help-----------------------------------------------
        JMenu help = new JMenu("Help");

        JMenuItem wel = new JMenuItem("Welcome");
        JMenuItem key = new JMenuItem("Key Assist");
        JMenuItem tip = new JMenuItem("Tips");

        help.add(wel);
        help.add(key);
        help.add(tip);

        bar.add(help);

        //---------------------OBEN---------------------------------------------
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JPanel top1 = new JPanel();
        JButton neuB = new JButton("New");
        JButton comB = new JButton("Compile");
        JButton debB = new JButton("Debug");
        JButton runB = new JButton("Run");
        top1.add(neuB);
        top1.add(comB);
        top1.add(debB);
        top1.add(runB);

        top.add(top1,BorderLayout.WEST);

        JPanel top2 = new JPanel();
        JButton searB = new JButton("Search");
        JTextField tF = new JTextField(10);
        top2.add(searB);
        top2.add(tF);

        top.add(top2, BorderLayout.EAST);

        //--------------LINKS----------------------------------------------
        JPanel links = new JPanel();
        links.setLayout(new GridLayout(5,1));
        Border brL = new LineBorder(Color.BLUE,1);
        brL = new TitledBorder("Editor Config");
        links.setBorder(brL);

        JPanel editor = new JPanel();
        editor.setLayout(new BorderLayout());

        JCheckBox high = new JCheckBox("Highlight");
        JCheckBox aFor = new JCheckBox("Auto Format");
        JCheckBox aCom = new JCheckBox("Auto Completion");

        editor.add(high,BorderLayout.NORTH);
        editor.add(aFor,BorderLayout.CENTER);
        editor.add(aCom,BorderLayout.SOUTH);


        links.add(editor);

        JPanel comm = new JPanel();
        comm.setLayout(new BorderLayout());
        Border brLLL1 = new LineBorder(Color.BLUE,1);
        brLLL1 = new TitledBorder("Comments");
        comm.setBorder(brLLL1);

        ButtonGroup groupComm = new ButtonGroup();
        JRadioButton hide = new JRadioButton("hide");
        JRadioButton out = new JRadioButton("outline");
        JRadioButton full = new JRadioButton("full");
        groupComm.add(hide);
        groupComm.add(out);
        groupComm.add(full);

        full.setSelected(true);
        comm.add(hide, BorderLayout.NORTH);
        comm.add(out,BorderLayout.CENTER);
        comm.add(full, BorderLayout.SOUTH);

        links.add(comm);

        //----------------------UNTEN-----------------------------------------
        JPanel unten = new JPanel();
        Border brU = new LineBorder(Color.BLUE,1);
        brU = new TitledBorder("Debug Info");
        unten.setBorder(brU);
        unten.setLayout(new BorderLayout());

        JTextArea ta = new JTextArea();
        ta.setEnabled(false);
        ta.setRows(3);
        ta.setEditable(true);

        JScrollPane spta = new JScrollPane(ta);
        
        unten.add(spta, BorderLayout.CENTER);

        //-----------------------RECHTS--------------------------------------
        JPanel rechts = new JPanel();
        Border brR = new LineBorder(Color.BLUE,1);
        brR = new TitledBorder("Data Types");
        rechts.setBorder(brR);
        rechts.setLayout(new BorderLayout());
        DefaultListModel model = new DefaultListModel();
        JList<String> list = new JList<>(model);
        model.addElement("BigInteger   ");
        model.addElement("Char");
        model.addElement("Double");
        model.addElement("Float");
        model.addElement("Integer");
        model.addElement("Long");
        model.addElement("String");
        JScrollPane sp = new JScrollPane(list);
        rechts.add(sp, BorderLayout.CENTER);

        //-----------------------MITTE--------------------------------------
        JTabbedPane reiter = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        JTextArea eins = new JTextArea();
        eins.setFont(new Font("Courier new", Font.PLAIN, 12));
        JTextArea zwei = new JTextArea();
        zwei.setFont(new Font("Courier new", Font.PLAIN, 12));
        JScrollPane sp1 = new JScrollPane(eins);
        sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollPane sp2 = new JScrollPane(zwei);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        reiter.add("1", sp1);
        reiter.add("2",sp2);

        window.add(bar);
        window.add(top,BorderLayout.NORTH);
        window.add(links, BorderLayout.WEST);
        window.add(unten, BorderLayout.SOUTH);
        window.add(rechts, BorderLayout.EAST);
        window.add(reiter, BorderLayout.CENTER);

        window.setJMenuBar(bar);
        window.isAlwaysOnTop();
        window.setLocationRelativeTo(window);
        window.setResizable(false);
        window.setVisible(true);





    }







}
