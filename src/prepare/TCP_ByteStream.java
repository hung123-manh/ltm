    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import static TCP.TCP_ByteStream_chuoicontangdandainhat.Solve;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author dinhh
 */
public class TCP_ByteStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try(Socket socket=new Socket("203.162.10.109", 2208)) {
            
                        
            //socket.connect( new InetSocketAddress("203.162.10.109", 2208));
            socket.setSoTimeout(5000);
            
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            //send
            String sendString = "HellowWorld";
            byte[] sendBytes = sendString.getBytes();
            out.write(sendBytes, 0, sendBytes.length);
            out.flush();
            
            //receive
            byte[] receivedBytes = new byte[9086];
            in.read(sendBytes);
            String receivedString = new String(receivedBytes, 0,receivedBytes.length);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
