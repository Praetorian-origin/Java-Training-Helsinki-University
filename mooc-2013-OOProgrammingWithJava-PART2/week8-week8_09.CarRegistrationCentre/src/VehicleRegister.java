
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    
    
    

    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.get(plate) == null) {
            owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate registrationPlate) {
        return owners.get(registrationPlate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        }
        return false;

    }

    public void printRegistrationPlates() {
        for (Map.Entry<RegistrationPlate, String> entry : owners.entrySet()) {
            RegistrationPlate key = entry.getKey();
            System.out.println(key);
        }
    }

    public void printOwners() {
        String ownersName = "";
        for (Map.Entry<RegistrationPlate, String> entry : owners.entrySet()) {
            String value = entry.getValue();
            if (!ownersName.contains(value)) {
                ownersName = ownersName + value + "\n";
            }

        }
        System.out.print(ownersName);
    }

}
