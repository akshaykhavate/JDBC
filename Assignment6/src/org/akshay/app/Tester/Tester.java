package org.akshay.app.Tester;

import java.sql.Connection;
import java.util.Scanner;

import org.akshay.app.Bean.SingleTonCon;
import org.akshay.app.Bean.UserBean;
import org.akshay.app.Bean.UserDAO;
import org.akshay.app.Bean.UserDAOImpl;

public class Tester {

	public static void main(String[] args) {
		UserDAO udao = new UserDAOImpl();
		Connection con = null;
		con = SingleTonCon.getObject().getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user data");
		UserDAOImpl ud = new UserDAOImpl();
		UserBean ub = new UserBean();
		System.out.println("Enter the id");
		int x = sc.nextInt();
		System.out.println("Enter the name");
		String y = sc.next();
		System.out.println("Enter the age");
		int z = sc.nextInt();
		ub.setId(x);;
		ub.setName(y);
		ub.setAge(z);
		ud.addUser(ub);
	}
}
