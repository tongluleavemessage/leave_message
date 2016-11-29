package com.tonglukuaijian.commerce.enums;

public enum UserUsingEnum {
	ALL(0), NONUSE(1), USING(2);
	private int value;

	private UserUsingEnum(int value) {
		this.value = value;
	}

	public int value(){
		return value;
	}
}
