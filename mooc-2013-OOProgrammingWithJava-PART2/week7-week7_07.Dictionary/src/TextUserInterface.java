
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void add() {
        System.out.print("In finnish: ");
        String finnishWord = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(finnishWord, translation);
    }

    public void translate() {
        System.out.print("Give a word: ");
        String to_translate = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(to_translate));
    }

    public void start() {
        System.out.println("Statement:");
        System.out.println("quit - quit the text user interface");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quits the text user interface");
        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }

            if (command.equals("add")) {
                add();
            }

            if (command.equals("translate")) {
                translate();
            }

        }

    }

}
