/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prepare;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author dinhh
 */
public class TCP_Data {
    
    public static void main(String[] args) {
        
       try(Socket socket = new Socket()) {
            
            socket.connect( new InetSocketAddress("203.162.10.109", 2208 ));
            socket.setSoTimeout(5000);
            
            DataInputStream in = new DataInputStream( socket.getInputStream() );
            DataOutputStream out = new DataOutputStream( socket.getOutputStream() );
            
            //Send
            out.writeInt(5);
            out.writeUTF("Hello World");
            out.flush();
            
            //receive
            String receivedString = in.readUTF();
            Integer i = in.readInt();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
