
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Greg
 */
public class KentrikoThread extends Thread {

    Socket socket;
    //String sock;

    public KentrikoThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            ObjectOutputStream OUT1 = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream IN1 = new ObjectInputStream(socket.getInputStream());

            Message KentrikoMessage = (Message) IN1.readObject();
            if (KentrikoMessage.getMessage2().equals("Invite")) {
                Client_Window.busy = true;
                JDialog.setDefaultLookAndFeelDecorated(true); //mhnuma gia chat
                int response = JOptionPane.showConfirmDialog(null, "Do you want to chat with " + KentrikoMessage.getMessage1() + " ?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    OUT1.writeObject(new Message("Accept"));
                    OUT1.flush();

                    Message I2PAdress = (Message) IN1.readObject();
                    int port = (int) I2PAdress.getMessage1();
                    Client_Window.got_invite = true;
                    System.out.println("port" + port);
                    Chat_Window chat = new Chat_Window();
                    chat.Port.add(port);

                    Message message = new Message(Client_Window.Current_User.getNickname(), KentrikoMessage.getMessage1(), "Busy", true);
                    System.out.println(message.getMessage1().toString() + message.getMessage2().toString());
                    Client_Window.OUT.writeObject(message);

                    Client_Window.OUT.flush();
                    System.out.println("Esteile");
                    Client_Window.sck.close();

                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }

            } else if (KentrikoMessage.getMessage2().equals("Chat_Message")) {
                System.out.println("prin diabasei");
                System.out.println("Phre mhnuma");
                String ref = KentrikoMessage.getMessage1().toString();
                Chat_Window.jTextArea2.setText(ref);
            } else if (KentrikoMessage.getMessage2().equals("Refresh")) {
                String ref = (String) KentrikoMessage.getMessage1();
                Chat_Window.jTextArea2.setText(ref);
            }

        } catch (IOException ex) {
            Logger.getLogger(KentrikoThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KentrikoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
