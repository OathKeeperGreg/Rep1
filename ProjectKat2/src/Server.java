

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g_man
 */
public class Server {
    
    protected static ServerSocket serverSocket;
    protected static Socket server;
    protected static ObjectOutputStream outstream;
    protected static ObjectInputStream instream;
    
    public static void main(String [] args) throws IOException, ClassNotFoundException{
           serverSocket = new ServerSocket(5555);
           
           server = serverSocket.accept();
           
           outstream = new ObjectOutputStream(server.getOutputStream());
           instream = new ObjectInputStream(server.getInputStream());
           
           while(true){
               String response = (String) instream.readObject();
               if(response.equals("START")){
                   outstream.writeObject("WAITING");
               }
               else{
                   if(response.equals("INSERT")){
                      Kratisi k1 = (Kratisi) instream.readObject();
                      
                      //upologismos kostous
                      
                      //apostoli kostous
                      //apostoli id
                      
                      //eisagwgi stin arraylist
                   }
               
               
               
                   //apostoli ok
               }
           
           
           }
           
           
           
    }
}
