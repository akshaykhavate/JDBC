package com.akshaytech.application.module3;

public class Runner {

	public static void main(String[] args) {
		System.out.println("start");
		TransactionDemo t1 = new TransactionDemo();
		System.out.println(t1);
		t1.transac1();
		/*TranDemo t2 = new TranDemo();
		System.out.println(t2);
		t2.transac2();*/
		System.out.println("end");
	}
}
