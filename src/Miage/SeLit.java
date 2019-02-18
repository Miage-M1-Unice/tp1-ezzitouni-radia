package Miage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import org.xml.sax.ext.LexicalHandler;

public class SeLit {  
	   void lecture(Scanner source) {  
	  
	       while(source.hasNextLine()) {  
	           String s = source.nextLine();
	           if(!s.trim().startsWith("//")) {	   
		           System.out.println(s); 
	        		   }	           
	           // A modifier  
	       }  
	   }  
	  
	   static public void main(String[] args) {   
	      // A compléter 
		   try {
			InputStream in = new FileInputStream(new File("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage\\SeLit.java"));
			Scanner sc = new Scanner(in);
			SeLit seL = new SeLit();
			seL.lecture(sc);
		   } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }  
	}  
