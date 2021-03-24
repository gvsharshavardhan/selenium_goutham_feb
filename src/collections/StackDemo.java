package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class StackDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee("harsha", 110);
		Employee e2 = new Employee("vineeth", 30);
		Employee e3 = new Employee("goutham", 70);
		
		TreeSet ts = new TreeSet(new VinGouCom());
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		
		System.out.println(ts);
	}

}
