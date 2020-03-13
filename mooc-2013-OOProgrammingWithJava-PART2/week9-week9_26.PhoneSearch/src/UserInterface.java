
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
public class UserInterface {

    private PersonsContactInfo personsContacts;
    private Scanner reader;

    public UserInterface(Scanner reader) {
        personsContacts = new PersonsContactInfo();
        this.reader = reader;
    }

    public void display_person_all_info(String person) {
        List<String[]> adress = personsContacts.getAdressOfPerson(person);
        List<String> phoneNumbers = personsContacts.getPersonPhoneNumbers(person);

        if (adress != null) {

            for (String[] adresses : adress) {
                System.out.print("  adress: ");
                System.out.println(adresses[0] + " " + adresses[1]);
            }
        } else {
            System.out.println("  address unknown");
        }

        if (phoneNumbers != null) {
            System.out.println("  phone numbers: ");
            for (String phoneNumber : phoneNumbers) {
                System.out.println("   " + phoneNumber);
            }
        } else {
            System.out.println("  phone number not found");
        }
    }

    public void start() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println();

        String command;
        while (true) {
            System.out.print("command: ");
            command = reader.nextLine();
            if (command.equals("x")) {
                break;
            }

            if (command.equals("1")) {
                System.out.print("whose number: ");
                String person = reader.nextLine();
                System.out.print("number: ");
                String number = reader.nextLine();
                personsContacts.addNumber(person, number);

            }

            if (command.equals("2")) {
                System.out.print("whose number: ");
                String person = reader.nextLine();
                List<String> numbers = personsContacts.getPersonPhoneNumbers(person);
                if (numbers == null || numbers.isEmpty()) {
                    System.out.println("  not found");
                } else {
                    for (String number : numbers) {
                        System.out.println(" " + number);
                    }
                }
            }

            if (command.equals("3")) {
                System.out.print("number: ");
                String number = reader.nextLine();
                String person = personsContacts.getPersonByPhoneNumber(number);
                if (person == null) {
                    System.out.println(" not found");
                } else {
                    System.out.println(" " + person);
                }
            }

            if (command.equals("4")) {
                System.out.print("whose address: ");
                String person = reader.nextLine();
                System.out.print("street: ");
                String street = reader.nextLine();
                System.out.print("city: ");
                String city = reader.nextLine();
                personsContacts.addAdress(person, street, city);
            }

            if (command.equals("5")) {
                System.out.print("whose information: ");
                String person = reader.nextLine();
                if (personsContacts.has_person_info(person)) {
                    display_person_all_info(person);
                }
                else {
                    System.out.println("  not found");
                }

            }

            if (command.equals("6")) {
                System.out.print("whose information: ");
                String person = reader.nextLine();
                personsContacts.deleteInformation(person);
            }

            if (command.equals("7")) {
                System.out.print("keyword (if empty, all listed): ");
                String keyword = reader.nextLine();
                Set<String> persons_with_keyword;
                if (!keyword.isEmpty()) {
                         persons_with_keyword = personsContacts.getPersonsThatHaveKeyWord(keyword);
                }  
                else {
                     persons_with_keyword = personsContacts.getAllPersons();
                }
           
                if (persons_with_keyword == null || persons_with_keyword.isEmpty()) {
                    System.out.println(" keyword not found");
                } else {
                    List<String> sortedPersonList = new ArrayList<String>(persons_with_keyword);
                    Collections.sort(sortedPersonList);
                    int index = 0;
                    for (String person : sortedPersonList) {
                        System.out.println(" " + person);
                        display_person_all_info(person);
                        index++;
                        if (sortedPersonList.size() > 1 && index < sortedPersonList.size()) {
                            System.out.println();
                        }
                    }
                }
            }
            System.out.println();

        }
    }

}
