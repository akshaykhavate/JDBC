package org.akshay.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Connection con = null;
		Scanner s = new Scanner(System.in);
		int m ;
		con = SingleTonCon.getSingle().getConnection();
		do{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice\n 1:for insertion\n 2: for update\n 3:for delete\n 4:for select \n 5:for getuser");
		int n = sc.nextInt();
		UserDao ud = new UserDaoImpl();
		UserBean ub = new UserBean();
				
		switch (n) {
		case 1:System.out.println("Enter the name");;
				String a = sc.next();
				System.out.println("Enter the age");
				int b = sc.nextInt();
				System.out.println("Enter the Email");
				String c = sc.next();
				System.out.println("Enter the phone number");
				String d = sc.next();
				ub.setName(a);
				ub.setAge(b);
				ub.setEmail(c);
				ub.setPhone(d);
				ud.insert(ub);
				break;
		case 2:System.out.println("enter what you want to update");
				String x = sc.next();
				ub.setName(x);
				System.out.println("Enter the age");
				int y = sc.nextInt();
				ub.setAge(y);
				System.out.println("Enter the mail id");
				String z = sc.next();
				ub.setEmail(z);
				System.out.println("Enter the Phone number");
				String p = sc.next();
				ub.setPhone(p);
				ud.update(ub);
				break;
		case 3:System.out.println("enter the name you want to delete");
				String name = sc.next();
				ub.setName(name);
				ud.delete(ub);
				break;
		case 4:System.out.println("Select the name of user which you want to display");
				String name1 = sc.next();
				ub.setName(name1);
				ud.select(ub);
				break;
		case 5:System.out.println("The users are");
				ud.getuser(ub);
				break;
		default:System.out.println("Invalid option selected");
				break;
		}
		System.out.println("press 1 to continue");
		m = s.nextInt();
		}while(m==1);
		
	}
}
