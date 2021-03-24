package collections;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {	
		Vector v = new Vector(5,5);
		System.out.println(v.capacity());
		System.out.println(v.size());
		System.out.println("*************");
		v.addElement(10);
		v.add(20);
		v.add(30);
		v.add(40);
		v.add(50);
		v.add(60);
		v.add(70);
		v.add(80);
		v.add(90);
		v.add(100);
		v.add(110);	
		Enumeration en = v.elements();
		while(en.hasMoreElements()) {
			System.out.println((Integer)en.nextElement()+1);
		}	
	}
}
