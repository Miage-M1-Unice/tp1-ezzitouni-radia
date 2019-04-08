package MiageTp3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader{
	
	private ArrayList<File> path = new ArrayList<File>();

	public MyClassLoader(ArrayList<File> p) {  
		this.path = p;  
	}
	
	 protected Class<?> findClass(String name) throws ClassNotFoundException {  
		   byte[] b = loadClassData(name);  
		   return super.defineClass(name, b, 0, b.length);
		 } 
	
	 private byte[] loadClassData(String name) throws ClassNotFoundException {  
	
		 
		 for (File unPath : path) {
				if(unPath.isDirectory()) {

					String cheminRecherche = unPath.getAbsolutePath() ;
					
					File fichierRechercher = new File(cheminRecherche);

					if (fichierRechercher.exists()) {

						System.out.println(fichierRechercher);
						Path path = Paths.get(fichierRechercher.getAbsolutePath());
						try {
							return Files.readAllBytes(path);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}}}
		  return null; 
		 }
	 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  ArrayList<File> al = new ArrayList<File>();  
		 
		  MyClassLoader myCL = new MyClassLoader(al);
		   al.add(new File("C:\\Users\\utilisateur\\eclipse-workspace\\TP1\\src\\")); 
		 
		  try {  
		    myCL.loadClass("MiageTp3.MyClassLoader"); 
		  } catch (ClassNotFoundException e) {  
		   e.printStackTrace();  
		   } 

	}

}
