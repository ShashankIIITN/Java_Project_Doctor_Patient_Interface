package com.mycompany.oopsproject;

import java.io.*;

public class Reader {
    public static String[][] BuildDoc(String SearchString) throws Exception {
        String[][] DocString = new String[5][5];
        String[][] DocStringDemo = new String[][] {
            { "Demo Doc", "Brain", "9874563210", "demodoc@gmail.com", "4" },
            { "Demo Doc2", "Bones", "9685743216", "demdo@gmail.com", "0" }
    };
        int m = -1;
        int n=0;
        BufferedReader rfile = new BufferedReader(new FileReader("D:\\My Projects\\NetBeansProjects\\OOpsProject\\src\\main\\java\\com\\mycompany\\oopsproject\\Doctors.txt"));
                String old_disease = SearchString;
                String line;
                int count = 0;
                int doctor_count = 0;
        while ((line = rfile.readLine()) != null) {
            if (old_disease.equalsIgnoreCase(line) || line.toLowerCase().contains(old_disease.toLowerCase())) {
                count++;
                for (int i = 1; i < 2; i++) {
                    line = rfile.readLine();
                    m++;
                    n=0;
                    String word = "";
                    for (int j = 0; j < line.length(); j++) {
                        if (line.charAt(j) != ',') {
                           word = word + line.charAt(j);
                        }else {
                            DocString[m][n] = word; 
                            //System.out.println(":::::"+word+"::::");
                            n++; 
                           word = "";
                        }
                    }
                }
            }
        }
        if (count > 0){
            return DocString;
        }else return DocStringDemo;
    }
    public static void main(String[] args) {
        try {
            String[][] Build = BuildDoc("cold");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Build[i][j]);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
