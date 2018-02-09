package com.jspiders.demoapp;

public class ClassTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.jspiders.demo.Fish");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class not loaded");
		}
	}
}
