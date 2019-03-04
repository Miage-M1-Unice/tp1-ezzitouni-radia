package MiageTp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflexion {

		  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
		    // Récupération d'un objet de type Class correspondant au nom passé en paramètres
		  
			  Class cl = Class.forName(nomClasse);

		    afficheEnTeteClasse(cl);

		    System.out.println("Fields = ");
		    afficheAttributs(cl);

		    System.out.println("Constructors = ");
		    afficheConstructeurs(cl);

		    System.out.println("les methodes= ");
		    afficheMethodes(cl);

		    // L'accolade fermante de fin de classe !
		    System.out.println("}");
		  }


		  /** Retourne la classe dont le nom est passé en paramètre */
		  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
			  Class c= Class.forName(nomClasse);
			  return c;	  
		  }

		  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
		  public static void afficheEnTeteClasse(Class cl) {
		    //  Affichage du modifier et du nom de la classe
		 
//			  int i = cl.getModifiers();
//		     String modif = mod.toString(i);
//		     System.out.println(modif);
//		   
			 
			Object o = new Object();
			  System.out.println(o.getClass().getName());


		   // Récupération de la superclasse si elle existe (null si cl est le type Object)
			  
			  cl = cl.getSuperclass();
		      System.out.println("super class= " + cl.getName());

		  
		    // Affichage des interfaces que la classe implemente
		    
			  Class[] i = cl.getInterfaces();
		      System.out.println("Interfaces = " + Arrays.asList(i));
		    
		  
		  }

		  public static void afficheAttributs(Class cl) {
			  		
			  Field[] f = cl.getDeclaredFields();
		         for (int i = 0; i < f.length; i++) {
		            System.out.println(f[i]);
		         }
		  }

		  public static void afficheConstructeurs(Class cl) {

		         Constructor[] ct = cl.getDeclaredConstructors();
		         for(int i = 0; i < ct.length; i++) {
		            System.out.println( ct[i].toString());
		         }
		    }
		  
		  public static void afficheMethodes(Class cl) {
			 
			  Method[] m = cl.getDeclaredMethods();
		      for(int i = 0; i < m.length; i++) {
		         System.out.println(m[i].toString());
		      }
		    
		    }
		  

		  public static String litChaineAuClavier() throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      return br.readLine();
		  }

		  public static void main(String[] args) {
		    boolean ok = false;

		    while(!ok) {
		      try {
		        System.out.print("Entrez le nom d'une classe (ex : java.util.Date):");
		        String nomClasse = litChaineAuClavier();

		        analyseClasse(nomClasse);

		        ok = true;
		      } catch(ClassNotFoundException e) {
		        System.out.println("Classe non trouvée.");
		      }catch(IOException e) {
		        System.out.println("Erreur d'E/S!");
		      }
		    }
		  }
		

	
}
