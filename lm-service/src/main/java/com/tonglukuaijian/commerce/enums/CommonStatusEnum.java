package com.tonglukuaijian.commerce.enums;

public enum CommonStatusEnum {
	NORMAL(1), CLOSE(2);
	private int value;

	private CommonStatusEnum(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}
