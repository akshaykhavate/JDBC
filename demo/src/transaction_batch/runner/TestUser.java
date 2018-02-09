package transaction_batch.runner;

import transaction_batch.jdbc.UserDAO;

public class TestUser {

	public static void main(String[] args) {
		
		UserDAO ud=new UserDAO();
		//ud.addUser();
		ud.updateUser();
		
	}
	
	
}
