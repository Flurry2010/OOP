package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HACal {

    private static final String[] DAYS = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};

    public HACal() {
        JFrame frame = new JFrame("HA Kalender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GregorianCalendar cal = new GregorianCalendar();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

        JPanel backg = new JPanel(new FlowLayout());
        JTextField eingabe = new JTextField(10);
       // JFormattedTextField eingabe = new JFormattedTextField(new Date());
        eingabe.setText(df.format(cal.getTime()));
        JLabel tag = new JLabel(DAYS[cal.get(Calendar.DAY_OF_WEEK)-1]);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    cal.setTime(df.parse(eingabe.getText()));
                    tag.setText(DAYS[cal.get(Calendar.DAY_OF_WEEK) - 1]);
                    frame.pack();
                }catch (ParseException e1){
                    JOptionPane.showMessageDialog(frame,"Die Eingabe hat das falsche Format: TT.MM.JJJJ", "Fehler im Datum",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        backg.add(eingabe);
        backg.add(ok);
        backg.add(tag);

        frame.add(backg, BorderLayout.NORTH);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HACal();
    }
}
