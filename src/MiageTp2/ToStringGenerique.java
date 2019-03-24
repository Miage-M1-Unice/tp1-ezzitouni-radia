package MiageTp2;

import java.awt.Point;
import java.awt.Polygon;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ToStringGenerique {
	
	
	public String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {
		
		String res = "";
		
		
		if(obj != null) {
			
			Class cl = obj.getClass();
			Field[] fields = cl.getDeclaredFields();
			
			res += cl.getCanonicalName() + "[ ";
			for (int i = 0; i < fields.length; i++) {
					Object object;
				
					fields[i].setAccessible(true);
					object = fields[i].get(obj);
					res += fields[i].getName() + "=" + object + " ";
		
			}
				res += "]\n";

		}
		return res ;
		}
	
	
	//*****************************
	
	
	public String toString(Object obj, int prof) throws IllegalArgumentException, IllegalAccessException {

		String res = "";

		if(obj!=null) {
		if (prof > 0) {

			Class cl = obj.getClass();
			
			Set s = new HashSet();
			
			s.addAll(new ArrayList(Arrays.asList(cl.getFields())));
			s.addAll(new ArrayList(Arrays.asList(cl.getDeclaredFields())));

			ArrayList<Field> fields = new ArrayList(s);

			res += cl.getCanonicalName() + "[ ";

			for (int i = 0; i < fields.size(); i++) {
				fields.get(i).setAccessible(true);
				Object object;
			
				
					String a = "";

					if (fields.get(i).getType().isArray()) {

						int j = Array.getLength(fields.get(i).get(obj));
						a += fields.get(i).getName() + "={";

						for (int r = 0; r < j - 1; r++) {

							a += Array.get(fields.get(i).get(obj), r).toString() + ",";

						}

						a += Array.get(fields.get(i).get(obj), j - 1).toString() + "} ";

						res += a;
						System.out.println(res);

					} else if (fields.get(i).getType().isPrimitive()) {
						object = fields.get(i).get(obj);
						res += fields.get(i).getName() + "=" + object + " ";
						System.out.println(res);

					} else {
						System.out.println(res);

						res += "\n" + fields.get(i).getName() + "=" + toString(fields.get(i).get(obj), prof--);
					}

				
			}
			res += "]";
		}
		}
		return res;
	}
	
	
	
	
	// ******************
	
	 public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		 
	 
		System.out.println(new ToStringGenerique().toString(new Point(12,24)));
	
	  Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
	
	  pol.getBounds();  
	  System.out.println(new ToStringGenerique().toString(pol, 2));
	  
	 }
}
