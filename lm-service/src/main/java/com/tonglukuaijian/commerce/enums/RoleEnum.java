package com.tonglukuaijian.commerce.enums;

public enum RoleEnum {
	ADMINISTRATOR(1), MINISTER(2), GROUP(3), PM(4), MEMBER(5);
	private int value;

	private RoleEnum(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}
