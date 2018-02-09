package org.akshay.app;

public class UserBean {
	private String Name;
	private int age;
	private String Email;
	private String phone;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserBean [Name=" + Name + ", age=" + age + ", Email=" + Email + ", phone=" + phone + "]";
	}
	
	
	
}
