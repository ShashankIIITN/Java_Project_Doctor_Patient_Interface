package com.mycompany.oopsproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SearchSeparate {
    public static int SearchSep(String Email) throws Exception {

        String path = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Doctors.txt";
        String pathnew = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Doctorsnew.txt";
        File file = new File(path);
        File file2 = new File(pathnew);

        FileWriter fw = new FileWriter(file2);
        PrintWriter pw = new PrintWriter(fw);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[][] sarr = new String[1][5];
        String word = "";
        while((line = br.readLine()) != null){
            int n = 0;
            if(line.contains(Email))
            {
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i)!=',')
                    {
                        word = word + line.charAt(i);
                    }else{
                       sarr[0][n] = word;
                         n++; word = "";
                    } 
                }
                break;
            }
        }
        pw.close();
        br.close();
        return Integer.parseInt(sarr[0][4]);
    }
    public static void main(String[] args) {
        try {
            System.out.println(SearchSep("R@gmail.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
