/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author dinhh
 */
public class UDP_Object {

    /**
     * @param args the command line arguments
     */
    
    class ObjectClass {
        
    }
    
    public static void main(String args[]) {
        try(DatagramSocket socket = new DatagramSocket()) {
            
            InetAddress serverAddress = InetAddress.getByName("203.162.10.109");
            
            byte[] sentBytes = new byte[9086];
            DatagramPacket firstPacket = new DatagramPacket(sentBytes, sentBytes.length, serverAddress, 2209);
            String requestId = new String(firstPacket.getData(), 0, 8);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(firstPacket.getData(), 8, firstPacket.getLength());
            ObjectInputStream ois = new ObjectInputStream(bais);
            ObjectClass obj = (ObjectClass) ois.readObject();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(requestId.getBytes());
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.flush();
            
            byte[] secondBytes = baos.toByteArray();
            DatagramPacket secondPacket = new DatagramPacket(secondBytes, secondBytes.length, serverAddress, 2209);
            socket.send(secondPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
