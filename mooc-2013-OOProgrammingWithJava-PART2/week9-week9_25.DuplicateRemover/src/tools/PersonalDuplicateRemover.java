/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author praetorian
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private int amountDuplicates;
    private Set<String> words;

    public PersonalDuplicateRemover() {
        amountDuplicates = 0;
        words = new HashSet<String>();
    }
    
    

    @Override
    public void add(String characterString) {
       if (words.add(characterString) == false) {
           amountDuplicates++;
       } 
       
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return amountDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
    }

    @Override
    public void empty() {
        amountDuplicates = 0;
       words.clear();
    }
}
