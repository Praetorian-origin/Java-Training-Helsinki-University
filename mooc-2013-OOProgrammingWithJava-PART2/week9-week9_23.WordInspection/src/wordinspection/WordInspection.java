/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author praetorian
 */
public class WordInspection {

    private File file;

    public WordInspection(File file) {
        this.file = file;
    }

    public int wordCount() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        int wordCount = 0;
        while (reader.hasNext()) {
            reader.next();
            wordCount++;
        }
        return wordCount;
    }

    public List<String> wordsContainingZ() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");

        while (reader.hasNext()) {
            String word = reader.next();
            if (word.contains("z")) {
                words.add(word);
            }

        }
        return words;
    }

    public List<String> wordsEndingInL() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");
        while (reader.hasNext()) {
            String word = reader.next();
            if (word.endsWith("l")) {
                words.add(word);
            }

        }
        return words;
    }

    public List<String> palindromes() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");
        while (reader.hasNext()) {
            String word = reader.next();
            int j = word.length() - 1;
            boolean palindrome = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != word.charAt(j)) {
                    palindrome = false;
                }
                j--;
            }

            if (palindrome) {
                words.add(word);
            }

        }
        return words;

    }

    public List<String> wordsWhichContainAllVowels() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(file, "UTF-8");

        String vowels = "aeiouyäö";
        char[] vowelsArray = vowels.toCharArray();

        while (reader.hasNext()) {
            String word = reader.next();
            boolean has_vowels = true;
            for (int i = 0; i < vowels.length(); i++) {
                if (!word.contains(String.valueOf(vowels.charAt(i)))) {
                    has_vowels = false;
                }

            }
            if (has_vowels) {
                words.add(word);
            }

        }
        return words;

    }

}
