//Icsd13110 Manitaras Grigorios

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Menu extends JFrame {

    JButton button1, button2;
    JPanel panel1, panel2;

    public Menu() {
        super("Menu");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Εισαγωγή κράτησης");
        button2 = new JButton("Εμφάνιση των κρατήσεων");

        Container c1 = getContentPane();
        c1.setLayout(new GridLayout(2, 1));
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(button1);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(button2);

        c1.add(panel1);
        c1.add(panel2);
        setVisible(true);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics1 g1 = new Graphics1();
            }
        });

        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Graphics2 g2 = new Graphics2();
                setDefaultCloseOperation(EXIT_ON_CLOSE);

            }
        });
    }
    
    public void getXrewsh(){
        
    }
}

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

}
