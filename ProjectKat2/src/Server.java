
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;
import static jdk.nashorn.internal.runtime.Debug.id;

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
    private static ArrayList<Kratisi> list = new ArrayList<Kratisi>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(5555);

        server = serverSocket.accept();

        outstream = new ObjectOutputStream(server.getOutputStream());
        instream = new ObjectInputStream(server.getInputStream());

        while (true) {
            Kratisi K1 = (Kratisi) instream.readObject();
            String response = (String) instream.readObject();
            if (response.equals("START")) {
                outstream.writeObject("WAITING");
            } else if (response.equals("INSERT")) { //EISAGWGH
                
                
                Graphics1.getXrewsh();
                K1.setXrewsh(Graphics1.getXrewsh());
                list.add(K1);
                UUID UId = UUID.randomUUID();//dhmiourgia Unique ID apo ton server
                K1.setId(UId);
                outstream.writeObject(K1.getId());
                outstream.writeObject(K1.getXrewsh());

                //upologismos kostous
            }//apostoli kostous
            //apostoli id
            //eisagwgi stin arraylist
            //apostoli ok
            else if (response.equals("SEARCH")){  //ANAZHTHSH SURNAME
                
                for (Kratisi kratisi : list) {
                    Client cust = kratisi.getC();
                    if (SearchSurname.textfield4.getText().equals(cust.getSurname()))  {
                        System.out.println(kratisi.toString());
                        outstream.writeObject(K1.getId());
                        outstream.writeObject("ΣΤΟΙΧΕΙΑ ΚΡΑΤΗΣΗΣ");
                        outstream.writeObject("OK");
                        break;
                    }
                }
            }
            
            else if(response.equals("DELETE")){
                
            }
                
                

            }

        }
    
    

    }

