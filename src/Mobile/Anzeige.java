package Mobile;



import GUI.JavaFrame;
import GUI.Layout;

import javax.swing.*;
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
        JList<Auto> list = new JList<Auto>(listModel);

       //box.setSize((int) autos.getPreferredSize().getWidth() + 50, 500);
        box.setSize(550, 500);
        JScrollPane listeSrcoller = new JScrollPane(list);
        box.add(listeSrcoller, BorderLayout.CENTER);

        for (Auto a : autos) {
            listModel.addElement(a.toHTML());
        }

        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);
    }



    public void frame2(JList list){

        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        JScrollPane listeSrcoller = new JScrollPane(list);

        JPanel panelTop = new JPanel();
        JLabel jl = new JLabel("Wie sollen die Autos sortiert werden ?", JLabel.CENTER);
        JLabel x = new JLabel("");
        JLabel y = new JLabel("");
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox ez = new Checkbox("EZ", cbg, false);
//        ItemListener il = new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                    if(((Checkbox)e.getItem()).isEnabled()){
//                       java.util.List<Auto> liste =  Mobile.finder(Mobile.findeDateien());
//                        liste.sort(Auto.SORT_EZ_RE);
//                        Mobile.jlist();
//                    }
//            }
//        };
        Checkbox km = new Checkbox("KmStand", cbg, false);
        Checkbox preis = new Checkbox("Preis", cbg, false);

        JPanel panelBottem = new JPanel();
        JButton b = new JButton("Close");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();

        box.setLayout(new BorderLayout());
        panelTop.setLayout(new GridLayout(2, 3));
        panelTop.add(x);
        panelTop.add(jl);
        panelTop.add(y);
        panelTop.add(ez);
        panelTop.add(km);
        panelTop.add(preis);
        panelBottem.add(b);

        box.add(panelTop, BorderLayout.NORTH);
        box.add(panelBottem, BorderLayout.SOUTH);
        box.add(panelLeft, BorderLayout.WEST);
        box.add(panelRight, BorderLayout.EAST);
        box.add(listeSrcoller, BorderLayout.CENTER);

        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);
    }
}
