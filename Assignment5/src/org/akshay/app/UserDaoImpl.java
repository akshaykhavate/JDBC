package org.akshay.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

	Connection con = SingleTonCon.getSingle().getConnection();
	
	UserBean ub = new UserBean();
	Runner r = new Runner();
	@Override
	public void insert(UserBean ub) {
		try {
			Statement stmt = con.createStatement();
			boolean res = stmt.execute("insert into user(Name,Age,Email,Phone) values('"+ub.getName()+"',"+ub.getAge()+",'"+ub.getEmail()+"','"+ub.getPhone()+"')");
			if(!res){
				System.out.println("User inserted successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(UserBean ub) {
		try {
			Statement stmt = con.createStatement();
			boolean res = stmt.execute("update user set name='"+ub.getName()+"',age='"+ub.getAge()+"',Email='"+ub.getEmail()+"',Phone='"+ub.getPhone()+"'where age=35");
			if(!res){
				System.out.println("User updated successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void select(UserBean ub) {
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from user where Name='"+ub.getName()+"'");
			while(res.next()){
				String name = res.getString(1);
				int age = res.getInt(2);
				String Email = res.getString(3);
				String phone = res.getString(4);
				System.out.println("Name:"+name+",Age:"+age+",Email:"+Email+",Phone:"+phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(UserBean ub) {
		try {
			Statement stmt = con.createStatement();
			boolean res = stmt.execute("delete from user where name = '"+ub.getName()+"'");
			if(!res){
				System.out.println("User deleted the record successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getuser(UserBean ub) {
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from user");
			while(res.next()){
				String name = res.getString(1);
				int age = res.getInt(2);
				String Email = res.getString(3);
				String phone = res.getString(4);
				System.out.println("Name:"+name+",Age:"+age+",Email:"+Email+",Phone:"+phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
