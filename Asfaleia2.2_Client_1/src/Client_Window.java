
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Client_Window extends javax.swing.JFrame {

    protected static User Current_User = new User("Greg ", "6666", false);
    protected static User Inv_Users;
    protected static int Port;
    protected static ServerSocket server;
    public static Socket sck;
    public static ObjectOutputStream OUT;
    public static ObjectInputStream IN;
    protected static ArrayList<User> AliveUsersList;
    protected static int address;
    protected static boolean first = false;
    protected static ArrayList<User> MultiChatList;

    public Client_Window() throws IOException {
        this.setVisible(true);
        address = 6666;
        MultiChatList = new ArrayList<User>();
        sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
        OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
        IN = new ObjectInputStream(sck.getInputStream());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        list1 = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list1.setMultipleMode(true);

        jLabel1.setText("Chat Room");

        jToggleButton2.setText("Online");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Multi-Chat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(148, 148, 148)))
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addComponent(jButton3)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jButton1))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        int delay = 3000;
        ActionListener taskPerformer = new ActionListener() { //action gia na stelnei o xrhsths to heartbeat
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {

                    Message stoixeia = new Message(Current_User.getNickname(), Current_User.getPort(), "Heartbeat_Message", Current_User.isStatus());
                    OUT.writeObject(stoixeia);
                    OUT.flush();
                    AliveUsersList = new <User> ArrayList();
                    list1.removeAll();
                    Message list = (Message) IN.readObject();
                    AliveUsersList = ((ArrayList<User>) list.getMessage1());
                    for (int i = 0; i < AliveUsersList.size(); i++) {
                        list1.add(AliveUsersList.get(i).getNickname());
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Timer(delay, taskPerformer).start();
        ListeningThread listen = new ListeningThread(address);
        listen.start();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
            ObjectOutputStream OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
            ObjectInputStream IN = new ObjectInputStream(sck.getInputStream());

            Message mes1 = new Message(Current_User.getNickname(), Current_User.getPort(), "Register_Message", Current_User.isStatus()); //stelnw sto server nickname kai i2p adress
            OUT.writeObject(mes1);
            OUT.flush();

            Message getOnlineList;
            ArrayList<User> OnlineUsersList = new <User> ArrayList();

            getOnlineList = (Message) IN.readObject();
            OnlineUsersList = ((ArrayList<User>) getOnlineList.getMessage1());
            System.out.println(getOnlineList.getMessage1());

            if (getOnlineList.getMessage2().equals("Online")) { //an pathsei pali o idios user register
                JOptionPane.showMessageDialog(null, "The user has already registered");
            } else {
                list1.removeAll();
                for (int i = 0; i < OnlineUsersList.size(); i++) {
                    list1.add(OnlineUsersList.get(i).getNickname()); //prosthetw sth lista tou GUI ta items pou pairnoume apo th lista tou server me tous xrhstes pou exoun sundethei sto chat
                }
                //System.out.println(OnlineUsersList.get(0).toString());
                System.out.println("List : " + getOnlineList.getMessage1());
                JOptionPane.showMessageDialog(null, "You have succesfully registered !");
            }

        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String[] s = list1.getSelectedItems();
            for (int j = 0; j < s.length; j++) {
                for (int i = 0; i < AliveUsersList.size(); i++) {
                    if (s[j].equals(AliveUsersList.get(i).getNickname())) {
                        if (AliveUsersList.get(i).isStatus() == false) {
                            System.out.println("Stelnw invite ston: " + s[j]);
                            Inv_Users = new User(AliveUsersList.get(i).getNickname(), AliveUsersList.get(i).getPort(), AliveUsersList.get(i).isStatus());
                            System.out.println(Inv_Users.getPort());
                            MultiChatList.add(Inv_Users);
                            first = true;
                            break;
                        }
                    }
                }
            }
            MultiToChatThread thread = new MultiToChatThread(Client_Window.MultiChatList);
            thread.start();
        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Client_Window().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}

class MultiToChatThread extends Thread {

    protected ArrayList<User> SocketList;
    protected Socket invSocket;

    public MultiToChatThread(ArrayList<User> SocketList) throws IOException {
        this.SocketList = SocketList;
    }

    @Override
    public void run() {
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

                                    Chat_Window chat = new Chat_Window();
                                    chat.Ports.add(Client_Window.MultiChatList);
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

class ListeningThread extends Thread {

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

class KentrikoThread extends Thread {

    Socket socket;

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
                    System.out.println("port" + port);

                    Chat_Window chat = new Chat_Window();

//                    Client_Window.OUT = new ObjectOutputStream(Client_Window.sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
//                    Client_Window.IN = new ObjectInputStream(Client_Window.sck.getInputStream());
                    Message message = new Message(Client_Window.Current_User.getNickname(), Client_Window.Inv_Users.getNickname(), "Busy", true);
                    System.out.println(message.getMessage1().toString() + message.getMessage2().toString());
                    Client_Window.OUT.reset();
                    Client_Window.OUT.writeObject(message);

                    Client_Window.OUT.flush();
                    System.out.println("Esteile");
                    Client_Window.sck.close();

                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
            } else if (KentrikoMessage.getMessage2().equals("Chat_Message")) {
                String keimeno = (String) KentrikoMessage.getMessage1();
                if (Client_Window.first = true) {
                    Chat_Window.jTextArea2.append(keimeno + "\n");
                    Chat_Window.jTextArea2.setText(keimeno);
//                OUT1.writeObject(keimeno);
//                OUT1.flush();
                }
                Client_Window.first=false;
            }

        } catch (IOException ex) {
            Logger.getLogger(KentrikoThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KentrikoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
