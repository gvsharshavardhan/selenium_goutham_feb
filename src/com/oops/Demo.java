package com.oops;

public class Demo {


	static int count = 0 ;
	int inst_count = 0;
	Demo(){
		count++;
		inst_count++;
	}

	public static void main(String[] args) {
		
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		Demo d3 = new Demo();
		Demo d4 = new Demo();
		Demo d5 = new Demo();
		Demo d6 = new Demo();
		
		System.out.println(count);
		System.out.println(d6.inst_count);

	}

}
