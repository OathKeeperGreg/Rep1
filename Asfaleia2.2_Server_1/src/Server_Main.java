
import java.io.IOException;
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
    protected static ArrayList<User> Registered_Users;
    protected static ArrayList<String> Online;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket Server = new ServerSocket(5555);
        Registered_Users = new ArrayList<User>();
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
            ObjectOutputStream OUT = new ObjectOutputStream(sock.getOutputStream());
            ObjectInputStream IN = new ObjectInputStream(sock.getInputStream());

            try {
                Message mes1 = (Message) IN.readObject();
                System.out.println("Phre to : " + mes1.getMessage1() + " " + mes1.getMessage2() + " " + mes1.getMes_type() + " " +mes1.isUser_status());

                if (mes1.getMes_type().equals("Register_Message")) {
                    System.out.println("phre register");

                    User user = new User(mes1.getMessage1().toString(), mes1.getMessage2().toString(), mes1.isUser_status());
                    if (Server_Main.Registered_Users.contains(user)) {
                        System.out.println("Yparxei");
                        Message Already_Online = new Message(Server_Main.Online, "Online");
                        OUT.writeObject(Already_Online);
                        OUT.flush();
                    } else {
                        Server_Main.Registered_Users.add(user);

                        System.out.println("O user me nickname : " + mes1.getMessage1() + "sundethike sto server");

                        for (int i = 0; i < Server_Main.Registered_Users.size(); i++) {
                            System.out.println("Users : " + Server_Main.Registered_Users.get(i).getNickname());

                        }
                        System.out.println(Server_Main.Registered_Users);
                        Message mes = new Message(Server_Main.Registered_Users, "User");
                        OUT.writeObject(mes);
                        // OUT.reset();
                        OUT.flush();
                    }
                } //                }
                else if (mes1.getMes_type().equals("Heartbeat_Message")) {
                    while (true) {
                        System.out.println(mes1.getMessage1() + " " + mes1.getMessage2());
                        //Server_Main.Users.clear();
                        User al_user = new User(mes1.getMessage1().toString(), mes1.getMessage2().toString(), mes1.isUser_status());

                        if (Server_Main.Registered_Users.contains(al_user)) {
                            System.out.println("brethike");
                            Message list = new Message(Server_Main.Registered_Users);
                            OUT.writeObject(list);
                            OUT.reset();
                            OUT.flush();
//                        Message Users_Alive_Message = new Message(al_user.getNickname(), al_user.getPort());
//                        OUT.writeObject(Users_Alive_Message);
//                        OUT.flush();
                        }
                    }
                } else if(mes1.getMes_type().equals("Busy")){
                    System.out.println("Mphke sthn else");
                    if (mes1.isUser_status() == true) {
                        for (int i = 0; i < Server_Main.Registered_Users.size(); i++) {
                            if (Server_Main.Registered_Users.contains((User) mes1.getMessage1()) || Server_Main.Registered_Users.contains((User) mes1.getMessage2())) {
                                Server_Main.Registered_Users.get(i).setStatus(true);
                                System.out.println("allakse o " + Server_Main.Registered_Users.get(i).getNickname() + "se" + Server_Main.Registered_Users.get(i).isStatus());
                            }
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
