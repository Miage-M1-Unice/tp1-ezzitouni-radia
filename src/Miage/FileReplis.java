/**
 * @author utilisateur
 */
package Miage;

import java.io.File;
import java.util.Arrays;

public class FileReplis {
	 
		private File fichier;
		
		
		public FileReplis(File l) {
			this.fichier = l;
		
		}
		
		
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
	 	
		public static void main(String[] args) 
		{
			File f = new File(".");
			
			FileReplis rep = new FileReplis(f);
			
			rep.parcoursProfondeur(f);
		
		}

		

}
