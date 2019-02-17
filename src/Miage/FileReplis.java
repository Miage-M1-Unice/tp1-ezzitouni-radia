/**
 * @author utilisateur
 */
package Miage;

import java.io.File;
import java.io.FilenameFilter;
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
			// creation d un tableau de fichier qui re�oit tous les fichier du parametre f
			File[] tab = f.listFiles();
			
			for(int i =0; i< tab.length; i++) {
				
				if(tab[i].isDirectory()) {//tester si l'element � la position i du tableau  est un repertoire 
					System.out.println("*********[repertoire]==> " +tab[i]);
					parcoursProfondeur(tab[i]);// appliquer la meme methode(appel r�cursif) sur les sous repertoire de ce repertoire
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
 			
 			/*if(!fich.exists()) 
 				System.out.println(chemin+ "le chemin n existe pas");*/
 			
 			
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
		
		
		
		/***********************************************************************************************************/
		public static void main(String[] args) 
		{
			File f = new File(".");
			
			FileReplis rep = new FileReplis(f);
			
			//rep.parcoursProfondeur(f);
			/****************************Implementation de la question 3*************************************/
			
			//rep.trouverfichier("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\Miage", ".java");
			rep.trouverfichier(".", ".java");
		}

		

}


