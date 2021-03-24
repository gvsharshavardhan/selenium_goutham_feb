package collections;

public class Employee implements Comparable {

	String name;
	int rollnum;

	Employee(String name, int rollnum) {
		this.name = name;
		this.rollnum = rollnum;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if (this.rollnum > ((Employee) arg0).rollnum) {
			return 1;
		} else if (this.rollnum < ((Employee) arg0).rollnum) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" : "+this.rollnum;
	}

}
