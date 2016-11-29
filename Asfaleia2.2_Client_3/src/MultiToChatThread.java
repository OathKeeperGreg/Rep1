
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg
 */
public class MultiToChatThread extends Thread{
    protected ArrayList<User> SocketList;
    protected Socket invSocket;

    public MultiToChatThread(ArrayList<User> SocketList) throws IOException {
        this.SocketList = SocketList;
    }

    @Override
    public void run() {
        ArrayList<Integer> Local_List;
        Local_List = new ArrayList<>();
        System.out.println("Mphke sto thread");
        for (int i = 0; i < Client_Window.MultiChatList.size(); i++) {
            for (User user : Client_Window.MultiChatList) {
                if (user.getNickname().equals(Client_Window.MultiChatList.get(i).getNickname())) {
                    if (user.isStatus() == false) {
                        try {
                            invSocket = new Socket("127.0.0.1", parseInt(Client_Window.MultiChatList.get(i).getPort()));
                            System.out.println(invSocket);
                            ObjectOutputStream OUT = null;
                            try {
                                OUT = new ObjectOutputStream(invSocket.getOutputStream()); //Δημιουργιία ροών προς τον Client
                                ObjectInputStream IN = new ObjectInputStream(invSocket.getInputStream());

                                Message ChatInvitation = new Message(Client_Window.Current_User.getNickname(), "Invite");
                                OUT.writeObject(ChatInvitation);
                                OUT.flush();

                                Message Reply = (Message) IN.readObject();
                                if (Reply.getMessage1().equals("Accept")) {
                                    System.out.println("Έναρξη συζήτησης");
                                    Message I2PDestination = new Message(Client_Window.address);
                                    OUT.writeObject(I2PDestination);

                                    Local_List.add(parseInt(Client_Window.MultiChatList.get(i).getPort())); //sth lista me tous users pou exw epileksei na kanw chat prostithetai o kathe user
                                    System.out.println(Local_List);
                                    Chat_Window chat = new Chat_Window();
                                }

                            } catch (IOException ex) {
                                Logger.getLogger(MultiToChatThread.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(MultiToChatThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MultiToChatThread.class.getName()).log(Level.SEVERE, null, ex);

                        }
                        user.setStatus(true);
                    }
                }
            }
        }
    }
}
