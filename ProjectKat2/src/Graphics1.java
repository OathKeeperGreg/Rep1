
//Icsd13110 Manitaras Grigorios
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//grafika gia thn kataxwrhsh pelath
public class Graphics1 extends JFrame {

    JButton button3, button4;
    JTextField textfield1, textfield2, textfield3, textfield4, textfield5;
    JPanel panel2;
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JComboBox c1, c2, c3, c4, c5, c6, ComboBox1;
    JCheckBox CheckBox1;
    JFrame frame;
    private String str;
    private int xrewsh = 0;
    private ArrayList<JTextField> textfields = new ArrayList();

    public Graphics1() {
        super("Εισαγωγή κράτησης");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] year = {"2016", "2017", "2018", "2019", "2020"};

        label1 = new JLabel("Όνομα : ", JLabel.LEFT); //sto sugkekrimeno frame xrthsimopoiw labels pou topothetountai aristera
        label1.setBounds(80, 40, 120, 30);            //kai textfields/boxes deksia
        add(label1);

        textfield1 = new JTextField();
        textfield1.setBounds(210, 42, 140, 25);
        add(textfield1);

        label2 = new JLabel("Επώνυμο : ", JLabel.LEFT);
        label2.setBounds(80, 80, 120, 30);
        add(label2);

        textfield2 = new JTextField();
        textfield2.setBounds(210, 82, 140, 25);
        add(textfield2);

        label3 = new JLabel("Τηλέφωνο : ", JLabel.LEFT);
        label3.setBounds(80, 120, 120, 30);
        add(label3);

        textfield3 = new JTextField();
        textfield3.setBounds(210, 122, 140, 25);
        add(textfield3);

        label4 = new JLabel("Ημερομηνία Άφιξης : ", JLabel.LEFT);
        label4.setBounds(80, 160, 120, 30);
        add(label4);

        c1 = new JComboBox(day);
        c1.setBounds(210, 162, 40, 25);
        add(c1);

        c2 = new JComboBox(month);
        c2.setBounds(260, 162, 40, 25);
        add(c2);

        c3 = new JComboBox(year);
        c3.setBounds(310, 162, 60, 25);
        add(c3);

        label5 = new JLabel("Ημερομηνία Αναχώρησης : ");
        label5.setBounds(80, 200, 120, 30);
        add(label5);

        c4 = new JComboBox(day);
        c4.setBounds(210, 202, 40, 25);
        add(c4);

        c5 = new JComboBox(month);
        c5.setBounds(260, 202, 40, 25);
        add(c5);

        c6 = new JComboBox(year);
        c6.setBounds(310, 202, 60, 25);
        add(c6);

        label6 = new JLabel("Τύπος Δωματίου : ");
        label6.setBounds(80, 240, 120, 30);
        add(label6);

        String[] Rooms = {"Μονόκλινο", "Δίκλινο", "Τρίκλινο"};

        ComboBox1 = new JComboBox(Rooms);
        ComboBox1.setBounds(210, 245, 140, 25);
        add(ComboBox1);

        label7 = new JLabel("Πρωινό : ");
        label7.setBounds(80, 280, 120, 30);
        add(label7);

        CheckBox1 = new JCheckBox("Breakfast");
        CheckBox1.setBounds(210, 282, 140, 25);
        CheckBox1.setMnemonic(KeyEvent.VK_C);
        CheckBox1.setSelected(true);
        add(CheckBox1);

        button3 = new JButton("Καταχώρηση");
        button3.setBounds(80, 330, 120, 30);
        add(button3);

        button4 = new JButton("Άκυρο");
        button4.setBounds(230, 330, 120, 30);
        add(button4);

        textfields.add(textfield1);
        textfields.add(textfield2);
        textfields.add(textfield3);

        button3.addActionListener(new ActionListener() { //action gia epibebaiwsh kataxwrhshs

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean all_filled = true;
                for (JTextField text : textfields) {
                    if (text.getText().trim().isEmpty()) {
                        all_filled = false;
                        break;
                    }
                }
                if (!all_filled) {
                    JOptionPane.showMessageDialog(frame,
                            "Η καταχώρηση δεν πραγματοποιήθηκε. Συμπληρώστε όλα τα κενά",
                            "Αποτυχία Καταχώρησης",
                            JOptionPane.PLAIN_MESSAGE);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);

                } else {
                    getXrewsh();
                    str = Integer.toString(xrewsh);
                    JOptionPane.showMessageDialog(frame,
                            "Η καταχώρηση πραγματοποιήθηκε με επιτυχία." + "Η συνολική χρέωση είναι : " + str,
                                "Επιτυχία Καταχώρησης",
                            JOptionPane.PLAIN_MESSAGE);
                    setVisible(false);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                    ArrayList<Kratisi> kratiseis = null;
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.txt"))) {
                        kratiseis = (ArrayList<Kratisi>) in.readObject();
                    } catch (ClassNotFoundException | IOException ex) {
                        kratiseis = new ArrayList<Kratisi>();
                    }

                    String name1, surname1, num1;
                    boolean ch = false;
                    int day1 = Integer.parseInt((String) c1.getSelectedItem());
                    int day2 = Integer.parseInt((String) c4.getSelectedItem());
                    int month1 = Integer.parseInt((String) c2.getSelectedItem());
                    int month2 = Integer.parseInt((String) c5.getSelectedItem());
                    int year1 = Integer.parseInt((String) c3.getSelectedItem());
                    int year2 = Integer.parseInt((String) c6.getSelectedItem());
                    Calendar cal = Calendar.getInstance(); //tis times apo ta year/month/day ta kanw Date
                    cal.set(year1, month1 - 1, day1);    //bazw month-1 gt me month ksekinouse apo February
                    Date date1 = cal.getTime();
                    cal.set(year2, month2 - 1, day2);
                    Date date2 = cal.getTime();

                    Epilogh(ch);

                    name1 = textfield1.getText();
                    surname1 = textfield2.getText();
                    num1 = textfield3.getText();

                    Client C1 = new Client(name1, surname1, num1);

                    String room1;
                    room1 = (String) ComboBox1.getSelectedItem();

                    Kratisi K1 = new Kratisi(date1, date2, room1, ch, C1);
                    kratiseis.add(K1);

                    try {
                        Main.outstream.writeObject("INSERT");
                    } catch (IOException ex) {
                        Logger.getLogger(Graphics1.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
        );

        button4.addActionListener(new ActionListener() { //action gia Akuro 

            @Override
            public void actionPerformed(ActionEvent e
            ) {
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public int getXrewsh() { //upologismos xrewshs
        if (ComboBox1.getSelectedItem() == "Μονόκλινο") {
            xrewsh = xrewsh + 40;
        } else if (ComboBox1.getSelectedItem() == "Δίκλινο") {
            xrewsh = xrewsh + 50;
        } else if (ComboBox1.getSelectedItem() == "Τρίκλινο") {
            xrewsh = xrewsh + 65;
        }

        if (CheckBox1.isSelected()) {
            xrewsh = xrewsh + 5;
        }

        return xrewsh;
    }

    public boolean Epilogh(boolean choice) { //elegxos gia to checkbox
        if (CheckBox1.isSelected()) {
            choice = true;
            return choice;
        } else {
            choice = false;
            return choice;
        }
    }
}
