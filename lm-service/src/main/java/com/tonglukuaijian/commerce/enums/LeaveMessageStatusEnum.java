package com.tonglukuaijian.commerce.enums;

public enum LeaveMessageStatusEnum {
	ALL(0), NORMAL(1), CLOSE(2), TODAY_COMMUNICATE(3), RETURN_VISIT(4), NOT_CONTACT(5);

	private int value;

	public int value() {
		return value;
	}

	private LeaveMessageStatusEnum(int value) {
		this.value = value;
	}

}
