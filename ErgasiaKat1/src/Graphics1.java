
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
    JComboBox ComboBox1;
    JCheckBox CheckBox1;
    JFrame frame;
    private String str;
    private int xrewsh = 0;

    public Graphics1() {
        super("Εισαγωγή κράτησης");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        label1 = new JLabel("Όνομα : ", JLabel.LEFT);
        label1.setBounds(80, 40, 120, 30);
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

        textfield4 = new JTextField();
        textfield4.setBounds(210, 162, 140, 25);
        add(textfield4);

        label5 = new JLabel("Ημερομηνία Αναχώρησης : ");
        label5.setBounds(80, 200, 120, 30);
        add(label5);

        textfield5 = new JTextField();
        textfield5.setBounds(210, 202, 140, 25);
        add(textfield5);

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
        
        
        
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Η καταχώρηση πραγματοποιήθηκε με επιτυχία.",
                        "Επιτυχία Καταχώρησης",
                        JOptionPane.PLAIN_MESSAGE);
                setVisible(false);
                getXrewsh();
                System.out.println(xrewsh);
                Menu m = new Menu();
            }
        });

        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Menu a = new Menu();
            }
        });

        setVisible(true);
    }
    
    public int getXrewsh(){
        if(ComboBox1.getSelectedItem() == "Μονόκλινο"){
            xrewsh = xrewsh + 40;
        }
        else if(ComboBox1.getSelectedItem() == "Δίκλινο"){
            xrewsh = xrewsh + 50;
        }
        else if(ComboBox1.getSelectedItem() == "Τρίκλινο"){
            xrewsh = xrewsh + 65;
        }
        
        if(CheckBox1.isSelected()){
            xrewsh = xrewsh +5;
        }
        
        return xrewsh;
    }

    public static void main(String[] args) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("customers.txt"));

        Customer C1 = new Customer("Name1", "bday1", "num1");
        Customer C2 = new Customer("Name1", "bday1", "num1");
        Customer C3 = new Customer("Name1", "bday1", "num1");

        out.writeObject(C1);
        out.writeObject(C2);
        out.writeObject(C3);
        out.close();
    }
}
