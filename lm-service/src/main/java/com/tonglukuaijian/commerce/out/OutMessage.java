package com.tonglukuaijian.commerce.out;

public class OutMessage<T> {
	private Integer code;
	private String message;
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OutMessage(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public OutMessage(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public OutMessage() {
		super();
	}

	public static <S> OutMessage<S> successMessage(Integer code, String message) {
		return new OutMessage<S>(code, message);
	}

	public static <S> OutMessage<S> successMessage(Integer code, String message, S data) {
		return new OutMessage<S>(code, message, data);
	}

	public static <E> OutMessage<E> errorMessage(Integer code, String message) {
		return new OutMessage<E>(code, message);
	}

	public static <E> OutMessage<E> errorMessage(Integer code, String message, E data) {
		return new OutMessage<E>(code, message, data);
	}

}
