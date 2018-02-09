package com.jspiders.main;

import java.util.Scanner;

import com.jspiders.bean.UserBean;
import com.jspiders.jdbc.UserDAO;

public class UserMain {
	public static void main(String[] args) {
		System.out.println("start");
		UserDAO ud=new UserDAO();
		UserBean ub=new UserBean();
		Scanner sc=new Scanner(System.in);

		System.out.println("enter user-name");
		ub.setName(sc.next());

		System.out.println("enter user-age");
		ub.setId(sc.nextInt());

		System.out.println("enter user-email");
		ub.setEmail(sc.next());

		System.out.println("enter user-mobile");
		ub.setMobile(sc.next());

		String n=ub.getName();
		int i=ub.getId();
		String e=ub.getEmail();
		String p=ub.getMobile();

		ud.addUser(n, i, e, p);
		System.out.println("end");
		sc.close();
	}
}
