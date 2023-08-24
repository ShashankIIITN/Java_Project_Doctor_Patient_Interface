package com.mycompany.oopsproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Updatedata {
    public static void Updater(String Email, String old, String newint) throws Exception {

        String path = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Doctors.txt";
        String pathnew = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Doctorsnew.txt";
        File file = new File(path);
        File file2 = new File(pathnew);

        FileWriter fw = new FileWriter(file2);
        PrintWriter pw = new PrintWriter(fw);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            if(line.contains(Email))
            {
                line = line.replace(old, newint);
                pw.println(line);
            }else if(!line.equalsIgnoreCase("") && !line.equalsIgnoreCase(" ")){
                pw.println(line);

            }
        }
        pw.close();
        br.close();
        
        FileWriter fwn = new FileWriter(file);
        PrintWriter pwn = new PrintWriter(fwn);
        FileReader frn = new FileReader(file2);
        BufferedReader brn = new BufferedReader(frn);
        while((line = brn.readLine()) != null){
                
            if(!line.equalsIgnoreCase("") && !line.equalsIgnoreCase(" ")){
                pwn.println(line);

            }
        }
        pwn.close();
        brn.close();
    }
    public static void main(String[] args) {
        try {
            Updater(args[0], args[1], args[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
