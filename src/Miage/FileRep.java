package Miage;
import java.io.*;

public class FileRep {
	
	 static String[] list;
	
	public FileRep(String a) {
		File repert = new File(a);
		list = repert.list();
	}

	public String[] list() {
		return list;
	}
	
	public static void main(String[] args) {
		
		FileRep a = new FileRep(".");
		 if (list != null) {         
	            for (int i = 0; i < list.length; i++) {
	                System.out.println(list[i]);
	            }
	        
	}

	}}
