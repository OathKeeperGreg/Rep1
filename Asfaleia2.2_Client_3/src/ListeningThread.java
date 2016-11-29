
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;
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
public class ListeningThread extends Thread{
    private int server;

    public ListeningThread(int server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            ServerSocket serversocket = new ServerSocket(parseInt(Client_Window.Current_User.getPort()));
            while (true) {

                try {
                    Socket sock = serversocket.accept();

                    KentrikoThread receive = new KentrikoThread(sock);
                    receive.start();
                } catch (IOException ex) {
                    Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
