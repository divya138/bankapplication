package com.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserLogin")
public class Login {
	@Id
	private long customerId;
	private String password;
	private boolean isLogin;
	public Login(long customerId, String password, boolean isLogin) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.isLogin = isLogin;
	}
	public Login() {
		super();
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
}
