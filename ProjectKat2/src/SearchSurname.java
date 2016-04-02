
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchSurname extends JFrame {

    JButton button7;
    JLabel label8;
    JTextField textfield4;

    public SearchSurname() {
        super("Αναζήτηση με βάση το επώνυμο");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        label8 = new JLabel("Επώνυμο : ", JLabel.LEFT);
        label8.setBounds(80, 80, 120, 30);
        add(label8);

        textfield4 = new JTextField();
        textfield4.setBounds(210, 82, 140, 25);
        add(textfield4);

        button7 = new JButton("ΟΚ");
        button7.setBounds(180, 200, 60, 30);
        add(button7);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                

                ArrayList<Kratisi> kratiseis = null;
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("customers.txt"))) {
                    kratiseis = (ArrayList<Kratisi>) in.readObject();
                } catch (ClassNotFoundException | IOException ex) {
                    kratiseis = new ArrayList<Kratisi>();
                }

                for (Kratisi kratisi : kratiseis) {
                    Client cust = kratisi.getC();
                    if (textfield4.getText().equals(cust.getSurname()))  {
                        System.out.println(kratisi.toString());
                        break;
                    }
                }   
            }

        });
       
        setVisible(true);
    }
}
