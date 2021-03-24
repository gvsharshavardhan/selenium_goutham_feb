package collections;

import java.util.Random;

public class Temp {
	Random rand = new Random();

	@Override
	public String toString() {
//		return String.valueOf(rand.nextInt(100));
		return "random";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("i am finalize method");
	}

}
