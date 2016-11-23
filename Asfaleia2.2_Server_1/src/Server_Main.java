
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_Main {

    public static ObjectOutputStream OUT;
    public static ObjectInputStream IN;
    protected static ArrayList<User> Users;
    protected static ArrayList<String> Online;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket Server = new ServerSocket(5555);
        Users = new ArrayList<User>();
        while (true) {

            Socket sock = Server.accept();
            System.out.println("The server is up and running........");

            ReceiveFromClientThread receive = new ReceiveFromClientThread(sock);
            Thread thread = new Thread(receive);
            thread.start();
        }
    }
}

class ReceiveFromClientThread extends Thread {

    Socket sock = null;

    public ReceiveFromClientThread(Socket sock) throws IOException, ClassNotFoundException {
        this.sock = sock;

    }//end constructor

    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        try {
            Server_Main.Online = new ArrayList<String>();
            Server_Main.Online.add("Online");
            ObjectOutputStream OUT;
            OUT = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream IN = new ObjectInputStream(sock.getInputStream());

            try {
                Message mes1 = (Message) IN.readObject();
                System.out.println("Phre to : " + mes1.getMessage1() + " " + mes1.getMessage2() + " " + mes1.getMes_Type());

                if (mes1.getMes_Type().equals("Register_Message")) {
                    System.out.println("phre register");

                    User user = new User(mes1.getMessage1().toString(), mes1.getMessage2().toString());
                    if (Server_Main.Users.contains(user)) {
                        System.out.println("Yparxei");
                        Message Already_Online = new Message(Server_Main.Online, "Online");
                        OUT.writeObject(Already_Online);
                        OUT.flush();
                    } else {
                        Server_Main.Users.add(user);
                        System.out.println("O user me nickname : " + mes1.getMessage1() + "sundethike sto server");

                        for (int i = 0; i < Server_Main.Users.size(); i++) {
                            System.out.println("Users : " + Server_Main.Users.get(i).getNickname());
                        }
                        Message mes = new Message(Server_Main.Users, "User");
                        OUT.writeObject(mes);
                        OUT.flush();
                    }
                }

                if (mes1.getMes_Type().equals("Heartbeat_Message")) {
                    while (true) {
                        System.out.println(mes1.getMessage1() + " " + mes1.getMessage2());
                        //Server_Main.Users.clear();
                        User al_user = new User(mes1.getMessage1().toString(), mes1.getMessage2().toString());

                        if (Server_Main.Users.contains(al_user)) {
                            System.out.println("brethike");
                            Message list = new Message(Server_Main.Users.toString());
                            OUT.writeObject(list);
                            OUT.flush();
//                        Message Users_Alive_Message = new Message(al_user.getNickname(), al_user.getPort());
//                        OUT.writeObject(Users_Alive_Message);
//                        OUT.flush();
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(ReceiveFromClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReceiveFromClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReceiveFromClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
