
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Client_Window extends javax.swing.JFrame {

    protected static User Current_User = new User("Taskos ", "8888", false);
    protected static User Inv_Users;
    protected static int Port;
    protected static ServerSocket server;
    public static Socket sck;
    public static ObjectOutputStream OUT;
    public static ObjectInputStream IN;
    protected static ArrayList<User> AliveUsersList;
    protected static int address;
    protected static boolean busy = false;
    protected static ArrayList<User> MultiChatList;
    public static boolean sent_invite = false;
    public static boolean got_invite = false;

    public Client_Window() throws IOException {
        this.setVisible(true);
        address = 8888;
        sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
        OUT = new ObjectOutputStream(sck.getOutputStream()); //Δημιουργιία ροών προς τον Client
        IN = new ObjectInputStream(sck.getInputStream());
        MultiChatList = new ArrayList<User>();
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

        jButton3.setText("Chat");
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
                                .addGap(150, 150, 150)))
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

    //koumpi Online
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        int delay = 3000;
        ActionListener taskPerformer = new ActionListener() { //action gia na stelnei o xrhsths to heartbeat
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {

                    Message stoixeia = new Message(Current_User.getNickname(), Current_User.getPort(), "Heartbeat_Message", Current_User.isStatus());//stelnw stoixeia gia na na dei o server oti eimai akoma sundedemenos
                    OUT.writeObject(stoixeia); //stelnw ta stoixeia mou sto server
                    OUT.flush();
                    AliveUsersList = new <User> ArrayList();
                    list1.removeAll(); 
                    Message list = (Message) IN.readObject(); //diabazw apo to server ta stoixeia twn users pou einai sundedemenoi
                    AliveUsersList = ((ArrayList<User>) list.getMessage1());
                    for (int i = 0; i < AliveUsersList.size(); i++) {
                        list1.add(AliveUsersList.get(i).getNickname()); //bazw sth lista tou GUI osous xrhstes diabasw
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Timer(delay, taskPerformer).start(); //stelnw ana lepto Heartbeat sto server me ena thread Timer
        ListeningThread listen = new ListeningThread(address); //bazoume to ListeningThread na trxei
        listen.start();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    //koumpi Register
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sck = new Socket("127.0.0.1", 5555); //socket gia na steilw stoixeia kai na sundethw
            ObjectOutputStream OUT = new ObjectOutputStream(sck.getOutputStream()); //dhmiourgia rown pros kai apo ton server
            ObjectInputStream IN = new ObjectInputStream(sck.getInputStream());

            Message mes1 = new Message(Current_User.getNickname(), Current_User.getPort(), "Register_Message", Current_User.isStatus()); //stelnw sto server nickname kai i2p adress gia register
            OUT.writeObject(mes1);
            OUT.flush();

            Message getOnlineList; 
            ArrayList<User> OnlineUsersList = new <User> ArrayList();

            getOnlineList = (Message) IN.readObject(); //diabazw poioi users exoun steilei heartbeat
            OnlineUsersList = ((ArrayList<User>) getOnlineList.getMessage1());
            System.out.println(getOnlineList.getMessage1());

            if (getOnlineList.getMessage2().equals("Online")) { //an pathsei pali o idios user register
                JOptionPane.showMessageDialog(null, "The user has already registered");
            } else { 
                list1.removeAll();
                for (int i = 0; i < OnlineUsersList.size(); i++) {
                    list1.add(OnlineUsersList.get(i).getNickname()); //prosthetw sth lista tou GUI ta items pou pairnoume apo th lista tou server me tous xrhstes pou exoun sundethei sto chat
                }
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
            String[] s = list1.getSelectedItems(); //apothikeuw se ena String oti epilegei o user apo th lista tou GUI
            for (int j = 0; j < s.length; j++) { 
                for (int i = 0; i < AliveUsersList.size(); i++) {
                    if (s[j].equals(AliveUsersList.get(i).getNickname())) {
                        if (AliveUsersList.get(i).isStatus() == false) { //oso to busy status tou user einai false steiltou invite
                            System.out.println("Stelnw invite ston: " + s[j]);
                            Inv_Users = new User(AliveUsersList.get(i).getNickname(), AliveUsersList.get(i).getPort(), AliveUsersList.get(i).isStatus());//ftiaxnoume ena user ston opoio kanoume inv
                            System.out.println(Inv_Users.getPort()); 
                            MultiChatList.add(Inv_Users); //prosthetoume sth lista twn users pou theloume na kanoume chat autous pou epelekse o user
                            sent_invite = true; //otan kapoios kanei invite ginetai automata kai admin gia na mporei na kanei refresh to chat stous upoloipous users
                            break;
                        }
                    }
                }
            }
            MultiToChatThread thread = new MultiToChatThread(Client_Window.MultiChatList);
            thread.start(); //ksekinaei na trexei to MultiToChatThread 
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




