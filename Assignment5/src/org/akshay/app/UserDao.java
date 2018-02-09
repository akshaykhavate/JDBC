package org.akshay.app;

public interface UserDao {
	public void insert(UserBean user);
	public void update(UserBean ub);
	public void select(UserBean ub);
	public void delete(UserBean ub);
	public void getuser(UserBean ub);
}
