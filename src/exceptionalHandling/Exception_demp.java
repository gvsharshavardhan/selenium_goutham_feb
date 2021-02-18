package exceptionalHandling;

import java.util.Scanner;

public class Exception_demp {

	public static void main(String[] args) {
		final Double bankBalance = 1000.0;

		try {
			int a = 10 / 0;
		} catch (ClassCastException e) {
			System.out.println(e);
		}
		finally {
			System.out.println("finally block");
		}
		System.out.println("bye!!");
	}
}
