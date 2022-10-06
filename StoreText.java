// Write a Java program to store text file content line by line into an array

package com.file_handling.bll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StoreText {
	
    public static void main(String a[]){
    	
	//creating a stringBuilder object 
        StringBuilder sb = new StringBuilder(); 
        String strLine = "";
        
	//creating an array list
        List<String> list = new ArrayList<String>();
        
        
        try {
             BufferedReader br = new BufferedReader(new FileReader("D:\\names.txt"));
              while (strLine != null)
               { 
                strLine = br.readLine();   
                sb.append(strLine); 
                sb.append(System.lineSeparator());
                strLine = br.readLine();  //reading the line
                if (strLine==null)
                   break;
                list.add(strLine);
            }
         System.out.println(Arrays.toString(list.toArray())); // printing the list
             br.close();
        } 
	    
	catch (FileNotFoundException e) { //catching FileNotFound Exception 
            System.err.println("File not found");
        } 
	    
	catch (IOException e) { //catching IO Exception
            System.err.println("Unable to read the file.");
        }
     }

}
