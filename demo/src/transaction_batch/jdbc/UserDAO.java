package transaction_batch.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import transaction_batch.util.SingleConn;
import transaction_batch.util.UserBean;
public class UserDAO
{
	Scanner sc=new Scanner(System.in);
	Connection con=SingleConn.getObject().getConnection();
	UserBean ub=new UserBean();
	Statement st=null;
	public void addUser()
	{
		System.out.println("enter how many users");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("enter account number");
			long acc=sc.nextLong();

			System.out.println("enter name");
			String name=sc.next();

			System.out.println("enter bal");
			double bal=sc.nextDouble();

			try {
				 st= con.createStatement();
				st.addBatch("insert into transactions values("+acc+",'"+name+"',"+bal+")");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			int[] a = st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateUser() {
		try {
			System.out.println("available account-numbers");
			 st= con.createStatement();
			 ResultSet rs=st.executeQuery("select accNO from transactions");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t");
			}
			System.out.println("enter any account number to debit amount");
			long acno1=sc.nextInt();
			System.out.println("enter any account number to credit amount");
			long acno2=sc.nextLong();
			System.out.println("enter amount to deduct from account-"+acno1);
			double cash=sc.nextDouble();
			

			ResultSet rs1=st.executeQuery("select bal from transactions where accNo="+acno1);
			 double avail=0;
				while(rs1.next())
				{
					avail=rs1.getInt(1);
					System.out.println(avail);
				}
			if(avail>cash)
			{
				double ded=avail-cash;
				System.out.println(ded);
			st.addBatch("update transactions set bal="+ded+" where accNo="+acno1);
			st.addBatch("update transactions set bal=bal+"+cash+" where accNo="+acno2);
			}
			else
			{
				System.out.println("min balance is not found");
			}
			int[] u=st.executeBatch();
			System.out.println(u+" records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
