package transaction_batch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConn {
private static SingleConn SINGLE;
private static Connection con;

static
{
	SINGLE=new SingleConn();
}

private SingleConn() 
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdetails","root","root");
		System.out.println(con);
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}

public static SingleConn getObject()
{
	return SINGLE;
}

public Connection getConnection()
{
	return con;
}
}
