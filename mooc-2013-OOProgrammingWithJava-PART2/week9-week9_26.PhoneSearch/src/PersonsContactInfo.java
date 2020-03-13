
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class PersonsContactInfo {

    private Map<String, List<String>> phoneNumbersPersons;
    private Map<String, List<String[]>> adressPersons;

    public PersonsContactInfo() {
        phoneNumbersPersons = new HashMap<String, List<String>>();
        adressPersons = new HashMap<String, List<String[]>>();
    }

    public void addNumber(String person, String number) {
        if (!phoneNumbersPersons.containsKey(person)) {

            phoneNumbersPersons.put(person, new ArrayList<String>());
            phoneNumbersPersons.get(person).add(number);
        } else {
            phoneNumbersPersons.get(person).add(number);
        }
    }

    public List<String> getPersonPhoneNumbers(String person) {
        return phoneNumbersPersons.get(person);
    }

    public String getPersonByPhoneNumber(String number) {
        String person = null;
        for (String key : phoneNumbersPersons.keySet()) {
            List<String> phones = phoneNumbersPersons.get(key);
            for (String phone : phones) {
                if (phone.equals(number)) {
                    person = key;
                    break;
                }
            }
        }
        return person;
    }

    public void addAdress(String person, String street, String city) {
        String[] adressArray = {street, city};

        if (!adressPersons.containsKey(person)) {
            adressPersons.put(person, new ArrayList<String[]>());
            adressPersons.get(person).add(adressArray);
        } else {
            adressPersons.get(person).add(adressArray);
        }
    }

    public List<String[]> getAdressOfPerson(String person) {
        return adressPersons.get(person);
    }

    public void deleteInformation(String person) {
        adressPersons.remove(person);
        phoneNumbersPersons.remove(person);
    }

    public Set<String> getPersonsThatHaveKeyWord(String keyWord) {
        //ArrayList<String> persons_having_keyword = new ArrayList<String>();
        //HashSet<String> persons = (HashSet<String>) phoneNumbersPersons.keySet();
        HashSet<String> persons = new HashSet<String>();
        for (Map.Entry<String, List<String>> entry : phoneNumbersPersons.entrySet()) {
            persons.add(entry.getKey());
        }

        for (Map.Entry<String, List<String[]>> entry : adressPersons.entrySet()) {
            persons.add(entry.getKey());
        }

        HashSet<String> persons_with_keyword = new HashSet<String>();
        for (String key : persons) {
            if (key.contains(keyWord)) {
                persons_with_keyword.add(key);
            }
            if (adressPersons.containsKey(key)) {
                List<String[]> address = adressPersons.get(key);
                for (String[] addres : address) {
                    if (addres[0].contains(keyWord) || addres[1].contains(keyWord)) {
                        persons_with_keyword.add(key);
                    }
                }
            }
        }
        return persons_with_keyword;
    }

    public boolean has_person_info(String person) {
        return adressPersons.containsKey(person) || phoneNumbersPersons.containsKey(person);
    }

    public Set<String> getAllPersons() {
        HashSet<String> persons = new HashSet<String>();
        for (Map.Entry<String, List<String>> entry : phoneNumbersPersons.entrySet()) {
            persons.add(entry.getKey());
        }

        for (Map.Entry<String, List<String[]>> entry : adressPersons.entrySet()) {
            persons.add(entry.getKey());
        }
        return persons;
    }

}
