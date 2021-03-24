package calender_demo;

public abstract class CalenderDemo {
	
//	static CalenderDemo cd;

	static CalenderDemo getInstance(){
		return null;
	}
	
	abstract void run();
	
	static void walk() {
		System.out.println("walking !!!");
	}
}
