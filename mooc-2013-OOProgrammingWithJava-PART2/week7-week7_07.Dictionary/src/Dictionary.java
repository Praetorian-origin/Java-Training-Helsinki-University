
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author praetorian
 */
public class Dictionary {
    
    private HashMap<String, String> translations;
    
    public Dictionary () {
        translations = new HashMap<String, String>();
    }
    
    public void add(String word, String translation) {
        translations.put(word, translation);
    }
    
    public String translate(String word) {
        return translations.get(word);
    }
    
    public int amountOfWords() {
        return translations.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> words_translated = new ArrayList<String>();
        for (String key : translations.keySet()) {
            words_translated.add(key + " = " + translations.get(key));
        }
        return words_translated;
    }
}
