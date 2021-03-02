package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListTestDemo {
	public static void main(String[] args) {

		Integer[] marks = { 56, 78, 90 };

		List<Integer> ages = List.of(10, 20, 30, 40, 50, 60, 70);
		List<Integer> ages2 = new ArrayList<Integer>();
		ages2.add(700);
		ages2.add(800);
		ages2.add(900);

		List<Integer> listMarks = Arrays.asList(marks);
		System.out.println(ages2);
		ages2.addAll(ages);
		System.out.println(ages2);
		ListIterator<Integer> itr = ages2.listIterator();
		while(itr.hasNext()) {	
				System.out.printf("%d : %d",itr.next(),itr.nextIndex());
//				System.out.printf("\n%d : %d",itr.previous(),itr.previousIndex());
				System.out.println("***************************");
		}
		System.out.printf("%d : %d",itr.next(),itr.nextIndex());
	}

}
