/**
 * @author utilisateur
 */
package Miage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileReplis {
	 
		private File fichier;
		
		
		public FileReplis(File l) {
			this.fichier = l;
		
		}
		/*******************************************QUESTION 2****************************************************************/
		
		/**
		 * 
		 * @param f
		 */
		public void parcoursProfondeur(File f) {
			// creation d un tableau de fichier qui reçoit tous les fichier du parametre f
			File[] tab = f.listFiles();
			
			for(int i =0; i< tab.length; i++) {
				
				if(tab[i].isDirectory()) {//tester si l'element à la position i du tableau  est un repertoire 
					System.out.println("*********[repertoire]==> " +tab[i]);
					parcoursProfondeur(tab[i]);// appliquer la meme methode(appel récursif) sur les sous repertoire de ce repertoire
				}else
					
					System.out.println("[fichier]==> " +tab[i]);
			}
			
		}
		/*********************************************QUESTION3**************************************************************/
		public class FiltreInterne implements FilenameFilter{
	 		private  String extension;
	 		
	 		public FiltreInterne(String ext) {
	 			this.extension= ext.toLowerCase();
	 		}
	 		
	 	
			@Override
			public boolean accept(File dir, String name) {
				 
				return name.toLowerCase().endsWith(extension);
			}
	 		
	 	}
				
		public void trouverfichier(String chemin, String ext) {
 			File fich = new File(chemin);
 			
 			File[] liste = fich.listFiles(new FiltreInterne(ext));
 			
 			if(liste.length == 0) {
 				System.out.println(chemin+ "n'a aucun fichier avec l extension "+ext);
 			}else {
 				System.out.println("\"les/le fichier(s) avec l extension"+ext+ ": ");
 				for(int i=0; i<liste.length; i++) {
 					System.out.println( liste[i].getName());
 				}
 			}
 		}
		
		public void trouverfichierEXT(String chemin, String ext) {
 			File fich = new File(chemin);
 			
 			File[] liste = fich.listFiles(new FiltreExterne(ext));
 			
 			if(liste.length == 0) {
 				System.out.println(chemin+ "n'a aucun fichier avec l extension "+ext);
 			}else {
 				System.out.println("\"les/le fichier(s) avec l extension"+ext+ ": ");
 				for(int i=0; i<liste.length; i++) {
 					System.out.println( liste[i].getName());
 				}
 			}
 		}
		

		public void trouverfichierAnonym(String chemin, String ext) {
 			File fich = new File(chemin);
 			
 			File[] liste = fich.listFiles(new FilenameFilter() {
 				
				@Override
				public boolean accept(File arg0, String arg1) {
					// TODO Auto-generated method stub
					return arg1.toLowerCase().endsWith(ext);
				}
			});
 			
 			if(liste.length == 0) {
 				System.out.println(chemin+ "n'a aucun fichier avec l extension "+ext);
 			}else {
 				System.out.println("\"les/le fichier(s) avec l extension"+ext+ ": ");
 				for(int i=0; i<liste.length; i++) {
 					System.out.println( liste[i].getName());
 				}
 			}
 		}
		
		
		
		/***********************************************************************************************************/
		public static void main(String[] args) 
		{
			File f = new File(".");
			
			FileReplis rep = new FileReplis(f);
			
			//rep.parcoursProfondeur(f);
			
			/****************************Implementation de la question 3 interne *************************************/
			
			//rep.trouverfichier("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage", ".java");
			
			/****************************Implementation de la question 3 externe*************************************/
			
			// rep.trouverfichierEXT("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage", ".java");
			
			/****************************Implementation de la question 3 Anonyme*************************************/

			// rep.trouverfichierAnonym("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage", ".java");
			
			
			/******************************************EXO1-partieB*********************************************/
			
			String dir = "C:\\Users\\utilisateur\\eclipse-workspace\\TP1";
			
			try {
				Files.walkFileTree(Paths.get(dir), new Exo1B());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

		

}


