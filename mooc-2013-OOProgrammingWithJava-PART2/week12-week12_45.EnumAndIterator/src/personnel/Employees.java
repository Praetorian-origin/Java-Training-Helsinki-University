/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author praetorian
 */
public class Employees {

    private List<Person> persons;

    public Employees() {
        persons = new ArrayList<Person>();
    }

    public void add(Person person) {
        persons.add(person);
    }

    public void add(List<Person> persons) {
        this.persons.addAll(persons);
    }

    public void print() {
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person);
        }

    }

    public void print(Education education) {
        Iterator<Person> iterator = persons.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = persons.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation() == education) {
                iterator.remove();
            }
        }
    }

}
