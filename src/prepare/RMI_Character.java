/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package prepare;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author dinhh
 */
public class RMI_Character {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            Registry registry = LocateRegistry.getRegistry("203.162.10.109");
            CharacterService service = (CharacterService) registry.lookup("RMICharacterService");
            
            String receivedString = service.requestCharacter("B22DCDT147", "qCode");
            
            String sendString = "";
            service.submitCharacter("B22DCDT147", "qCode", sendString);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
