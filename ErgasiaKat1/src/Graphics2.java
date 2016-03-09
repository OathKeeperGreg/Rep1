
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class Graphics2 extends JFrame {

    JPanel panel3, panel4;
    JButton button5, button6;

    public Graphics2() {
        super("Εμφάνιση των κρατήσεων");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button5 = new JButton("Αναζήτηση με βάση το επίθετο");
        button6 = new JButton("Αναζήτηση με βάση την ημερομηνία άφιξης");

        Container c2 = getContentPane();
        c2.setLayout(new GridLayout(2, 1));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.add(button5);

        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        panel4.add(button6);

        c2.add(panel3);
        c2.add(panel4);
        setVisible(true);

        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                SearchSurname search = new SearchSurname();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
}
