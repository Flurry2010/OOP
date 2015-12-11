package NewListModel;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by mtheilen on 01.12.2015.
 */
public class NewListModel {

    private int zahl = -1;

    public NewListModel() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MyModel lm = new MyModel();
        JList<Integer> jl = new JList<>(lm);
        JButton b = new JButton("ADD");

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lm.add(++zahl);
            }
        });

        JScrollPane jlp = new JScrollPane(jl);
        window.add(jlp);
        window.add(b,BorderLayout.SOUTH);
        window.setSize(200,200);
        window.setVisible(true);
    }


    public static void main(String[] args) {
        new NewListModel();
    }

    private class MyModel implements ListModel<Integer> {

        List<Integer> list = new ArrayList<>();
        List<ListDataListener> ldls = new ArrayList<>();

        public int getSize() {
            return list.size();
        }


        public Integer getElementAt(int index) {
            return list.get(index);
        }


        public void addListDataListener(ListDataListener l) {
            ldls.add(l);
        }


        public void removeListDataListener(ListDataListener l) {
            ldls.remove(l);
        }

        public void add(Integer zahl) {
            list.add(zahl);

            for (ListDataListener l : ldls)
                l.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, list.size() - 1));
        }
    }
}

