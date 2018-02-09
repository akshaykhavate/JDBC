package com.jspiders.switchexp;

import java.util.Scanner;

public class User {
	public void read() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the typeoflight you want");
		String light = sc.next();
		ISwitch sw = LightFactory.getlight(light);
		sw.switchOn();
		sw.switchOff();
	}
}
