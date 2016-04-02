//Icsd13110 Manitaras Grigorios

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchDate extends JFrame {

    JLabel label9;
    JTextField textfield5;
    JButton button8;
    JComboBox c1, c2, c3;

    public SearchDate() {
        super("Αναζήτηση με βάση την ημερομηνία");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] year = {"2016", "2017", "2018", "2019", "2020"};

        label9 = new JLabel("Ημερομηνία : ", JLabel.LEFT);
        label9.setBounds(80, 80, 120, 30);
        add(label9);

        c1 = new JComboBox(day);
        c1.setBounds(210, 162, 40, 25);
        add(c1);

        c2 = new JComboBox(month);
        c2.setBounds(260, 162, 40, 25);
        add(c2);

        c3 = new JComboBox(year);
        c3.setBounds(310, 162, 60, 25);
        add(c3);

        button8 = new JButton("ΟΚ");
        button8.setBounds(180, 200, 60, 30);
        add(button8);

        int day1 = Integer.parseInt((String) c1.getSelectedItem());
        int month1 = Integer.parseInt((String) c2.getSelectedItem());
        int year1 = Integer.parseInt((String) c3.getSelectedItem());

        Calendar cal = Calendar.getInstance(); //tis times apo ta year/month/day ta kanw Date
        cal.set(year1, month1 - 1, day1);    //bazw month-1 gt me month ksekinouse apo February
        Date date1 = cal.getTime();

        setVisible(true);

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ArrayList<Kratisi> kratiseis = null;
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.txt"))) {
                    kratiseis = (ArrayList<Kratisi>) in.readObject();
                } catch (ClassNotFoundException | IOException ex) {
                    kratiseis = new ArrayList<Kratisi>();
                }

                for (Kratisi kratisi : kratiseis) {
                    Date hm = kratisi.getAfixh();
                    if (hm.equals(date1)) {
                        System.out.println(kratisi.toString());
                        break;
                    }
                }
            
                setVisible(true);
            }

        });
    }
} 
