/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaWorkExercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Beren
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<String> fileLocs = new ArrayList<>();
        // HERE IS RANDOM CHANGE FOR GITHUB!!!!!!!! LETS SEE IF WE CAN GET THIS INTO THINGS (WE CAN'T!)
        
        
        // Test 2 to see if it works again.
//        fileLocs.add("C:\\Users\\Beren\\Desktop\\Java tasks\\file1.txt");//optional!
//        fileLocs.add("C:\\Users\\Beren\\Desktop\\Java tasks\\file2.txt");//optional!
//        fileLocs.add("C:\\Users\\Beren\\Desktop\\Java tasks\\file3.txt");//optional!
        String backupFolder = "C:\\Users\\Beren\\Desktop\\Java tasks";
        int numberOfFiles = 3;
        if (fileLocs.size() < numberOfFiles) {
            addFromDefault(backupFolder,fileLocs,numberOfFiles);
        }
        String write_file_name = "C:\\Users\\Beren\\Desktop\\Java tasks\\result_file.txt";
        List<String> Masterlist = new ArrayList<>();
        for (int a = 0; a < fileLocs.size(); a++) {
            ReadFile file = new ReadFile(fileLocs.get(a));
            String Afile[] = file.OpenFile();
            List<String> lfile = fileConvertToString(Afile);
            Masterlist.addAll(lfile);
        }
        List<String> IDslist = new ArrayList<>();
        Map personMap = new HashMap();
        String[] s = Masterlist.toString().split("[,:;]");
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(" ID") || i == 65) {
                String ID = tempList.get(1);
                if (IDslist.contains(ID) == false) {
                    IDslist.add(ID);
                    Person p = new Person();
                    p.setID(ID);
                    personMap.put(ID, p);
                }
                for (int l = 0; l < tempList.size(); l++) {
                    Person x = (Person) personMap.get(ID);
                    if (tempList.get(l).equals(" Name")) {
                        x.setName(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Job Title")) {
                        x.setJob_title(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Height")) {
                        x.setHeight(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Hair Colour")) {
                        x.setHair_Colour(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Eye Colour")) {
                        x.setEye_Colour(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Gender")) {
                        x.setGender(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" DOB")) {
                        x.setDOB(tempList.get(l + 1));
                    }
                    if (tempList.get(l).equals(" Phone Number")) {
                        x.setPhone_number(tempList.get(l + 1));
                       
                    }
                }
                tempList.clear();
            }
            tempList.add(s[i]);
        }
//        updateAll(personMap, "Name", "Blibble", IDslist);
//        update(personMap, " 012", "Hair Colour", "Stygian Blue");
        writeInfoToFile(personMap, IDslist, write_file_name, true);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + i);
        }
        if (args.length < 1)
        {
            System.out.println("No input! Are you sure???");
        }
        else if (args[0].equals("updateall"))
        {
            updateAll(personMap, args[1], args[2],IDslist);
            System.out.println("Updated.");
        }
        else if (args[0].equals("update"))
        {
            update(personMap, args[1],args[2],args[3]);
            System.out.println("Updated.");
        }
        else if (args[0].equals("Write to file"))
        {
            if (args[1].equals("default"))
            {
                writeInfoToFile(personMap,IDslist,write_file_name, false);
            }
            else {
            writeInfoToFile(personMap, IDslist, args[1], false);
            }
        }
        else if (args[0].equals("Write to file verbose"))
        {
            if (args[1].equals("default"))
            {
                writeInfoToFile(personMap,IDslist,write_file_name, true);
            }
            else {
            writeInfoToFile(personMap, IDslist, args[1], true);
            }
        }
        else if (args[0].equals("Add file"))
        {
            getAddFiles(args[1], fileLocs, numberOfFiles);
        }
        else if (args[0].equals("Add files from default"))
        {
            addFromDefault(args[1], fileLocs,numberOfFiles);
        }
//        else System.out.println("You typed incorrectly.");
        
    }

    public static List<String> fileConvertToString(String[] file) {
        List<String> Filelist = new ArrayList<>();
        for (int i = 0; i < file.length; i++) {
            Filelist.add(file[i]);
        }
        return Filelist;
    }

    public static void checkIDList(String ID, List<String> IDlist, List<Person> PersonList) {
        if (IDlist.size() == 0) {
            IDlist.add(ID);
        }
        for (int i = 0; i < IDlist.size(); i++) {
            if (ID.equals(IDlist.get(i)) == false) {
                IDlist.add(ID);
                Person p = new Person();
                p.setID(ID);
                PersonList.add(p);
            }
        }
    }

    public static void update(Map personMap, String ID, String attribute, String update) {

        Person x = (Person) personMap.get(ID);
        if (attribute.equals("Name")) {
            x.setName(update);
        }
        else if (attribute.equals("Job Title")) {
            x.setJob_title(update);
        }
        else if (attribute.equals("Date of Birth")) {
            x.setDOB(update);
        }
        else if (attribute.equals("Gender")) {
            x.setGender(update);
        }
        else if (attribute.equals("Phone Number")) {
            x.setPhone_number(update);
        }
        else if (attribute.equals("Height")) {
            x.setHeight(update);
        }
        else if (attribute.equals("Hair Colour")) {
            x.setHair_Colour(update);
        }
        else if (attribute.equals("Eye Colour")) {
            x.setEye_Colour(update);
        }
        else {System.out.println("The attribute specified does not exist. Please try again.");}
    }

    public static void updateAll(Map personMap, String attribute, String update, List IDlist) {
        for (int i = 0; i < personMap.size(); i++) {
            Person x = (Person) personMap.get(IDlist.get(i));
            if (attribute.equals("Name")) {
                x.setName(update);
            }
            else if (attribute.equals("Job Title")) {
                x.setJob_title(update);
            }
            else if (attribute.equals("Date of Birth")) {
                x.setDOB(update);
            }
            else if (attribute.equals("Gender")) {
                x.setGender(update);
            }
            else if (attribute.equals("Phone Number")) {
                x.setPhone_number(update);
            }
            else if (attribute.equals("Height")) {
                x.setHeight(update);
            }
            else if (attribute.equals("Hair Colour")) {
                x.setHair_Colour(update);
            }
            else if (attribute.equals("Eye Colour")) {
                x.setEye_Colour(update);
            }
            else {System.out.println("Update failed. The attribute desired was incorrectly specified.");}
        }
    }

    public static void writeToFile(String content, String file_name) throws IOException {
        File result = new File(file_name);
        if (!result.exists()) {
            result.createNewFile();
        }
        FileWriter fw = new FileWriter(result.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

    public static void fileClear(String file_name) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file_name);
        pw.print("");
        pw.close();
    }

    public static void writeInfoToFile(Map personMap, List IDlist, String file_name, boolean verbose) throws FileNotFoundException, IOException {
        for (int m = 0; m < IDlist.size(); m++) {
            Person x = (Person) personMap.get(IDlist.get(m));
            String persondata = "Name:" + x.getName() + " ID:" + x.getID() + " Job Title:" + x.getJob_title() + " Date of Birth:" + x.getDOB() + " Gender:" + x.getGender() + " Phone Number:" + x.getPhone_number() + " Height" + x.getHeight() + " Hair Colour: " + x.getHair_Colour() + " Eye Colour: " + x.getEye_Colour() + System.lineSeparator() + System.lineSeparator();
            if (m == 0) {
                fileClear(file_name);
            }
            writeToFile(persondata, file_name);
            if (verbose == true) {
                System.out.println(persondata);
            } else {
                System.out.println("Written!");
            }
        }
    }
    public static void getAddFiles (String fileName, List<String> fileLocs, int numberOfFiles)
    {
        if (fileLocs.size() < numberOfFiles)
        {
            fileLocs.add(fileName);
        }
        else {System.out.println("You've already got as many files as need.");}
    }
    public static void addFromDefault(String backupFolder, List fileLocs, int numberOfFiles) {
        File f = new File(backupFolder);
            List<String> nameList = new ArrayList<String>(Arrays.asList(f.list()));
            for (int b = 0; b < numberOfFiles; b++) {
                if (fileLocs.contains(backupFolder + "\\" + nameList.get(b)) == false) {
                    fileLocs.add(backupFolder + "\\" + nameList.get(b));
                }
            }
    }
}

