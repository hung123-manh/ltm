/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import RMI.ObjectService;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author dinhh
 */

class ObjectClass implements Serializable{
    private static final long serialVersionUID = 20241132L;
}


public class RMI_Object {

    /**
     * @param args the command line arguments
     */
    
  
    
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("203.162.10.109");
            ObjectService service = (ObjectService) registry.lookup("RMIObjectService");
            
            ObjectClass obj = (ObjectClass) service.requestObject("B22DCDT147", "qCode");
            
            service.submitObject("B22DCDT147", "qCode", obj);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
