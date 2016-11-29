package com.tonglukuaijian.commerce.enums;

public enum LeaveMessageStatusEnum {
	NORMAL(1), CLOSE(2);

	private int value;

	public int value() {
		return value;
	}

	private LeaveMessageStatusEnum(int value) {
		this.value = value;
	}

}
