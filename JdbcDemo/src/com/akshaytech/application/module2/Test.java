package com.akshaytech.application.module2;

import com.akshaytech.application.module2.SingleTonCon;

public class Test {
	public static void main(String[] args) {
		SingleTonCon s1 = SingleTonCon.getsingle();
		SingleTonCon s2 = SingleTonCon.getsingle();
		SingleTonCon s3 = SingleTonCon.getsingle();
		SingleTonCon s4 = SingleTonCon.getsingle();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
