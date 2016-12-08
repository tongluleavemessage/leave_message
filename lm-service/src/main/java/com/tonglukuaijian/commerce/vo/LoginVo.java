package com.tonglukuaijian.commerce.vo;

import javax.validation.constraints.NotNull;

public class LoginVo {
	@NotNull(message = "账号不能为空")
	private String accountNumber;
	@NotNull(message = "密码不能为空")
	private String password;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
