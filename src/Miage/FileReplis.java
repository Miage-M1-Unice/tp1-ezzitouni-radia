package Miage;

import java.io.File;
import java.util.Arrays;

public class FileReplis {
	 
		public  File[] liste;
		
		public FileReplis(String a) {
			
			File repert = new File(a);
			liste = repert.listFiles();

		}
		
		 @Override
		public String toString() {
			return "FileReplis [liste=" + Arrays.toString(liste) + "]";
		}

		public File[] listFiles() {
			 return liste;
		 }

	 	
		public static void main(String[] args) {
			
			File a = new File(".");			
			 if (liste != null) {         
		            for (int i = 0; i < liste.length; i++) {
		                System.out.println(liste[i]);
		            }
		        
		}

		}

}
