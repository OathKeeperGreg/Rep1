
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
    

public class Search extends JFrame{
    JButton button7;
    JLabel label8;
    JTextField textfield4;
    
    public Search(){
        super("Αναζήτηση με βάση το επώνυμο");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        label8 = new JLabel("Επώνυμο : ", JLabel.LEFT);
        label8.setBounds(80, 80, 120, 30);
        add(label8);
        
        textfield4 = new JTextField();
        textfield4.setBounds(210, 82, 140, 25);
        add(textfield4);
        
        button7 = new JButton("ΟΚ");
        button7.setBounds(200, 200, 40, 40);
        add(button7);
        
        setVisible(true);
    }
    
}
