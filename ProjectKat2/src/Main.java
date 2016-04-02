

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author g_man
 */
class Menu extends JFrame {

    JButton button1, button2;
    JPanel panel1, panel2;

    public Menu() { //Arxiko menu me epiloges
        super("Menu");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Εισαγωγή κράτησης");
        button2 = new JButton("Εμφάνιση των κρατήσεων");

        Container c1 = getContentPane();//dhmiourgia GridLayout gia na pane ta buttons to 1 katw apo to allo
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

        button1.addActionListener(new ActionListener() { //action gia thn kataxwrhsh

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                Graphics1 g1 = new Graphics1();
            }
        });

        button2.addActionListener(new ActionListener() { //action gia thn anazhthsh

            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                setVisible(false);
                Graphics2 g2 = new Graphics2();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
    }
}

public class Main {

    protected static Socket socket;
    protected static ObjectOutputStream outstream;
    protected static ObjectInputStream instream;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        socket = new Socket("127.0.0.1", 5555);

        outstream = new ObjectOutputStream(socket.getOutputStream());
        instream = new ObjectInputStream(socket.getInputStream());
        
        outstream.writeObject("START");
        String response = (String) instream.readObject();
        System.out.print(response);
        
        Menu menu = new Menu();

    }
}
