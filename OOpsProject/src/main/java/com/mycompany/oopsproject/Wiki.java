package com.mycompany.oopsproject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import Jwiki.*;

public class Wiki {
   public static String[][] Searchwiki(String SearchString) throws Throwable
   {
    Jwiki jwiki = new Jwiki(SearchString); 
    String[][] Result = new String[1][4];
    Result[0][0] = jwiki.getDisplayTitle();
    Result[0][1] = jwiki.getExtractText();
    Result[0][2] = jwiki.getImageURL();
    Result[0][3] = jwiki.getImageURL();
    System.out.println("Title :"+jwiki.getDisplayTitle());
    System.out.println("Text : "+jwiki.getExtractText());  
    System.out.println("Image : "+jwiki.getImageURL());    

    URL url = new URL(Result[0][2]);
    InputStream in = new BufferedInputStream(url.openStream());
    OutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\My Projects\\NetBeansProjects\\OOpsProject\\target\\classes\\com\\mycompany\\oopsproject\\imageres.png"));
    Result[0][0] = Result[0][0].substring(Result[0][0].indexOf(">") + 1, Result[0][0].indexOf("</"));
    Result[0][3] = "D:\\My Projects\\NetBeansProjects\\OOpsProject\\target\\classes\\com\\mycompany\\oopsproject\\imageres.png";
    for ( int i; (i = in.read()) != -1; ) {
        out.write(i);
        }
    in.close();
    out.close();

    return Result;
   }

    public static void main(String[] args) {
        try {
            Searchwiki("fever");
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}