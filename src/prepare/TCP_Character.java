/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author dinhh
 */
public class TCP_Character {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try(Socket socket = new Socket()) {
            
            socket.connect( new InetSocketAddress("203.162.10.109", 2208) );
            socket.setSoTimeout(5000);
            
            BufferedWriter out = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            
            String sendString = "Hello";
            //send
            out.write(sendString);
            out.newLine();
            out.flush();
            
            //receive
            String receivedString = in.readLine();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
