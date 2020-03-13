/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author praetorian
 */
public class MindfulDictionary {

    private Map<String, String> translations;
    private String file;
    private File filef;

    public MindfulDictionary() {
        this.translations = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.translations = new HashMap<String, String>();
        this.file = file;
    }

    public boolean load() {
        try {
            filef = new File(file);
            Scanner reader = new Scanner(filef);
            while (reader.hasNextLine()) {

                String line = reader.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
            return true;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean save() {
        try {
            
            FileWriter fileWriter = new FileWriter(file);
            for (String key : translations.keySet()) {
                fileWriter.write(key + ':' + translations.get(key) + "\n");
            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void add(String word, String translation) {
        if (translations.containsKey(word)) {
            return;
        }
        translations.put(word, translation);
    }

    public String translate(String word) {

        if (translations.containsKey(word)) {
            return translations.get(word);
        } else {
            for (String key : translations.keySet()) {
                if (translations.get(key).equals(word)) {
                    return key;
                }
            }
        }
        return null;

    }

    public void remove(String word) {

        ArrayList<String> toBeRemoved = new ArrayList<String>();
        translations.remove(word);
        for (String key : translations.keySet()) {
            if (translations.get(key).equals(word)) {
                toBeRemoved.add(key);
            }
        }

        for (String toremove : toBeRemoved) {
            translations.remove(toremove);
        }

    }

}
