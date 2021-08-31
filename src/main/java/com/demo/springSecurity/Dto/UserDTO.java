package com.demo.springSecurity.Dto;

public class UserDTO {
	
	private String userName;
	private String userPassword;
	private String usrFullNname;
	private String phone;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUsrFullNname() {
		return usrFullNname;
	}
	public void setUsrFullNname(String usrFullNname) {
		this.usrFullNname = usrFullNname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
