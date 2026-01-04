/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import RMI.ByteService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author dinhh
 */
public class RMI_Byte {

    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String args[]) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("203.162.10.109");
            ByteService service = (ByteService) registry.lookup("RMIByteService");
            
            //send and receive data
            service.requestData("studentCode","qCode" );
            
            byte[] result = new byte[9086];
            //send result
            service.submitData("studentCode" , "qCode", result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
