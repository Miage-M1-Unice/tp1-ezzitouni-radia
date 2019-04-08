package MiageTp3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		URL url = new URL("file://C:\\Users\\utilisateur\\eclipse-workspace\\jeupuis\\src");
		
		URL[] urls = {url};
				
			
		URLClassLoader cl = new URLClassLoader(urls);
		Class c = cl.loadClass("jeupuis.Jeu.java");

		System.out.println("class "+c.getName());
		
		//System.out.println("HIIIIIIIIIIIIIIII");

}
		

	}



