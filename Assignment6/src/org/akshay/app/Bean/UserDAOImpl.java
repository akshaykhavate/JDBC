package org.akshay.app.Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.akshay.app.Tester.Tester;

public class UserDAOImpl implements UserDAO {
	Connection con = SingleTonCon.getObject().getConnection();
	UserBean ub = new UserBean();
	Tester t = new Tester();
	private String row;
	@Override
	public void addUser(UserBean ub) {
		String query = null;
		query = "insert into user_new values('"+ub.getId()+"','"+ub.getName()+"','"+ub.getAge()+"')";
		try {
			Statement stmt = con.createStatement();
			boolean rs = stmt.executeBatch() != null;
			ArrayList<String> lst = new ArrayList<>();
			//while(rs.next()){
				int column_count = 3;
				for (int i=0; i<column_count; i++) {
					String[] row = new String[column_count];
					//row[i] = rs.getString(i+1);
				}
				lst.add(row);
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}