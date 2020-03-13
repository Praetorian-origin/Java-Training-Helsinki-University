/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author praetorian
 */
public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Fedor Dostojevski", "Crime and Punishment", 2.0);
        Book book2 = new Book("Robert Martin", "Clean Code", 1.0);
        Book book3 = new Book("Kent Beck", "Test Driven Development", 0.5);

        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);

        Box box1 = new Box(4);
        box1.add(book1);
        box1.add(book2);
        System.out.println(box1);
        
        Box box2 = new Box(8);
        box2.add(box1);
        box2.add(box1);
        System.out.println(box2);
        
        Box box3 = new Box(8);
        box3.add(book1);
        box3.add(book2);
        box3.add(box3);
        System.out.println(box3);

    }
}
