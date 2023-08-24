package com.mycompany.oopsproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RecieptGen {
   static void Printreciept(String Doctorname,String Doctoremail,String PatientsName,String PatientsEmail, String PatientsPhone,String AppointmentID,String Date_of_booking,String Time_of_booking){

        try{
        File obj1 = new File("Reciept.txt");
     
        FileWriter obj2 = new FileWriter(obj1);
        obj2.write("""
                    --------------------------------------------------------------
            -------------- Congratulations ,Your appointment has been booked ---------------
                    --------------------------------------------------------------
            """);
            obj2.write("Appointment ID is"+" "+ AppointmentID+"\n");
        obj2.write("Your Doctor name is" + " " + Doctorname +"\n" );
        obj2.write("Doctoremail is" +" "+ Doctoremail+"\n");
        obj2.write("Patient Name is"+" "+ PatientsName+"\n");
        obj2.write("Patient Email is"+" "+ PatientsEmail+"\n");
        obj2.write("Patient Phone is"+" "+ PatientsPhone+"\n");
        obj2.write("Your Date_of_booking is"+" "+ Date_of_booking+"\n");
        obj2.write("Your Time_of_booking is"+ " "+Time_of_booking+"\n");
        obj2.write("Your Doctor fees is"+ " " + 5500 + "\n");
        obj2.write("-------------------- BILL RECEIPT ----------------------");
        obj2.write("--------------------------------------------------------");
        obj2.write("\nTotal Services And its Cost :\n");
        obj2.write(" GST Amount ="+ " "+ (0.18)*5500 + "\n");
        obj2.write("Grand Total Bill  Rs."+ " " + (5500+ (0.18)*5500)+"\n");
        obj2.write("--------------------------------------------------------");
    
    obj2.close();
    }
       catch(IOException exception)
       {
         exception.printStackTrace();
       }


     
    }
}