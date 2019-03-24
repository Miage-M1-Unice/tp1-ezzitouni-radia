package Miage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Selit2b {
	
	  void lecture(Scanner source) throws FileNotFoundException {  
		  
		  File fich = new File("fich.txt");
		  FileOutputStream fs = new FileOutputStream(fich);
		  PrintStream ps = new PrintStream(fs);
		  
	       while(source.hasNextLine()) {  
	    	   
	           String s = source.nextLine();
	           System.out.println(s); 
	           System.setOut(ps);
	        		              
	        
	       }  
	   } 

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		FileReader in = new FileReader(new File("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage\\Selit2b.java"));
		Scanner sc = new Scanner(in);
	
		 Selit2b seL = new Selit2b();
		 seL.lecture(sc);
	}

}
