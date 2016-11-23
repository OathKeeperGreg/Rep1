
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Client_Window extends javax.swing.JFrame {

    protected static User Current_User = new User("Stathis ", "7777");
    protected static User Inv_Users;
    protected static ServerSocket server;
    public static Socket sck;
    public static ObjectOutputStream OUT;
    public static ObjectInputStream IN;

    /**
     * Creates new form Client_Window
     */
    public Client_Window() throws IOException {
        this.setVisible(true);
        server = new ServerSocket(1111);
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
        jButton2 = new javax.swing.JButton();

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

        jButton2.setText("Chat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                                .addComponent(jButton2)
                                .addGap(66, 66, 66)))
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
                        .addComponent(jButton2)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jButton1))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
            OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
            IN = new ObjectInputStream(sck.getInputStream());
            int delay = 3000; //milliseconds
            ArrayList<String> AliveUsersList = new <String> ArrayList();
            ActionListener taskPerformer = new ActionListener() { //action gia na stelnei o xrhsths to heartbeat
                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        Message stoixeia = new Message(Current_User.getNickname(), Current_User.getPort(), "Heartbeat_Message");
                        OUT.writeObject(stoixeia);
                        OUT.flush();

                        list1.removeAll();
                        Message list = (Message) IN.readObject();
                        //AliveUsersList.add(list.getMessage1());
                        for (int i = 0; i < AliveUsersList.size(); i++) {
                            list1.add(AliveUsersList.get(i));
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            new Timer(delay, taskPerformer).start();
        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
            ObjectOutputStream OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
            ObjectInputStream IN = new ObjectInputStream(sck.getInputStream());

            Message mes1 = new Message(Current_User.getNickname(), Current_User.getPort(), "Register_Message"); //stelnw sto server nickname kai i2p adress
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

            sck.close();

        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s = list1.getSelectedItem().toString();
        String[] parts = s.split(" ");
        String part1 = parts[0]; //username
        String part2 = parts[1]; //password

        Inv_Users = new User(part1, part2);
        Syndeseis connections = new Syndeseis(server, sck);
        connections.start();

        try {
            InviteToChatThread thread = new InviteToChatThread(Current_User.getPort(), part2);
            thread.start();
            Chat_Window chat = new Chat_Window();
        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (server.isBound()) {
            try {
                AnswerToInviteThread thread1 = new AnswerToInviteThread(part2);
                thread1.start();
            } catch (IOException ex) {
                Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton2;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}

class InviteToChatThread extends Thread {

    protected static String sck1, sck2;
    protected static Socket mySocket, invSocket;

    public InviteToChatThread(String sck1, String sck2) throws IOException {
        this.sck1 = sck1;
        this.sck2 = sck2;
        mySocket = new Socket("127.0.0.1", parseInt(sck1));
        invSocket = new Socket("127.0.0.1", parseInt(sck2));
    }

    @Override
    public void run() {
        ObjectOutputStream OUT = null;
        try {
            OUT = new ObjectOutputStream(invSocket.getOutputStream()); //Δημιουργιία ροών προς τον Client
            ObjectInputStream IN = new ObjectInputStream(invSocket.getInputStream());

            Message ChatInvitation = new Message("Stathis", "Invitation");
            OUT.writeObject(ChatInvitation);

            Message Reply = (Message) IN.readObject();
            if (Reply.getMessage1().equals("Accept")) {
                System.out.println("Έναρξη συζήτησης");
                Message I2PDestination = new Message(mySocket.toString());
                OUT.writeObject(I2PDestination);
            }

        } catch (IOException ex) {
            Logger.getLogger(InviteToChatThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InviteToChatThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                OUT.close();
            } catch (IOException ex) {
                Logger.getLogger(InviteToChatThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class AnswerToInviteThread extends Thread {

    protected static String sck2;
    protected static Socket sck;

    public AnswerToInviteThread(String sck2) throws IOException {
        this.sck2 = sck2;
        sck = new Socket("127.0.0.1", parseInt(sck2));
    }

    @Override
    public void run() {
        try {
//            ServerSocket sock = new ServerSocket(0000); //socket gia na steilw stoixeia kai na sundethw
//            Socket sck = sock.accept();
            ObjectOutputStream OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
            ObjectInputStream IN = new ObjectInputStream(sck.getInputStream());
            Message mes1 = (Message) IN.readObject();
            if (mes1.getMessage2().equals("Invitation")) {

                JDialog.setDefaultLookAndFeelDecorated(true); //mhnuma gia chat
                int response = JOptionPane.showConfirmDialog(null, "Do you want to chat with " + mes1.getMessage1() + " ?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                    sck.close();
                } else if (response == JOptionPane.YES_OPTION) {
                    System.out.println("Yes button clicked");
//                    String port;
//                    port =  sock.getLocalPort().toString();

                    Message mes2 = new Message("Accept");
                    OUT.writeObject(mes2);

                    Message I2PDestination = (Message) IN.readObject();
                    System.out.println(I2PDestination);

                    Chat_Window chat1 = new Chat_Window();
                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class Syndeseis extends Thread { //Thread gia tis sundeseis twn sockets

    ServerSocket server;
    Socket socket;

    public Syndeseis(ServerSocket server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            server.accept();
        } catch (IOException ex) {
            Logger.getLogger(Syndeseis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
