package com.sample.user.model;

import java.util.Date;


/**
 * The DTO class for UserObject
 * 
 * @author Sneha John Choondal
 *
 */
public class UserModel {

	private String name;

	private String email;
	
	private String password;
	
	private Date loginDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
