/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author dinhh
 */

class ObjectClass implements Serializable{
    private static final long serialVersionUID = 20150711L;
}

public class TCP_Object {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try(Socket socket = new Socket()) {
            
            socket.connect( new InetSocketAddress("203.162.10.109", 2208) );
            socket.setSoTimeout(5000);
            
            ObjectInputStream in = new ObjectInputStream( socket.getInputStream() );
            ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
            
            //send
            String sendString = "Hello";
            out.writeObject(sendString);
            out.flush();
            
            //receive
            ObjectClass obj = (ObjectClass) in.readObject();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
