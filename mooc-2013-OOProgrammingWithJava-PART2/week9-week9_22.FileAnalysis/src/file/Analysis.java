/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author praetorian
 */
public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(file);
        int lines = 0;

        while (reader.hasNextLine()) {
            lines++;
            reader.nextLine();
        }
        reader.close();
        return lines;
    }

    public int characters() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        int characters = 0;
        while (reader.hasNextLine()) {
     
            characters += reader.nextLine().length() + 1;
        }
        return characters;

    }

}
