package com.jspiders.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	static  String URL="jdbc:mysql://localhost:3306";
	static  String USER="root";
	static  String PWD="root";

	public boolean addUser( String name,int age, String email, String phone)
	{
		String query=" insert into assignment1.user values('"+name+"',"+age+",'"+email+"','"+phone+"')";
		System.out.println(name+" "+age+" "+email+" "+phone);
		boolean res=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(URL, USER, PWD);
			Statement st=con.createStatement();
			res=st.execute(query);
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
}
