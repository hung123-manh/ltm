/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author dinhh
 */
public class RMI_Data {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("203.162.10.109");
            DataService service = (DataService) registry.lookup("RMIDataService");
            
            String receivedString = (String) service.requestData("B22DCDT147", "qCode");
            
            String sendString = "";
            service.submitData("B22DCDT147", "qCode", sendString);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
