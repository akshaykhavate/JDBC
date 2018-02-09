package com.akshayapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Demo {

	public static void main(String[] args) {
		Connection con = null;

		Scanner sc =new Scanner(System.in);

		System.out.println("Enter the senders ID");
		int senderId = sc.nextInt();

		System.out.println("Enter the reciever ID");
		int recieverId = sc.nextInt();

		System.out.println("Enter the amount to be transferred");
		double amt = sc.nextDouble();

		double s_bal=0.0;
		double r_bal=0.0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banktransac","root","root");
			Statement stmt = con.createStatement();

			//getting the sender balance
			ResultSet rs = stmt.executeQuery("select balance from customer where id="+senderId);
			if(rs.next()){
				s_bal = rs.getDouble(1);
				System.out.println(s_bal);
			}

			//getting the reciever balance
			ResultSet rs1 = stmt.executeQuery("select balance from customer where id="+recieverId);
			if(rs1.next()){
				r_bal = rs1.getDouble(1);
			}

			//transaction
			if(amt+1000<=s_bal){
				//calculating the updated balance
				double su_bal = s_bal-amt;
				double ru_bal = r_bal+amt;

				String u_sender = "update customer set balance="+su_bal+"where id="+senderId;
				String u_reciever = "update customer set balance="+ru_bal+"where id="+recieverId;	
				String t_sender = "insert into transaction values("+senderId+",'Success','debited',"+amt+")";	
				String t_reciever = "insert into transaction values("+recieverId+",'Success','credited',"+amt+")";

				stmt.addBatch(u_sender);
				stmt.addBatch(u_reciever);
				stmt.addBatch(t_sender);
				stmt.addBatch(t_reciever);

				int[] a = stmt.executeBatch();

				System.out.println("Transaction Successfull!!!!!!!!!");
			}
			else
			{
				System.out.println("low balance!!!!!!!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null){
				try {
					con.close();
					con=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}