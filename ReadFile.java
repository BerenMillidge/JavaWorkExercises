/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaWorkExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beren
 */
public class ReadFile {
    private String path;


 public  ReadFile(String file_path) {
        path = file_path;
    }
    
    public String[] OpenFile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        int numberOfLines =readLines();
        String[] textData = new String[numberOfLines];
        //Now the loop to add the lines to the array.
        int i;
        for (i=0; i < numberOfLines; i++)
        {
            textData[i] = textReader.readLine();
        }
        textReader.close();
        return textData;  
    }
    public int readLines() throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String aLine;
        int numberOfLines = 0;
        while ((aLine = br.readLine()) != null)
        {
            numberOfLines++;
        }
        br.close();
        return numberOfLines;
    }
}

