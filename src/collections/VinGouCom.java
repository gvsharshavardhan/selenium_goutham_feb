package collections;

import java.util.Comparator;

public class VinGouCom implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee i1 = (Employee)arg0;
		Employee i2 = (Employee)arg1;
		return i1.name.compareTo(i2.name);		
	}

}
